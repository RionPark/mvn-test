package com.mvn.test.controller;

import java.io.BufferedReader;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PostFormServlet
 */
@WebServlet("/postForm")
public class PostFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		if(name==null) {
			BufferedReader br = request.getReader();
			name = br.readLine();
		}
		response.getWriter().println("니가 쓴 이름 : " + name);
	}

}
