package com.furiousoop;

import com.ibm.icu.text.CharsetDetector;
import com.ibm.icu.text.CharsetMatch;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class DecoderService {
    private final RestTemplate restTemplate = new RestTemplate();

    public String getCoded() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("AUTH_TOKEN", "74a61737-8139-497e-b5f2-df04ea507730");

        HttpEntity<Void> requestEntity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange("http://ya.praktikum.fvds.ru:8080/dev-day/task/4", HttpMethod.GET, requestEntity, String.class);

        String str = htmlParser(response.getBody());

        return str;
    }

    public void sendDecoded(String str) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("AUTH_TOKEN", "74a61737-8139-497e-b5f2-df04ea507730");
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<?> requestEntity = new HttpEntity<>("{\"congratulation\": \"" + str + "\"}" , headers);

        ResponseEntity<String> response = restTemplate.exchange("http://ya.praktikum.fvds.ru:8080/dev-day/task/4", HttpMethod.POST, requestEntity, String.class);
        System.out.println(response.getBody());
    }

    public String decode(String string) throws UnsupportedEncodingException {
        byte bytes[] = string.getBytes("windows-1251");
        String value = new String(bytes, "UTF-8");

        return value;
    }

    public void tryString(String str) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("AUTH_TOKEN", "74a61737-8139-497e-b5f2-df04ea507730");
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<?> requestEntity = new HttpEntity<>("{\"congratulation\": \"" + str + "\"}" , headers);

        ResponseEntity<String> response = restTemplate.exchange("http://ya.praktikum.fvds.ru:8080/dev-day/task/4", HttpMethod.POST, requestEntity, String.class);
        System.out.println(response.getBody());
    }

    public static byte[] transcodeField(byte[] source, Charset from, Charset to) {
        return new String(source, from).getBytes(to);
    }

    private String htmlParser(String htmlString) {
        int idx1 = htmlString.indexOf("<span>") + 6;
        int idx2 = htmlString.indexOf("</span>");


        return htmlString.substring(idx1, idx2);
    }
}
