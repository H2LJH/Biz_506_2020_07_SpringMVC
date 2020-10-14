<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value='${pageContext.request.contextPath}' />

<style>
    section{
        width: 50%;
        height: 80%;
        position: absolute;
        top: 50%;
        left: 50%;
        transform: translate(-50%,-50%);
        border: 1px solid blue;
        border-radius: 6px;

        display: flex;
		justify-content: center;
		align-items: center;
		flex-direction: column;

    }
	section *{
        text-align: center;
        width: 99%;
        margin: 3px auto;

	}

    #user_login_header{
        border: 1px solid red;
    }
    
    #login_fail{
    	margin: 5px auto;
    	background-color: red;
    	color: white;
    }

   form button{
        margin-top: 10px;
        width: 62%;
        background-color: #3EB489;
    }

</style>

	<section>
	<div id="user_login_header">
		<h2>로그인</h2>
		<c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
		<h4 id="login_fail">${SPRING_SECURITY_LAST_EXCEPTION.message}</h4>
		<c:remove var="SPRING_SECURITY_LAST_EXCEPTION" scope="session"/>
		</c:if>  
	</div>
	
	<form method="POST" action="${rootPath}/login">
		<input type ="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		<input name="userID" placeholder="ID" required="1">
		<input name="userPWD" placeholder="PWD" required="1">
		<button type="submit" id="login_button">로그인</button> 
		<button type="button" id="join_button">회원가입</button>
	</form>
	<div>
        ㅁㄴㅁㄴㅇㅁㄴ
	</div>
	</section>
