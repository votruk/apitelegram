package ru.kurtov.apitelegram.requestbodies;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
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

}
