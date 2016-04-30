package ru.kurtov.apitelegram.api.models.keyboard;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.Serializable;
import java.util.List;

/**
 * Created by KURT on 30.04.2016.
 */
public class ReplyKeyboardMarkup implements ReplyMarkup, Serializable {

    private final static long serialVersionUID = 0L;

    @JsonProperty("keyboard")
    private final List<List<KeyboardButton>> keyboard;
    @JsonProperty("resize_keyboard")
    private final Boolean resizeKeyboard;
    @JsonProperty("one_time_keyboard")
    private final Boolean oneTimeKeyboard;
    @JsonProperty("selective")
    private final Boolean selective;

    public ReplyKeyboardMarkup(@NotNull final List<List<KeyboardButton>> keyboard,
                               @Nullable final Boolean resizeKeyboard,
                               @Nullable final Boolean oneTimeKeyboard,
                               @Nullable final Boolean selective) {
        this.keyboard = keyboard;
        this.resizeKeyboard = resizeKeyboard;
        this.oneTimeKeyboard = oneTimeKeyboard;
        this.selective = selective;
    }

    @NotNull
    public List<List<KeyboardButton>> getKeyboard() {
        return keyboard;
    }

    @Nullable
    public Boolean getResizeKeyboard() {
        return resizeKeyboard;
    }

    @Nullable
    public Boolean getOneTimeKeyboard() {
        return oneTimeKeyboard;
    }

    @Nullable
    public Boolean getSelective() {
        return selective;
    }
}
