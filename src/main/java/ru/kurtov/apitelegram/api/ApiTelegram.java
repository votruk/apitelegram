package ru.kurtov.apitelegram.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jetbrains.annotations.NotNull;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;
import ru.kurtov.apitelegram.api.models.*;
import ru.kurtov.apitelegram.api.requestbodies.send.SendMessageBodyWithChatId;
import rx.Observable;
import rx.Subscription;
import rx.schedulers.Schedulers;
import rx.subjects.BehaviorSubject;
import rx.subjects.PublishSubject;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by KURT on 24.04.2016.
 */
public class ApiTelegram {

    private static final String BASE_URL = "https://api.telegram.org/bot";
    private static final long DELAY = TimeUnit.MILLISECONDS.toMillis(1000);
    private BehaviorSubject<Message> messagesSubject = BehaviorSubject.create();
    private PublishSubject<InlineQuery> inlineQueriesSubject = PublishSubject.create();
    private PublishSubject<ChosenInlineResult> chosenInlineResultsSubject = PublishSubject.create();
    private PublishSubject<CallbackQuery> callbackQueriesSubject = PublishSubject.create();
    private int lastUpdatedId;

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

        final CountDownLatch countDownLatch = new CountDownLatch(Integer.MAX_VALUE);
        observeIncomingMessages(countDownLatch);

    }

    private void observeIncomingMessages(final CountDownLatch countDownLatch) {
        Observable
                .interval(DELAY, TimeUnit.MILLISECONDS)
                .subscribe(counter ->
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
                                    countDownLatch.countDown();
                                }));
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @NotNull
    public Observable<Message> sendMessage(final @NotNull SendMessageBodyWithChatId sendMessageBody) {
        return telegramApiMethods.sendMessage(sendMessageBody)
                .map(TelegramResponse::getResult);
    }

    @NotNull
    public Observable<Message> observeMessages() {
        return messagesSubject;
    }

    public Subscription subscription() {
        return messagesSubject.subscribe(message -> {
            System.out.println(message.getChat().getFirstName() + " " + message.getChat().getLastName());
        });
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

    private void updateSubject(@NotNull final Update update) {
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