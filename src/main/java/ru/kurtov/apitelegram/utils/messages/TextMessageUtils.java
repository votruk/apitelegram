package ru.kurtov.apitelegram.utils.messages;

import org.jetbrains.annotations.NotNull;
import ru.kurtov.apitelegram.ShouldNotHappenedException;
import ru.kurtov.apitelegram.api.models.Message;
import ru.kurtov.apitelegram.api.models.MessageEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by KURT on 01.05.2016.
 */
public final class TextMessageUtils {

    @NotNull
    public static TextMessage convertMessageToTextMessage(@NotNull final Message message) throws ShouldNotHappenedException {
        if (message.getText() == null) {
            throw new ShouldNotHappenedException("Cannot convert Message to TextMessage because text is null");
        }
        return new TextMessage(message.getMessageId(), message.getDate(), message.getChat(), message.getFromUser(), message.getFromUser(),
                message.getForwardDate(), message.getReplyToMessage(), message.getText(), message.getEntities());
    }

    @NotNull
    public static List<SimpleMessageEntity> getSimpleMessagesEntities(@NotNull final String messageText,
                                                                      @NotNull final List<MessageEntity> entities) {
        final List<SimpleMessageEntity> simpleMessageEntities = new ArrayList<>();
        for (final MessageEntity messageEntity : entities) {
            simpleMessageEntities.add(new SimpleMessageEntity(messageEntity.getType(), messageText.substring(messageEntity.getOffset(),
                    messageEntity.getOffset() + messageEntity.getLength())));
        }
        return simpleMessageEntities;
    }

    private TextMessageUtils() {
    }
}
