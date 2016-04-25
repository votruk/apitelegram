package ru.kurtov.apitelegram.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.Nullable;

import java.io.Serializable;

/**
 * Created by KURT on 24.04.2016.
 */
public class Update implements Serializable {

    @JsonProperty("update_id")
    private int updateId;

    @JsonProperty("message")
    @Nullable
    private Message message;


}
