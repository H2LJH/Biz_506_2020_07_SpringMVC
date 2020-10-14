<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value='${pageContext.request.contextPath}' />

<form>
	<fieldset>
		<legend>
			<input placeholder="User ID">
			<input placeholder="Password">
			<button>가입 신청</button>
		</legend>
	</fieldset>
</form>