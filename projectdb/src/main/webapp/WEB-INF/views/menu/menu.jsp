<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>


<style>
* {
	box-sizing: border-box;
	font-family: "맑은 고딕";
}

#container {
	width: 1000px;
	margin: 0 auto;
}

h1 {
	text-align: center;
}

h3 {
	text-align: center;
}

nav {
	background-color: black;
}

nav ul {
	height: 55px;
}

nav li {
	height: 100%;
	padding: 10px;
	list-style: none;
	display: inline-block;
}

nav a {
	vertical-align: -webkit-baseline-middle;
	text-decoration: none;
	color: white;
}

nav li:hover {
	background-color: gray;
	color: black;
}

/* nav li:last-child {
            float: right;
        } */
</style>
</head>

<body>
	<nav>
		<ul>
			<c:if test="${empty id}">
			<li><a href="memberloginform.do">로그인 메뉴</a></li>
			<li><a href="noticeselectlist.do">content</a></li>
			<li><a href="memberjoinform.do">회원가입</a></li>
			<li><a href="books.do">books</a></li>
			</c:if>
			<c:if test="${not empty id}">
			<li><a href="memberlist.do">Member</a></li>
			<li><a href="noticeselectlist.do">content</a></li>
			<li><a href="memberlogout.do">로그아웃</a></li>
			</c:if>
			<!-- <li><a href="#">로그인</a></li> -->
		</ul>
	</nav>
</body>

</html>