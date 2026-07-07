package com.github.zabavgit.javarushtelegrambot.bot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@SpringBootApplication
public class JavarushTelegrambotApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(JavarushTelegrambotApplication.class, args);

        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            JavaRushTelegramBot bot = context.getBean(JavaRushTelegramBot.class);
            botsApi.registerBot(bot);

            System.out.println("Бот успешно зарегистрирован и готов к работе!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}