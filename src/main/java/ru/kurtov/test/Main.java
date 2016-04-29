package ru.kurtov.test;

import ru.kurtov.apitelegram.api.ApiTelegram;
import ru.kurtov.apitelegram.models.keyboard.KeyboardButton;
import ru.kurtov.apitelegram.models.keyboard.ReplyKeyboardHide;
import ru.kurtov.apitelegram.models.keyboard.ReplyKeyboardMarkup;
import ru.kurtov.apitelegram.requestbodies.SendMessageBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by KURT on 24.04.2016.
 */
public class Main {

    public static void main(String[] args) {

        final ApiTelegram apiTelegram = new ApiTelegram("183925292:AAHrPi7BHHVCK6vuvc8k7qbAIYfdAiaLnjI");
        apiTelegram.observeMessages()
                .filter(message -> message.getText() != null)
                .subscribe(message -> {
                    System.out.println(message.getText());
                    final SendMessageBody sendMessageBody = new SendMessageBody(message.getChat().getChatId(), "Что значит " + message.getText());
                    final String[] words = message.getText().split(" ");
                    final List<List<KeyboardButton>> keyboardButtons = new ArrayList<>();
                    for (final String string : words) {
                        final List<KeyboardButton> button = new ArrayList<>();
                        button.add(new KeyboardButton(string, null, null));
                        keyboardButtons.add(button);
                    }
                    sendMessageBody.setReplyMarkup(new ReplyKeyboardMarkup(keyboardButtons, true, null, null));
                    apiTelegram.sendMessage(sendMessageBody)
                            .subscribe(message1 ->{
                                System.out.println(message1.getText());
                            });
                });
    }

}
