package com.mvn.test.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.google.gson.Gson;
import com.mvn.test.common.ServletFileUtil;
import com.mvn.test.service.PhotoBoardService;
import com.mvn.test.service.impl.PhotoBoardServiceImpl;
import com.mvn.test.vo.PhotoBoardVO;

@WebServlet("/photo/*")
public class PhotoBoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private PhotoBoardService pbs = new PhotoBoardServiceImpl();
    private Gson g = new Gson();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String json = g.toJson(pbs.selectPhotoBoard());
		response.getWriter().print(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String,Object> param = ServletFileUtil.parseRequest(request);
		Map<String,String> rMap = pbs.insertPhotoBoard(param);
		System.out.println(rMap);
	}

}
