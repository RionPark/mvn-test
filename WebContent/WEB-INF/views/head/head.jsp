<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<script src="${jsPath}/jquery-3.4.1.js"></script>
<script src="${jsPath}/bootstrap.min.js"></script>
<script src="${jsPath}/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="${cssPath}/bootstrap.min.css"/>
<link rel="stylesheet" href="${cssPath}/bootstrap-reboot.min.css"/>
<link rel="stylesheet" href="${cssPath}/bootstrap-grid.min.css"/>
<script>
function goPage(url){
	location.href = '/views' + url;
}

function makeFormData(){
	var objs = document.querySelectorAll('input[id],textarea[id]');
	var formData = new FormData();
	for(var i=0;i<objs.length;i++){
		var obj = objs[i];
		if(obj.type=='file'){
			if(obj.files.length){
				formData.append(obj.id, obj.files[0]);
			}
		}else{
			formData.append(obj.id,obj.value);
		}
	}
	return formData;
}

function send(conf){
	var xhr = new XMLHttpRequest();
	xhr.open(conf.method, conf.url);
	xhr.onreadystatechange = function(){
		if(xhr.readyState==4){
			if(xhr.status==200){
				conf.func(xhr.responseText);
			}
		}
	}
	xhr.send(conf.data);
}
</script>