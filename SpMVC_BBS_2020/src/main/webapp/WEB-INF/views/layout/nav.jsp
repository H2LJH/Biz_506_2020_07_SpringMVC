<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<c:set var="rootPath" value='${pageContext.request.contextPath}' />
<script>
	document.addEventListener("DOMContentLoaded", ()=>
	{
		
		document.querySelector("#nav-home").addEventListener("click", () =>
		{
			document.location.href="${rootPath}/";
		})
		
		document.querySelector("#nav-bbs").addEventListener("click", ()=>
		{
				document.location.href="${rootPath}/bbs/list";
		})
	})
</script>


<nav>
	<ul>
		<li id="nav-home">Home</li>
		<li id="nav-bbs">자유게시판</li>
	</ul>
</nav>