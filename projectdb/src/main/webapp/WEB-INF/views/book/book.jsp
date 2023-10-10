<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- jQuery -->
<script type="text/javascript"
	src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
</head>
<body>
	<div style="width: 400px; margin: 0 auto;">
		<div style="float: left;">
			<span>도서코드</span><input type="text" id="Code"><br> <span>도서명</span><input
				type="text" id="Title"><br> <span>저자</span><input
				type="text" id="Writer"><br> <span>출판사</span><input
				type="text" id="Puble"><br> <span>가격</span><input
				type="text" id="Price"><br>
		</div>
		<div style="float: right">
			<button type="button" id="save">저장</button>
			<button type="button">선택삭제</button>
		</div>
		<br>
		<table border="1" id="table">
			<tr>
				<th>체크박스</th>
				<th>도서코드</th>
				<th>도서명</th>
				<th>저자</th>
				<th>출판사</th>
				<th>가격</th>
				<th>삭제</th>
			</tr>
			 <c:forEach items="${list }" var="l"> 
			<tr>
				<td><input type="checkbox"></td>
				<td>${l.bookCode}</td>
				<td>${l.bookTitle}</td>
				<td>${l.bookWriter}</td>
				<td>${l.bookPublisher}</td>
				<td>${l.bookPrice}</td>
				<td><input type="button" value="삭제"></td>
			</tr>
			 </c:forEach> 
		</table>
	</div>
</body>
<script type="text/javascript">
$('#save').on('click', function() {
	console.log($('#Code').val());
	 
	$.ajax({
	    url : "booklist.do",
	    type : "POST",
	    data : {
	    	Code : $('#Code').val(),
	  	    Title : $('#Title').val(),
	  	    Writer : $('#Writer').val(),
	  	    Puble : $('#Puble').val(),
	  	    Price : $('#Price').val()
	    },
	    success : function() {
	    	console.log("성공");
	    	document.location.reload();
	    },
	    error : function() {
	    	console.log("실패");
	    }
	   
	})
})
</script>

</html>