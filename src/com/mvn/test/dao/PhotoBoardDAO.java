package com.mvn.test.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mvn.test.vo.PhotoBoardVO;

public interface PhotoBoardDAO {
	List<PhotoBoardVO>selectPhotoBoard(SqlSession ss);
	int insertPhotoBoard(SqlSession ss,PhotoBoardVO pb);
}
