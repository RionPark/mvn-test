package com.mvn.test.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.mvn.test.common.ServletFileUtil;
import com.mvn.test.service.PhotoBoardService;
import com.mvn.test.service.impl.PhotoBoardServiceImpl;
import com.mvn.test.vo.PhotoBoardVO;

/**
 * Servlet implementation class PhotoBoardController
 */
@WebServlet("/photo/*")
public class PhotoBoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PhotoBoardService pbs = new PhotoBoardServiceImpl();
    private Gson gson = new Gson();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/")+1);
		String json = "";
		if("list".equals(cmd)) {
			json = gson.toJson(pbs.selectPhotoBoardList(null));
		}else if("view".equals(cmd)) {
			int pbNum = Integer.parseInt(request.getParameter("pbNum"));
			json = gson.toJson(pbs.selectPhotoBoard(pbNum));
		}
		response.getWriter().print(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/")+1);
		String json = "";
		Map<String,Object> param = ServletFileUtil.parseRequest(request);
		JsonElement je = gson.toJsonTree(param);
		PhotoBoardVO pb = gson.fromJson(je, PhotoBoardVO.class);
		if("insert".equals(cmd)) {
			json = gson.toJson(pbs.insertPhotoBoard(pb));
		}else if("delete".equals(cmd)) {
			json = gson.toJson(pbs.deletePhotoBoard(pb));
		}else if("update".equals(cmd)) {
			json = gson.toJson(pbs.updatePhotoBoard(pb));
		}
		response.getWriter().print(json);
	}

}
