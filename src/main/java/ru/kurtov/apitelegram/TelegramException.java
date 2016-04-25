package ru.kurtov.apitelegram;

import org.jetbrains.annotations.NotNull;

/**
 * Created by KURT on 24.04.2016.
 */
public class TelegramException extends Exception {

    private int errorCode;

    @NotNull
    private String description;

    public TelegramException(@NotNull final String description, final int errorCode) {
        super(description);
        this.description = description;
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }

    @NotNull
    public String getDescription() {
        return description;
    }

}
