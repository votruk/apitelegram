package ru.kurtov.apitelegram.api;

import com.sun.istack.internal.NotNull;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by KURT on 24.04.2016.
 */
public class ApiUtils {

    @NotNull
    public static OkHttpClient.Builder createDefaultClientBuilder() {
        final OkHttpClient.Builder result = new OkHttpClient.Builder();
        result.readTimeout(TimeUnit.SECONDS.toSeconds(30), TimeUnit.SECONDS);
        result.connectTimeout(TimeUnit.SECONDS.toSeconds(15), TimeUnit.SECONDS);
        result.addInterceptor(new CharsetHeaderInterceptor());
        final HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        result.addInterceptor(loggingInterceptor);
        return result;
    }

    private static class CharsetHeaderInterceptor implements Interceptor {
        @Override
        public okhttp3.Response intercept(final Chain chain) throws IOException {
            final Request.Builder requestBuilder = chain.request().newBuilder();
                requestBuilder.addHeader("charset", "UTF-8");

            return chain.proceed(requestBuilder.build());
        }
    }

}
