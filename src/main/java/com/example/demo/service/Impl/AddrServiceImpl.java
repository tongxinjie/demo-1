package com.example.demo.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.example.demo.dao.AddrMapper;
import com.example.demo.pojo.Addr;
import com.example.demo.pojo.Chatroom;
import com.example.demo.pojo.ConcatMom;
import com.example.demo.service.Addrservice;


@Service("addrService")
public class AddrServiceImpl implements Addrservice {
	
	@Resource
	private AddrMapper addrMapper;
	public List<Addr> findAllAddresslist(){
		return this.addrMapper.selectAlladdr();
	}
	
	public List<Addr> findAllGroups(){
		return this.addrMapper.selectAllgroups();
	}
	
	public List<ConcatMom> FindMomentsList(String userid){
		return this.addrMapper.selectMomentsList(userid);
	}
	
	public int InsertNewFriend(String id1, String id2){
		return this.addrMapper.insertNewFriend(id1, id2);
	}
	
}
