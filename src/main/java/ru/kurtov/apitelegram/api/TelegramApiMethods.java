package ru.kurtov.apitelegram.api;

import org.jetbrains.annotations.NotNull;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import ru.kurtov.apitelegram.models.Message;
import ru.kurtov.apitelegram.models.TelegramResponse;
import ru.kurtov.apitelegram.models.Update;
import ru.kurtov.apitelegram.models.User;
import ru.kurtov.apitelegram.requestbodies.SendMessageBody;
import rx.Observable;

import java.util.ArrayList;

/**
 * Created by KURT on 24.04.2016.
 */
public interface TelegramApiMethods {

    @GET("getupdates")
    Observable<TelegramResponse<ArrayList<Update>>> getUpdates(@Query("offset") final int offset);

    @GET("getme")
    Observable<TelegramResponse<User>> getMe();

    @POST("sendmessage")
    Observable<TelegramResponse<Message>> sendMessage(@NotNull @Body final SendMessageBody sendMessageBody);

}
