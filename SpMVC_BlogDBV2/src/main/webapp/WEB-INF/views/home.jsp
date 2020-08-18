<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value = '${pageContext.request.contextPath}'/>
<!DOCTYPE html>
<html>
<head>
	<%@ include file ="/WEB-INF/views/include/include-head.jspf" %>
	<link rel = "stylesheet" type ="text/css" href='${rootPath}/static/css/input.css?ver=2020-08-13'/>
</head>
<body>
	<%@ include file ="/WEB-INF/views/include/include-header.jspf" %> <!-- Header -->

	<section id="main">
		<article id="button">
			<button>
				<a href='${rootPath}/blog/list'>블로그 작성</a>
			</button>
		</article>

		<article id="blog_body">
			<section class="blog_title">
				<h4>김성모 폭룡의시</h4>
			</section>

			<section class="blog_text">
				<h5>붉은 피,</h5>
				<h5> 보이지 않는 폭룡의 전투 눈물겨운 기억들 망가진 내 육체,</h5> 
				<h5>내 가슴에 묻고 승리여</h5>
				<h5>나에게 오라 자만도 오만도 그것은 폭룡의 검</h5> 
				<h5>어느날 전투의 패배에 쓰러졌어도 숱한 전투의 종착지라</h5> 
				<h5>생각지마라 육체는</h5>
				<h5>단명이고 근성은 영원한것 대류... 폭룡이 최고다</h5>
			</section>
		</article>
	</section>



	<section>
	<%@ include file ="/WEB-INF/views/include/include-footer.jspf" %>
	</section>
</body>
</html>