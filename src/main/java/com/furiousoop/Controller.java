package com.furiousoop;

import com.furiousoop.client.EncodedDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class Controller {
    private final ResultService resultService;
    private final EncodedService encodedService;
    private final Caesar caesar;

    @GetMapping("/start")
    public void start() {
        EncodedDto dto = encodedService.getEncoded();
        String answer = caesar.result(dto.getEncoded(), dto.getOffset());
        resultService.sendAnswer(answer);
    }
}
