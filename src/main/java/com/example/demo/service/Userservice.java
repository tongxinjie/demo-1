
package com.example.demo.service;
 
import com.example.demo.pojo.Addr;
import com.example.demo.pojo.Chat;
import com.example.demo.pojo.User;
import com.example.demo.dao.UserMapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
 
/**
 * @Author:wjup
 * @Date: 2018/9/26 0026
 * @Time: 15:23
 */


public interface Userservice {
 
	public User tryLogin(String loginName, String pwd);
	public User findUserByUserId(String loginName);
	public User findUserById(Integer id);
	public int updateUser(User user);
	public List<User> findDetailsByUserId(String userid);
	public List<User> findDetailsList(String mywechatid);
	public List<User> findAllGroupsByHost(String host);
	public List<User> findAllAddresslistByHost(String host);
	public List<User> findDetailsMoments(String host);
	public int findUserExistByUserId(String searchId, String myId);
	
}


