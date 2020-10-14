<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<c:set var="rootPath" value='${pageContext.request.contextPath}' />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name='viewport' content='width=device-width, initial-scale=1'>
<script src="https://code.jquery.com/jquery-latest.min.js"></script>
<script src="https://kit.fontawesome.com/c1d8b25418.js" crossorigin="anonymous"></script>
<title>나의 홈페이지</title>

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
		padding: 2rem;
		background-color: green;
		color:white;
		text-align: center;
	}
	
	section#content{
	/*
		html, body를 height : 100%로 설정하고,
		body를 flex로 설정하고
		flex-direction : column으로 설정
		
		header, nav, content, footer를 각각 배열하고
		content가 있는 box에만 flex:1로 설정하면
		세로방향 전체 가득찬 layout이 만들어진다.
	*/
		flex:1;
		overflow: auto;
	}
	nav#main-nav ul{
		list-style: none;
		display: flex;
		background-color: blue;
	}
	nav#main-nav li{
		padding: 12px 16px;
		margin: 0px 5px;
		color:white;
		border-bottom: 3px solid transparent;
		cursor: pointer;
		transition : border-color 0.3s linear;
	}
	
	nav#main-nav li:hover{
		border-bottom: 3px solid red; 
		
	}
	
	nav#main-nav li:nth-child(3)
	{
		margin-left: auto;
	}
	
	
	footer {
		background-color: black;
		color: white;
		text-align: center;
		padding: 0.7rem;
	}
</style>


</head>
<body>
	<tiles:insertAttribute name ="header" />
	<tiles:insertAttribute name="menu" />
	<tiles:insertAttribute name="content" />
	<tiles:insertAttribute name="footer" />
</body>
</html>