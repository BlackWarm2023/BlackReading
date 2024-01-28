package com.bk.commen.utils;

import com.bk.commen.vo.KeyCode;

import javax.crypto.Cipher;
import java.security.KeyFactory;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

/**
 * @Description: RSA 非对称加密 用来对密码进行加密,目前还没启用
 * @author: BlackWarm
 * @date: 2024年 01月 23日  21:17
 */
public class RSAUtils {
    private static final String ALGORITHM = "RSA";
    /**
     * RSA 公钥加密
     *
     * @param data 加密数据
     * @param publicKey 公钥
     * @return 密文
     * @throws Exception 加密过程中的异常
     */
    public static String encrypt(String data, String publicKey) throws Exception {
        // base64 编码的公钥
        byte[] decoded = Base64.getDecoder().decode(publicKey);
        RSAPublicKey pubKey = (RSAPublicKey) KeyFactory
                .getInstance(ALGORITHM)
                .generatePublic(new X509EncodedKeySpec(decoded));
        // RSA 加密
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, pubKey);
        return Base64
                .getEncoder()
                .encodeToString(cipher
                        .doFinal(data
                                .getBytes("UTF-8")));
    }
    /**
     * RSA 私钥解密
     *
     * @param data 解密数据
     * @param privateKey 私钥
     * @return 明文
     * @throws Exception 解密过程中的异常
     */
    public static String decrypt(String data, String privateKey) throws Exception {
        byte[] inputByte = Base64.getDecoder().decode(data.getBytes("UTF-8"));
        // base64 编码私钥
        byte[] decoded = Base64.getDecoder().decode(privateKey);
        RSAPrivateKey priKey = (RSAPrivateKey) KeyFactory
                .getInstance(ALGORITHM)
                .generatePrivate(new PKCS8EncodedKeySpec(decoded));
        // RSA 解密
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, priKey);
        return new String(cipher.doFinal(inputByte));
    }//
    public static void main(String[] args) throws Exception {
        RSAUtils rsaUtils = new RSAUtils();
        String plaintext = "你好";
        String encryptedText = rsaUtils.encrypt(plaintext, KeyCode.PUBLICKEY.getKey());
        String encryptedText2 = rsaUtils.encrypt(plaintext, KeyCode.PUBLICKEY.getKey());
        String decryptedText = rsaUtils.decrypt(encryptedText, KeyCode.PRIVATEKEY.getKey());
        System.out.println("明文::" + plaintext
                + "\n 加密1:: " + encryptedText
                + "\n 密文1长度:: " + encryptedText.length()
                + "\n 加密2:: " + encryptedText2
                + "\n 密文2长度:: " + encryptedText2.length()
                + "\n" + (encryptedText.equals(encryptedText2) ? "匹配成功" : "匹配失败")
                + "\n 解密:: " + decryptedText
        );
    }
}