package com.beyond.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.beyond.model.UserInfo;

@Component
@SuppressWarnings({ "unchecked", "rawtypes" })
public class UserInfoMapper {
    
	@Autowired
    private JdbcTemplate jdbcTemplate;

	public List<Map<String, Object>> selectUserInfoList() {
		// TODO Auto-generated method stub
		String sql = "select * from t_user_info ";  
        return jdbcTemplate.queryForList(sql);  
	}

	public void insertUserInfo(UserInfo userInfo) {
		// TODO Auto-generated method stub
		String sql = "insert into t_user_info (name, age, password) values(?, ?, ?)";  
        this.jdbcTemplate.update(sql, new Object[] {userInfo.getName(), 
        		userInfo.getAge(), userInfo.getPassword()}); 
	}

	public void updateUserInfo(UserInfo userInfo) {
		// TODO Auto-generated method stub
		String sql = "update t_user_info set name=?, age=?, password=? where id=?";  
        this.jdbcTemplate.update(sql, new Object[] {userInfo.getName(), 
        		userInfo.getAge(), userInfo.getPassword(), userInfo.getId()}); 
	}

	public void deleteUserInfoById(Integer id) {
		// TODO Auto-generated method stub
		String sql = "delete from t_user_info where id=?";  
        this.jdbcTemplate.update(sql, id); 
	}

	public Map<String, Object> getUserInfoById(Integer id) {
		// TODO Auto-generated method stub
		String sql = "select * from t_user_info where id=1";  
        return jdbcTemplate.queryForMap(sql); 
	}

}
