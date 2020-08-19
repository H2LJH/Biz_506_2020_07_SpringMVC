# Spring Project 빛나리 쇼핑몰 V1
* 상품관리, 거래처관리, 회원가입, 로그인을 포함
* DB 오라클 
* 반응형 메뉴를 사용, 반응형 메인화면 구현

## Project 시작
* java Version 1.8로 변경
* Spring Framework 5.2.8
* lombock, logback
* views/home.jsp 삭제 후 재 생성


## DB 연동 설정(pom.xml)
* spring-jdbc
* mybatis
* mybatis-spring
* commons-dbcp2
* ojdbc6

* spring/appServlet/mybatis-context.xml 파일 생성, 작성