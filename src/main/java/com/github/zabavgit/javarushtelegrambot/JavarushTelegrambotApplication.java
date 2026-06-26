package com.github.zabavgit.javarushtelegrambot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@SpringBootApplication
public class JavarushTelegrambotApplication {

    public static void main(String[] args) {
        // 1. Запускаем Spring контекст и сохраняем его в переменную
        ConfigurableApplicationContext context = SpringApplication.run(JavarushTelegrambotApplication.class, args);

        try {
            // 2. Достаем твоего бота, которого Spring уже создал благодаря аннотации @Component
            JavaRushTelegramBot javaRushTelegramBot = context.getBean(JavaRushTelegramBot.class);

            // 3. Создаем официальное API сессии Telegram
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);

            // 4. Регистрируем бота. Именно эта строчка создает бесконечный фоновый поток (Long Polling)!
            botsApi.registerBot(javaRushTelegramBot);

            System.out.println("Робот успешно запущен и слушает Telegram!");

        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}