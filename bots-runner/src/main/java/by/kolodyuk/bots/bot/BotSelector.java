package by.kolodyuk.bots.bot;

import by.kolodyuk.bots.common.Bot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class BotSelector {

    @Autowired
    List<Bot> bots;

    Optional<Bot> select(String command) {
        return bots.stream()
                   .filter(bot -> bot.accept(command))
                   .findFirst();
    }
}
