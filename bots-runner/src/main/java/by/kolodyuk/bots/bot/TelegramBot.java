package by.kolodyuk.bots.bot;

import by.kolodyuk.bots.common.Bot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.util.Optional;

@Component
@ManagedResource
public class TelegramBot extends TelegramLongPollingBot {

    private static final Logger LOGGER = LoggerFactory.getLogger(TelegramBot.class);

    @Value("${telegram.bot.name}")
    private String name;
    @Value("${telegram.bot.token}")
    private String token;

    @Autowired
    BotSelector botSelector;

    @Override
    public void onUpdateReceived(Update update) {
        long chatId = update.getMessage().getChatId();
        String message = update.getMessage().getText();

        Optional<Bot> selectedBot = botSelector.select(message);
        String reply = selectedBot.map(bot -> bot.reply(message))
                                  .orElse("No appropriate bot found");

        sendTextMessage(chatId, reply);
    }

    @ManagedOperation
    public void sendTextMessage(long chatId, String text) {
        try {
            SendMessage message = new SendMessage().setChatId(chatId).setText(text);
            execute(message);
        } catch (TelegramApiException e) {
            LOGGER.error("Failed to send text message to chatId {} ", chatId, e);
        }
    }

    @Override
    public String getBotToken() {
        return token;
    }

    @Override
    public String getBotUsername() {
        return name;
    }
}
