package by.kolodyuk.bots.papajohns;

import by.kolodyuk.bots.common.KeyWordBot;
import by.kolodyuk.bots.papajohns.controller.PapaJohnsController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class PapaJohnsBot extends KeyWordBot {

    @Autowired
    PapaJohnsController papaJohnsController;

    @Override
    public String reply(String command) {
        return papaJohnsController.getPromoCodesGroupedByPrice();
    }

    @Override
    public List<String> getAcceptedKeyWords() {
        return Arrays.asList("papajohns", "papa-johns", "papa");
    }
}
