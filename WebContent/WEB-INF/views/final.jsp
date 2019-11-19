<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>final<%=request.getParameter("a")%></h4>
	<ul>
		<c:forEach items="${list}" var="name">
			<li>${name}</li>
		</c:forEach>
	</ul>
</body>
</html>