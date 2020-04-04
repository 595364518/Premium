package com.lhb.springboot.utils;

import java.util.Random;

/**
 * @author: yaya
 * @create: 2020/4/2
 * 验证码生成工具类
 */
public class CodeUtil {
    /**
     * 生成随机验证码
     * @return 验证码
     */
    public static String generateCode(){
        char[] codeArr = new char[62];
        char upperBegin = 'A';
        char lowerBegin = 'a';
        char digitBegin = '0';
        String validateCode = "";
        for(int i = 0;i <= 25;i++){
            codeArr[i] = upperBegin;
            upperBegin = (char)(upperBegin+1);
        }
        for(int i = 26;i <= 51;i++){
            codeArr[i] =lowerBegin;
            lowerBegin = (char)(lowerBegin+1);
        }
        for(int i = 52;i <= 61;i++){
            codeArr[i] = digitBegin;
            digitBegin = (char)(digitBegin+1);
        }
        Random random = new Random();
        for(int i = 0;i < 6;i++){
            validateCode +=codeArr[random.nextInt(62)];
        }
        return validateCode;
    }
}
