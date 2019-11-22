<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	제목 : <input type="text" id="pbTitle"><br>
	내용 : <input type="text" id="pbContent"><br>
	작성자 : <input type="text" id="creusr"><br>
	사진1 : <input type="file" id="pbImg1"><br>
	사진2 : <input type="file" id="pbImg2"><br>
	<button onclick="submit()">파일전송</button>
<script>
function makeFormData(){
	var objs = document.querySelectorAll('[id]');
	var formData = new FormData();
	for(var i=0;i<objs.length;i++){
		var obj = objs[i];
		if(obj.type=='file'){
			if(obj.files.length!=0){
				formData.append(obj.id,obj.files[0]);
			}
		}else{
			formData.append(obj.id,obj.value);
		}
	}
	return formData;
}
function getXhr(conf){
	var xhr = new XMLHttpRequest();
	xhr.open(conf.method,conf.url);
	xhr.onreadystatechange = function(){
		if(xhr.readyState==4){
			if(xhr.status==200){
				conf.func(xhr.responseText);
			}
		}
	}
	return xhr;
}

function submit(){
	var xhr = getXhr({
		method:'POST',
		url:'/photo/insert',
		func:function(res){
			res = JSON.parse(res);
			alert(res.msg);
		}
	})
	var fd = makeFormData();
	xhr.send(fd);
}
</script>
</body>
</html>





