package ru.kurtov.apitelegram.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.Serializable;

/**
 * Created by KURT on 30.04.2016.
 */
public class Contact implements Serializable {

    private final static long serialVersionUID = 0L;

    @JsonProperty("phone_number")
    private String phone_number;
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;
    @JsonProperty("user_id")
    private Integer userId;

    @NotNull
    public String getPhone_number() {
        return phone_number;
    }

    @NotNull
    public String getFirstName() {
        return firstName;
    }

    @Nullable
    public String getLastName() {

        return lastName;
    }

    @Nullable
    public Integer getUserId() {
        return userId;
    }
}
