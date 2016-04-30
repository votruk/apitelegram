package ru.kurtov.apitelegram.api.models.keyboard;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.Serializable;

/**
 * Created by KURT on 30.04.2016.
 */
public class KeyboardButton implements Serializable {

    private final static long serialVersionUID = 0L;

    @JsonProperty("text")
    private final String text;
    @JsonProperty("request_contact")
    private final Boolean requestContact;
    @JsonProperty("request_location")
    private final Boolean requestLocation;

    public KeyboardButton(@NotNull final String text,
                          @Nullable final Boolean requestContact,
                          @Nullable final Boolean requestLocation) {
        this.text = text;
        this.requestContact = requestContact;
        this.requestLocation = requestLocation;
    }

    @NotNull
    public String getText() {
        return text;
    }

    @Nullable
    public Boolean getRequestContact() {
        return requestContact;
    }

    @Nullable
    public Boolean getRequestLocation() {
        return requestLocation;
    }

}
