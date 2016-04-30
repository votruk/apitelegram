package ru.kurtov.apitelegram.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.kurtov.apitelegram.api.models.enums.ChatType;

import java.io.Serializable;

/**
 * Created by KURT on 24.04.2016.
 */
public class Chat implements Serializable {

    private final static long serialVersionUID = 0L;

    @JsonProperty("id")
    private int chatId;
    @JsonProperty("type")
    private ChatType chatType;
    @Nullable
    @JsonProperty("title")
    private String title;
    @Nullable
    @JsonProperty("username")
    private String username;
    @Nullable
    @JsonProperty("first_name")
    private String firstName;
    @Nullable
    @JsonProperty("last_name")
    private String lastName;

    public int getChatId() {
        return chatId;
    }

    @NotNull
    public ChatType getChatType() {
        return chatType;
    }

    @Nullable
    public String getTitle() {
        return title;
    }

    @Nullable
    public String getUsername() {
        return username;
    }

    @Nullable
    public String getFirstName() {
        return firstName;
    }

    @Nullable
    public String getLastName() {
        return lastName;
    }

}
