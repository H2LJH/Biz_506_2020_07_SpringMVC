<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<% /*
	spring security에서 ROLE 정보를 확인하여
	권한에 따라서 메뉴를 보이고 보이지 않도록 하는 용도로 사용하는 taglib
*/ %>

<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<c:set var="rootPath" value='${pageContext.request.contextPath}' />

<script>
	// 현재 화면의 DOM이 load 된 후
	// DOMContentLoaded와 비슷한 event로 load event가 있는데
	// load event는 좀 오래전에 지정된 event이다.
	// 원래 이 event window.onload() event를 감싸는 핸들링이다.
	// 최근의 JS에서는 별로 사용을 권하지 않는 event 이다.
	window.addEventListener("load", function()
	{
		document.querySelector("#menu_home").addEventListener("click", function()
		{
			document.location.href = "${rootPath}/";	
		})
		
		document.querySelector("#menu_center").addEventListener("click", function()
		{
			document.location.href = "${rootPath}/admin";	
		})
		
		document.querySelector("#menu_join").addEventListener("click",function()
		{
			document.location.href = "${rootPath}/user/join";
		})
		document.querySelector("#menu_login").addEventListener("click",function()
		{
			document.location.href = "${rootPath}/user/login";
		})
		document.querySelector("#menu_mypage").addEventListener("click",function()
		{
			document.location.href = "${rootPath}/user/mypage";
		})
		
	})
</script>

<nav id="main-nav">
	<ul>
		<li id="menu_home">HOME</li>
		<li id="menu_center">Center</li>
		
		<sec:authorize access="isAnonymous()"> <%/* isAnonymous() : 현재 화면에서 로그인한 세션정보를 찾을 수 없으면 회원가입, 로그인 메뉴를 보여라 */ %>
			<li id="menu_join">회원가입</li>
			<li id="menu_login">로그인</li>
		</sec:authorize>
		
		<sec:authorize access="isAuthenticated()"> <%/* isAuthenticated() : 현재 화면에서 권한에 관계없이 로그인한 세션정보가 있으면 mypage 로그아웃 메뉴를 보여라 */ %>
			<li id="menu_mypage">MyPage</li>
			<li>로그아웃</li>
		</sec:authorize>
		
		
		<sec:authorize access="hasRole('ROLE_ADMIN')"> <%/* hasRole('') 로그인 세션정보가 있고, ROLE(권한) 정보가 ADMIN이면 보여라  */ %>
			<li>관리자</li>
		</sec:authorize>
		
		<sec:authorize access="hasRole('user')"> <%/* hasRole('') 로그인 세션정보가 있고, ROLE(권한) 정보가 USER이면 보여라  */ %>
			<li>유저</li>
		</sec:authorize>
		
		<sec:authorize access="hasRole('guest')"> <%/* hasRole('') 로그인 세션정보가 있고, ROLE(권한) 정보가 ADMIN이면 보여라  */ %>
			<li>게스트</li>
		</sec:authorize>
		
	</ul>
</nav>