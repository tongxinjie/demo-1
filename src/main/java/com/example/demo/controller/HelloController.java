
package com.example.demo.controller;
 
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
//import java.sql.Date;
//import java.text.SimpleDateFormat;
//import java.util.Date;
import java.util.Date;
import java.text.SimpleDateFormat;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.bind.annotation.PathVariable;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.demo.pojo.ApiResponse;
import com.example.demo.pojo.User;
import com.example.demo.service.Userservice;
import com.example.demo.util.ApiResponseUtil;
import com.example.demo.util.JwtUtil;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.example.demo.service.TokenService;
import com.example.demo.enums.ApiResponseEnum;

import sun.misc.BASE64Encoder;

import org.apache.log4j.Logger;
 

@Controller
public class HelloController {
	private static Logger logger = Logger.getLogger(HelloController.class);
	@Resource
	private Userservice userService;
	@Resource
	private TokenService tokenService;
	
//	登录
	
	@RequestMapping(value="/hello",method = RequestMethod.POST)
	@ResponseBody
	public String Loginpage(HttpServletRequest request, HttpServletResponse response) {
	
		String username = request.getParameter("name");
		String password =request.getParameter("password");
		System.out.println(username);
		System.out.println(password);
	
//		return username;
		try{
			User user = userService.tryLogin(username, password);
			if(user!=null){
				HttpSession session = request.getSession(); 
				String userid = user.getWechatId();
	            return JSON.toJSONString(user);
	            
			}
			else{
				request.setAttribute("error", "用户名或密码错误请重新填写！");
				return "false";
			}
		
		}catch (Exception e) {
			logger.error(e.getMessage());
			request.setAttribute("error", "用户名或密码错误请重新填写！");
			return "false";
		}
	}
//	
	//token
	
	@RequestMapping(value="/login",method = RequestMethod.POST)
	@ResponseBody
	public String login(HttpServletRequest request, HttpServletResponse response) {
	
		String username = request.getParameter("name");
		String password =request.getParameter("password");
		System.out.println(username);
		System.out.println(password);
		try{
			User user = userService.tryLogin(username, password);
			if(user!=null){
				String token = tokenService.getToken(user);
//				JwtUtil jwt = new JwtUtil();
//				String token = jwt.sign(user);
//				System.out.println("1:"+ token);
                if (token != null) {
//                	ApiResponse apiResponse= ApiResponseUtil.getApiResponse(token);
            		JSONObject jsonObj =new JSONObject();
            		jsonObj.put("token", token);
            		jsonObj.put("username", user.getLoginName());
            		jsonObj.put("avatar", user.getAvatar()); 
            		jsonObj.put("wechatid", user.getWechatId()); 
                    return JSON.toJSONString(jsonObj);
                }
	            
			}
			else{
//				System.out.println("2");	
//				ApiResponse apiResponse= ApiResponseUtil.getApiResponse(ApiResponseEnum.LOGIN_FAIL);
				return "登陆失败";
			}
		
		}catch (Exception e) {
			logger.error(e.getMessage());
			request.setAttribute("error", "用户名或密码错误请重新填写！");
		}
		return null;
	}
	
	
	@RequestMapping(value="/refreshToken",method = RequestMethod.POST)
	@ResponseBody
	public String refreshToken(HttpServletRequest request, HttpServletResponse response) {
	
		String acceptToken = request.getParameter("refreshToken");
		System.out.println(" acceptToken: " +  acceptToken);
		try{
			if(null != acceptToken) {
				String userId = JWT.decode(acceptToken).getAudience().get(0);
            	User user = userService.findUserByUserId(userId);
//                Algorithm algorithm = Algorithm.HMAC256(user.getPassword());
//                JWTVerifier verifier = JWT.require(algorithm).build();
//                DecodedJWT jwt = verifier.verify(acceptToken);
                Date expiresDate = JWT.decode(acceptToken).getExpiresAt(); //获取过期时间
                //获取现在时间
                Date nowDate = new Date(System.currentTimeMillis());
                //计算过期时间
                int RestTime = (int)(nowDate.getTime()-expiresDate.getTime());
                System.out.println(" RestTime: " +  RestTime);
                if (RestTime < 60000) {
                	//签发新的token
                	String refreshToken = tokenService.getToken(user);
                	JSONObject jsonObj =new JSONObject();
            		jsonObj.put("refreshToken", refreshToken);
                	return JSON.toJSONString(jsonObj);
                }

			}
			
              
		}catch (Exception e) {
			logger.error(e.getMessage());
			request.setAttribute("error", "用户名或密码错误请重新填写！");
		}
		return null;
	}
	
	
//	退出登录
	@RequestMapping(value="/logout",method = RequestMethod.GET)
	@ResponseBody
	public String logout(HttpServletRequest request, HttpServletResponse response) {   
        String result = "false";
        HttpSession session = request.getSession();  //session
        session.removeAttribute("username");
        System.out.println("logout~~~~~~ ");
        return result;  
    }
	
