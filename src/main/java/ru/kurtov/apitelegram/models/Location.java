package ru.kurtov.apitelegram.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created by KURT on 27.04.2016.
 */
public class Location implements Serializable {

    private final static long serialVersionUID = 0L;

    @JsonProperty("longitude")
    private float longitude;
    @JsonProperty("latitude")
    private float latitude;

    public float getLongitude() {
        return longitude;
    }

    public float getLatitude() {
        return latitude;
    }

}
