<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="//cdn.datatables.net/1.13.6/css/jquery.dataTables.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
<script src="//cdn.datatables.net/1.13.6/js/jquery.dataTables.min.js"></script>

</head>

<body>
	<div align="center">
		<jsp:include page="../menu/menu.jsp" />
		<div>
			<h1>게시글 상세보기</h1>
		</div>
		<div>
			<table border="1">
				<tr>
					<th width="150">작성자</th>
					<td width="150">${n.noticeName }</td>
					<th width="150">작성일자</th>
					<td width="50" align="center">${n.noticeDate }</td>
					<th width="150">조회수</th>
					<td width="50" align="center">${n.noticeHit }</td>
				</tr>
				<tr>
					<th>이미지</th>
					<td colspan="5"><img src="attech/notice/${n.noticeImage }">
					</td>
				</tr>
				<tr>
					<th>제 목</th>
					<td colspan="5">${n.noticeTitle }</td>
				</tr>
				<tr>
					<th>내 용</th>
					<td colspan="5"><textarea rows="10" cols="60">${n.noticeSubject }</textarea></td>
				</tr>
				<tr>
					<th>첨부파일</th>
					<td colspan="5">${n.noticeAttech }</td>
				</tr>
			</table>
		</div>
	</div>
	<h3>댓글등록</h3>
	<div>
		<table border="1">
			<tr>
				<th>댓글번호</th>
				<td><input type="text" name="rid"></td>
			</tr>
			<tr>
				<th>댓글내용</th>
				<td><input type="text" name="content"></td>
			</tr>
			<tr>
				<th>댓글작성자</th>
				<td><input type="text" name="writer"></td>
			</tr>
			<tr>
				<th>작성일자</th>
				<td><input type="text" name="replyDate"></td>
			</tr>
			<tr>
				<td colspan="2"><button class="addRow">추가</button></td>
			</tr>
		</table>
	</div>
	<h3>댓글목록</h3>
	<table id="example" class="display" style="width: 100%">
		<thead>
			<tr>
				<th>댓글번호</th>
				<th>댓글내용</th>
				<th>댓글작성자</th>
				<th>등록</th>
			</tr>
		</thead>
		<tfoot>
			<tr>
				<th>댓글번호</th>
				<th>댓글내용</th>
				<th>댓글작성자</th>
				<th>등록</th>
			</tr>
		</tfoot>
	</table>
	<script src="js/reply.js"></script>
	<script>
	const rep = new Reply();
		let noticeId = "${n.noticeId}";
		
		
		const table = new DataTable('#example', {
			ajax : 'ajaxreplylist.do?nid=' + noticeId + '&param=jquery',
					columns :[{
						data : 'replyId'
					},{
						data : 'reply'
					},{
					data : 'replyer'
					},{
					data : 'replyDate',
					
					render: function(data, type){
					return rep.displayDate(data);
					}
					}]
				
		});
		function addNewRow() {
		    table.row
		        .add({
		          replyId : $('input[name=rid]').val(),
		          reply :$('input[name=content]').val(),
		          replyer :$('input[name=writer]').val(),
		          replyDate :$('input[name=replyDate]').val(),
		        })
		        .draw(false);
		 
		   
		}
		 
		 
		document.querySelector('.addRow').addEventListener('click', addNewRow);
		addNewRow();
		
	</script>
</body>
</html>