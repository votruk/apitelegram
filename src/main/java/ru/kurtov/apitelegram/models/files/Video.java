package ru.kurtov.apitelegram.models.files;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.Nullable;

import java.io.Serializable;

/**
 * Created by KURT on 30.04.2016.
 */
public class Video extends FileWithIdAndSize implements Serializable {

    private final static long serialVersionUID = 0L;

    @JsonProperty("duration")
    private int duration;
    @JsonProperty("thumb")
    private PhotoSize thumb;
    @JsonProperty("mime_type")
    private String mimeType;

    public int getDuration() {
        return duration;
    }

    @Nullable
    public PhotoSize getThumb() {
        return thumb;
    }

    @Nullable
    public String getMimeType() {
        return mimeType;
    }

}
