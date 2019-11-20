package com.mvn.test.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public interface FileTestService {
	public Map<String,String> insertFileTest(Map<String,Object> param);
	List<Map<String,String>>selectFileTest();
}
