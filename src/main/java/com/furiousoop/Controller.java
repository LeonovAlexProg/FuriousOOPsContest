package com.furiousoop;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class Controller {
    private final ResultService resultService;
    private final EncodedService encodedService;
    private final Caesar caesar;
    private final BruteForcer bruteForcer;
    private final DecoderService decoderService;

    @GetMapping("/start")
    public void start() {
        EncodedDto dto = encodedService.getEncoded();
        String answer = caesar.result(dto.getEncoded(), dto.getOffset());
        resultService.sendAnswer(answer);
    }

    @GetMapping("/brut")
    public void brut() {
        bruteForcer.passwords();
    }

    @GetMapping("/decode")
    public void decode() throws UnsupportedEncodingException {
        String coded = decoderService.getCoded();
        String decoded = decoderService.decode(coded);
        decoderService.sendDecoded(decoded);
    }
}
