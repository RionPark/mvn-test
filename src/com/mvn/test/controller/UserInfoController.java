package com.mvn.test.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.mvn.test.service.UserInfoService;
import com.mvn.test.service.impl.UserInfoServiceImpl;
import com.mvn.test.vo.UserInfoVO;

/**
 * Servlet implementation class UserInfoController
 */
@WebServlet(name = "UserInfoController", urlPatterns = {"/user/*"})
public class UserInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserInfoService uis = new UserInfoServiceImpl();
	private Gson gson = new Gson();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getRequestURI().substring(6);
		String json = "";
		if("list".equals(cmd)) {
			json = gson.toJson(uis.getUserList(null));
		}else if("view".equals(cmd)) {
			int uiNum = Integer.parseInt(request.getParameter("uiNum"));
			UserInfoVO user = new UserInfoVO();
			user.setUiNum(uiNum);
			json = gson.toJson(uis.getUser(user));
		}
		response.getWriter().print(json);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BufferedReader br = request.getReader();
		String str =  null;
		String json = "";
		while((str=br.readLine())!=null) {
			json += str;
		}
		UserInfoVO user = gson.fromJson(json, UserInfoVO.class);
		String cmd = request.getRequestURI().substring(6);
		if("insert".equals(cmd)) {
			json = gson.toJson(uis.insertUser(user));
		}else if("update".equals(cmd)) {
			json = gson.toJson(uis.updateUser(user));
		}else if("delete".equals(cmd)) {
			json = gson.toJson(uis.deleteUser(user));
		}
		response.getWriter().print(json);
	}

}
