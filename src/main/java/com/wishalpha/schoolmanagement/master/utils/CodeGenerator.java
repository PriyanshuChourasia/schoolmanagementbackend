package com.wishalpha.schoolmanagement.master.utils;


import org.springframework.stereotype.Component;

@Component
public class CodeGenerator {

    public CodeGenerator() {}
    public String generateCode(String text){
        String code = "ORG";
        code = code + System.currentTimeMillis() + text;
        return code;
    }
}
