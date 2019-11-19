<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.apache.ibatis.executor.ReuseExecutor"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<c:set var="name" value="page" />
<c:set var="name" value="req" scope="request"/>
<c:set var="name" value="session" scope="session"/>
<c:set var="name" value="app" scope="application"/>
<%
RequestDispatcher rd = request.getRequestDispatcher("/target.jsp");
rd.forward(request, response); 
%>
${name}