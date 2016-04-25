package ru.kurtov.apitelegram.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;

/**
 * Created by KURT on 24.04.2016.
 */
public class Chat implements Serializable {

    @JsonProperty("id")
    private int chatId;
    @JsonProperty("type")
    @NotNull
    private ChatType chatType;

}
