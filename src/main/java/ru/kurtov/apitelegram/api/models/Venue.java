package ru.kurtov.apitelegram.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.Serializable;

/**
 * Created by KURT on 30.04.2016.
 */
public class Venue implements Serializable {

    private final static long serialVersionUID = 0L;

    @JsonProperty("location")
    private Location location;
    @JsonProperty("title")
    private String title;
    @JsonProperty("address")
    private String address;
    @JsonProperty("foursquare_id")
    private String foursquareId;

    @NotNull
    public Location getLocation() {
        return location;
    }

    @NotNull
    public String getTitle() {
        return title;
    }

    @NotNull
    public String getAddress() {
        return address;
    }

    @Nullable
    public String getFoursquareId() {
        return foursquareId;
    }
}
