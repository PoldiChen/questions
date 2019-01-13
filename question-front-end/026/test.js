
function foo() {}

console.log(foo.prototype); // foo {}
console.log(foo.__proto__); // [Function]

foo.prototype = { a: 1 };

console.log(foo.prototype); // { a: 1 }