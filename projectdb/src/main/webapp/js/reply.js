

//script src = 'js/reply.js>   <<noticeselect.jsp에
console.log('js/reply.js');
class Reply {
	showInfo() {
		console.log('ss');
	}









	//목록조회기능
	replyList(noticeId, callback, errorcall) {
		//	let xhttp = new XMLHttpRequest();
		//	xhttp.open('get', 'ajaxreplylist.do?nid=' + noticeId);
		//	xhttp.send();
		//	xhttp.onload = function(e) {
		//		let data = JSON.parse(xhttp.responseText);
		//		callback(data);}
		fetch('ajaxreplylist.do?nid=' + noticeId)
			.then(resolve => resolve.json())
			.then(result => callback(result))
			.catch(console.log);
	}


	displayDate(millis) {
		let today = new Date(millis);
		let yyyy = today.getFullYear();
		let mm = ('0' + (today.getMonth() + 1)).slice(-2);
		let dd = ('0' + today.getDay()).slice(-2);
		let hh = ('0' + today.getHours()).slice(-2);
		let mi = ('0' + today.getMinutes()).slice(-2);
		let ss = ('0' + today.getSeconds()).slice(-2);

		return yyyy + "-" + mm + "-" + dd + " " + hh + "-" + mi + "-" + ss;
	}

	//댓글삭제
	replyRemove(replyId, callback, errorcall) {
		//	let xhttp = new XMLHttpRequest();
		//	xhttp.open('get', 'ajaxreplydelete.do?rid=' + replyId);
		//	xhttp.send();
		//	xhttp.onload = function(e) {
		//		let data = JSON.parse(xhttp.responseText);
		//		callback(data);
		fetch('ajaxreplydelete.do?rid=' + replyId)
			.then(resolve => resolve.json())
			.then(result => callback(result))
			.catch(console.log);
	}


	//댓글등록기능     =======post알아보기 get
	replyAdd(reply = { nid: 1, replyer: 'user1', reply: 'test' }, callback) {
		//	let xhttp = new XMLHttpRequest();
		//	xhttp.open('post', 'ajaxreplyadd.do');
		//	xhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
		//	xhttp.send('nid=' + reply.nid + '&content=' + reply.reply + '&writer=' + reply.replyer);
		//	xhttp.onload = function(e) {
		//		let data = JSON.parse(xhttp.responseText);
		//		callback(data);

		fetch('ajaxreplyadd.do', {
			method: "POST",
			headers: {
				'Content-Type': 'application/x-www-form-urlencoded',
			},
			body: 'nid=' + reply.nid + '&content=' + reply.reply + '&writer=' + reply.replyer
		})
			.then(resolve => resolve.json())
			.then(result => callback(result))
			.catch(console.log);
	}

	//댓글조회기능
	replySearch(replyId, callback) {
		//	let xhttp = new XMLHttpRequest();
		//	xhttp.open('get', 'ajaxreplysearch.do?rid=' + replyId);
		//	xhttp.send();
		//	xhttp.onload = function(e) {
		//		let data = JSON.parse(xhttp.responseText);
		//		callback(data);

		fetch('ajaxreplysearch.do?rid=' + replyId)
			.then(resolve => resolve.json())
			.then(result => callback(result))
			.catch(console.log);
	}
	//댓글수정기능
	replyModify(reply = { rid: 10, reply: "변경값입니다..." }, callback) {
		//let xhttp = new XMLHttpRequest();
		//xhttp.open('post', 'ajaxreplymdodify.do?rid=');
		//xhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
		//xhttp.send('rid=' + reply.rid + "&content=" + reply.reply);
		//xhttp.onload = function(e) {
		//	let data = JSON.parse(xhttp.responseText);
		//	callback(data);
		fetch('ajaxreplymodify.do', {
			method: "POST",
			headers: {
				'Content-Type': 'application/x-www-form-urlencoded',
			},
			body: 'rid=' + reply.rid + '&content=' + reply.reply
		})
			.then(resolve => resolve.json())
			.then(result => callback(result))
			.catch(console.log);
	}
}
