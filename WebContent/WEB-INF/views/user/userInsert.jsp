<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>유저추가</title>
<jsp:include page="/WEB-INF/views/head/head.jsp"></jsp:include>
</head>
<body>
	<div class="container">
		<h4>유저 추가</h4>

		<table class="table  table-bordered table-striped">
			<tr>
				<th>이름</th>
				<td><input type="text" id="uiName"></td>
			</tr>
			<tr>
				<th>아이디</th>
				<td><input type="text" id="uiId"></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" id="uiPwd"></td>
			</tr>
			<tr>
				<th colspan="2">
					<button onclick="save()">유저추가</button>
					<button onclick="goPage('/user/userList')">리스트 돌아가기</button>
				</th>
			</tr>
		</table>
	</div>
<script>
function save(){
	var xhr = new XMLHttpRequest();
	xhr.open('POST','/user/insert');
	xhr.onreadystatechange = function(){
		if(xhr.readyState==xhr.DONE){
			if(xhr.status==200){
				var res = JSON.parse(xhr.responseText);
				alert(res.msg);
				if(res.result=='true'){
					goPage('/user/userList');
				}
			}
		}
	}
	var param = {
			uiId:document.querySelector('#uiId').value,
			uiName:document.querySelector('#uiName').value,
			uiPwd:document.querySelector('#uiPwd').value,
	}
	xhr.send(JSON.stringify(param));
}
</script>
</body>
</html>