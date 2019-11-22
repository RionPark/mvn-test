<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="/WEB-INF/views/head/head.jsp"></jsp:include>
</head>
<body>
<div class="container">
	제목 : <input type="text" id="pbTitle"><br>
	내용 : <textarea id="pbContent"></textarea><br>
	유저 : <input type="number" id="creusr"><br>
	이미지1 : <input type="file" id="pbImg1"><br>
	이미지2 : <input type="file" id="pbImg2"><br>
	<button onclick="submit()">등록</button>
<script>
function submit(){
	var formData = makeFormData();
	var conf = {
			method : 'POST',
			url : '/photo/insert',
			func : function(res){
				console.log(res);
			},
			data : formData
	}
	send(conf);
}
</script>
</div>
</body>
</html>