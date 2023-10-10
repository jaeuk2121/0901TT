<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<jsp:include page="../menu/menu.jsp" />
		</div>
		<div>
			<div align=center>
				<h1>로 그 인</h1>
			</div>
			<div align=center>
				<form id="frm" action="memberlogin.do" method="post">
					<div>
						<table border="1">
							<tr>
								<th width="150">아이디</th>
								<td width="200"><input type="text" id="memberId"
									name="memberId" required="required"></td>
							<tr>
								<th>패스워드</th>
								<td><input type="password" id="memberPassword"
									name="memberPassword" required="required"></td>
						</table>
					</div>
					<br>
					<div>
						
						<input type="submit" value="로그인">&nbsp;&nbsp; 
						<input type="reset" value="취소">
					</div>
				</form>
			</div>

		</div>
</body>
</html>