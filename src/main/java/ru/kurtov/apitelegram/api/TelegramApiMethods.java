package ru.kurtov.apitelegram.api;

import retrofit2.http.GET;
import ru.kurtov.apitelegram.models.TelegramResponse;
import ru.kurtov.apitelegram.models.Update;
import ru.kurtov.apitelegram.models.User;
import rx.Observable;

/**
 * Created by KURT on 24.04.2016.
 */
public interface TelegramApiMethods {

    @GET("getUpdate/")
    Observable<TelegramResponse<Update>> getUpdate();

    @GET("getMe/")
    Observable<TelegramResponse<User>> getMe();

}
