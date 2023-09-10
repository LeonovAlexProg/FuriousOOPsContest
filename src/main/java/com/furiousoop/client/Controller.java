package com.furiousoop.client;

import com.fasterxml.jackson.core.JsonParser;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequiredArgsConstructor
public class Controller {
    private final EncodedService encodedService;

    @GetMapping("/start")
    public void start() {
        encodedService.getEncoded();
    }
}
