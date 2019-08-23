package com.example.demo.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.example.demo.dao.UserMapper;
import com.example.demo.pojo.Addr;
import com.example.demo.pojo.Chat;
import com.example.demo.pojo.User;
import com.example.demo.service.Userservice;


@Service("userService")
public class UserServiceImpl implements Userservice {
	
	@Resource
	private UserMapper userMapper;
	public User tryLogin(String loginName, String pwd){
		return this.userMapper.selectByNamePwd(loginName,pwd);
	}
	public User findUserByUserId(String loginName){
		return this.userMapper.selectByUserId(loginName);
	}
	public User findUserById(Integer id){
		return this.userMapper.selectByPrimaryKey(id);
	}
	public int updateUser(User user){
		return this.userMapper.updateByPrimaryKey(user);
	}
	
	public List<User> findDetailsByUserId(String userid){
		return this.userMapper.selectDetailsByUserId(userid);
	}
	
	public List<User> findDetailsList(String mywechatid){
		return this.userMapper.selectDetailsList(mywechatid);
	}
	
	public List<User> findAllAddresslistByHost(String host){
		return this.userMapper.selectAlladdrByHost(host);
	}
	
	public List<User> findAllGroupsByHost(String host){
		return this.userMapper.selectAllgroupsByHost(host);
	}
	public List<User> findDetailsMoments(String host){
		return this.userMapper.selectDetailsMoments(host);
	}
}
