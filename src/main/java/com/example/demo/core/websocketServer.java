package com.example.demo.core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.example.demo.core.ApplicationContextRegister;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoader;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.pojo.Chatroom;
import com.example.demo.pojo.ConcatTable;
import com.example.demo.pojo.Grouplist;
import com.example.demo.pojo.User;
import com.example.demo.service.Chatroomservice;
//import com.example.demo.service.IDataServcie;
import com.example.demo.service.Userservice;

import javax.annotation.Resource;


import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Date;
import java.util.List;
import java.util.Set;



@Component
//访问服务端的url地址
@ServerEndpoint(value = "/websocket/{id}")
public class websocketServer {

    
    private ApplicationContext act = ApplicationContextRegister.getApplicationContext();
    private Userservice userService = act.getBean(Userservice.class);
    private Chatroomservice chatroomService = act.getBean(Chatroomservice.class);
    
	
	
    private static int onlineCount = 0;
    private static ConcurrentHashMap<String, websocketServer> webSocketSet = new ConcurrentHashMap<>();

    //与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;
    private static Logger log = LogManager.getLogger(websocketServer.class);
    private String id = "";
    /**
     * 连接建立成功调用的方法*/
    @OnOpen
    public void onOpen(@PathParam(value = "id") String id, Session session) {
        this.session = session;
//        System.out.println("来自客户端的id:" + id);
        this.id = id;//接收到发送消息的人员编号
//        webSocketSet.add(this);
        webSocketSet.put(id, this);     //加入set中
        addOnlineCount();           //在线数加1
        log.info("用户"+id+"加入！当前在线人数为" + getOnlineCount());
        try {
            sendMessage("");
        } catch (IOException e) {
            log.error("websocket IO异常");
        }
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose() {
        webSocketSet.remove(id);  //从set中删除
        subOnlineCount();           //在线数减1
        log.info("有一连接关闭！当前在线人数为" + getOnlineCount());
    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message 客户端发送过来的消息*/

    
    @OnMessage
    public void onMessage(String message, Session session) {
    	System.out.println("群发来自客户端的消息:" + message);
    	JSONObject object = (JSONObject) JSONObject.parse(message);
    	String sender =  object.get("frommsg").toString();
    	String receiver =  object.get("tomsg").toString();;
    	String sendMessage = object.get("msg").toString();
//    	System.out.println("接收人："  + receiver);
        try {
        	if(receiver.equals("All")) {
        		
        		System.out.println("群发来自客户端的消息:" + message);
                sendtoAll(message);
        		
        	}else {
        		sendtoUser(message);
        	}
        	
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error) {
        log.error("发生错误");
        error.printStackTrace();
    }


    public void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
    }

    /**
     * 发送信息给指定ID用户，如果用户不在线则返回不在线信息给自己
     */
    public void sendtoUser(String message) throws IOException {

    	System.out.println("私聊消息:" + message); 
    	JSONObject object = (JSONObject) JSONObject.parse(message);
    	String sender =  object.get("frommsg").toString();
    	String receiver =  object.get("tomsg").toString();;
    	String sendMessage = object.get("msg").toString();
    	String text = object.get("text").toString();
    	String isgroup = object.get("isgroup").toString();
    	System.out.println("isgroup:" + isgroup); 
    	
    	User user = userService.findUserByUserId(sender);
		String fromname = user.getLoginName();
		String avatar = user.getAvatar();
    		long currentTime = System.currentTimeMillis();
            Date date = new Date(currentTime);
            JSONObject jsonObj =new JSONObject();
    		jsonObj.put("frommsg", sender);
    		jsonObj.put("tomsg", receiver);
    		jsonObj.put("msg", sendMessage);
    		jsonObj.put("text", text);
    		jsonObj.put("time", date);
    		jsonObj.put("fromname", fromname);
    		jsonObj.put("avatar", avatar);
    		jsonObj.put("isgroup", isgroup);
        	
        	//当前用户在线
    		if(isgroup.equals("0")) {
    			
    			System.out.println("1： " + receiver);
    			
    			if (webSocketSet.get(receiver) != null) {	
           		 if(!id.equals(receiver)) {	
                       webSocketSet.get(receiver).sendMessage(JSON.toJSONString(jsonObj));                           
           		 }
           	}
           	else {  		
//               	System.out.println("当前用户不在线： " + receiver);
               	  }	
        		
        	}
    		else {
    			
    			String GroupId = receiver;
    			List<Grouplist> group = chatroomService.FindGroupMembers(GroupId);
    			System.out.println("groupsize:" + group.size()); 
    			for (int i = 0; i < group.size(); i++) {
    				
    				Grouplist receiver_tmp = group.get(i);
    				String receiver_tmp_id = receiver_tmp.getMember();
    				
    				
    				
    				
    				if (webSocketSet.get(receiver_tmp_id) != null) {
    					
    					System.out.println("receiver_tmp:" + receiver_tmp_id); 
    					
    	           		 if(!id.equals(receiver_tmp_id)) {	
    	                       webSocketSet.get(receiver_tmp_id).sendMessage(JSON.toJSONString(jsonObj));                           
    	           		 }}
    				
    			}

//    			return JSON.toJSONString(group);
        		
        	}
        	
    		
    	
    	
    	}
    


    /**
     * 发送信息给所有人
     * @param message
     * @throws IOException
     */
    public void sendtoAll(String message) throws IOException {
        for (String key : webSocketSet.keySet()) {
            try {
            	System.out.println("群发来自客户端的消息:" + message);
                webSocketSet.get(key).sendMessage(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 群发自定义消息
     * */

    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
    	websocketServer.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
    	websocketServer.onlineCount--;
    }
}

