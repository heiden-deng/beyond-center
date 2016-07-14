package com.beyond.controller;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.beyond.filter.UserInfoFilter;
import com.beyond.mapper.api.IUserInfoMapper;
import com.beyond.model.UserInfo;

@RestController
@RequestMapping(value = "/user")
public class UserInfoController {

	@Autowired
	private IUserInfoMapper userInfoMapper;

	@RequestMapping(value = "/getUserList")
	public List<UserInfo> getUserList(HttpServletRequest request,
			HttpServletResponse response, ModelMap modelMap) {

		List<UserInfo> userInfos = new LinkedList<>();
		
		UserInfo zhangsan = new UserInfo();
		zhangsan.setAge(10);
		zhangsan.setId(1);
		zhangsan.setName("zhangsan");
		zhangsan.setTrueName("张三");
		zhangsan.setPassword("000000");
		userInfos.add(zhangsan);
		
		UserInfo lisi = new UserInfo();
		lisi.setAge(20);
		lisi.setId(2);
		lisi.setName("lisi");
		lisi.setTrueName("李四");
		lisi.setPassword("123456");
		userInfos.add(lisi);
		
		return userInfos;
	}

	@RequestMapping(value = "/getList")
	public List<UserInfo> getList(HttpServletRequest request,
			HttpServletResponse response, ModelMap modelMap) {

		 return userInfoMapper.selectList();
	}

	@RequestMapping(value = "/getById")
	public Map<String, Object> getById(HttpServletRequest request,
			HttpServletResponse response, ModelMap modelMap, String id) {

		if (StringUtils.isNotBlank(id)) {
			return userInfoMapper.getById(Integer.parseInt(id));
		} 
		return null;
	}

	@RequestMapping(value = "/edit")
	public String edit(HttpServletRequest request,
			HttpServletResponse response, ModelMap modelMap, UserInfo userInfo) {

		if (userInfo != null) {
			if (userInfo.getId() != null) {
				if (userInfoMapper.update(userInfo) > 0) {
					return "success";
				}
			} else {
				if (userInfoMapper.insert(userInfo) > 0) {
					return "success";
				}
			}
		} 
		return "error";
	}

	@RequestMapping(value = "/deleteById")
	public String deleteById(HttpServletRequest request,
			HttpServletResponse response, ModelMap modelMap, String id) {

		if (StringUtils.isNotBlank(id)) {
			if (userInfoMapper.deleteById(Integer.parseInt(id)) > 0) {
				return "success";
			}
		} 
		return "error";
	}

	@RequestMapping(value = "/selectListByFilter")
	public List<UserInfo> selectListByFilter(UserInfoFilter filter) {
        
		return userInfoMapper.selectListByFilter(filter);
	}

	@RequestMapping(value = "/getCountByFilter")
	public Integer getCountByFilter(UserInfoFilter filter) {

		return userInfoMapper.getCountByFilter(filter);
	}
}
