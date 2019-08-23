package com.example.demo.service.Impl;
import javax.annotation.Resource;
import java.util.List;
import org.springframework.stereotype.Service;

//import com.alibaba.druid.sql.visitor.functions.Concat;
import com.example.demo.dao.ChatroomMapper;
import com.example.demo.pojo.Chat;
import com.example.demo.pojo.Chatroom;
import com.example.demo.pojo.ConcatTable;
import com.example.demo.service.Chatroomservice;


@Service("chatroomService")
public class ChatroomServiceImpl implements Chatroomservice {
	
	@Resource
	private ChatroomMapper chatroomMapper;

	public List<Chatroom> findChatlistByWechatName(String wechatName){
		return this.chatroomMapper.selectByWechatName(wechatName);
	}
	public int InsertNewMsg(Chatroom chatroom){
		return this.chatroomMapper.insertNewMsg(chatroom);
	}
	public List<Chatroom> findChatlistByWechatId(String wechatid, String wechathost){
		return this.chatroomMapper.selectByWechatId(wechatid, wechathost);
	}
	public List<Chatroom> findAllChatlistByHost(String host){
		return this.chatroomMapper.selectAllByHost(host);
	}
	public List<ConcatTable> CountUnreadNum(String host){
		return this.chatroomMapper.selectUnreadNum(host);
	}
	
	public int ResetUnreadNum(String wechatid, String wechathost, int unread){
		return this.chatroomMapper.setUnreadNum(wechatid, wechathost,unread);
	}
}
