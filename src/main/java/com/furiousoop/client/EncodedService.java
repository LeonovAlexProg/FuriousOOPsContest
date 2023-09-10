package com.furiousoop.client;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EncodedService {
    private final RestTemplate restTemplate = new RestTemplate();

    public EncodedDto getEncoded() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("AUTH_TOKEN", "74a61737-8139-497e-b5f2-df04ea507730");

        HttpEntity<Void> requestEntity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange("http://ya.praktikum.fvds.ru:8080/dev-day/task/2", HttpMethod.GET, requestEntity, String.class);

        return htmlParser(response.getBody());
    }

    private EncodedDto htmlParser(String htmlString) {
        int idx1 = htmlString.indexOf("&quot;", 1850) + 6;
        int idx2 = htmlString.indexOf("&quot;", 1855);

        int idx3 = htmlString.indexOf("&quot;", idx2 + 25) + 6;
        int idx4 = htmlString.indexOf("&quot;", idx3);

        return new EncodedDto(htmlString.substring(idx1, idx2), Integer.parseInt(htmlString.substring(idx3, idx4)));
    }
}
