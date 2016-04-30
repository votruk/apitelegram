package ru.kurtov.apitelegram.models.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by KURT on 30.04.2016.
 */
public enum MessageEntityType {

    @JsonProperty("mention")
    MENTION,
    @JsonProperty("hashtag")
    HASHTAG,
    @JsonProperty("bot_command")
    BOT_COMMAND,
    @JsonProperty("url")
    URL,
    @JsonProperty("email")
    EMAIL,
    @JsonProperty("bold")
    BOLD,
    @JsonProperty("italic")
    ITALIC,
    @JsonProperty("code")
    CODE,
    @JsonProperty("pre")
    PRE,
    @JsonProperty("text_link")
    TEXT_LINK

}
