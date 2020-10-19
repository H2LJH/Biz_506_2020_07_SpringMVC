<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script>
	document.addEventListener("DOMContentLoaded", ()=>
	{
		document.querySelector("#bbs-write").addEventListener("click", ()=>
		{
			document.location.href="${rootPath}/bbs/bbs/write"	
		})
	})
</script>

<table class="table table-striped table-bordered table-hover">
	<thead>
		<tr>
			<th>NO</th>
			<th>작성일자</th>
			<th>작성시각</th>
			<th>작성자</th>
			<th>제목</th>
			<th>조회수</th>
		</tr>
	</thead>
	
	<tbody>
	<c:if test="${empty BBS_LIST}">
		<tr><td colspan="6">데이터가 없습니다.</td></tr>
	</c:if>
	<c:forEach items="${BBS_LIST}" var="vo" varStatus="i">
		<tr>
			<td>${i.count}</td>
			<td>${vo.b_date}</td>
			<td>${vo.b_time}</td>
			<td>${vo.b_writer}</td>
			<td>${vo.b_subject}</td>
			<td>${vo.b_count}</td>
		</tr>
	</c:forEach>	
	</tbody>
	
</table>
<button id="bbs-write">글쓰기</button>