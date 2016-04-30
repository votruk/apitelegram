package ru.kurtov.apitelegram.api.requestbodies;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.kurtov.apitelegram.api.models.keyboard.ReplyMarkup;

import java.io.Serializable;

/**
 * Created by KURT on 30.04.2016.
 */
public class ForwardMessage implements Serializable {
    
    private final static long serialVersionUID = 0L;

    @NotNull
    @JsonProperty("chat_id")
    private String chatId;
    @NotNull
    @JsonProperty("photo")
    private String photo;
    @Nullable
    @JsonProperty("caption")
    private String caption;
    @Nullable
    @JsonProperty("disable_notification")
    private Boolean disableNotification;
    @Nullable
    @JsonProperty("reply_to_message_id")
    private Integer replyToMessageId;
    @Nullable
    @JsonProperty("reply_markup")
    private ReplyMarkup replyMarkup;

    public ForwardMessage(@NotNull final String chatId,
                          @NotNull final String photo,
                          @Nullable final String caption,
                          @Nullable final Boolean disableNotification,
                          @Nullable final Integer replyToMessageId,
                          @Nullable final ReplyMarkup replyMarkup) {
        this.chatId = chatId;
        this.photo = photo;
        this.caption = caption;
        this.disableNotification = disableNotification;
        this.replyToMessageId = replyToMessageId;
        this.replyMarkup = replyMarkup;
    }

    @NotNull
    public String getChatId() {
        return chatId;
    }

    @NotNull
    public String getPhoto() {
        return photo;
    }

    @Nullable
    public String getCaption() {
        return caption;
    }

    @Nullable
    public Boolean getDisableNotification() {
        return disableNotification;
    }

    @Nullable
    public Integer getReplyToMessageId() {
        return replyToMessageId;
    }

    @Nullable
    public ReplyMarkup getReplyMarkup() {
        return replyMarkup;
    }
}
