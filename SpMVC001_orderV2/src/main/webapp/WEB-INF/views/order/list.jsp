<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<%@ include file = "/WEB-INF/views/include/include-head.jspf" %>
	<meta charset="UTF-8">
	<meta name='viewport' content='width=device-width, initial-scale=1'>
	
	<c:set var="korea" value = "대한민국"/>
	
	<style>
		section  { margin: 10px; }
		#buttons { padding : 10px; text-align: right; }
		#order_input
		{
			background-color: blue;
			color : white;
			padding : 5px;
			border : 0;
			border-bottom: 2px solid blue;
		}
		
		/* X:hover 어떤 tag에 마우스를 올렸을때의 효과 지정 */
		#order_input:hover
		{
			background-color: gray;
			color : black;
			border-bottom: 2px solid yellow;
		}
		td a {color : black; cursor : pointer;}
	</style>
	
<title>주문서</title>
</head>
<body>
	<%@ include file = "/WEB-INF/views/include/include-header.jspf" %>
	<%@ include file = "/WEB-INF/views/include/include-nav.jspf" %>
	
	<section>
		 <table>
	            <thead>
	            	<tr>
		                <th>NO</th>
		                <th>주문번호</th>
		                <th>주문일자</th>
		                <th>고객번호</th>
		                <th>상품번호</th>
		                <th>상품이름</th>
		                <th>가격</th>
		                <th>수량</th>
		                <th>합계</th>
	                </tr>
	            </thead>
	            <tbody>
	            	<c:forEach items = "${ORDERS}" var = "vo" varStatus = "index">
	            	<tr>
			            <td>${index.count}</td>
		                <td>
		                <a href = "order?seq=${vo.o_seq}">${vo.o_num}</a>
		                </td>
		                <td>${vo.o_date}</td>
		                <td>${vo.o_cnum}</td>
		                <td>${vo.o_pcode}</td>
		                <td>상품이름</td>
		                <td>${vo.o_price}</td>
		                <td>${vo.o_qty}</td>
		                <td>${vo.o_price * vo.o_qty}</td>
	                </tr>
	                </c:forEach>
	            </tbody>
	        </table>
	</section>
	
	<hr/>
	<section id = "buttons">
		<button id = order_input>
			<a href = "input">주문서 작성</a>
		</button>
	</section>
	
	
<%@ include file = "/WEB-INF/views/include/include-footer.jspf" %>
</body>
</html>