package com.example.demo.service;
 
import com.example.demo.pojo.Mom;
import com.example.demo.dao.MomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import java.util.List;
 

public interface Momentsservice {
	public List<Mom> findAllMoments();
	public List<Mom> findAllMomentsByHost(String host);
}