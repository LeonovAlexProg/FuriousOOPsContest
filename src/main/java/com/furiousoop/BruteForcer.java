package com.furiousoop;

import java.util.ArrayList;
import java.util.List;

public class BruteForcer {
    String alphabet = "0123456789ABCDEFabcdef";

    List<Character> oldSymbols = new ArrayList<>();
    private int minPlace = 0;
    private int maxPlace = alphabet.length();
    private int numberPlace = 0;
    private char thisChar = '0';
    private String result = "00000000";

    public String getPassword() {
        char pointer;
        while (numberPlace < result.length()) {
            pointer = getTest(result);
            if (pointer == '=') {
                break;
            }
            thisChar = newChar(pointer);
            result = result.substring(0, numberPlace) + thisChar + result.substring(numberPlace + 1);
        }
        return result;
    }

    private char getTest(String passPhrase) {
        String pass = "10EE9Ef2";
        long passValue = convertValue(pass);
        long passPhraseValue = convertValue(passPhrase);
        char getTest;

        if (passValue < passPhraseValue) {
            getTest = '<';
        } else if (passPhraseValue == passValue) {
            getTest = '=';
        } else {
            getTest = '>';
        }
        return getTest;
    }

    private long convertValue(String passPhrase) {
        long total = 0;
        for (int i = 0; i < passPhrase.length(); i++) {
            total += alphabet.indexOf(passPhrase.charAt(i)) * Math.pow(alphabet.length(), passPhrase.length() - i - 1.0);
        }
        return total;
    }

    private char newChar(char pointer) {
        char resultNewChar = 'A';
        int thisPlace = alphabet.indexOf(thisChar);

        if (pointer == '>' && thisPlace == maxPlace - 1) {
            numberPlace++;
            minPlace = 0;
            maxPlace = alphabet.length();
        } else if (pointer == '>') {
            minPlace = thisPlace;
            if (maxPlace - thisPlace == 1) {
                maxPlace = thisPlace;
            } else {
                thisPlace +=  (maxPlace - thisPlace) / 2;
            }
            resultNewChar = alphabet.charAt(thisPlace);
        } else if (pointer == '<' && thisPlace == minPlace) {
            numberPlace--;
            minPlace = 0;
            maxPlace = alphabet.length();
        } else if (pointer == '<') {
            maxPlace = thisPlace;
            if (thisPlace - minPlace == 1) {
                thisPlace = minPlace;
            } else {
                thisPlace -= (thisPlace - minPlace) / 2;
            }
            resultNewChar = alphabet.charAt(thisPlace);
        }
        return resultNewChar;
    }
}

