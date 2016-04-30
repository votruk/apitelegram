package ru.kurtov.apitelegram;

/**
 * Created by KURT on 01.05.2016.
 */
public class ShouldNotHappenedException extends RuntimeException {

    public ShouldNotHappenedException(final String message) {
        super(message);
    }

}
