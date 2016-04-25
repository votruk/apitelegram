package ru.kurtov.test;

import ru.kurtov.apitelegram.api.ApiTelegram;
import rx.Observable;

/**
 * Created by KURT on 24.04.2016.
 */
public class Main {

    public static void main(String[] args) {
        final ApiTelegram apiTelegram = new ApiTelegram("183925292:AAHrPi7BHHVCK6vuvc8k7qbAIYfdAiaLnjI");
        apiTelegram.getMe()
                .subscribe(user -> {
                    System.out.println(user.getFirstName());
                });

        apiTelegram.getUpdates()
                .subscribe(update -> {
                    System.out.println(update.toString());
                });
    }

}
