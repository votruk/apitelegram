package ru.kurtov.apitelegram.models.files;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created by KURT on 30.04.2016.
 */
public abstract class FileWithIdAndSize extends FileWithId implements Serializable {

    private final static long serialVersionUID = 0L;

    @JsonProperty("width")
    private int width;
    @JsonProperty("height")
    private int height;

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

}
