package com.wishalpha.schoolmanagement.master.utils;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


@Component
public class PasswordGenerator {

    private final PasswordEncoder passwordEncoder;

    public PasswordGenerator(PasswordEncoder passwordEncoder){
        this.passwordEncoder = passwordEncoder;
    }

    public String encodePassword(String password){
        String encoded = passwordEncoder.encode(password);
        return encoded;
    }

    public String generatePassword(){
        int min = (int) 'A';
        int max = (int) 'z';
        int smallMin = (int) 'a';
        int smallMax = (int) 'z';
        int maxLoop = 3;
        int[] numarr = new int[maxLoop];
        String randomString = "";


        int randomInt = (int) (Math.random() * (max - min + 1) ) +  min;
        int randomIntTwo = (int) (Math.random() * (smallMax - smallMin + 1) ) +  smallMin;
        char char1 = (char) randomInt;
        char char2 = (char) randomIntTwo;
        randomString = randomString + char1 + char2;

        for (int i = 0; i < maxLoop; i++){
            int randomNum = (int) (Math.random() * (10000 - 90 + 1) ) +  90;
            randomString = randomString + "" + randomNum;
            numarr[i] = randomNum;
        }
        return randomString;
    }


}
