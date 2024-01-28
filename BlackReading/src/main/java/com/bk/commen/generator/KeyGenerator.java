package com.bk.commen.generator;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * @Description: RSA 密钥生成器
 * @author: BlackWarm
 * @date: 2024年 01月 23日  18:18
 */
public class KeyGenerator {
//
    public static void main(String[] args) throws NoSuchAlgorithmException {
        // 创建密钥生成器
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        // 初始化密钥生成器
        keyPairGenerator.initialize(2048);
        // 生成密钥对
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        // 获取公钥
        byte[] publicKeyBytes = keyPair.getPublic().getEncoded();
        // 获取私钥
        byte[] privateKeyBytes = keyPair.getPrivate().getEncoded();
        // 将公钥和私钥转换为 Base64 编码
        String publicKey = Base64.getEncoder().encodeToString(publicKeyBytes);
        String privateKey = Base64.getEncoder().encodeToString(privateKeyBytes);
        // 打印公钥和私钥
        System.out.println("公钥：" + publicKey);
        System.out.println("私钥：" + privateKey);
    }
}
