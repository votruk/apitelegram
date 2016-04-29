package ru.kurtov.test;

import ru.kurtov.apitelegram.api.ApiTelegram;
import ru.kurtov.apitelegram.models.keyboard.ReplyKeyboardHide;
import ru.kurtov.apitelegram.requestbodies.SendMessageBody;

/**
 * Created by KURT on 24.04.2016.
 */
public class Main {

    public static void main(String[] args) {

        final ApiTelegram apiTelegram = new ApiTelegram("183925292:AAHrPi7BHHVCK6vuvc8k7qbAIYfdAiaLnjI");
        apiTelegram.observeMessages()
                .subscribe(message -> {
                    System.out.println(message.getText());
                    final SendMessageBody sendMessageBody = new SendMessageBody(message.getChat().getChatId(), "Что значит " + message.getText());
                    sendMessageBody.setReplyMarkup(new ReplyKeyboardHide(true));
                    apiTelegram.sendMessage(sendMessageBody)
                            .subscribe(message1 ->{
                                System.out.println(message1.getText());
                            });
                });
    }

}
