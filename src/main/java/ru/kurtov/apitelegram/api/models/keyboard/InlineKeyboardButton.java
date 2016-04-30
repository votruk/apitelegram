package ru.kurtov.apitelegram.api.models.keyboard;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.Serializable;

/**
 * Created by KURT on 30.04.2016.
 */
public class InlineKeyboardButton implements Serializable {

    private final static long serialVersionUID = 0L;

    @JsonProperty("text")
    private final String text;
    @JsonProperty("url")
    private final String url;
    @JsonProperty("callback_data")
    private final String callbackData;
    @JsonProperty("switch_inline_query")
    private final String switchInlineQuery;

    public InlineKeyboardButton(@NotNull final String text,
                                @Nullable final String url,
                                @Nullable final String callbackData,
                                @Nullable final String switchInlineQuery) {
        this.text = text;
        this.url = url;
        this.callbackData = callbackData;
        this.switchInlineQuery = switchInlineQuery;
    }

    @NotNull
    public String getText() {
        return text;
    }

    @Nullable
    public String getUrl() {
        return url;
    }

    @Nullable
    public String getCallbackData() {
        return callbackData;
    }

    @Nullable
    public String getSwitchInlineQuery() {
        return switchInlineQuery;
    }
}
