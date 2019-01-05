package by.kolodyuk.bots.papajohns.controller;

import by.kolodyuk.bots.papajohns.service.PapaJohnsService;
import by.kolodyuk.bots.papajohns.service.model.PromoCodeDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class PapaJohnsController {

    @Autowired
    PapaJohnsService papaJohnsService;

    public String getPromoCodesGroupedByPrice() {
        Map<Integer, List<PromoCodeDomain>> grouped = papaJohnsService.getValidPromoCodes()
                                                                      .stream()
                                                                      .collect(Collectors.groupingBy(PromoCodeDomain::getMoneyRequired));
        return grouped.keySet()
                      .stream()
                      .sorted()
                      .map(price -> "От " + price + " рублей:\n" + toString(grouped.get(price)))
                      .collect(Collectors.joining("\n"));
    }

    private String toString(List<PromoCodeDomain> promoCodes) {
        return promoCodes.stream().map(this::toString).collect(Collectors.joining("\n", "", "\n"));
    }

    private String toString(PromoCodeDomain promoCodeDomain) {
        String prizePostfix = promoCodeDomain.getPrize() != null ? " - " + promoCodeDomain.getPrize() : "";
        return promoCodeDomain.getCode() + prizePostfix;
    }
}
