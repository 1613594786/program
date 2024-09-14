package com.example.springboot.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.Map;

/**
 * @author zzp
 * @create 2024/8/29-20:54
 */
public class JwtUtil {
    private static final String SECRET_KEY = "zzptoken";
    private static final long EXPIRATION_TIME = 1000*60*60*2;//两小时
    public static String createJWT(Map<String,Object> claims) {

        long expMillis = System.currentTimeMillis()+EXPIRATION_TIME;
        Date exp = new Date(expMillis);

        //设置jwt的body
        JwtBuilder jwtBuilder = Jwts.builder()
                //设置jwt的body
                .setClaims(claims)
                //设置签名算法和签名使用的秘钥
                .signWith(SignatureAlgorithm.HS256,SECRET_KEY)
                //设置jwt的过期时间
                .setExpiration(exp);
        return jwtBuilder.compact();
    }

    public static Claims parseJWT(String jwt) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(jwt)
                .getBody();
    }
}
