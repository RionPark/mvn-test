package com.mvn.test.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mvn.test.vo.PhotoBoardVO;

public interface PhotoBoardDAO {
	List<PhotoBoardVO> selectPhotoBoardList(SqlSession ss, PhotoBoardVO pb);
	PhotoBoardVO selectPhotoBoard(SqlSession ss, int pbNum);
	int insertPhotoBoard(SqlSession ss, PhotoBoardVO pb);
	int updatePhotoBoard(SqlSession ss, PhotoBoardVO pb);
	int deletePhotoBoard(SqlSession ss, PhotoBoardVO pb);
}
