package by.kolodyuk.bots.papajohns.client;

import by.kolodyuk.bots.papajohns.client.model.PromoCodeCheckRequest;
import by.kolodyuk.bots.papajohns.client.model.PromoCodeCheckResponse;
import by.kolodyuk.bots.papajohns.client.model.PromoCodes;
import by.kolodyuk.bots.papajohns.service.PapaJohnsService;
import by.kolodyuk.bots.papajohns.service.model.PromoCodeDomain;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@Ignore
@RunWith(SpringRunner.class)
@EnableAutoConfiguration
@Import(PapaJohnsService.class)
@SpringBootTest(classes = PapaJohnsClientConfig.class, properties = "papajohns.ribbon.listOfServers=papajohns.by")
public class PapaJohnsClientTest {

    @Autowired
    PapaJohnsClient papaJohnsClient;

    @Autowired
    PapaJohnsService papaJohnsService;

    @Test
    public void getPromocodes() {
        List<PromoCodeCheckResponse> response = papaJohnsClient.checkPromoCode(PromoCodeCheckRequest.of("ПРАЗДНИКИ"));

        System.out.println(response);
    }

    @Test
    public void getValidPromoCodes() {
        List<PromoCodeDomain> validPromoCodes = papaJohnsService.getValidPromoCodes();
        System.out.println(validPromoCodes.size());
    }
}
