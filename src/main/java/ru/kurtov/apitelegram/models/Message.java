package ru.kurtov.apitelegram.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.kurtov.apitelegram.models.files.*;

import java.io.Serializable;
import java.util.List;

/**
 * Created by KURT on 24.04.2016.
 */
public class Message implements Serializable {

    private final static long serialVersionUID = 0L;

    @JsonProperty("message_id")
    private int messageId;
    @Nullable
    @JsonProperty("from")
    private User fromUser;
    @JsonProperty("date")
    private int date;
    @JsonProperty("chat")
    private Chat chat;
    @Nullable
    @JsonProperty("forward_date")
    private Integer forwardDate;
    @Nullable
    @JsonProperty("reply_to_message")
    private Message replyToMessage;
    @Nullable
    @JsonProperty("text")
    private String text;
    @Nullable
    @JsonProperty("entities")
    private List<MessageEntity> entities;
    @JsonProperty("audio")
    private @Nullable Audio audio;
    @JsonProperty("document")
    private @Nullable Document document;
    @Nullable
    @JsonProperty("photo")
    private List<PhotoSize> photo;
    @Nullable
    @JsonProperty("sticker")
    private Sticker sticker;
    @Nullable
    @JsonProperty("video")
    private Video video;
    @Nullable
    @JsonProperty("voice")
    private Voice voice;
    @Nullable
    @JsonProperty("caption")
    private String caption;
    @Nullable
    @JsonProperty("contact")
    private Contact contact;
    @Nullable
    @JsonProperty("location")
    private Location location;
    @Nullable
    @JsonProperty("venue")
    private Venue venue;
    @Nullable
    @JsonProperty("new_chat_member")
    private User newChatMember;
    @Nullable
    @JsonProperty("left_chat_member")
    private User leftChatMember;
    @Nullable
    @JsonProperty("new_chat_title")
    private String newChatTitle;
    @Nullable
    @JsonProperty("new_chat_photo")
    private List<PhotoSize> newChatPhoto;
    @Nullable
    @JsonProperty("delete_chat_photo")
    private Boolean deleteChatPhoto;
    @Nullable
    @JsonProperty("group_chat_created")
    private Boolean groupChatCreated;
    @Nullable
    @JsonProperty("supergroup_chat_created")
    private Boolean supergroupChatCreated;
    @Nullable
    @JsonProperty("channel_chat_created")
    private Boolean channelChatCreated;
    @Nullable
    @JsonProperty("migrate_to_chat_id")
    private Integer migrateToChatId;
    @Nullable
    @JsonProperty("migrate_from_chat_id")
    private Integer migrateFromChatId;
    @Nullable
    @JsonProperty("pinned_message")
    private Message pinnedMessage;


    public int getMessageId() {
        return messageId;
    }

    @Nullable
    public User getFromUser() {
        return fromUser;
    }

    public int getDate() {
        return date;
    }

    @NotNull
    public Chat getChat() {
        return chat;
    }

    @Nullable
    public Integer getForwardDate() {
        return forwardDate;
    }

    @Nullable
    public Message getReplyToMessage() {
        return replyToMessage;
    }

    @Nullable
    public String getText() {
        return text;
    }

    @Nullable
    public List<MessageEntity> getEntities() {
        return entities;
    }

    @Nullable
    public Audio getAudio() {
        return audio;
    }

    @Nullable
    public Document getDocument() {
        return document;
    }

    @Nullable
    public List<PhotoSize> getPhoto() {
        return photo;
    }

    @Nullable
    public Sticker getSticker() {
        return sticker;
    }

    @Nullable
    public Video getVideo() {
        return video;
    }

    @Nullable
    public Voice getVoice() {
        return voice;
    }

    @Nullable
    public String getCaption() {
        return caption;
    }

    @Nullable
    public Contact getContact() {
        return contact;
    }

    @Nullable
    public Location getLocation() {
        return location;
    }

    @Nullable
    public Venue getVenue() {
        return venue;
    }

    @Nullable
    public User getNewChatMember() {
        return newChatMember;
    }

    @Nullable
    public User getLeftChatMember() {
        return leftChatMember;
    }

    @Nullable
    public String getNewChatTitle() {
        return newChatTitle;
    }

    @Nullable
    public List<PhotoSize> getNewChatPhoto() {
        return newChatPhoto;
    }

    @Nullable
    public Boolean getDeleteChatPhoto() {
        return deleteChatPhoto;
    }

    @Nullable
    public Boolean getGroupChatCreated() {
        return groupChatCreated;
    }

    @Nullable
    public Boolean getSupergroupChatCreated() {
        return supergroupChatCreated;
    }

    @Nullable
    public Boolean getChannelChatCreated() {
        return channelChatCreated;
    }

    @Nullable
    public Integer getMigrateToChatId() {
        return migrateToChatId;
    }

    @Nullable
    public Integer getMigrateFromChatId() {
        return migrateFromChatId;
    }

    @Nullable
    public Message getPinnedMessage() {
        return pinnedMessage;
    }

}
