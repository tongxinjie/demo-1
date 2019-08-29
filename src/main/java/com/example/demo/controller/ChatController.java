
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.pojo.Chat;
import com.example.demo.pojo.Chatroom;
import com.example.demo.pojo.User;
import com.example.demo.pojo.ConcatTable;
import com.example.demo.service.Chatservice;
import com.example.demo.service.Userservice;
import com.example.demo.service.Chatroomservice;
import org.apache.log4j.Logger;
import com.alibaba.fastjson.JSONObject;
//import com.cmbsh.jcWeb.pojo.User;
import com.alibaba.fastjson.JSON;

import java.text.SimpleDateFormat;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
//import java.util.Date;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@RestController
public class ChatController {
	private static Logger logger = Logger.getLogger(ChatController.class);
	@Resource
	private Chatservice chatService;
	@Resource
	private Chatroomservice chatroomService;
	@Resource
	private Userservice userService;
//	
//	//获取聊天列表
	@RequestMapping(value="/getList",method = RequestMethod.POST)
	@ResponseBody
	public String getList(HttpServletRequest request, HttpServletResponse response) {
		String userid = request.getParameter("myid"); 
		List<ConcatTable> concat = chatroomService.CountUnreadNum(userid);

		if(concat!=null) {
			return JSON.toJSONString(concat);			
		}else {
			return null;
		}
    }
	

	
	//未读消息清零
	
	@RequestMapping(value="/setUnread",method = RequestMethod.POST)
	@ResponseBody
	public String setUnread(HttpServletRequest request, HttpServletResponse response) {
		String wechatid = request.getParameter("wechatid");
		String wechathost = request.getParameter("host");
		int unread = 0;
	    int i = chatroomService.ResetUnreadNum(wechatid, wechathost,unread);
		if(i!=0) {
			return "reset success";			
		}else {
			return null;
		}
    }
	
		
//		获取聊天记录
		@RequestMapping(value="/getHistory",method = RequestMethod.POST)
		@ResponseBody
		public String getHistory(HttpServletRequest request, HttpServletResponse response) {   	
			String wechatName = request.getParameter("wechatname");
//			System.out.println("wechatname: "+ wechatName);
			
			List<Chatroom> chatroom = chatroomService.findChatlistByWechatName(wechatName);
			if(chatroom!=null) {
				return JSON.toJSONString(chatroom);
//				return chat.toString();		
			}else {
				return "error";
			}
	    }
		
//		获取聊天记录2
		@RequestMapping(value="/getHistorylist",method = RequestMethod.POST)
		@ResponseBody
		public String getHistorylist(HttpServletRequest request, HttpServletResponse response) {   	
			String wechatid = request.getParameter("wechatid");
			String wechathost = request.getParameter("host");
			List<Chatroom> chatroom = chatroomService.findChatlistByWechatId(wechatid, wechathost);
			//清空未读消息
//			int unread = 0;
//		    int i = chatroomService.ResetUnreadNum(wechatid, wechathost,unread);
//		    System.out.println("i: "+ i);
			if(chatroom!=null) {
				return JSON.toJSONString(chatroom);
//				return chat.toString();		
			}else {
				return "error";
			}
	    }
		
		//更新聊天记录
		@RequestMapping(value="/MsgFrom",method = RequestMethod.POST)
		@ResponseBody
		public String MsgFrom(HttpServletRequest request, HttpServletResponse response) {   	
			String fromid = request.getParameter("fromid");
			
			User user = userService.findUserByUserId(fromid);
			String fromname = user.getLoginName();
			String avatar = user.getAvatar();
			JSONObject jsonObj =new JSONObject();
    		jsonObj.put("fromname", fromname);
    		jsonObj.put("avatar", avatar);
			
			System.out.println("frommsg: "+ fromid);
			return JSON.toJSONString(jsonObj);
			
	    }
//		
		
		//更新聊天记录
				@RequestMapping(value="/insertMsg",method = RequestMethod.POST)
				@ResponseBody
				public String insertMsg(HttpServletRequest request, HttpServletResponse response) {   	
					String frommsg = request.getParameter("frommsg");
					String msg = request.getParameter("msg");
					String tomsg = request.getParameter("tomsg");
					String strtext = request.getParameter("text");
					int text = Integer.parseInt(strtext);
//					int label = Integer.parseInt(labelstr);
					
					System.out.println("frommsg: "+ frommsg);
					Chatroom chatroom = new Chatroom();
					chatroom.setFrommsg(frommsg);
					chatroom.setTomsg(tomsg);
					chatroom.setMsg(msg);
					chatroom.setText(text);
					chatroom.setUnread(1);
					
					int i = chatroomService.InsertNewMsg(chatroom);
					if (i==1) {
						return JSON.toJSONString(chatroom);
					}else {
						return "error";
					}
			    }
//				
				//插入图片
				@RequestMapping(value="/insertImg",method = RequestMethod.POST)
				@ResponseBody
				public String insertImg(HttpServletRequest request, HttpServletResponse response) throws IllegalStateException, IOException {   	
					MultipartHttpServletRequest mul = (MultipartHttpServletRequest)request;
				    MultipartFile mutipartfile = mul.getFile("file");
				    if(!mutipartfile.isEmpty()) {
				    	
				    	 long size= mutipartfile.getSize();
				    	 long currentTime = System.currentTimeMillis();
				         SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
				         Date date1 = new Date(currentTime);
					     String name = formatter.format(date1)+ "-"+mutipartfile.getOriginalFilename();
					     System.out.println("filename: "+ name);
					     String filepath= "D:\\暑期实习\\vue-wechat-master\\static\\chatroom";
//					     String filepath=request.getServletContext().getRealPath("/")+"files\\";
					     File newfile=new File(filepath);
				            if(!newfile.exists()){
				                newfile.mkdirs();
				            };
				        String saveName = name;					     
				        mutipartfile.transferTo(new File(newfile+"\\"+saveName));//保存文件 
				        String frommsg = request.getParameter("frommsg");
						String tomsg = request.getParameter("tomsg");
						String strText = request.getParameter("text");
						int text = Integer.parseInt(strText);
//						String online = request.getParameter("online");
//						int unread = Integer.parseInt(online);
//						System.out.println("frommsg: "+ unread);
						Chatroom chatroom = new Chatroom();
						chatroom.setFrommsg(frommsg);
						chatroom.setTomsg(tomsg);
						chatroom.setMsg(saveName); //存入图片路径
						chatroom.setText(text);
						chatroom.setUnread(1);
						int i = chatroomService.InsertNewMsg(chatroom);
						if (i==1) {
							return JSON.toJSONString(chatroom);
						}else {
							return "error";
						}

				    };
					return null;
					
								
					
			    }
	}



