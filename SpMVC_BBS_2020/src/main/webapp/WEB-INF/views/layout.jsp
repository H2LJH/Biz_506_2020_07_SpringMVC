<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<c:set var="rootPath" value='${pageContext.request.contextPath}' />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name='viewport' content='width=device-width, initial-scale=1'>
<title>BBS 2020</title>

<!-- 폰트어썸 -->
<script src="https://kit.fontawesome.com/c1d8b25418.js" crossorigin="anonymous"></script>


<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<!-- include summernote css/js -->
<!-- <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script> -->


<link rel="stylesheet" href="${rootPath}/static/summernote/summernote-bs4.min.css">
<script src="${rootPath}/static/summernote/summernote-bs4.min.js"></script>
<script src="${rootPath}/static/summernote/lang/summernote-ko-KR.min.js"></script>
<style>

	*{
		box-sizing: border-box;
		margin: 0;
		padding: 0;
	}
	
	html, body{
		width: 100%;
		height: 100%;
	}
	
	body{
		display: flex;
		flex-direction: column;
	}
	
	header{
		background-color: green;
		color: white;
		padding: 1.2rem;
		text-align: center;
	}
	
	nav ul{
		list-style: none;
		display: flex;
		background-color: blue;
		color: white;
	}
	
	nav ul li{
		display: inline-block;
		margin: 0px 10px;
		padding: 12px 16px;
		cursor: pointer;
	}
	
	nav ul li:hover {
	background-color: #ddd;
	color: black;
	}
	
	/*
		body를 flex로 선언하고
		content가 위치하는 Box에 flex값을 1로 선언하면
		화면에 가득차는 layout이 만들어진다.
		html, body의 height를 100%로 설정해주어야 한다.
		overflow : auto로 설정을 하면 내용이 가득찼을때 자동으로 스크롤바가 생성
	*/
	section#content {
		flex: 1;
		overflow: auto;
	}
	
	footer{
		background-color: black;
		color: white;
		text-align: center;
		padding: 0.7rem;	
	}
}
	
</style>
</head>
<body>
	<tiles:insertAttribute name="header" />
	<tiles:insertAttribute name="nav" />
	
	<section id="content">
			<tiles:insertAttribute name="content" />
	</section>
	
	<tiles:insertAttribute name="footer" />
	
</body>
</html>