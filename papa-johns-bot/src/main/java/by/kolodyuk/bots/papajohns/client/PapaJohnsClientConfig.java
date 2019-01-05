package by.kolodyuk.bots.papajohns.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableFeignClients
public class PapaJohnsClientConfig {

    @Autowired
    MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter;

    @PostConstruct
    public void addTextJsonMediaType() {
        List<MediaType> supported = new ArrayList<>(mappingJackson2HttpMessageConverter.getSupportedMediaTypes());
        supported.add(new MediaType("text", "json"));
        mappingJackson2HttpMessageConverter.setSupportedMediaTypes(supported);
    }
}
