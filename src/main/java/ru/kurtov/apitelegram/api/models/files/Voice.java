package ru.kurtov.apitelegram.api.models.files;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created by KURT on 30.04.2016.
 */
public class Voice extends FileWithIdAndMimeType implements Serializable {

    @JsonProperty("duration")
    private int duration;

    public int getDuration() {
        return duration;
    }

}
