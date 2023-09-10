package com.furiousoop;

import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;

import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class ResultService {
    private final RestTemplate restTemplate = new RestTemplate();

    public String sendAnswer(String decoded) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("AUTH_TOKEN", "74a61737-8139-497e-b5f2-df04ea507730");
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<?> requestEntity = new HttpEntity<>("{\"decoded\": \"" + decoded + "\"}" , headers);

        ResponseEntity<String> response = restTemplate.exchange("http://ya.praktikum.fvds.ru:8080/dev-day/task/2", HttpMethod.POST, requestEntity, String.class);
        System.out.println(response.getBody());

        return response.getBody();
    }
}