	//修改名字
	@RequestMapping(value="/changeName",method = RequestMethod.POST)
	@ResponseBody
	public String changeName(HttpServletRequest request, HttpServletResponse response) {   
//        System.out.println("new: "+ in);
        String in = request.getParameter("in");
        System.out.println("new: "+ in);
        String myid = request.getParameter("id");
        System.out.println("id: "+ myid);
        User user = userService.findUserByUserId(myid);
        user.setLoginName(in.trim());
        int i = userService.updateUser(user);
        if (i == 1) {	
        	HttpSession session = request.getSession();  
            session.setAttribute("username", user.getLoginName()); 
        	return "success";  
		}else {
			return "fail";  
		}  
    }
	
//	//获取名字
//		@RequestMapping(value="/getName",method = RequestMethod.POST)
//		@ResponseBody
//		public String getName(HttpServletRequest request, HttpServletResponse response) {   
//	        String loginName = (String)request.getSession().getAttribute("username");
//	        return loginName;  
//	    }
//		
   // 上传头像
	@RequestMapping(value="/changeHeader",method = RequestMethod.POST)
	@ResponseBody
	public String changeHeader(HttpServletRequest request, HttpServletResponse response) throws IllegalStateException, IOException {   
		 MultipartHttpServletRequest mul = (MultipartHttpServletRequest)request;
	     MultipartFile mutipartfile = mul.getFile("file");
	     String myid =  request.getParameter("myid");
//	     System.out.println("id!!!"+ id);
	     if(!mutipartfile.isEmpty()) {
	    	 long size= mutipartfile.getSize();
		     String name = mutipartfile.getOriginalFilename();
		     System.out.println("filename: "+ name);
		     String filepath= "D:\\暑期实习\\vuetest\\static\\uploads";
		     File newfile=new File(filepath);
	            if(!newfile.exists()){
	                newfile.mkdirs();
	            };
	            
		     String saveName = name;
	         mutipartfile.transferTo(new File(newfile+"\\"+saveName));//保存文件 
	         
	         //-----------------转化图片--------------------
//	         String savePath = filepath +"\\"+ saveName; //保存路径
//	         InputStream inputImg = new FileInputStream(savePath);
//	         byte[] data = new byte[inputImg.available()]; 
//	         inputImg.read(data);
//	         inputImg.close();                 
//	         BASE64Encoder encoder = new BASE64Encoder();
//        	 String saveImg =  encoder.encode(data);
	         //-------------------------------------------------
//	         String loginName = (String)request.getSession().getAttribute("userid");
//	         System.out.println("loginName: "+ loginName);
	         User user = userService.findUserByUserId(myid);
	         user.setAvatar(saveName);
//	         user.setBase(saveImg);
	         int i = userService.updateUser(user);
	         if (i==1) {
	        	 return "done";
	         }else {
	        	 return "error";
	         }
	         }
		return "done";
    }	
	}




