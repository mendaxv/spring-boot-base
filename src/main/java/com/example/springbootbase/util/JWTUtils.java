package com.example.springbootbase.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.HashMap;

/**
 * @author zhouwei
 * @description:
 * @date 2022/5/9 10:06
 */
public class JWTUtils {

    private static final String ALGORITHM = "123456";

    public static String getToken(Integer userId, String username) {
        // 指定token过期时间为30分钟
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND, 60*30);

        String jwt = JWT.create()
                .withHeader(new HashMap<>())
                .withClaim("userId", userId)
                .withClaim("userName", username)
                .withExpiresAt(calendar.getTime())
                .sign(Algorithm.HMAC256(ALGORITHM));
        return jwt;
    }

    public static DecodedJWT decode(String token) {
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(ALGORITHM)).build();
        return jwtVerifier.verify(token);
    }
}
