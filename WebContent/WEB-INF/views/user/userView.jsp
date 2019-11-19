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
	<table class="table table-bordered">
		<tr>
			<th>번호</th>
			<td data-id="uiNum"></td>
		</tr>
		<tr>
			<th>이름</th>
			<td data-id="uiName"></td>
		</tr>
		<tr>
			<th>아이디</th>
			<td data-id="uiId"></td>
		</tr>
		<tr>
			<th>가입시간</th>
			<td data-id="cretim"></td>
		</tr> 
		<tr>
			<th>가입일</th>
			<td data-id="credat"></td>
		</tr>
		<tr>
			<th>활성여부</th>
			<td data-id="active"></td>
		</tr>
		<tr>
			<th colspan="2">
				<button onclick="update(this)">수정</button>
				<button onclick="deleteUser()">삭제</button>
				<button onclick="goPage('/user/userList')">리스트가기</button>
			</th>
		</tr>
	</table>
</div>
<script>
var user;
window.onload = function(){
	var xhr = new XMLHttpRequest();
	xhr.open('GET','/user/view?uiNum=${param.uiNum}');
	xhr.onreadystatechange = function(){
		if(xhr.readyState==4){
			if(xhr.status==200){
				user = JSON.parse(xhr.responseText);
				var tds = document.querySelectorAll('td[data-id]');
				for(var idx=0;idx<tds.length;idx++){
					var td = tds[idx];
					var key = td.getAttribute('data-id');
					td.innerHTML = user[key];
				}
			}
		}
	}
	xhr.send();
}

function deleteUser(){
	var xhr = new XMLHttpRequest();
	xhr.open('POST','/user/delete');
	xhr.onreadystatechange = function(){
		if(xhr.readyState==4){
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
			uiNum:user.uiNum
	}
	xhr.send(JSON.stringify(param));
}

function update(btn){
	btn.onclick = updateUser;
	var tds = document.querySelectorAll('td[data-id=active],td[data-id=uiName]');
	for(var i=0;i<tds.length;i++){
		var td = tds[i];
		var id = td.getAttribute('data-id');
		td.innerHTML = '<input type="text" id="' + id + '" value="' + user[id]+ '">';
	}
}

function updateUser(){
	var xhr = new XMLHttpRequest();
	xhr.open('POST','/user/update');
	xhr.onreadystatechange = function(){
		if(xhr.readyState==4){
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
			uiNum:user.uiNum,
			uiName:document.querySelector('#uiName').value,
			active:document.querySelector('#active').value
	}
	xhr.send(JSON.stringify(param));
}
</script>
</body>
</html>