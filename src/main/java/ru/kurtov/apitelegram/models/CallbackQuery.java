package ru.kurtov.apitelegram.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.Serializable;

/**
 * Created by KURT on 27.04.2016.
 */
public class CallbackQuery implements Serializable {

    private final static long serialVersionUID = 0L;

    @JsonProperty("id")
    private String id;
    @JsonProperty("from")
    private User fromUser;
    @Nullable
    @JsonProperty("message")
    private Message message;
    @Nullable
    @JsonProperty("inline_message_id")
    private String inlineMessageId;
    @JsonProperty("data")
    private String data;

    @NotNull
    public String getId() {
        return id;
    }

    @NotNull
    public User getFromUser() {
        return fromUser;
    }

    @Nullable
    public Message getMessage() {
        return message;
    }

    @Nullable
    public String getInlineMessageId() {
        return inlineMessageId;
    }

    @NotNull
    public String getData() {
        return data;
    }

}
