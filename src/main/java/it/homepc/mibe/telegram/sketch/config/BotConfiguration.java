package it.homepc.mibe.telegram.sketch.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MissingRequiredPropertiesException;

@Configuration
public class BotConfiguration {

    private final Environment env;

    @Autowired
    public BotConfiguration(Environment env) {
        this.env = env;
    }

    @Bean(name = "apiToken")
    public String getBotApiToken() {
        String botToken = env.getProperty("telegram.bot.token");
        if (botToken == null) {
            throw new MissingRequiredPropertiesException();
        } else {
            return botToken;
        }
    }

    @Bean(name = "botUsername")
    public String getBotUsername() {
        String botUsername = env.getProperty("telegram.bot.username");
        if (botUsername == null) {
            throw new MissingRequiredPropertiesException();
        } else {
            return botUsername;
        }
    }

}
