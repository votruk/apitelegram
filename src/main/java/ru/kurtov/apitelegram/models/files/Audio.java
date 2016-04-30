package ru.kurtov.apitelegram.models.files;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.Nullable;

import java.io.Serializable;

/**
 * Created by KURT on 30.04.2016.
 */
public class Audio extends FileWithIdAndMimeType implements Serializable {

    private final static long serialVersionUID = 0L;

    @JsonProperty("duration")
    private int duration;
    @Nullable
    @JsonProperty("performer")
    private String performer;
    @Nullable
    @JsonProperty("title")
    private String title;


    public int getDuration() {
        return duration;
    }

    @Nullable
    public String getPerformer() {
        return performer;
    }

    @Nullable
    public String getTitle() {
        return title;
    }

}
