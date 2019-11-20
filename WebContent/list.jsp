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
		<h4>파일 리스트</h4>
		<table class="table  table-bordered table-striped">
			<thead class="thead-dark">
				<tr>
					<th>아이디</th>
					<th>이름</th>
					<th>이미지</th>
				</tr>
			</thead>
			<tbody id="tBody">
				<tr>
					<td colspan="3">내용없음</td>
				</tr>
			</tbody>
		</table>
	</div>
<script>

window.onload = function(){
	var xhr = new XMLHttpRequest();
	xhr.open('GET','/file');
	xhr.onreadystatechange = function(){
		if(xhr.readyState==4){
			if(xhr.status==200){
				var ftList = JSON.parse(xhr.responseText);
				var html ='';
				for(var ft of ftList){
					html += '<tr>';
					html += '<td>' + ft.FT_ID + '</td>';
					html += '<td>' + ft.FT_NAME + '</td>';
					html += '<td><img src="' + ft.FT_FILE + '" width=150></td>';
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