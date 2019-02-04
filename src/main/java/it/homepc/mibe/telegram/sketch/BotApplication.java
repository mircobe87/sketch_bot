package it.homepc.mibe.telegram.sketch;

import it.homepc.mibe.telegram.sketch.bot.Bot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@SpringBootApplication
public class BotApplication implements ApplicationListener<ApplicationReadyEvent> {

    private final Bot theBot;

    @Autowired
    public BotApplication(Bot theBot) {
        this.theBot = theBot;
    }

    public static void main(String[] args) {
        ApiContextInitializer.init();
        SpringApplication.run(BotApplication.class, args);
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        TelegramBotsApi botsApi = new TelegramBotsApi();

        try {
            botsApi.registerBot(theBot);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}

