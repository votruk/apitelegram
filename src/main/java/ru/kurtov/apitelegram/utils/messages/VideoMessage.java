package ru.kurtov.apitelegram.utils.messages;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.kurtov.apitelegram.api.models.Chat;
import ru.kurtov.apitelegram.api.models.Message;
import ru.kurtov.apitelegram.api.models.User;
import ru.kurtov.apitelegram.api.models.files.Audio;
import ru.kurtov.apitelegram.api.models.files.Video;

import java.io.Serializable;

/**
 * Created by KURT on 01.05.2016.
 */
public class VideoMessage extends BaseMessage implements Serializable {

    private final static long serialVersionUID = 0L;

    @NotNull
    private final Video video;
    @Nullable
    private final String caption;

    public VideoMessage(final int messageId,
                        final int date,
                        @NotNull final Chat chat,
                        @Nullable final User from,
                        @Nullable final User forwardFrom,
                        @Nullable final Integer forwardDate,
                        @Nullable final Message replyToMessage,
                        @NotNull final Video video,
                        @Nullable final String caption) {
        super(messageId, date, chat, from, forwardFrom, forwardDate, replyToMessage);
        this.video = video;
        this.caption = caption;
    }

    @NotNull
    public Video getVideo() {
        return video;
    }

    @Nullable
    public String getCaption() {
        return caption;
    }
}
