package ru.kurtov.apitelegram.api.models.files;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.Serializable;

/**
 * Created by KURT on 30.04.2016.
 */
public abstract class FileWithId implements Serializable {

    private final static long serialVersionUID = 0L;

    @JsonProperty("file_id")
    private String fileId;
    @Nullable
    @JsonProperty("file_size")
    private String fileSize;

    @NotNull
    public String getFileId() {
        return fileId;
    }

    @Nullable
    public String getFileSize() {
        return fileSize;
    }
}
