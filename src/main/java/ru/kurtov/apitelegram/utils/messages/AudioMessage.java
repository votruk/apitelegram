package ru.kurtov.apitelegram.utils.messages;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.kurtov.apitelegram.api.models.Chat;
import ru.kurtov.apitelegram.api.models.Message;
import ru.kurtov.apitelegram.api.models.User;
import ru.kurtov.apitelegram.api.models.files.Audio;

import java.io.Serializable;

/**
 * Created by KURT on 01.05.2016.
 */
public class AudioMessage extends BaseMessage implements Serializable {

    private final static long serialVersionUID = 0L;

    @NotNull
    private final Audio audio;

    public AudioMessage(final int messageId,
                        final int date,
                        @NotNull final Chat chat,
                        @Nullable final User from,
                        @Nullable final User forwardFrom,
                        @Nullable final Integer forwardDate,
                        @Nullable final Message replyToMessage,
                        @NotNull final Audio audio) {
        super(messageId, date, chat, from, forwardFrom, forwardDate, replyToMessage);
        this.audio = audio;
    }

    @NotNull
    public Audio getAudio() {
        return audio;
    }
}
