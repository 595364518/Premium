package com.lhb.springboot.utils;

import org.springframework.util.StringUtils;

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
        char[] codeArr = new char[58];
        char upperBegin = 'A';
        char lowerBegin = 'a';
        char digitBegin = '0';
        String validateCode = "";
        for(int i = 0;i <= 23;i++){
            codeArr[i] = upperBegin;
            if(i==7||i==9){
                upperBegin = (char)(upperBegin+2);
            }else{
                upperBegin = (char)(upperBegin+1);
            }
        }
        for(int i = 24;i <= 47;i++){
            codeArr[i] =lowerBegin;
            if(i==31||i==33){
                lowerBegin = (char)(lowerBegin+2);
            }else{
                lowerBegin = (char)(lowerBegin+1);
            }
        }
        for(int i = 48;i <= 57;i++){
            codeArr[i] = digitBegin;
            digitBegin = (char)(digitBegin+1);
        }
        Random random = new Random();
        for(int i = 0;i < 6;i++){
            validateCode +=codeArr[random.nextInt(58)];
        }
//        for (char a:codeArr) {
//            System.out.print(a+",");
//        }
        return validateCode;
    }
}
