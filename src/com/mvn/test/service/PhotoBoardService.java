package com.mvn.test.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.mvn.test.vo.PhotoBoardVO;

public interface PhotoBoardService {
	List<PhotoBoardVO> selectPhotoBoardList( PhotoBoardVO pb);
	PhotoBoardVO selectPhotoBoard( int pbNum);
	Map<String,String> insertPhotoBoard( PhotoBoardVO pb);
	Map<String,String> updatePhotoBoard( PhotoBoardVO pb);
	Map<String,String> deletePhotoBoard( PhotoBoardVO pb);
}
