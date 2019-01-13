

function isObjOrArray(value) {
	if (Object.prototype.toString.call(value) === '[object Array]') {
		console.log('Array');
	} else if (Object.prototype.toString.call(value) === '[object Object]') {
		console.log('Object');
	} else {
		console.log('neither');
	}
}

let value1 = [];
let value2 = {};
isObjOrArray(value1);
isObjOrArray(value2);

console.log(typeof value1); // object
console.log(typeof value2); // object