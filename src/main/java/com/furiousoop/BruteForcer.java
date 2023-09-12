package com.furiousoop;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BruteForcer {
    String alphabet = "0123456789ABCDEFabcdefZ";
    public List<String> passwords(){
        List<String> results = new ArrayList<>();
        for(String symbol1: alphabet.split("")) {
            for(String symbol2: alphabet.split("")) {
                for(String symbol3: alphabet.split("")) {
                    for(String symbol4: alphabet.split("")) {
                        for(String symbol5: alphabet.split("")) {
                            for(String symbol6: alphabet.split("")) {
                                for(String symbol7: alphabet.split("")) {
                                    for(String symbol8: alphabet.split("")) {
                                        String result = symbol1 + symbol2 + symbol3 + symbol4 + symbol5 + symbol6 + symbol7 + symbol8;
                                    results.add(result.replace("Z", ""));
                                        System.out.println(results);
                                    }
                                }
                            }
                        }
                    }
                }
            }

        }
        return results;
    }
}

