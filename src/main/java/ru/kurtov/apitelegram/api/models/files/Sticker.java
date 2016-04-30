package ru.kurtov.apitelegram.api.models.files;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.Nullable;

import java.io.Serializable;

/**
 * Created by KURT on 30.04.2016.
 */
public class Sticker extends FileWithIdAndSize implements Serializable {

    private final static long serialVersionUID = 0L;

    @Nullable
    @JsonProperty("thumb")
    private PhotoSize thumb;

    @Nullable
    public PhotoSize getThumb() {
        return thumb;
    }
}
