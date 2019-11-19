package com.mvn.test.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServlet;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.mvn.test.controller.InitServlet;
import com.mvn.test.dao.UserInfoDAO;
import com.mvn.test.vo.UserInfoVO;

public class UserInfoDAOImpl implements UserInfoDAO {

	private SqlSessionFactory ssf;

	@Override
	public List<UserInfoVO> selectUserList(Map<String, String> pUser) {
		SqlSession ss =  InitServlet.getSqlSession();
		try {
			return ss.selectList("UserInfo.selectUserList",pUser);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			ss.close();
		}
		return null;
	}

	@Override
	public UserInfoVO selectUser(UserInfoVO user) {
		SqlSession ss =  InitServlet.getSqlSession();
		try {
			return ss.selectOne("UserInfo.selectUser",user);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			ss.close();
		}
		return null;
	}
	@Override
	public int insertUser(UserInfoVO user) {
		SqlSession ss =  InitServlet.getSqlSession();
		try {
			int cnt = ss.insert("UserInfo.insertUser",user);
			ss.commit();
			return cnt;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			ss.close();
		}
		return 0;
	}
	
	@Override
	public int updateUser(UserInfoVO user) {
		SqlSession ss =  InitServlet.getSqlSession();
		try {
			int cnt = ss.update("UserInfo.updateUser",user);
			ss.commit();
			return cnt;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			ss.close();
		}
		return 0;
	}

	@Override
	public int deleteUser(UserInfoVO user) {
		SqlSession ss =  InitServlet.getSqlSession();
		try {
			int cnt = ss.delete("UserInfo.deleteUser",user);
			ss.commit();
			return cnt;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			ss.close();
		}
		return 0;
	}
}
