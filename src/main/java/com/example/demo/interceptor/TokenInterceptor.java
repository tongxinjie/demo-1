package com.example.demo.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.demo.pojo.ApiResponse;
import com.example.demo.pojo.User;
import com.example.demo.service.Userservice;
import com.example.demo.enums.ApiResponseEnum;
import com.example.demo.util.ApiResponseUtil;
import com.example.demo.util.JwtUtil;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * 自定义token拦截器
 *
 * @author qiaokun
 * @date 2018/08/11
 */


public class TokenInterceptor implements HandlerInterceptor {
	
	@Resource
	private Userservice userService;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
//        System.out.println("2:"+ token);
        //token不存在
        if (null != token) {
             
             try {
            	 String userId = JWT.decode(token).getAudience().get(0);
             	 User user = userService.findUserByUserId(userId);
                 Algorithm algorithm = Algorithm.HMAC256(user.getPassword());
                 JWTVerifier verifier = JWT.require(algorithm).build();
                 DecodedJWT jwt = verifier.verify(token);
                 System.out.println("过期时间：" + jwt.getExpiresAt());  
                 
             } catch (Exception exception) {
             	throw new RuntimeException("401");
//            	 return false;
             }    
             return true;
//        	String userId = JWT.decode(token).getAudience().get(0);
//        	User user = userService.findUserByUserId(userId);
//        	boolean result = JwtUtil.verify(token,user);
//            if (result) {
//                return true;
//            }
        }
//        ApiResponse apiResponse = ApiResponseUtil.getApiResponse(ApiResponseEnum.AUTH_ERROR);
//        responseMessage(response,response.getWriter(),apiResponse);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

    /**
     * 返回信息给客户端
     *
     * @param response
     * @param out
     * @param apiResponse
     */
    
    private void responseMessage(HttpServletResponse response, PrintWriter out, ApiResponse apiResponse) {
        response.setContentType("application/json; charset=utf-8");
        out.print(JSONObject.toJSONString(apiResponse));
        out.flush();
        out.close();
    }

}
