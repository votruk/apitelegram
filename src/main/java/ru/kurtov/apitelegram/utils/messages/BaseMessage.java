package ru.kurtov.apitelegram.utils.messages;

import java.io.Serializable;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.kurtov.apitelegram.api.models.Chat;
import ru.kurtov.apitelegram.api.models.Message;
import ru.kurtov.apitelegram.api.models.User;

/**
 * Created by KURT on 01.05.2016.
 */
public abstract class BaseMessage implements Serializable {

    private final static long serialVersionUID = 0L;

    private final int messageId;
    private final int date;
    @NotNull
    private final Chat chat;
    @Nullable
    private final User from;
    @Nullable
    private final User forwardFrom;
    @Nullable
    private final Integer forwardDate;
    @Nullable
    private final Message replyToMessage;

    public BaseMessage(final int messageId,
                       final int date,
                       @NotNull final Chat chat,
                       @Nullable final User from,
                       @Nullable final User forwardFrom,
                       @Nullable final Integer forwardDate,
                       @Nullable final Message replyToMessage) {
        this.messageId = messageId;
        this.date = date;
        this.chat = chat;
        this.from = from;
        this.forwardFrom = forwardFrom;
        this.forwardDate = forwardDate;
        this.replyToMessage = replyToMessage;
    }

    public int getMessageId() {
        return messageId;
    }

    public int getDate() {
        return date;
    }

    @NotNull
    public Chat getChat() {
        return chat;
    }

    @Nullable
    public User getFrom() {
        return from;
    }

    @Nullable
    public User getForwardFrom() {
        return forwardFrom;
    }

    @Nullable
    public Integer getForwardDate() {
        return forwardDate;
    }

    @Nullable
    public Message getReplyToMessage() {
        return replyToMessage;
    }
}
