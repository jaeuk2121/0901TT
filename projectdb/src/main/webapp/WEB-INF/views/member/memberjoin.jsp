<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<jsp:include page="../menu/menu.jsp" />
<body>
<div>
			<div align=center>
				<h1>회 원 가 입</h1>
			</div>
			<div align=center>
				<form id="frm" action="memberjoin.do" onsubmit="return formCheck()" method="post">
					<div>
						<table border="1">
							<tr>
								<th width="150">아이디</th>
								<td width="200"><input type="text" id="memberId" name="memberId" required="required">
									<button type="button" class="idCheck" value = "No" onclick="memberIdCheck()">중복검사</button>
									</td>
							<tr>
								<th>패스워드</th>
								<td><input type="password" id="memberPassword"
									name="memberPassword" required="required"></td>
									</tr>
							<tr>
								<th>패스워드 확인</th>
								<td><input type="password" id="checkPassword"
									name="checkPassword" required="required"></td>
							<tr>
								<th>이름</th>
								<td><input type="text" id="memberName"
									name="memberName" required="required"></td>
							<tr>
								<th>전화번호</th>
								<td><input type="tel" id="membertel"
									name="memberTel"></td>
						</table>
					</div>
					<br>
					<div>
						
						<input type="submit" value="회원가입">&nbsp;&nbsp; 
						<input type="reset" value="취소">
					</div>
				</form>
			</div>

		</div>
	<script type="text/javascript">

		function formCheck(){
			let form = document.getElementById("frm");
		
			if(form.idCheck == 'No'){
				alert("아이디 중복체크를 하세요.");
				return false;
			}
			if(form.memberPassword == form.checkPassword){
				alert("입력한 패스워드가 일치하지 않습니다.")
				form.memberPassword.value = "";
				form.checkPassword.value = "";
				form.memberPassword.focus();
				return false;
			}
			return true;
		
		}
		function memberIdCheck() { //ajax사용
			let url = "ajaxmembercheck.do";
			let payload = document.getElementById("memberId").value;
			
			url = url +"?memberId=" + payload;

			fetch(url)
			.then(response => response.text())
			.then(text => membercheck(text));
		}
	

		function membercheck(str){
			if (str =='Yes'){
				alert("사용가능한 아이디 입니다.");
				document.getElementById("idCheck").value = "Yes";
				document.getElementById("idCheck").disabled = false;
			}else{
				alert("이미 사용하는 아이디");
				document.getElementById("memberId").value = "";
				document.getElementById("memberId").focuce();
			}
		}
		
</script>
		
</body>
</html>