package com.mvn.test.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.google.gson.Gson;
import com.mvn.test.service.FileTestService;
import com.mvn.test.service.impl.FileTestServiceImpl;

/**
 * Servlet implementation class FileServlet
 */
@WebServlet("/file")
@MultipartConfig
public class FileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private FileTestService fts = new FileTestServiceImpl();
    private Gson gson = new Gson();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String json = gson.toJson(fts.selectFileTest());
		response.getWriter().print(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int memSize = 1024 *1024*5; //5MB
		int totalSize = 1024*1024*50; //50MB
		int fileSize = 1024*1024*10; //10MB
		DiskFileItemFactory dfif = new DiskFileItemFactory();
		dfif.setSizeThreshold(memSize);
		dfif.setRepository(new File(System.getProperty("java.io.tmpdir")));
		ServletFileUpload sfu = new ServletFileUpload(dfif);
		sfu.setFileSizeMax(fileSize);
		sfu.setSizeMax(totalSize);
		if(ServletFileUpload.isMultipartContent(request)) {
			try {
				List<FileItem> fList = sfu.parseRequest(request);
				Map<String,Object> param = new HashMap<>();
				
				for(FileItem fi:fList) {
					String key = fi.getFieldName();
					if(fi.isFormField()) {
						String value = fi.getString("utf-8");
						param.put(key, value);
					}else {
						param.put(key, fi);
					}
				}
				fts.insertFileTest(param);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			throw new ServletException("파일 형식이 잘못되었습니다.");
		}
	}

	public static void main(String[] args) {
		String tmp = System.getProperty("java.io.tmpdir");
		System.out.println(tmp);
	}
}
