package ru.kurtov.apitelegram.api;

import org.jetbrains.annotations.NotNull;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;
import ru.kurtov.apitelegram.TelegramException;
import ru.kurtov.apitelegram.models.TelegramResponse;
import ru.kurtov.apitelegram.models.Update;
import ru.kurtov.apitelegram.models.User;
import rx.Observable;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import sun.rmi.runtime.Log;

import java.util.concurrent.TimeUnit;

/**
 * Created by KURT on 24.04.2016.
 */
public class ApiTelegram {

    private static final String BASE_URL = "https://api.telegram.org/bot";
    private static final long DELAY = TimeUnit.MILLISECONDS.toMillis(1000);

    private boolean isOpened;

    @NotNull
    private final TelegramApiMethods telegramApiMethods;

    public ApiTelegram(@NotNull final String token) {
        final Retrofit mainEndpoint = new Retrofit.Builder()
                .baseUrl(BASE_URL + token + "/")
                .addCallAdapterFactory(RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io()))
                .client(ApiUtils.createDefaultClientBuilder().build())
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
        telegramApiMethods = mainEndpoint.create(TelegramApiMethods.class);
    }

    public void setOpened(boolean opened) {
        isOpened = opened;
    }

    public Observable<Update> getUpdates() {
        return telegramApiMethods.getUpdate()
                .repeatWhen(observable -> Observable.timer(DELAY, TimeUnit.MILLISECONDS))
                .retryWhen(attempts -> attempts.switchMap(throwable -> {
//                    if (throwable instanceof TelegramException) {
                        return Observable.timer(DELAY, TimeUnit.MILLISECONDS);
//                    }

                }))
                .switchMap(Observable::just)
                .map(TelegramResponse::getResult);

    }

    public Observable<User> getMe() {
        return telegramApiMethods.getMe()
//                .repeatWhen(observable -> Observable.timer(DELAY, TimeUnit.MILLISECONDS))
//                .retryWhen(attempts -> attempts.switchMap(throwable -> {
////                    if (throwable instanceof TelegramException) {
//                    return Observable.timer(DELAY, TimeUnit.MILLISECONDS);
////                    }
//
//                }))
                .switchMap(Observable::just)
                .map(TelegramResponse::getResult);

    }


}
