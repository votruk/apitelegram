package ru.kurtov.test;

import ru.kurtov.apitelegram.api.ApiTelegram;
import ru.kurtov.apitelegram.api.requestbodies.SendMessageBody;
import ru.kurtov.apitelegram.utils.messages.MessageType;
import ru.kurtov.apitelegram.utils.messages.SimpleMessageEntity;
import ru.kurtov.apitelegram.utils.messages.TextMessageUtils;

import java.util.List;

/**
 * Created by KURT on 24.04.2016.
 */
public class Main {

    public static void main(final String[] args) {

        final ApiTelegram apiTelegram = new ApiTelegram("183925292:AAHrPi7BHHVCK6vuvc8k7qbAIYfdAiaLnjI");
        apiTelegram.observeMessages()
                .filter(message -> message.getMessageType() == MessageType.TEXT)
                .map(TextMessageUtils::convertMessageToTextMessage)
                .subscribe(textMessage -> {
                    if (textMessage.getEntities() != null) {
                        final List<SimpleMessageEntity> simpleMessageEntities = TextMessageUtils.getSimpleMessagesEntities(textMessage.getText(),
                                textMessage.getEntities());
                        StringBuilder stringBuilder = new StringBuilder();
                        for (final SimpleMessageEntity simpleMessageEntity : simpleMessageEntities) {
                            stringBuilder.append(simpleMessageEntity.getMessageEntityType().toString());
                            stringBuilder.append(": ");
                            stringBuilder.append(simpleMessageEntity.getText());
                            stringBuilder.append(System.getProperty("line.separator"));
                        }
                        final SendMessageBody sendMessageBody = new SendMessageBody(textMessage.getChat().getChatId(), stringBuilder.toString());
                        apiTelegram.sendMessage(sendMessageBody)
                                .subscribe(message1 -> {
                                    System.out.println(message1.getText());
                                });
                    }
//                    final String[] words = message.getText().split(" ");
//                    final List<List<KeyboardButton>> keyboardButtons = new ArrayList<>();
//                    for (final String string : words) {
//                        final List<KeyboardButton> button = new ArrayList<>();
//                        button.add(new KeyboardButton(string, null, null));
//                        keyboardButtons.add(button);
//                    }
//                    sendMessageBody.setReplyMarkup(new ReplyKeyboardMarkup(keyboardButtons, true, null, null));

                }, throwable -> {

                });
    }

}
