package com.beyond.filter;

import com.beyond.framework.filter.SearchFilter;

public class UserInfoFilter extends SearchFilter {

	private String name;
	private String trueName;
	private Integer age;

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getAge() {
		return age;
	}
	
	public void setAge(Integer age) {
		this.age = age;
	}

	public String getTrueName() {
		return trueName;
	}

	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}
}
