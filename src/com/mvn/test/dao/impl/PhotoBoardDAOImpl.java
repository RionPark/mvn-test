package com.mvn.test.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mvn.test.controller.InitServlet;
import com.mvn.test.dao.PhotoBoardDAO;
import com.mvn.test.vo.PhotoBoardVO;

public class PhotoBoardDAOImpl implements PhotoBoardDAO {

	@Override
	public List<PhotoBoardVO> selectPhotoBoardList(SqlSession ss, PhotoBoardVO pb) {

		return ss.selectList("PhotoBoard.selectPhotoBoardList",pb);
	}

	@Override
	public PhotoBoardVO selectPhotoBoard(SqlSession ss, int pbNum) {
		
		return ss.selectOne("PhotoBoard.selectPhotoBoard",pbNum);
	}

	@Override
	public int insertPhotoBoard(SqlSession ss, PhotoBoardVO pb) {
		
		return ss.insert("PhotoBoard.insertPhotoBoard",pb);
	}

	@Override
	public int updatePhotoBoard(SqlSession ss, PhotoBoardVO pb) {
		
		return ss.update("PhotoBoard.updatePhotoBoard",pb);
	}

	@Override
	public int deletePhotoBoard(SqlSession ss, PhotoBoardVO pb) {
		
		return ss.delete("PhotoBoard.deletePhotoBoard",pb);
	}
	public static void main(String[] args) {
		PhotoBoardDAO pdao = new PhotoBoardDAOImpl();
		SqlSession ss = InitServlet.getSqlSession();
		PhotoBoardVO pb = new PhotoBoardVO();
		pb.setPbTitle("업데이트 제목");
		pb.setPbContent("업데이트 내용");
		pb.setCreusr(1);
		pb.setPbNum(27);
		//System.out.println(pdao.insertPhotoBoard(ss, pb));
		//System.out.println(pdao.selectPhotoBoard(ss, 27));
		//System.out.println(pdao.selectPhotoBoardList(ss, null));
		//System.out.println(pdao.updatePhotoBoard(ss, pb));
		System.out.println(pdao.deletePhotoBoard(ss, pb));
		ss.commit();
		
	}


}
