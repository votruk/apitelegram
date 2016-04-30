package ru.kurtov.apitelegram.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.NotNull;
import ru.kurtov.apitelegram.api.models.files.PhotoSize;

import java.io.Serializable;
import java.util.List;

/**
 * Created by KURT on 30.04.2016.
 */
public class UserProfilePhotos implements Serializable {

    private final static long serialVersionUID = 0L;

    @JsonProperty("total_count")
    private int total_count;
    @JsonProperty("photos")
    private List<List<PhotoSize>> photos;

    @NotNull
    public int getTotal_count() {
        return total_count;
    }

    @NotNull
    public List<List<PhotoSize>> getPhotos() {
        return photos;
    }
}
