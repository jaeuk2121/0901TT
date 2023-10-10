/**
 * objAry.js
 */
const mem1 = {
	name: "홍길동",
	age: 20,
	phone: '010-1111'
}
const mem2 = {
	name: "김길동",
	age: 20,
	phone: '010-2222'
}
const mem3 = {
	name: "박길동",
	age: 20,
	phone: '010-3333'
}
const members = [mem1, mem2, mem3];

let target = document.querySelector('#memberList>tbody');
//target.innerHTML='';

members.forEach(function(member = {}) {
	let tr = document.createElement('tr');
	for (let prop in member) {
		let td = document.createElement('td');
		td.innerText = member[prop];
		tr.appendChild(td);

	}
	let td = document.createElement('td');
	let btn = document.createElement('button');

	btn.addEventListener('click', function(e) {
		console.log(e); //this
		e.target.parentElement.parentElement.remove();
	})

	btn.innerText = '삭제';
	td.appendChild(btn);
	tr.appendChild(td);
	target.appendChild(tr);
})

document.querySelector('#memberList>tbody button').onclick = function(e) {
	e.target.parentElement.parentElement.remove();
}

//document.querySelectorAll('memberList > tbody > tr').forEach()
//	tr.addeventListener('mouseover',function(){		
//	})

document.querySelector('.add').addEventListener('click', function(e) {
	let name = document.querySelector('input[name=name]').value;
	let age = document.querySelector('input[name=age]').value;
	let phone = document.querySelector('input[name=phone]').value;
	const member = {
		name, age, phone
	}
addList(member);


});

function addList(member = {}) {
	let tr = document.createElement('tr');
	for (let prop in member) {
		let td = document.createElement('td');
		td.innerText = member[prop];
		tr.appendChild(td);

	}
	let td = document.createElement('td');
	let btn = document.createElement('button');

	btn.addEventListener('click', function(e) {
		console.log(e); //this
		e.target.parentElement.parentElement.remove();
	})

	btn.innerText = '삭제';
	td.appendChild(btn);
	tr.appendChild(td);
	target.appendChild(tr);
};
