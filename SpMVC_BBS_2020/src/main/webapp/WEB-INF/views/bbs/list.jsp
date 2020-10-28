<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value='${pageContext.request.contextPath}' />

<script>
	document.addEventListener("DOMContentLoaded", ()=>
	{
		document.querySelector("#bbs-write").addEventListener("click", ()=>
		{
			document.location.href="${rootPath}/bbs/write"	
		})
		
		/*
			tag와 tag들이 서로 감싸는 관계로 layout이 만들어져 있을때
			tag들에 click event 핸들링이 설정되어 있으면 어떤 특정 tag를
			click  했을때 원하지 않는 event가 발생하는 경우가 있다.
			이러한 현상을 이벤트 버블링 이라고 한다.
			tag box의 가장 중간부분에 있는 tag를 클릭하면 안쪽부터 바깥쪽으로
			계속해서 이벤트가 전해지는 현상
		*/
/* 		document.querySelector("table").addEventListener("click", function(event)
        {
            let tag_name = event.target.tagName;
            if(tag_name === "TD")
            {
                let seq = event.target.dataset.seq;
                if(seq)
                	document.location.href = "${rootPath}/bbs/detail/" + seq;
            }
        }) */
        
	    
	    let tr_list = document.getElementsByClassName("tr_list");
           for(let i=0; i < tr_list.length; ++i)
           {
           		tr_list[i].onclick = () =>
                {
               		 let seq = tr_list[i].dataset.seq;
               		 document.location.href = "${rootPath}/bbs/detail/" + seq;
                }
           }
	})
</script>
<style>
	.tr_list{
		cursor:pointer;
	}
	.tr_list:hover{
		background-color: #ccc;
	}
</style>
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
		<tr data-seq="${vo.b_seq}" class="tr_list">
			<td>${i.count}</td>
			<td>${vo.b_date}</td>
			<td>${vo.b_time}</td>
			<td>${vo.b_writer}</td>
			<td>
				${vo.b_subject}
				<img src="${rootPath}/upload/${vo.b_file}" width="50px">				
			</td>
			<td>${vo.b_count}</td>
		</tr>
	</c:forEach>	
	</tbody>
	
</table>
<button id="bbs-write">글쓰기</button>