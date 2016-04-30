package ru.kurtov.apitelegram.utils.messages;

import org.jetbrains.annotations.NotNull;
import ru.kurtov.apitelegram.api.models.enums.MessageEntityType;

/**
 * Created by KURT on 01.05.2016.
 */
public class SimpleMessageEntity {

    @NotNull
    private final MessageEntityType messageEntityType;
    @NotNull
    private final String text;

    public SimpleMessageEntity(@NotNull final MessageEntityType messageEntityType, @NotNull final String text) {
        this.messageEntityType = messageEntityType;
        this.text = text;
    }

    @NotNull
    public MessageEntityType getMessageEntityType() {
        return messageEntityType;
    }

    @NotNull
    public String getText() {
        return text;
    }
}
