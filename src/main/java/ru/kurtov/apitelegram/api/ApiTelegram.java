package ru.kurtov.apitelegram.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jetbrains.annotations.NotNull;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;
import ru.kurtov.apitelegram.models.*;
import ru.kurtov.apitelegram.requestbodies.SendMessageBody;
import rx.Observable;
import rx.schedulers.Schedulers;
import rx.subjects.PublishSubject;

import java.util.concurrent.TimeUnit;

/**
 * Created by KURT on 24.04.2016.
 */
public class ApiTelegram {

    private static final String BASE_URL = "https://api.telegram.org/bot";
    private static final long DELAY = TimeUnit.MILLISECONDS.toMillis(1000);
    private PublishSubject<Message> messagesSubject = PublishSubject.create();
    private PublishSubject<InlineQuery> inlineQueriesSubject = PublishSubject.create();
    private PublishSubject<ChosenInlineResult> chosenInlineResultsSubject = PublishSubject.create();
    private PublishSubject<CallbackQuery> callbackQueriesSubject = PublishSubject.create();
    private int lastUpdatedId;

    private boolean isOpened = true;

    @NotNull
    private final TelegramApiMethods telegramApiMethods;

    public ApiTelegram(@NotNull final String token) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        final Retrofit mainEndpoint = new Retrofit.Builder()
                .baseUrl(BASE_URL + token + "/")
                .addCallAdapterFactory(RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io()))
                .client(ApiUtils.createDefaultClientBuilder().build())
                .addConverterFactory(JacksonConverterFactory.create(mapper))
                .build();
        telegramApiMethods = mainEndpoint.create(TelegramApiMethods.class);
        final Thread thread = new Thread(new ReaderThread());
        thread.start();
    }

    public void setOpened(boolean opened) {
        isOpened = opened;
    }

    @NotNull
    public Observable<Message> sendMessage(@NotNull final SendMessageBody sendMessageBody) {
        return telegramApiMethods.sendMessage(sendMessageBody)
                .map(TelegramResponse::getResult);
    }

    @NotNull
    public Observable<Message> observeMessages() {
        return messagesSubject;
    }

    @NotNull
    public Observable<InlineQuery> observeInlineQueries() {
        return inlineQueriesSubject;
    }

    @NotNull
    public Observable<ChosenInlineResult> observeChosenInlineResults() {
        return chosenInlineResultsSubject;
    }

    @NotNull
    public Observable<CallbackQuery> observeCallbackQueries() {
        return callbackQueriesSubject;
    }

    private class ReaderThread implements Runnable {

        @Override
        public void run() {
            while (isOpened) {
                try {
                    Thread.sleep(DELAY);
                    telegramApiMethods.getUpdates(lastUpdatedId + 1)
                            .map(TelegramResponse::getResult)
                            .subscribe(updates -> {
                                lastUpdatedId = 0;
                                for (final Update update : updates) {
                                    updateSubject(update);
                                    if (update.getUpdateId() > lastUpdatedId) {
                                        lastUpdatedId = update.getUpdateId();
                                    }
                                }
                            });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    private void updateSubject(Update update) {
        switch (update.getUpdateType()) {
            case INLINE_QUERY:
                inlineQueriesSubject.onNext(update.getInlineQuery());
                break;
            case CHOSEN_INLINE_RESULT:
                chosenInlineResultsSubject.onNext(update.getChosenInlineResult());
                break;
            case CALLBACK_QUERY:
                callbackQueriesSubject.onNext(update.getCallbackQuery());
                break;
            case MESSAGE:
            default:
                messagesSubject.onNext(update.getMessage());
                break;
        }
    }

}