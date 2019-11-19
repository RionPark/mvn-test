package com.mvn.test.controller;

import java.io.InputStream;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mvn.test.dao.impl.UserInfoDAOImpl;

@WebServlet(name="Init",urlPatterns = {"/init"},loadOnStartup = 1)
public class InitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static SqlSessionFactory ssf;
    static {
    	System.out.println("나는 내 클래스의 생성자보다 무조거~~~언 먼저 실행되지");
    	System.out.println("난 생성자랑 init이랑은 전혀 상관 없지~~");
		String path = "/config/mybatis-config.xml";
		InputStream is = UserInfoDAOImpl.class.getResourceAsStream(path);
		ssf = new SqlSessionFactoryBuilder().build(is);
    }
    public InitServlet() {
    	System.out.println("난 서버 켜질때 실행됨!!");
    	System.out.println("난 해당메모리가 사라지기 전에는 1번만 실행함!");
    }
    public void init() {
    	System.out.println("난 InitServlet()실행 후에 실행됨.");
    	System.out.println("나도 1번만 실행함!");
    }
	public static SqlSession getSqlSession() {
		return ssf.openSession();
	}
}
