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
</script>