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

		<div>
			<h3>댓글목록</h3>

		</div>
		<div>
			<table border="1">
				<tr>
					<th>댓글내용</th>
					<td><input type="text" name="content"></td>
				</tr>
				<tr>
					<th>작성자</th>
					<td><input type="text" name="writer"></td>
				</tr>

				<tr>
					<td colspan="2">
						<button id="addReply">댓글등록</button>
					</td>
				</tr>
			</table>
			<table border="1">
				<tbody id="replyList1">
				<tr>
				</tr>
				</tbody>
			</table>
		</div>


		<style>
body {
	font-family: Arial, Helvetica, sans-serif;
}

/* The Modal (background) */
.modal {
	display: none; /* Hidden by default */
	position: fixed; /* Stay in place */
	z-index: 1; /* Sit on top */
	padding-top: 100px; /* Location of the box */
	left: 0;
	top: 0;
	width: 100%; /* Full width */
	height: 100%; /* Full height */
	overflow: auto; /* Enable scroll if needed */
	background-color: rgb(0, 0, 0); /* Fallback color */
	background-color: rgba(0, 0, 0, 0.4); /* Black w/ opacity */
}

/* Modal Content */
.modal-content {
	background-color: #fefefe;
	margin: auto;
	padding: 20px;
	border: 1px solid #888;
	width: 80%;
}

/* The Close Button */
.close {
	color: #aaaaaa;
	float: right;
	font-size: 28px;
	font-weight: bold;
}

.close:hover, .close:focus {
	color: #000;
	text-decoration: none;
	cursor: pointer;
}
</style>
		<div id="myModal" class="modal">

			<!-- Modal content -->
			<div class="modal-content">
				<span class="close">&times;</span>
				<p>23</p>
				<p>
					<input class="content">
				</p>
				<p>
					<button id="editBtn">수정</button>
			</div>
		</div>
		<script src='js/reply.js'></script>
		<script>
	
		const rpyObj = new Reply();
		rpyObj.displayDate();

		let noticeId = "${n.noticeId}";
		
		
			const fields = [ 'replyId', 'reply', 'replyer', 'replyDate' ];
		//댓글목록
		rpyObj.replyList(noticeId, function(data) {
		
			data.forEach(function(reply) {
				let tr = makeTr(reply);
				document.querySelector('#replyList1').appendChild(tr);

			})
		});

		//댓글삭제 이벤트 핸들러
		function deleteReplyFnc(e) {
			e.target.parentElement.parentElement.getAttribute('rid');
			let rid = e.target.parentElement.parentElement.getAttribute('rid');
			rpyObj.replyRemove(rid, function(result) {
				console.log(result);
				if (result.retCode = 'Success') {
					e.target.parentElement.parentElement.remove();
				} else if (result.retCode == 'Fail') {
					alert("처리중 에러");
				} else {
					alert("잘못된 코드 반환.");
				}
			})
		}
		
		//댓글등록 이벤트.
		document.querySelector('#addReply').addEventListener('click',function (e){
			let content = document.querySelector('input[name=content]').value;
			let writer = document.querySelector('input[name=writer]').value;
			
			const r = { nid:noticeId, replyer:writer,reply:content};
			
			rpyObj.replyAdd(r, function(data){
				console.log(data);
				if (data.retCode = 'Success') {
					let tr = makeTr(data.data);
					document.querySelector('#replyList1').appendChild(tr);
					fieldInit();
				} else if (data.retCode == 'Fail') {
					alert("처리중 에러");
				} else {
					alert("잘못된 코드 반환.");
				}
			})		
			
		})

		function makeTr(reply){
			
			let tr = document.createElement('tr');
			
			tr.addEventListener('dblclick',showEditForm);
			tr.setAttribute('rid', reply.replyId);
			for ( let prop of fields) {
				let td = document.createElement('td');
				if (prop == 'replyDate') {
					td.innerText = rpyObj.displayDate(reply[prop]);
				} else {
					td.innerText = reply[prop];
				}
				tr.appendChild(td);
			}
			let td = document.createElement('td');
			let btn = document.createElement('button');
			btn.addEventListener('click', deleteReplyFnc);
			btn.innerText = '삭제';
			td.appendChild(btn);
			tr.appendChild(td);
			
			return tr;
		}
		
		function showEditForm(e){
			var modal = document.getElementById("myModal");
			modal.style.display = "block";
			
			let rid = this.getAttribute('rid');
			rpyObj.replySearch(rid, function(data){
				document.querySelector('#myModal p').innerText =rid;
				document.querySelector('#myModal input.content').value = data.reply;
			})	
		}
		
		
		function fieldInit(){
			document.querySelector('input[name=content]').value = '';
			document.querySelector('input[name=writer]').value = '';
		}
		
		
		//modal 창의 닫기 버튼 클릭 이벤트
		document.querySelector('span.close').addEventListener('click', function(){
			var modal = document.getElementById("myModal");
			modal.style.display= "none";
		})
		
		//
		window.onclick = function(event){
			var modal = document.getElementById("myModal");
			if(event.target == modal){
			modal.style.display= "none";
				
			}
		}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
	var modal = document.getElementById("myModal");
  if (event.target == modal) {
    modal.style.display = "none";
  }
}
//수정이벤트
document.querySelector('#editBtn').addEventListener('click', editReplyHandler);

function editReplyHandler(e){
	let rid = document.querySelector('#myModal p').innerText;
	let content = document.querySelector('#myModal input.content').value;
	
	const r = {rid: rid, reply: content};
	
	rpyObj.replyModify(r, function(data){
		console.log(data);	
		let oldTr = document.querySelector('tr[rid="'+rid+'"]');
		let newTr = makeTr(data.data);
		document.querySelector('#replyList1').replaceChild(newTr, oldTr);
		
		var modal = document.getElementById("myModal");
		modal.style.display = "none";
	});
}
	</script>
	</div>
</body>
</html>