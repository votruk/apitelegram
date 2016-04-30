package ru.kurtov.apitelegram.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.Serializable;

/**
 * Created by KURT on 27.04.2016.
 */
public class ChosenInlineResult implements Serializable {

    private final static long serialVersionUID = 0L;

    @JsonProperty("result_id")
    private String resultId;
    @JsonProperty("from")
    private User fromUser;
    @Nullable
    @JsonProperty("location")
    private Location location;
    @Nullable
    @JsonProperty("inline_message_id")
    private String inlineMessageId;
    @JsonProperty("query")
    private String query;

    @NotNull
    public String getResultId() {
        return resultId;
    }

    @NotNull
    public User getFromUser() {
        return fromUser;
    }

    @Nullable
    public Location getLocation() {
        return location;
    }

    @Nullable
    public String getInlineMessageId() {
        return inlineMessageId;
    }

    @NotNull
    public String getQuery() {
        return query;
    }

}
