package com.furiousoop;

public class Caesar {
    String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public String result(String string, int shift){
        String alphebet2 =  alphabet.substring(shift) + alphabet.substring(0, shift);
        StringBuilder stringBuilder = new StringBuilder();
        for(String word: string.split("")){
            int index = alphebet2.indexOf(word);
            if (index == -1) {
                stringBuilder.append(word);
            } else {
                char char1 = alphabet.charAt(index);
                stringBuilder.append(char1);
            }
        }
        return stringBuilder.toString();
    }
}
