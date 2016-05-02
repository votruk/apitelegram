package ru.kurtov.apitelegram.api.requestbodies.send;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.kurtov.apitelegram.api.models.enums.ParseMode;
import ru.kurtov.apitelegram.api.models.keyboard.ReplyMarkup;
import ru.kurtov.apitelegram.api.requestbodies.base.BaseBodyWithChatId;

import java.io.Serializable;

/**
 * Created by KURT on 27.04.2016.
 */
public class SendMessageBodyWithChatId extends BaseBodyWithChatId implements Serializable {

    private final static long serialVersionUID = 0L;

    @NotNull
    @JsonProperty("text")
    private final String text;
    @Nullable
    @JsonProperty("parse_mode")
    private ParseMode parseMode;
    @Nullable
    @JsonProperty("disable_web_page_preview")
    private Boolean disableWebPagePreview;
    @Nullable
    @JsonProperty("disable_notification")
    private Boolean disableNotification;
    @Nullable
    @JsonProperty("replyToMessageId")
    private Integer replyToMessageId;
    @Nullable
    @JsonProperty("reply_markup")
    private ReplyMarkup replyMarkup;

    public SendMessageBodyWithChatId(@NotNull final String chatId, @NotNull final String text) {
        super(chatId);
        this.text = text;
    }

    public SendMessageBodyWithChatId(final int chatId, @NotNull final String text) {
        this(String.valueOf(chatId), text);
    }

    @NotNull
    public String getText() {
        return text;
    }

    @Nullable
    public ParseMode getParseMode() {
        return parseMode;
    }

    @Nullable
    public Boolean getDisableWebPagePreview() {
        return disableWebPagePreview;
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

    public void setParseMode(@Nullable final ParseMode parseMode) {
        this.parseMode = parseMode;
    }

    public void setDisableWebPagePreview(@Nullable final Boolean disableWebPagePreview) {
        this.disableWebPagePreview = disableWebPagePreview;
    }

    public void setDisableNotification(@Nullable final Boolean disableNotification) {
        this.disableNotification = disableNotification;
    }

    public void setReplyToMessageId(@Nullable final Integer replyToMessageId) {
        this.replyToMessageId = replyToMessageId;
    }

    public void setReplyMarkup(@Nullable final ReplyMarkup replyMarkup) {
        this.replyMarkup = replyMarkup;
    }
}
