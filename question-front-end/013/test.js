
function deepClone(obj) {
	var _toString = Object.prototype.toString;

	// null, undefined, non-object, function
	if (!obj || typeof obj !== 'object') {
		return obj;
	}

	// DOM node DOM元素
	if (obj.nodeType && 'cloneNode' in obj) {
		return obj.cloneNode(true);
	}

	// Date 日期
	if (_toString.call(obj) === '[object Date]') {
		return new Date(obj.getTime());
	}

	// RegExp 正则表达式
	if (_toString.call(obj) === '[object RegExp]') {
		var flags = [];
		if (obj.global) {
			flags.push('g');
		}
		if (obj.multiline) {
			flags.push('m');
		}
		if (obj.ignoreCase) {
			flags.push('i');
		}
		return new RegExp(obj.source, flags.join(' '));
	}

	// Array 数组
	var result = Array.isArray(obj)? []: obj.constructor? new obj.constructor(): {};

	// Object
	for (var key in obj) {
		result[key] = deepClone(obj[key]);
	}

	return result;
}

// test
var a = {
	name: 'jack',
	birth: new Date(),
	pattern: /jack/tom,
	container: document.body,
	hobbys: ['book', new Date(), /aaa/bbb, 1]
};

function A() {
	this.a = a;
}

var b = new A();
var c = deepClone(b);
console.log(b.a === c.a);
console.log(b, c);