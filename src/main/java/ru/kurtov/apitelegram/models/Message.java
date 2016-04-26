package ru.kurtov.apitelegram.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.Serializable;

/**
 * Created by KURT on 24.04.2016.
 */
public class Message implements Serializable {

    private final static long serialVersionUID = 0L;

    @JsonProperty("message_id")
    private int messageId;
    @Nullable
    @JsonProperty("from")
    private User fromUser;
    @JsonProperty("date")
    private int date;
    @JsonProperty("chat")
    private Chat chat;
    @Nullable
    @JsonProperty("forward_date")
    private Integer forwardDate;
    @Nullable
    @JsonProperty("reply_to_message")
    private Message replyToMessage;
    @Nullable
    @JsonProperty("text")
    private String text;

    public int getMessageId() {
        return messageId;
    }

    @Nullable
    public User getFromUser() {
        return fromUser;
    }

    public int getDate() {
        return date;
    }

    @NotNull
    public Chat getChat() {
        return chat;
    }

    @Nullable
    public Integer getForwardDate() {
        return forwardDate;
    }

    @Nullable
    public Message getReplyToMessage() {
        return replyToMessage;
    }

    @Nullable
    public String getText() {
        return text;
    }

}
