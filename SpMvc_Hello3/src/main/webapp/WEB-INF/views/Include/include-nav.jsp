<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" pageEncoding="UTF-8"%>

<style>
	#header
	{
		background-color : green;
		color : white;
		padding : 1.5rem;
		text-align : center;
	}
	
	#nav
	{
		background-color : blue;
	}
	
	ul
	{ 
		margin : 0 
	}
	
	li
	{ 
		display : inline-block;
		padding : 5px;
		background-color : blue;
		color : white; 
		cursor : pointer;
	}
	
	li:hover
	{
		background-color : teal;
		color : white;
	}
	
	a
	{
		color : white;
		text-decoration: none;
	}
	
</style>

	<div id = "header">
		<h3>반갑습니다</h3>
		<p>나의 Spring MVC Project V1</p> 
	</div>
	
	<div id="nav">
		<ul>
			<li><a href = 'http://localhost:8080/hello/'>Home</a></li>
			<li><a href = 'home2'>나의 집</a></li>
			<li><a href = 'home3'>너의 집</a></li>
			<li><a href = 'home4'>우리 집</a></li>
			<li><a href = 'home5'>친구 집</a></li>
		</ul>
	</div>

