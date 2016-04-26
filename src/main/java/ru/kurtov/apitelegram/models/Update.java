package ru.kurtov.apitelegram.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.Nullable;

import java.io.Serializable;

/**
 * Created by KURT on 24.04.2016.
 */
public class Update implements Serializable {

    private final static long serialVersionUID = 0L;

    @JsonProperty("update_id")
    private int updateId;
    @Nullable
    @JsonProperty("message")
    private Message message;
    @Nullable
    @JsonProperty("inline_query")
    private InlineQuery inlineQuery;
    @JsonProperty("chosen_inline_result")
    private @Nullable ChosenInlineResult chosenInlineResult;
    @Nullable
    @JsonProperty("callback_query")
    private CallbackQuery callbackQuery;

    public int getUpdateId() {
        return updateId;
    }

    @Nullable
    public Message getMessage() {
        return message;
    }

    @Nullable
    public InlineQuery getInlineQuery() {
        return inlineQuery;
    }

    @Nullable
    public ChosenInlineResult getChosenInlineResult() {
        return chosenInlineResult;
    }

    @Nullable
    public CallbackQuery getCallbackQuery() {
        return callbackQuery;
    }

    public UpdateType getUpdateType() {
        if (inlineQuery != null) {
            return UpdateType.INLINE_QUERY;
        }
        if (chosenInlineResult != null) {
            return UpdateType.CHOSEN_INLINE_RESULT;
        }
        if (callbackQuery != null) {
            return UpdateType.CALLBACK_QUERY;
        }
        return UpdateType.MESSAGE;
    }

}
