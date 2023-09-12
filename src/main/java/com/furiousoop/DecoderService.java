package com.furiousoop;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

@Service
public class DecoderService {
    private final RestTemplate restTemplate = new RestTemplate();

    public String getCoded() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("AUTH_TOKEN", "74a61737-8139-497e-b5f2-df04ea507730");

        HttpEntity<Void> requestEntity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange("http://ya.praktikum.fvds.ru:8080/dev-day/task/2", HttpMethod.GET, requestEntity, String.class);
        System.out.println(response.getBody());



        return null;
    }

    public List<String> decode(String string) {
        List<String> strings = new ArrayList<>();

        for (Charset in : Charset.availableCharsets().values()) {
            for (Charset out : Charset.availableCharsets().values()) {
                byte[] bytes = transcodeField(string.getBytes(), in, out);

                strings.add(new String(bytes, out));
            }
        }

        return strings;
    }

    public void tryString(String str) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("AUTH_TOKEN", "74a61737-8139-497e-b5f2-df04ea507730");
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<?> requestEntity = new HttpEntity<>("{\"congratulation\": \"" + str + "\"}" , headers);

        ResponseEntity<String> response = restTemplate.exchange("http://ya.praktikum.fvds.ru:8080/dev-day/task/2", HttpMethod.POST, requestEntity, String.class);
        System.out.println(response.getBody());
    }

    public static byte[] transcodeField(byte[] source, Charset from, Charset to) {
        return new String(source, from).getBytes(to);
    }

    private EncodedDto htmlParser(String htmlString) {
        int idx1 = htmlString.indexOf("&quot;", 1850) + 6;
        int idx2 = htmlString.indexOf("&quot;", 1855);

        int idx3 = htmlString.indexOf("&quot;", idx2 + 25) + 6;
        int idx4 = htmlString.indexOf("&quot;", idx3);

        return new EncodedDto(htmlString.substring(idx1, idx2), Integer.parseInt(htmlString.substring(idx3, idx4)));
    }
}
