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
		<h4>유저리스트</h4>
		<table class="table  table-bordered table-striped">
			<thead class="thead-dark">
				<tr>
					<th>번호</th>
					<th>이름</th>
					<th>아이디</th>
					<th>가입일</th>
				</tr>
			</thead>
			<tbody id="tBody">
				<tr>
					<td colspan="4">내용없음</td>
				</tr>
			</tbody>
		</table>
		<div class="button">
			<button onclick="goPage('/user/userInsert')">유저추가</button>
		</div>
	</div>
<script>
window.onload = function(){
	var xhr = new XMLHttpRequest();
	xhr.open('GET','/user/list');
	xhr.onreadystatechange = function(){
		if(xhr.readyState==4){
			if(xhr.status==200){
				var userList = JSON.parse(xhr.responseText);
				var html ='';
				for(var user of userList){
					html += '<tr onclick="goPage(\'/user/userView?uiNum=' + user.uiNum + '\')">';
					html += '<td>' + user.uiNum + '</td>';
					html += '<td>' + user.uiName + '</td>';
					html += '<td>' + user.uiId + '</td>';
					html += '<td>' + user.credat + '</td>';
					html += '</tr>';
				}
				document.querySelector('#tBody').innerHTML = html;
			}
		}
	}
	xhr.send();
}
</script>
</body>
</html>