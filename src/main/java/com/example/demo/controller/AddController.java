
package com.example.demo.controller;
 
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.pojo.Mom;
import com.example.demo.pojo.Addr;
import com.example.demo.pojo.ConcatMom;
import com.example.demo.pojo.ConcatTable;
import com.example.demo.service.Addrservice;
import com.example.demo.service.Momentsservice;
import com.example.demo.service.Userservice;

import com.example.demo.pojo.User;
import org.apache.log4j.Logger;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSON;
import java.util.List;

@RestController
public class AddController {
	private static Logger logger = Logger.getLogger(AddController.class);

	@Resource
	private Addrservice addrService;
	@Resource
	private Momentsservice momentsService;
	@Resource
	private Userservice userService;
	

		
		//获取通讯录列表2
		@RequestMapping(value="/getGroups",method = RequestMethod.POST)
		@ResponseBody
		public String getGroups(HttpServletRequest request, HttpServletResponse response) {   	
//			String loginName = (String)request.getSession().getAttribute("userid");
//	        System.out.println("loginName: "+ loginName);
			String userid = request.getParameter("myid");
			List<User> groups = userService.findAllGroupsByHost(userid);
			if(groups!=null) {
				return JSON.toJSONString(groups);
			}else {
				return "error";
			}
	    }
		
				@RequestMapping(value="/getAddr",method = RequestMethod.POST)
				@ResponseBody
				public String getAddr(HttpServletRequest request, HttpServletResponse response) {   	
					String userid = request.getParameter("myid");
					List<User> user = userService.findAllAddresslistByHost(userid);
					if(user!=null) {
						return JSON.toJSONString(user);
					}else {
						return "error";
					}
			    }
		
		//获取朋友圈列表
		@RequestMapping(value="/getMoments",method = RequestMethod.POST)
		@ResponseBody
		public String getMoments(HttpServletRequest request, HttpServletResponse response) {
			String userid = request.getParameter("myid");
			List<ConcatMom> mom = addrService.FindMomentsList(userid);
			if(mom!=null) {
				return JSON.toJSONString(mom);
			}else {
				return "error";
			}
	    }
		
		//加好友&判断用户是否存在/是否已经是好友
				@RequestMapping(value="/SearchFriend",method = RequestMethod.POST)
				@ResponseBody
				public String SearchFriend(HttpServletRequest request, HttpServletResponse response) {
					String searchId = request.getParameter("searchId");
					String myId = request.getParameter("myid");
					System.out.println("searchId: "+ searchId);
					//判断是否已经是好友
					int exist = userService.findUserExistByUserId(searchId,myId);	
					System.out.println("exist: "+ exist);
					User user = userService.findUserByUserId(searchId);

					if(user!=null) {
						
						String username = user.getLoginName();
						String avatar = user.getAvatar();
						String userid = user.getWechatId();
						String userloc = user.getLocation();
						JSONObject jsonObj =new JSONObject();
			    		jsonObj.put("username", username);
			    		jsonObj.put("avatar", avatar);
			    		jsonObj.put("userid", userid);
			    		jsonObj.put("userloc", userloc);
			    		jsonObj.put("exist", exist);
						return JSON.toJSONString(jsonObj);
						
					}else {
						return "404";
					}
					
			    }
				
		//
				
				@RequestMapping(value="/InsertFriend",method = RequestMethod.POST)
				@ResponseBody
				public String InsertFriend(HttpServletRequest request, HttpServletResponse response) {
					String searchId = request.getParameter("searchId");
					String myId = request.getParameter("myid");
					int i1 = addrService.InsertNewFriend(searchId,myId);
					int i2 = addrService.InsertNewFriend(myId,searchId);
					if (i1==1&i2==1) {
						
						return "ok";
						
					}
					return null;
					
					
			    }
		

	}



