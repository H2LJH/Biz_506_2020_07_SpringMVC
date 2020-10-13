<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<c:set var="rootPath" value = '${pageContext.request.contextPath}'/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name='viewport' content='width=device-width, initial-scale=1'>
<title>나의 홈페이지</title>
</head>
<body>
		<form:form modelAttribute="memberVO" method="post" >
			<form:input path="userid"/>
			<form:input path="userpassword"/>
			<form:button>로그인</form:button>
			<button type="button">회원가입</button>
		</form:form>
</body>
</html>