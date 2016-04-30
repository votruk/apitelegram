package ru.kurtov.apitelegram.api.models.files;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.Nullable;

import java.io.Serializable;

/**
 * Created by KURT on 30.04.2016.
 */
public abstract class FileWithIdAndMimeType extends FileWithId implements Serializable {

    private final static long serialVersionUID = 0L;

    @Nullable
    @JsonProperty("mime_type")
    private String mimeType;

    @Nullable
    public String getMimeType() {
        return mimeType;
    }

}
