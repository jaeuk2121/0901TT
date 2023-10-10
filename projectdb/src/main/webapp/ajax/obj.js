/**
 * obj.js
 */
let name = "Hong"
let age = 20;
let obj = {
	name,
	age,
	phone: '010-1111-1111',
	showinfo: function(){
		return this.name+","+this.age;
	}
}
console.log(obj.name);
console.log(obj.age);
console.log(obj['phone']);
console.log(obj.showinfo());

obj.hobbies = ['reading','eating','sleeping'];		//==hobbies[];
console.log(obj.hobbies[0]);

let yourHobbies=['운동하기','영화보기','자전거타기'];

function makeHobbies(hobbies = []){
	
	for(let i =0;i<obj.hobbies.length;i++){
		li = document.createElement('li');	//<li><li>
		txt = document.createTextNode(hobbies[i]);
		li.appendChild(txt);
		ul.appendChild(li);
		document.getElementById('myHobby').appendChild(li);
	}
}

makeHobbies(yourHobbies);

for(let prop in obj){	//prop: obj가 가지고 있는 값 수만큼 반복?
	//console.log(prop);
	console.log(`속성: ${prop}, 값: ${obj[prop]}`);
}