package ru.kurtov.apitelegram.api.models.keyboard;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.Nullable;

import java.io.Serializable;

/**
 * Created by KURT on 28.04.2016.
 */
public class ReplyKeyboardHide implements ReplyMarkup, Serializable {

    private final static long serialVersionUID = 0L;

    @JsonProperty("hide_keyboard")
    private final boolean hideKeyboard = true;
    @JsonProperty("selective")
    private final Boolean selective;

    public ReplyKeyboardHide(boolean selective) {
        this.selective = selective;
    }

    public boolean isHideKeyboard() {
        return hideKeyboard;
    }

    @Nullable
    public Boolean getSelective() {
        return selective;
    }

}
