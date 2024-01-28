package com.bk.commen.generator;

import java.util.Base64;

/**
 * @Description: TODO
 * @author: BlackWarm
 * @date: 2024年 01月 23日  21:48
 */
public class AESKeyGenerator {
    /**
     * 生成指定长度的随机密钥
     *
     * @param length 密钥长度（字节数）
     * @return 生成的随机密钥
     */
    public static String generateRandomKey(int length) {
        byte[] key = new byte[length];
        new java.security.SecureRandom().nextBytes(key);
        return Base64.getEncoder().encodeToString(key);
    }
//
    public static void main(String[] args) {
        String key = generateRandomKey(16); // 生成随机密钥，长度为16字节（128位）
        System.out.println("AES 密钥:: " + key);
    }
}
