package ru.kurtov.apitelegram.requestbodies.enums;

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
