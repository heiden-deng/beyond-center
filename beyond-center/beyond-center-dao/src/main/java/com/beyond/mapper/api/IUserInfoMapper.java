package com.beyond.mapper.api;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.beyond.filter.UserInfoFilter;
import com.beyond.model.UserInfo;

@Component
public interface IUserInfoMapper {

	public List<UserInfo> selectList();

	public List<UserInfo> selectListByFilter(UserInfoFilter filter);

	public Integer getCountByFilter(UserInfoFilter filter);

	public Integer insert(UserInfo userInfo);

	public Integer update(UserInfo userInfo);

	public Integer deleteById(Integer id);

	public Map<String, Object> getById(Integer id);

}
