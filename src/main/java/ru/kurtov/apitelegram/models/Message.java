package ru.kurtov.apitelegram.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.Serializable;

/**
 * Created by KURT on 24.04.2016.
 */
public class Message implements Serializable {

    @JsonProperty("message_id")
    private int messageId;
    @Nullable
    @JsonProperty("from")
    private User fromUser;
    @JsonProperty("date")
    private int date;
    @NotNull
    @JsonProperty("chat")
    private Chat chat;



}
