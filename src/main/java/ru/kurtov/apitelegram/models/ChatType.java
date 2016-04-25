package ru.kurtov.apitelegram.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by KURT on 24.04.2016.
 */
public enum ChatType {

    @JsonProperty("private")
    PRIVATE,
    @JsonProperty("group")
    GROUP,
    @JsonProperty("supergroup")
    SUPERGROUP,
    @JsonProperty("channel")
    CHANNEL;

}
