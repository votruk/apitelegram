package ru.kurtov.apitelegram.api.models.keyboard;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.Nullable;

import java.io.Serializable;

/**
 * Created by KURT on 30.04.2016.
 */
public class ForceReply implements ReplyMarkup, Serializable {

    private final static long serialVersionUID = 0L;

    @JsonProperty("force_reply")
    private final boolean forceReply = true;
    @JsonProperty("selective")
    private Boolean selective;

    public ForceReply(@Nullable final Boolean selective) {
        this.selective = selective;
    }

    public boolean isForceReply() {
        return forceReply;
    }

    public Boolean getSelective() {
        return selective;
    }

}
