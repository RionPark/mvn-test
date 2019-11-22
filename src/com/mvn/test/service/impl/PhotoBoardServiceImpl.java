package com.mvn.test.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.mvn.test.controller.InitServlet;
import com.mvn.test.dao.PhotoBoardDAO;
import com.mvn.test.dao.impl.PhotoBoardDAOImpl;
import com.mvn.test.service.PhotoBoardService;
import com.mvn.test.vo.PhotoBoardVO;

public class PhotoBoardServiceImpl implements PhotoBoardService{
	private PhotoBoardDAO pbdao = new PhotoBoardDAOImpl();
	public static void main(String[] args) {
		PhotoBoardService pbs = new PhotoBoardServiceImpl();
		PhotoBoardVO pb = new PhotoBoardVO();
		pb.setPbTitle("신규 입력 테스트 제목");
		pb.setPbContent("신규입력 테스트 내용");
		pb.setCreusr(1);
		System.out.println(pbs.selectPhotoBoard(29));
	}
	@Override
	public List<PhotoBoardVO> selectPhotoBoardList(PhotoBoardVO pb) {
		SqlSession ss = InitServlet.getSqlSession();
		try {
			return pbdao.selectPhotoBoardList(ss, pb);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			ss.close();
		}
		return null;
	}

	@Override
	public PhotoBoardVO selectPhotoBoard(int pbNum) {
		SqlSession ss = InitServlet.getSqlSession();
		try {
			PhotoBoardVO pb = new PhotoBoardVO();
			pb.setPbNum(pbNum);
			pb.setPbCnt(1);
			updatePhotoBoard(pb);
			return pbdao.selectPhotoBoard(ss, pbNum);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			ss.close();
		}
		return null;
	}

	@Override
	public Map<String, String> insertPhotoBoard(PhotoBoardVO pb) {
		SqlSession ss = InitServlet.getSqlSession();
		Map<String, String> hm = new HashMap<>();
		hm.put("msg", "입력 실패");
		hm.put("result", "false");
		try {
			int cnt =  pbdao.insertPhotoBoard(ss, pb);
			if(cnt==1) {
				hm.put("msg", "입력 성공");
				hm.put("result", "true");
			}
			ss.commit();
		}catch(Exception e) {
			ss.rollback();
			e.printStackTrace();
		}finally {
			ss.close();
		}
		return hm;
	}

	@Override
	public Map<String, String> updatePhotoBoard(PhotoBoardVO pb) {
		SqlSession ss = InitServlet.getSqlSession();
		Map<String, String> hm = new HashMap<>();
		hm.put("msg", "수정 실패");
		hm.put("result", "false");
		try {
			int cnt =  pbdao.updatePhotoBoard(ss, pb);
			if(cnt==1) {
				hm.put("msg", "수정 성공");
				hm.put("result", "true");
			}
			ss.commit();
		}catch(Exception e) {
			ss.rollback();
			e.printStackTrace();
		}finally {
			ss.close();
		}
		return hm;
	}

	@Override
	public Map<String, String> deletePhotoBoard(PhotoBoardVO pb) {
		SqlSession ss = InitServlet.getSqlSession();
		Map<String, String> hm = new HashMap<>();
		hm.put("msg", "삭제 실패");
		hm.put("result", "false");
		try {
			int cnt =  pbdao.deletePhotoBoard(ss, pb);
			if(cnt==1) {
				hm.put("msg", "삭제 성공");
				hm.put("result", "true");
			}
			ss.commit();
		}catch(Exception e) {
			ss.rollback();
			e.printStackTrace();
		}finally {
			ss.close();
		}
		return hm;
	}

}
