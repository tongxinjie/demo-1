package com.example.demo.service;
 
import com.example.demo.pojo.Chat;
import com.example.demo.pojo.Chatroom;
import com.example.demo.pojo.ConcatTable;
import com.example.demo.pojo.GroupTable;
import com.example.demo.pojo.Grouplist;
//import com.alibaba.druid.sql.visitor.functions.ConcatTable;
import com.example.demo.dao.ChatroomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import java.util.List;
 



public interface Chatroomservice {
	
	public List<Chatroom> findChatlistByWechatName(String wechatName);
	public List<Chatroom> findChatlistByWechatId(String wechatid, String wechathost);
	public int InsertNewMsg(Chatroom chatroom);
	public List<Chatroom> findAllChatlistByHost(String host);
	public List<ConcatTable> CountUnreadNum(String host);
	public int ResetUnreadNum(String wechatid, String wechathost, int unread);
	public List<GroupTable> findGroupChatlistByWechatId(String wechatid);
	public int ResetGroupUnreadNum(String wechatid,int unread);
	public List<Grouplist> FindGroupMembers(String GroupId);
	public Grouplist findGroupByGroupId(String GroupId);
 
}