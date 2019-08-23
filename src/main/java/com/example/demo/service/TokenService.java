package com.example.demo.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.example.demo.pojo.User;

import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;


/**
 * @author jinbin
 * @date 2018-07-08 21:04
 */
@Service("TokenService")
public class TokenService {
    public String getToken(User user) throws IllegalArgumentException, JWTCreationException, UnsupportedEncodingException {
    	 Calendar nowTime = Calendar.getInstance();
         nowTime.add(Calendar.MINUTE, 60);
         Date expiresDate = nowTime.getTime();
    	
    	String token = JWT.create().withAudience(user.getWechatId())// 将 user id 保存到 token 里面
                .withExpiresAt(expiresDate)
                .sign(Algorithm.HMAC256(user.getPassword()));// 以 password 作为 token 的密钥
        return token;
    }
}