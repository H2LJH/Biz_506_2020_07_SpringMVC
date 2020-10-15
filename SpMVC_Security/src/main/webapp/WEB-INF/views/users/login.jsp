<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<style>
  #login_section{
        width: 20%;
        height: 35%;
		background-color: #191919;
		border: 2px solid orange;

        position: absolute;
        top: 50%;
        left: 50%;
        transform: translate(-50%,-50%);

        display: flex;
		justify-content: center;
		align-items: center;
		flex-direction: column;

    }
	#login_section *{
        text-align: center;
        width: 85%;
        margin: 3px auto;
        color: white;

	}

    #user_login_header{
    	height: 50%;
        width: 100%;
    }

    #login_fail{
    	background-color: red;
    }

    #login_section input{
        background-color:transparent;
        border: 1px solid whitesmoke;
    }

   #login_section button{
        margin-top: 10px;
        border: 1px solid whitesmoke;
        background-color: transparent;
    }

    #login_section input:hover, #login_section button:hover{
        border: 1px solid orange;
        color: orange;
    }

</style>

	<section id="login_section">
		<div id="user_login_header">
			<h2>LogIn</h2>
			<c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
			<h4 id="login_fail">${SPRING_SECURITY_LAST_EXCEPTION.message}</h4>
			<c:remove var="SPRING_SECURITY_LAST_EXCEPTION" scope="session"/>
			</c:if>  
		</div>
	
		<form method="POST" action="${rootPath}/login">
			<input type ="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
			<input name="username" placeholder="ID" required="1">
			<input name="password" placeholder="PWD" required="1">
			<button type="submit" id="login_button">로그인</button> 
			<button type="button" id="join_button">회원가입</button>
		</form>
	</section>