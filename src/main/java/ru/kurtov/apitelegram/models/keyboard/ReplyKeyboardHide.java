package ru.kurtov.apitelegram.models.keyboard;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.Nullable;

import java.io.Serializable;

/**
 * Created by KURT on 28.04.2016.
 */
public class ReplyKeyboardHide implements ReplyMarkup, Serializable {

    private final static long serialVersionUID = 0L;

    @JsonProperty("hide_keyboard")
    private boolean hideKeyboard;
    @JsonProperty("selective")
    private Boolean selective;

    public ReplyKeyboardHide(boolean hideKeyboard) {
        this.hideKeyboard = hideKeyboard;
    }

    public boolean isHideKeyboard() {
        return hideKeyboard;
    }

    @Nullable
    public Boolean getSelective() {
        return selective;
    }

    public void setSelective(Boolean selective) {
        this.selective = selective;
    }
}
