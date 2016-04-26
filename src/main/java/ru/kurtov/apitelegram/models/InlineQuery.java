package ru.kurtov.apitelegram.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.Serializable;

/**
 * Created by KURT on 27.04.2016.
 */
public class InlineQuery implements Serializable {

    private final static long serialVersionUID = 0L;

    @JsonProperty("id")
    private String id;
    @JsonProperty("from")
    private User fromUser;
    @Nullable
    @JsonProperty("location")
    private Location location;
    @JsonProperty("query")
    private String query;
    @JsonProperty("offset")
    private String offset;

    @NotNull
    public String getId() {
        return id;
    }

    @NotNull
    public User getFromUser() {
        return fromUser;
    }

    @Nullable
    public Location getLocation() {
        return location;
    }

    @NotNull
    public String getQuery() {
        return query;
    }

    @NotNull
    public String getOffset() {
        return offset;
    }

}
