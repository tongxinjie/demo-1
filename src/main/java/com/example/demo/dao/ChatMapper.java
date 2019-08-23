
package com.example.demo.dao;
 
import com.example.demo.pojo.Chat;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import com.example.demo.pojo.ChatExample;
import com.example.demo.pojo.ChatKey;
import com.example.demo.pojo.User;



@Mapper
public interface ChatMapper {
	 /**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table chatlist
	 * @mbg.generated  Wed Jul 31 16:25:52 CST 2019
	 */
	long countByExample(ChatExample example);
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table chatlist
	 * @mbg.generated  Wed Jul 31 16:25:52 CST 2019
	 */
	int deleteByExample(ChatExample example);
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table chatlist
	 * @mbg.generated  Wed Jul 31 16:25:52 CST 2019
	 */
	int deleteByPrimaryKey(ChatKey key);
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table chatlist
	 * @mbg.generated  Wed Jul 31 16:25:52 CST 2019
	 */
	int insert(Chat record);
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table chatlist
	 * @mbg.generated  Wed Jul 31 16:25:52 CST 2019
	 */
	int insertSelective(Chat record);
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table chatlist
	 * @mbg.generated  Wed Jul 31 16:25:52 CST 2019
	 */
	List<Chat> selectByExample(ChatExample example);
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table chatlist
	 * @mbg.generated  Wed Jul 31 16:25:52 CST 2019
	 */
	Chat selectByPrimaryKey(ChatKey key);
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table chatlist
	 * @mbg.generated  Wed Jul 31 16:25:52 CST 2019
	 */
	int updateByExampleSelective(@Param("record") Chat record, @Param("example") ChatExample example);
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table chatlist
	 * @mbg.generated  Wed Jul 31 16:25:52 CST 2019
	 */
	int updateByExample(@Param("record") Chat record, @Param("example") ChatExample example);
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table chatlist
	 * @mbg.generated  Wed Jul 31 16:25:52 CST 2019
	 */
	int updateByPrimaryKeySelective(Chat record);
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table chatlist
	 * @mbg.generated  Wed Jul 31 16:25:52 CST 2019
	 */
	int updateByPrimaryKey(Chat record);
	List<Chat> selectAll();
	List<Chat> selectAllByHost(String host);
	List<Chat> selectChatDetailsByUserId(String userid);
}