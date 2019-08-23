package com.example.demo.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.demo.pojo.User;
import com.example.demo.service.Userservice;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import com.example.demo.service.Userservice;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

//import org.hibernate.annotations.common.util.impl.Log_.logger;

/**
 * Java web token 工具类
 *
 * @author qiaokun
 * @date 2018/08/10
 */
public class JwtUtil {
    /**
     * 过期时间一天，
     * TODO 正式运行时修改为15分钟
     */
    private static final long EXPIRE_TIME = 1* 60 * 60 * 1000;
    /**
     * token私钥
     */
    private static final String TOKEN_SECRET = "f26e587c28064d0e855e72c0a6a0e618";

    /**
     * 校验token是否正确
     *
     * @param token 密钥
     * @return 是否正确
     */
    
    public static boolean verify(String token, User user) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(user.getPassword());
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(token);
            System.out.println("过期时间：" + jwt.getExpiresAt());
            return true;
        } catch (Exception exception) {
            return false;
//        	throw new RuntimeException("401");
            
        }
    }


    /**
     * 获得token中的信息无需secret解密也能获得
     *
     * @return token中包含的用户名
     */
    public static String getWechatId(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("wechatId").asString();
        } catch (JWTDecodeException e) {
            return null;
        }
    }

    /**
     * 获取登陆用户ID
     * @param token
     * @return
     */
    public static String getLoginName(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("loginName").asString();
        } catch (JWTDecodeException e) {
            return null;
        }
    }

    /**
     * 生成签名,15min后过期
     *
     * @param username 用户名
     * @return 加密的token
     */
    public String sign(User user) {
        try {

        	long currentTime = System.currentTimeMillis();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy年-MM月dd日-HH时mm分ss秒");
            Date date1 = new Date(currentTime);
            System.out.println("现在时间："+formatter.format(date1));
            
            Calendar nowTime = Calendar.getInstance();
            nowTime.add(Calendar.MINUTE, 60);
            Date expiresDate = nowTime.getTime();
            System.out.println(expiresDate);
//            私钥及加密算法
//            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            Algorithm algorithm = Algorithm.HMAC256(user.getPassword());
            Map<String, Object> header = new HashMap<>(2);
            header.put("typ", "JWT");
            header.put("alg", "HS256");
            // 附带username，userId信息，生成签名
            String token = JWT.create()
                    .withHeader(header)
                    .withClaim("wechatId", user.getWechatId())
                    .withAudience(user.getWechatId())
                    .withExpiresAt(expiresDate)
                    .withIssuedAt(date1)
                    .sign(algorithm);
            
            return token;
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }

}
