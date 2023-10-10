/**
 * ary.js
 */
const myNumbers = [20, 30, 45, 65, 88, 22];
let sum = 0;

for(let i=0; i<myNumbers.length; i++){
	console.log(myNumbers[i]);
	sum+=myNumbers[i];
}
sum=0;
for(let num of myNumbers){
	sum += num;
}

sum=0;
myNumbers.forEach(function (elem, idx){
	console.log(`index: ${idx}, value: ${elem}`);
	sum+=elem;
});
console.log(`배열의 누적 합: ${sum}`);

let fruits = ['Apple', 'Banana', 'Cherry'];
//document.querySelector('.fruits').innerHTML = '';	//초기화
fruits.forEach(function(elem,idx){
	li = document.createElement('li');
	txt = document.createTextNode(elem);
	li.appendChild(txt);
	
	let btn = document.createElement('button');
	btn.onclick = function(){
	btn.parentElement.remove();
	}
	btn.innerText = '삭제';
	li.appendChild(btn);
	document.querySelector('.fruits').appendChild(li);
});

