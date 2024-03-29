package com.bk.commen.utils;

import com.alibaba.fastjson2.JSON;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Date;
import java.util.UUID;

/**
 * @Description: JWT token 生成策略
 * @author: BlackWarm
 * @date: 2024年 01月 15日  12:02
 */
@Component
public class JwtUtils {

    // 有效期                                 2个小时
    private static final long JWT_EXPIRE = 120 * 60 * 1000L;
    // 令牌密钥
    private static final String JWT_KEY = "540788";

    // 生成 token
    public String creatToken(Object data){
        // 当前时间
        long currentTime = System.currentTimeMillis();
        // 过期时间
        long expTime = currentTime + JWT_EXPIRE;
        // 构建 jwt
        JwtBuilder builder = Jwts.builder()
                .setId(UUID.randomUUID() + "")
                .setSubject(JSON.toJSONString(data))
                .setIssuer("system")
                .setIssuedAt(new Date(currentTime))
                // SignatureAlgorithm.HS256 对称加密
                .signWith(SignatureAlgorithm.HS256, encodeSecret(JWT_KEY))
                .setExpiration(new Date(expTime));
        return builder.compact();
    }

    // 将密钥转码
    private SecretKey encodeSecret(String key){
        byte[] encode = Base64.getEncoder().encode(key.getBytes());
        SecretKeySpec secretKeySpec = new SecretKeySpec(encode, 0, encode.length, "AES");
        return secretKeySpec;
    }


    public Claims parseToken(String token){
        Claims body = Jwts.parser()
                .setSigningKey(encodeSecret(JWT_KEY))
                .parseClaimsJws(token)
                .getBody();
        return body;
    }

    public <T> T parseToken(String token, Class<T> tClass){
        Claims body = Jwts.parser()
                .setSigningKey(encodeSecret(JWT_KEY))
                .parseClaimsJws(token)
                .getBody();
        return JSON.parseObject(body.getSubject(), tClass);
    }
}
