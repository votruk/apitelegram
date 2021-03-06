package ru.kurtov.apitelegram.api.models;


import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.Nullable;

import java.io.Serializable;

/**
 * Created by KURT on 24.04.2016.
 */
public class TelegramResponse<TObject extends Serializable> {

    @JsonProperty("ok")
    private boolean ok;
    @Nullable
    @JsonProperty("description")
    private String description;
    @JsonProperty("error_code")
    private int errorCode;
    @JsonProperty("result")
    @Nullable
    private TObject result;

    @Nullable
    public String getDescription() {
        return description;
    }

    public int getErrorCode() {
        return errorCode;
    }

    @Nullable
    public TObject getResult() {
        return result;
    }

}
