package ru.kurtov.test;

import ru.kurtov.apitelegram.api.ApiTelegram;
import ru.kurtov.apitelegram.api.models.Message;
import ru.kurtov.apitelegram.api.models.keyboard.KeyboardButton;
import ru.kurtov.apitelegram.api.models.keyboard.ReplyKeyboardMarkup;
import ru.kurtov.apitelegram.api.requestbodies.send.SendMessageBodyWithChatId;
import ru.kurtov.apitelegram.utils.messages.MessageType;
import ru.kurtov.apitelegram.utils.messages.TextMessage;
import ru.kurtov.apitelegram.utils.messages.TextMessageUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by KURT on 24.04.2016.
 */
public class Main {

    public static void main(final String[] args) {

        final ApiTelegram apiTelegram = new ApiTelegram("183925292:AAHrPi7BHHVCK6vuvc8k7qbAIYfdAiaLnjI");
//        apiTelegram.observeMessagesList()
//                .map(messages -> {
//                    System.out.println("GET MESSAGES");
//                    final ArrayList<TextMessage> textMessages = new ArrayList<>();
//                    for (final Message message : messages) {
//                        if (message.getMessageType() == MessageType.TEXT) {
//                            textMessages.add(TextMessageUtils.convertMessageToTextMessage(message));
//                        }
//                    }
//                    return textMessages;
//                })
        apiTelegram.subscription();
        apiTelegram.observeMessages()
//                .map(messages -> {
//                    System.out.println("GET MESSAGES");
//                    final ArrayList<TextMessage> textMessages = new ArrayList<>();
//                    for (final Message message : messages) {
//                        if (message.getMessageType() == MessageType.TEXT) {
//                            textMessages.add(TextMessageUtils.convertMessageToTextMessage(message));
//                        }
//                    }
//                    return textMessages;
//                })

                .filter(message -> message.getMessageType() == MessageType.TEXT)
                .map(TextMessageUtils::convertMessageToTextMessage)
                .subscribe(textMessages -> {
                    System.out.println(textMessages.getText());
//                    if (textMessage.getEntities() != null) {
//                        final List<SimpleMessageEntity> simpleMessageEntities = TextMessageUtils.getSimpleMessagesEntities(textMessage.getText(),
//                                textMessage.getEntities());
//                        StringBuilder stringBuilder = new StringBuilder();
//                        for (final SimpleMessageEntity simpleMessageEntity : simpleMessageEntities) {
//                            stringBuilder.append(simpleMessageEntity.getMessageEntityType().toString());
//                            stringBuilder.append(": ");
//                            stringBuilder.append(simpleMessageEntity.getText());
//                            stringBuilder.append(System.getProperty("line.separator"));
//                        }
//                        final SendMessageBody sendMessageBody = new SendMessageBody(textMessage.getChat().getChatId(), stringBuilder.toString());
//                        apiTelegram.sendMessage(sendMessageBody)
//                                .subscribe(message1 -> {
//                                    System.out.println(message1.getText());
//                                });
//                    }
                    final SendMessageBodyWithChatId sendMessageBody = new SendMessageBodyWithChatId(textMessages.getChat().getChatId(), "Я написал " + textMessages.getText());

                    final String[] words = textMessages.getText().split(" ");
                    final List<List<KeyboardButton>> keyboardButtons = new ArrayList<>();
                    for (final String string : words) {
                        final List<KeyboardButton> button = new ArrayList<>();
                        button.add(new KeyboardButton(string, null, null));
                        keyboardButtons.add(button);
                    }
                    sendMessageBody.setReplyMarkup(new ReplyKeyboardMarkup(keyboardButtons, true, null, null));
                    apiTelegram.sendMessage(sendMessageBody)
                                .subscribe(message1 -> {
                                    System.out.println(message1.getText());
                                });
                }, throwable -> {

                });
    }

}
