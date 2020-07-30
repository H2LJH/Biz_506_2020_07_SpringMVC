<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
		<%@ include file = "/WEB-INF/views/include/include-head.jspf" %>
</head>
<body>
	<%@ include file = "/WEB-INF/views/include/include-header.jspf" %>
	<%@ include file = "/WEB-INF/views/include/include-nav.jspf" %>
	
	
	<section>
		<h3>반갑습니다</h3>
		<p>나는 ${name} <br/>방문해주셔서&nbsp;반갑습니다.</p>
		<p id = "p1">
			ddddddddddddd
		<hr>
		</p>
		
		<p id = "p2">
			dddddddddd
		<hr>
		</p>
			
		<p id = "p3">
			ddddddddd
		<hr>
		</p>		
		
		<p>
			<pre> ddd </pre>
		<p/>
	</section>
	
	<section>
		<img src = "resources/imgs/Jupiter.jpg" alt = "목성 수평선" width = "100px"/>
	</section>
	
	
	<%@ include file = "/WEB-INF/views/include/include-footer.jspf" %>
</body>
</html>