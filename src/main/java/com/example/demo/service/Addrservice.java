
package com.example.demo.service;
 
import com.example.demo.pojo.Addr;
import com.example.demo.pojo.ConcatMom;
import com.example.demo.dao.AddrMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import java.util.List;
 



public interface Addrservice {
	public List<Addr> findAllAddresslist();
	public List<Addr> findAllGroups();
	public List<ConcatMom> FindMomentsList(String userid);
}
