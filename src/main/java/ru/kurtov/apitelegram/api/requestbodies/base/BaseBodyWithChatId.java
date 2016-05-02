package ru.kurtov.apitelegram.api.requestbodies.base;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;

/**
 * Created by KURT on 02.05.2016.
 */
public abstract class BaseBodyWithChatId implements Serializable {

    private final static long serialVersionUID = 0L;

    @NotNull
    @JsonProperty("chat_id")
    private String chatId;

    public BaseBodyWithChatId(@NotNull final String chatId) {
        this.chatId = chatId;
    }

    @NotNull
    public String getChatId() {
        return chatId;
    }

}
