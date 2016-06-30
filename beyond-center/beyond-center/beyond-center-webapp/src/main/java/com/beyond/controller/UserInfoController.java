package com.beyond.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.beyond.mapper.UserInfoMapper;
import com.beyond.model.UserInfo;

@RestController
@RequestMapping(value = "/user")
public class UserInfoController {

	@Autowired
	private UserInfoMapper userInfoMapper;

	@RequestMapping(value = "/getUserInfoList")
	public List<Map<String, Object>> getUserInfoList(HttpServletRequest request,
			HttpServletResponse response, ModelMap modelMap) {

		 return userInfoMapper.selectUserInfoList();
	}

	@RequestMapping(value = "/getUserInfoById")
	public Map<String, Object> getUserInfoById(HttpServletRequest request,
			HttpServletResponse response, ModelMap modelMap, String id) {

		if (StringUtils.isNotBlank(id)) {
			return userInfoMapper.getUserInfoById(Integer.parseInt(id));
		} else {
			return null;
		}
	}

	@RequestMapping(value = "/editUserInfo")
	public void editUserInfo(HttpServletRequest request,
			HttpServletResponse response, ModelMap modelMap, UserInfo userInfo) {

		if (userInfo.getId() != null) {
			userInfoMapper.updateUserInfo(userInfo);
		} else {
			userInfoMapper.insertUserInfo(userInfo);
		}
	}

	@RequestMapping(value = "/deleteUserInfo")
	public void deleteUserInfo(HttpServletRequest request,
			HttpServletResponse response, ModelMap modelMap, String id) {

		if (StringUtils.isNotBlank(id)) {
			userInfoMapper.deleteUserInfoById(Integer.parseInt(id));
		} 
	}
}
