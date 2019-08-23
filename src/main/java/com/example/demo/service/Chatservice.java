
package com.example.demo.service;
 
import com.example.demo.pojo.Chat;
import com.example.demo.pojo.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import java.util.List;
 



public interface Chatservice {
	
	public List<Chat> findAllChatlist();
	public List<Chat> findAllChatlistByHost(String host);
	public List<Chat> findChatDetailsByUserId(String userid);
 
}


