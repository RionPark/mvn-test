package com.mvn.test.service;

import java.util.List;
import java.util.Map;

import com.mvn.test.vo.UserInfoVO;

public interface UserInfoService {
	public List<UserInfoVO> getUserList(Map<String,String> pUser);
	public UserInfoVO getUser(UserInfoVO user);
	public Map<String,String> insertUser(UserInfoVO user);
	public Map<String,String> updateUser(UserInfoVO user);
	public Map<String,String> deleteUser(UserInfoVO user);
} 
