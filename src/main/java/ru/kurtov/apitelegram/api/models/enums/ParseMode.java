package ru.kurtov.apitelegram.api.models.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by KURT on 27.04.2016.
 */
public enum ParseMode {

    @JsonProperty("Markdown")
    MARKDOWN,
    @JsonProperty("HTML")
    HTML

}
