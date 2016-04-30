package ru.kurtov.apitelegram.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.kurtov.apitelegram.api.models.enums.MessageEntityType;

import java.io.Serializable;

/**
 * Created by KURT on 30.04.2016.
 */
public class MessageEntity implements Serializable {

    private final static long serialVersionUID = 0L;

    @JsonProperty("type")
    private MessageEntityType type;
    @JsonProperty("offset")
    private int offset;
    @JsonProperty("length")
    private int length;
    @JsonProperty("url")
    private String url;

    @NotNull
    public MessageEntityType getType() {
        return type;
    }

    public int getOffset() {
        return offset;
    }

    public int getLength() {
        return length;
    }

    @Nullable
    public String getUrl() {
        return url;
    }

}
