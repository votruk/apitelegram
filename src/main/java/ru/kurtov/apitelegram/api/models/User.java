package ru.kurtov.apitelegram.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;

/**
 * Created by KURT on 24.04.2016.
 */
public class User implements Serializable {

    @JsonProperty("id")
    private int id;

    @JsonProperty("first_name")
    @NotNull
    private String firstName;
    @JsonProperty("last_name")
    @NotNull
    private String lastName;
    @JsonProperty("username")
    @NotNull
    private String username;

    @NotNull
    public String getFirstName() {
        return firstName;
    }

    @NotNull
    public String getLastName() {
        return lastName;
    }

    @NotNull
    public String getUsername() {
        return username;
    }

}
