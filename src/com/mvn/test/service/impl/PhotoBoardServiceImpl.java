package com.mvn.test.service.impl;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.fileupload.FileItem;
import org.apache.ibatis.session.SqlSession;

import com.mvn.test.common.ServletFileUtil;
import com.mvn.test.controller.InitServlet;
import com.mvn.test.dao.PhotoBoardDAO;
import com.mvn.test.dao.impl.PhotoBoardDAOImpl;
import com.mvn.test.service.PhotoBoardService;
import com.mvn.test.vo.PhotoBoardVO;

public class PhotoBoardServiceImpl implements PhotoBoardService {
	private PhotoBoardDAO pbdao = new PhotoBoardDAOImpl();
	
	@Override
	public List<PhotoBoardVO> selectPhotoBoard() {
		SqlSession ss = InitServlet.getSqlSession();
		try {
			return pbdao.selectPhotoBoard(ss);
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			ss.close();
		}
		return null;
	}

	@Override
	public Map<String, String> insertPhotoBoard( Map<String,Object> param) {
		PhotoBoardVO pb = new PhotoBoardVO();
		pb.setPbTitle((String)param.get("pbTitle"));
		pb.setPbContent((String)param.get("pbContent"));
		pb.setCreusr(Integer.parseInt((String)param.get("creusr")));

		Map<String,String> rMap = new HashMap<>();
		rMap.put("msg","실패");
		rMap.put("result", "false");
		SqlSession ss = InitServlet.getSqlSession();
		try {
			if(param.get("pbImg1")!=null) {
				FileItem fi = (FileItem) param.get("pbImg1");
				String fileName = ServletFileUtil.saveFile(fi);
				pb.setPbImg1(fileName);
			}
			if(param.get("pbImg2")!=null) {
				FileItem fi = (FileItem) param.get("pbImg2");
				String fileName = ServletFileUtil.saveFile(fi);
				pb.setPbImg2(fileName);
			}
			int cnt = pbdao.insertPhotoBoard(ss, pb);
			if(cnt==1) {
				rMap.put("msg","성공");
				rMap.put("result", "true");
			}
			ss.commit();
		}catch(Exception e) {
			ss.rollback();
			e.printStackTrace();
		}finally {
			ss.close();
		}
		return rMap;		
	}
}
