<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<input type="text" id="name">
<button onclick="submit()">전송</button>
<script>
function submit(){
	var name = document.querySelector('#name');
	var xhr = new XMLHttpRequest();
	var param = {
			name:name.value
	}
	param = encodeURIComponent(JSON.stringify(param))
	xhr.open('GET', '/getForm?json=' + param);
	xhr.onreadystatechange = function(){
		if(xhr.readyState == xhr.DONE){
			if(xhr.status==200){
				alert(xhr.responseText);
			}
		}
	}
	xhr.send();
}
</script>
</body>
</html>