package com.beyond.mapper;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.beyond.filter.UserInfoFilter;
import com.beyond.mapper.api.IUserInfoMapper;
import com.beyond.mapper.common.AbstractBusinessMapper;
import com.beyond.model.UserInfo;

@Component
@SuppressWarnings({ "unchecked", "rawtypes" })
public class UserInfoMapper extends AbstractBusinessMapper implements IUserInfoMapper {
    
	@Autowired
    private JdbcTemplate jdbcTemplate;

	@Override
	public List<UserInfo> selectList() {
		// TODO Auto-generated method stub
		String sql = "select * from t_user_info ";  
        return (List<UserInfo>) jdbcTemplate.query(sql, new BeanPropertyRowMapper(UserInfo.class));  
	}

	@Override
	public Integer insert(UserInfo userInfo) {
		// TODO Auto-generated method stub
		String sql = "insert into t_user_info (name, password, true_name, age) values(?, ?, ?, ?)";  
        return this.jdbcTemplate.update(sql, userInfo.getName(), userInfo.getPassword(), userInfo.getTrueName(), userInfo.getAge()); 
	}

	@Override
	public Integer update(UserInfo userInfo) {
		// TODO Auto-generated method stub
		String sql = "update t_user_info set name=?, password=?, true_name=?, age=? where id=?";  
        return this.jdbcTemplate.update(sql, userInfo.getName(), userInfo.getPassword(), userInfo.getTrueName(), userInfo.getAge(), userInfo.getId()); 
	}

	@Override
	public Integer deleteById(Integer id) {
		// TODO Auto-generated method stub
		String sql = "delete from t_user_info where id=?";  
        return this.jdbcTemplate.update(sql, id); 
	}

	@Override
	public Map<String, Object> getById(Integer id) {
		// TODO Auto-generated method stub
		String sql = "select * from t_user_info where id=?";  
        return jdbcTemplate.queryForMap(sql, new Object[] { id }); 
	}

	@Override
	public List<UserInfo> selectListByFilter(UserInfoFilter filter) {
		// TODO Auto-generated method stub
		String sql = "select * from t_user_info ";
		StringBuffer sb = new StringBuffer(appendFilter(sql, filter));
		sb.append(appendCommonFilter(filter));
        return (List<UserInfo>) jdbcTemplate.query(sb.toString(), new BeanPropertyRowMapper(UserInfo.class));
	}

	@Override
	public Integer getCountByFilter(UserInfoFilter filter) {
		// TODO Auto-generated method stub
		String sql = "select count(*) from t_user_info ";
        return jdbcTemplate.queryForObject(appendFilter(sql, filter), Integer.class);
	}

	/**
	 * sql追加过滤条件
	 * @param sql sql语句
	 * @param filter 过滤条件
	 * @return
	 */
	private String appendFilter(String sql, UserInfoFilter filter) {
		StringBuffer sb = new StringBuffer(sql);
		sb.append(" where 1=1 ");
		if (StringUtils.isNotBlank(filter.getName())) {
			sb.append(" and name='" + filter.getName() + "'");
		}
		if (filter.getAge() != null) {
			sb.append(" and age=" + filter.getAge());
		}
		if (StringUtils.isNoneBlank(filter.getTrueName())) {
			sb.append(" and true_name like '%" + filter.getTrueName() + "%'");
		}
		return sb.toString();
	}
}
