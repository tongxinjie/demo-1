package com.example.demo.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.example.demo.dao.ChatMapper;
import com.example.demo.pojo.Chat;
import com.example.demo.pojo.User;
import com.example.demo.service.Chatservice;


@Service("chatService")
public class ChatServiceImpl implements Chatservice {
	
	@Resource
	private ChatMapper chatMapper;

	public List<Chat> findAllChatlist(){
		return this.chatMapper.selectAll();
	}
	
	public List<Chat> findAllChatlistByHost(String host){
		return this.chatMapper.selectAllByHost(host);
	}
	
	public List<Chat> findChatDetailsByUserId(String userid){
		return this.chatMapper.selectChatDetailsByUserId(userid);
	}
}
