package by.kolodyuk.bots.papajohns.service;

import by.kolodyuk.bots.papajohns.client.PapaJohnsClient;
import by.kolodyuk.bots.papajohns.client.model.PromoCode;
import by.kolodyuk.bots.papajohns.client.model.PromoCodeCheckRequest;
import by.kolodyuk.bots.papajohns.client.model.PromoCodeCheckResponse;
import by.kolodyuk.bots.papajohns.client.model.PromoCodes;
import by.kolodyuk.bots.papajohns.service.model.PromoCodeDomain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PapaJohnsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PapaJohnsService.class);

    @Autowired
    PapaJohnsClient papaJohnsClient;

    public List<PromoCodeDomain> getValidPromoCodes() {
        PromoCodes promoCodes = papaJohnsClient.getPromoCodes();
        List<PromoCodeDomain> validPromoCodes = new ArrayList<>();

        for (PromoCode code : promoCodes.getCodes()) {
            try {
                List<PromoCodeCheckResponse> checkResponses = papaJohnsClient.checkPromoCode(PromoCodeCheckRequest.of(code.getCode()));

                PromoCodeDomain promoCodeDomain = new PromoCodeDomain();
                promoCodeDomain.setCode(code.getCode());
                promoCodeDomain.setName(code.getName());
                promoCodeDomain.setMoneyRequired(checkResponses.get(0).getStock().getConditions().getMinimalSum().intValue());

                promoCodeDomain.setPrize(parsePrize(code.getName()));

                validPromoCodes.add(promoCodeDomain);
                LOGGER.info("Promo code: {} is valid", code.getCode());
            } catch (Exception e) {
                LOGGER.info("Promo code: {} is invalid", code.getCode());
            }
        }

        return validPromoCodes;
    }

    private String parsePrize(String codeName) {
        String[] tokens = codeName.split(" - ");
        int prizeIndex = 2;

        if (prizeIndex < tokens.length) {
            return tokens[prizeIndex];
        }

        return null;
    }
}
