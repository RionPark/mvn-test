package com.mvn.test.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mvn.test.controller.InitServlet;
import com.mvn.test.dao.PhotoBoardDAO;
import com.mvn.test.vo.PhotoBoardVO;

public class PhotoBoardDAOImpl implements PhotoBoardDAO {

	@Override
	public List<PhotoBoardVO> selectPhotoBoard(SqlSession ss) {
		return ss.selectList("PhotoBoard.selectPhotoBoard");
	}

	@Override
	public int insertPhotoBoard(SqlSession ss, PhotoBoardVO pb) {
		return ss.insert("PhotoBoard.insertPhotoBoard",pb);
	}

	public static void main(String[] args) {
		SqlSession ss = InitServlet.getSqlSession();
		PhotoBoardDAO pbdao = new PhotoBoardDAOImpl();
		//System.out.println(pbdao.selectPhotoBoard(ss));
		PhotoBoardVO pb = new PhotoBoardVO();
		pb.setPbContent("내용");
		pb.setPbTitle("제목");
		pb.setCreusr(1);
		pb.setPbImg1("1");
		pb.setPbImg2("2");
		System.out.println(pb);
		System.out.println(pbdao.insertPhotoBoard(ss, pb));
	}
}
