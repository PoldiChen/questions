/**
	实现Rect继承Shape的三种方法
**/

function Shape() {}

function Rect() {}

Rect.prototype = new Shape();

Rect.prototype = Shape.prototype;

Rect.prototype = Object.create(Shape.prototype);