package ru.kurtov.apitelegram.api.models.keyboard;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.List;

/**
 * Created by KURT on 30.04.2016.
 */
public class InlineKeyboardMarkup implements ReplyMarkup, Serializable {

    private final static long serialVersionUID = 0L;

    @JsonProperty("inline_keyboard")
    private final List<List<InlineKeyboardButton>> inlineKeyboard;

    public InlineKeyboardMarkup(@NotNull final List<List<InlineKeyboardButton>> inlineKeyboard) {
        this.inlineKeyboard = inlineKeyboard;
    }

    @NotNull
    public List<List<InlineKeyboardButton>> getInlineKeyboard() {
        return inlineKeyboard;
    }

}
