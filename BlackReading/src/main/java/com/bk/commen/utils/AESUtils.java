package com.bk.commen.utils;

import com.bk.commen.vo.KeyCode;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * @Description: AES 加密工具类  用来对文章进行加密
 * @author: BlackWarm
 * @date: 2024年 01月 23日  21:17
 */
public class AESUtils {
    /****
     * 使用 AES 对称加密算法对文章进行加密
     *
     * @param article 要加密的文章
     * @param key     密钥
     * @return 加密后的数据
     * @throws NoSuchAlgorithmException 无此算法异常
     * @throws NoSuchPaddingException   无此填充异常
     * @throws InvalidKeyException      无效的密钥异常
     * @throws BadPaddingException      错误的填充异常
     * @throws IllegalBlockSizeException 非法的块大小异常
     */
    public static byte[] encrypt(String article, String key) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        return cipher.doFinal(article.getBytes(StandardCharsets.UTF_8));
    }
    /**
     * 使用 AES 对称解密算法对加密数据进行解密
     *
     * @param encryptedData 加密的数据
     * @param key           密钥
     * @return 解密后的文章
     * @throws NoSuchAlgorithmException 无此算法异常
     * @throws NoSuchPaddingException   无此填充异常
     * @throws InvalidKeyException      无效的密钥异常
     * @throws BadPaddingException      错误的填充异常
     * @throws IllegalBlockSizeException 非法的块大小异常
     */
    public static String decrypt(byte[] encryptedData, String key) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decryptedData = cipher.doFinal(encryptedData);
        return new String(decryptedData, StandardCharsets.UTF_8);
    }
    public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        String article = "This is a sample article.";
        String key = KeyCode.AESKEY.getKey();
        System.out.println("随机生成的密钥：" + key);
        // 加密文章
        byte[] encryptedData = encrypt(article, key);
        System.out.println("加密后的文章：");
        System.out.println(Base64.getEncoder().encodeToString(encryptedData));
        // 解密文章
        String decryptedArticle = decrypt(encryptedData, key);
        System.out.println("解密后的文章：");
        System.out.println(decryptedArticle);
    }
}
