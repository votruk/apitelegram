package ru.kurtov.apitelegram.models.files;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.Nullable;

import java.io.Serializable;

/**
 * Created by KURT on 30.04.2016.
 */
public class Document extends FileWithIdAndMimeType implements Serializable {

    private final static long serialVersionUID = 0L;

    @Nullable
    @JsonProperty("thumb")
    private PhotoSize thumb;
    @Nullable
    @JsonProperty("file_name")
    private String fileName;

    @Nullable
    public PhotoSize getThumb() {
        return thumb;
    }

    @Nullable
    public String getFileName() {
        return fileName;
    }
}
