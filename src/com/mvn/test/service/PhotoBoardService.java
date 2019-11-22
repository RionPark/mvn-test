package com.mvn.test.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.mvn.test.vo.PhotoBoardVO;

public interface PhotoBoardService {

	List<PhotoBoardVO>selectPhotoBoard();
	Map<String,String> insertPhotoBoard(Map<String,Object> param);
}
