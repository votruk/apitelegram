package ru.kurtov.apitelegram.utils.messages;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.kurtov.apitelegram.api.models.Chat;
import ru.kurtov.apitelegram.api.models.Message;
import ru.kurtov.apitelegram.api.models.MessageEntity;
import ru.kurtov.apitelegram.api.models.User;
import ru.kurtov.apitelegram.api.models.files.Audio;

import java.io.Serializable;
import java.util.List;

/**
 * Created by KURT on 01.05.2016.
 */
public class TextMessage extends BaseMessage implements Serializable {

    private final static long serialVersionUID = 0L;

    @NotNull
    private final String text;
    @Nullable
    private List<MessageEntity> entities;

    public TextMessage(final int messageId,
                       final int date,
                       @NotNull final Chat chat,
                       @Nullable final User from,
                       @Nullable final User forwardFrom,
                       @Nullable final Integer forwardDate,
                       @Nullable final Message replyToMessage,
                       @NotNull final String text,
                       @Nullable final List<MessageEntity> entities) {
        super(messageId, date, chat, from, forwardFrom, forwardDate, replyToMessage);
        this.text = text;
        this.entities = entities;
    }

    @NotNull
    public String getText() {
        return text;
    }

    @Nullable
    public List<MessageEntity> getEntities() {
        return entities;
    }
}
