package by.kolodyuk.bots.papajohns.client;

import by.kolodyuk.bots.papajohns.client.model.PromoCodeCheckRequest;
import by.kolodyuk.bots.papajohns.client.model.PromoCodeCheckResponse;
import by.kolodyuk.bots.papajohns.client.model.PromoCodes;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(value = "papajohns", url = "https://www.papajohns.by")
public interface PapaJohnsClient {

    @GetMapping(path = "/api/stock/codes")
    PromoCodes getPromoCodes();
    @PostMapping(path = "/api/stock/code")
    List<PromoCodeCheckResponse> checkPromoCode(PromoCodeCheckRequest request);
}
