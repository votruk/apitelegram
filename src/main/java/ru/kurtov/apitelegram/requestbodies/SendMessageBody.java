package ru.kurtov.apitelegram.requestbodies;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.kurtov.apitelegram.models.keyboard.ReplyMarkup;
import ru.kurtov.apitelegram.requestbodies.enums.ParseMode;

import java.io.Serializable;

/**
 * Created by KURT on 27.04.2016.
 */
public class SendMessageBody implements Serializable {

    private final static long serialVersionUID = 0L;

    @JsonProperty("chat_id")
    private String chatId;
    @JsonProperty("text")
    private String text;
    @JsonProperty("parse_mode")
    private ParseMode parseMode;
    @JsonProperty("disable_web_page_preview")
    private Boolean disableWebPagePreview;
    @JsonProperty("disable_notification")
    private Boolean disableNotification;
    @JsonProperty("reply_to_message_id")
    private Integer reply_to_message_id;
    @JsonProperty("reply_markup")
    private ReplyMarkup replyMarkup;
    //TODO add other fields


    public SendMessageBody(@NotNull final String chatId,
                           @NotNull final String text) {
        this.chatId = chatId;
        this.text = text;
    }

    public SendMessageBody(final int chatId,
                           @NotNull final String text) {
        this(String.valueOf(chatId), text);
    }

    @NotNull
    public String getChatId() {
        return chatId;
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
    public Integer getReply_to_message_id() {
        return reply_to_message_id;
    }

    @Nullable
    public ReplyMarkup getReplyMarkup() {
        return replyMarkup;
    }

    public void setParseMode(ParseMode parseMode) {
        this.parseMode = parseMode;
    }

    public void setDisableWebPagePreview(Boolean disableWebPagePreview) {
        this.disableWebPagePreview = disableWebPagePreview;
    }

    public void setDisableNotification(Boolean disableNotification) {
        this.disableNotification = disableNotification;
    }

    public void setReplyToMessageId(Integer reply_to_message_id) {
        this.reply_to_message_id = reply_to_message_id;
    }

    public void setReplyMarkup(ReplyMarkup replyMarkup) {
        this.replyMarkup = replyMarkup;
    }
}
