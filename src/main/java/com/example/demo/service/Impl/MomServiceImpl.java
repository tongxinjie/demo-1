package com.example.demo.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.example.demo.dao.MomMapper;
import com.example.demo.pojo.Mom;
import com.example.demo.service.Momentsservice;


@Service("momentsService")
public class MomServiceImpl implements Momentsservice {
	
	@Resource
	private MomMapper momMapper;
	public List<Mom> findAllMoments(){
		return this.momMapper.selectAllMoments();
	}
	
	public List<Mom> findAllMomentsByHost(String host){
		return this.momMapper.selectAllMomentsByHost(host);
	}
	
}
