package ru.kurtov.apitelegram.api.requestbodies.send;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.kurtov.apitelegram.api.requestbodies.base.BaseBodyWithChatId;

import java.io.Serializable;

/**
 * Created by KURT on 30.04.2016.
 */
public class SendPhotoBodyWithChatId extends BaseBodyWithChatId implements Serializable {

    private final static long serialVersionUID = 0L;

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

    public SendPhotoBodyWithChatId(@NotNull final String chatId, @NotNull final String photo) {
        super(chatId);
        this.photo = photo;
    }

    public SendPhotoBodyWithChatId(final int chatId, @NotNull final String photo) {
        this(String.valueOf(chatId), photo);
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

    public void setCaption(@Nullable final String caption) {
        this.caption = caption;
    }

    public void setDisableNotification(@Nullable final Boolean disableNotification) {
        this.disableNotification = disableNotification;
    }

    public void setReplyToMessageId(@Nullable final Integer replyToMessageId) {
        this.replyToMessageId = replyToMessageId;
    }
}
