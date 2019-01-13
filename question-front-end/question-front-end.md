# question-front-end
some questions and codes for front-end.

#### 1. XMLHttpRequest有哪些通用属性和方法？
readystate：表示请求状态的整数<br>
&emsp;UNSET(0)：对象已创建；<br>
&emsp;OPENED(1)：open()成功调用，在这个状态下可以为xhr设置请求头，或者使用send()发送请求；<br>
&emsp;HEADERS_RECEIVED(2)：所有重定向已自动完成访问，并且最终响应的HTTP头已经收到；<br>
&emsp;LOADING(3)：响应体正在接收；<br>
&emsp;DONE(4)：数据传输完成或者传输发生错误。<br>
onreadystatechange：readystate改变时调用的函数<br>
Status：服务器返回的HTTP状态码，如200、404<br>
statusText：服务器返回的HTTP状态信息，如OK、No Content<br>
responseText：来自服务器的字符串形式的完整响应<br>
responseXML：Document对象，表示服务器的响应解析成的XML文档<br>
abort()：取消异步HTTP请求<br>
getAllResponseHesders()：返回一个字符串，包含响应中服务器发送的所有HTTP报头，每个报头都是用冒号分割的键值对，用换行符分割报头行<br>
open(method, url, asynchronous [, user, passwod])：初始化准备发送到服务器上的请求，asynchronous表示请求是否异步<br>
setRequestHeader(name, value)：设置HTTP报头<br>
send(body)：对服务器请求进行初始化。参数body包含请求的主体部分，对于POST请求为键值对字符串，对于GET请求为null<br>

#### 2. sessionStorage、localStorage和cookie的区别？
(1) 都会在浏览器保存，有大小限制，同源限制<br>
(2) cookie在请求时发送到服务器，作为会话的标志，服务器可修改cookie；storage不会发送到服务器<br>
(3) cookie有path概念，子路径可以访问父路径cookie，父路径不能访问子路径cookie<br>
(4) 有效期：cookie在设置的有效期内有效，默认为浏览器关闭，可以通过max-age设置有效期；sessionStorage在窗口关闭前有效，localStorage长期有效，直到用户删除<br>
(5) 共享：sessionStorage不能共享，localStorage在同源文档间共享，cookie在同源且符合path规则的文档间共享<br>
(6) localStorage的修改会触发其他窗口的update事件<br>
(7) cookie有secure属性要求HTTPS传输<br>
(8) 浏览器不能保存超过300个cookie，单个服务器不能超过20个，每个cookie不能超过4K；storage大小能达到5M

#### 3. JavaScript的数据类型？
六种基本数据类型：undefined、null、boolean、number、string、symbol(ES6)<br>
一种引用类型：Object

#### 4. 什么是闭包？有什么用？
闭包是在某个作用域内定义的函数，它可以访问这个作用域内的所有变量。<br>
闭包作用域链通常包括三个部分：<br>
(1) 函数本身作用域<br>
(2) 闭包定义时的作用域<br>
(3) 全局作用域<br>

闭包常见用途：<br>
(1) 创建特权方法用于访问控制<br>
(2) 事件处理程序及回调

#### 5. JavaScript定义函数的方法？
(1) 函数声明表达式<br>
(2) function操作符<br>
(3) Function构造函数<br>
(4) ES6：arrow function

#### 6. JavaScript定义对象的方法？
(1) 对象字面量：var obj = {};<br>
(2) 构造函数：var obj = new Object();<br>
(3) Object.create()方法：var obj = Object.create(Object.prototype);

#### 7. ===和==运算符判断相等的流程？
(1) 不是相同类型，则不等<br>
(2) 都是null或者undefined，则相等<br>
(3) 都是bool类型true或false，则相等<br>
(4) 其中一个是NaN，则不等<br>
(5) 都是数值类型且值相等，则相等。-0等于0<br>
(6) 都是字符串且在相同的位置包含相同的16位值？？？，则相等；如果长度或者内容不等，则不相等；两个字符串显示结果相同但编码不同，==和===都是不相等<br>
(7) 指向相同的对象、数组、函数，则相等；指向不同对象，则不相等<br>

==操作符的判断流程：<br>
(1) 如果类型相同，则按照===的方法比较<br>
(2) 类型不同，则按照以下流程判断<br>
(3) 一个是null，一个是undefined，则相等<br>
(4) 一个是数字一个是字符串，则将字符串转化成数字比较<br>
(5) 如果有bool类型，将true转化为1，false转化为0<br>
(6) 一个是对象一个是数字或字符串，将对象转化为原始值？？？<br>
(7) 其他情况为不相等

#### 8. 对象如何转化为字符串、数字？
对象转化为字符串：<br>
(1) 如果对象有toString()方法，则调用，如果返回一个原始值（bool, number, string），则将这个值转化为字符串作为结果<br>
(2) 如果没有toString()方法或者返回不是原始值，找valueOf()方法，调用结果是原始值则转化为字符串作为结果<br>
(3) 不能从toString()或者valueOf()方法获得一个原始值，throws a TypeError<br>

对象转化为数字：<br>
(1) 如果有valueOf()方法且返回原始值，则将原始值转化为数字作为结果<br>
(2) 如果有toString()方法且返回原始值，则将原始值转化为数字作为结果<br>
(3) 否则，throws a TypeError

#### 9. DOM事件模型？
DOM事件包括捕获（capture）和冒泡（bubble）两个阶段。<br>
捕获阶段事件从window开始触发事件然后通过祖先节点一次传递到发生事件的DOM元素上。<br>
冒泡阶段事件从初始元素依次向祖先节点传递直到window。

#### 10.JavaScript实现继承的三种方法？
function Shape() {}<br>
function Rect() {}<br>
// 方法1<br>
Rect.prototype = new Shape();<br>
// 方法2<br>
Rect.prototype = Shape.prototype;<br>
// 方法3<br>
Rect.prototype = Object.create(Shape.prototype);

方法1：<br>
(1) 优点：正确设置原型链实现继承<br>
(2) 优点：父类实例属性得到继承，原型链查找效率高，能为一些属性提供合理的默认值<br>
(3) 缺点：父类实例属性为实例类型时，不恰当的修改会导致所有子类被修改<br>
(4) 缺点：创建父类实例作为子类原型时，可能无法确定构造函数需要的合理参数，这样提供的参数继承给子类没有实际作用，当子类需要这些参数时应该在构造函数中设置和初始化。<br>
(5) 总结：继承应该是继承方法而不是属性，为子类设置父类实例应该是通过在子类构造函数中调用父类构造函数进行设置和初始化。

方法2：<br>
(1) 优点：正确设置原型链实现继承<br>
(2) 缺点：父类构造函数原型和子类相同，修改子类原型添加方法会修改父类<br>

方法3：<br>
(1) 优点：正确设置原型链且避免1和2中的问题<br>
(2) 缺点：ES5方法需要注意兼容性<br>

改进：<br>
(1) 三种方法都应该在子类构造函数中调用父类构造函数实现实例属性初始化
```
function Rect() {
Shape.call(this);
}
```
(2) 用新创建的对象代替子类默认原型，设置Rect.prototype.constructor = Rect;保持一致性<br>
(3) 第三种方法的polyfill：
```
funcion create(obj) {
    if (Object.create) {
        return Object.create(obj);
    }
    function f() {}
    f.prototype = obj;
    return new f();
}
```

#### 11. 什么是polyfill？？

#### 12. 延时循环输出0 1 2 3 4，以下代码是否正确？
```
for (var i = 0; i < 5; i++) {
    setTimeout(function() {
        console.log(i);
    }, 100);
}
```
不正确，循环中setTimeout接收的参数是通过闭包访问变量i，JavaScript运行的环境为单线程，setTimeout注册的函数需要等到线程空闲才能运行，这时循环已经结束，i的值为5。<br>
应该将setTimeout放在函数立即调用表达式中，将i作为参数传递给包裹函数，创建新闭包。
```
for (var i = 0; i < 5; i++) {
	(function(i) {
		setTimeout(function() {
			console.log(i);
		}, 100);
	}(i))
}
```

#### 13.实现JavaScript深度克隆函数？code

#### 14.如何判断一个对象是否是数组？code
如果运行环境（浏览器）支持，可以直接用Array.isArray(obj)判断，否则用以下函数判断：
```
function isArray(val) {
	if (typeof val === 'object') {
		return Object.prototype.toString.call(val) === '[object Array]';
	} else {
		return false;
	}
}
```

#### 15. 如何判断一个对象是否是函数？code
先判断运行环境对可调用对象（比如正则表达式）的typeof是否返回function
```
function isFunction(val) {
	if (val) {
		if (typeof (/./) === 'function') {
			return Object.prototype.toString.call(val) === '[object Function]';
		} else {
			return typeof val === 'function';
		}
	}
	return false;
}
```

#### 16. TypeScript和JavaScript的区别？
aaa

#### 17. let和var的区别？
var声明的变量，作用域为语句所在的函数内，且存在变量提升现象。<br>
let声明的变量，作用域为语句所在的代码块内，不存在变量提升。<br>
let不允许重复声明。

#### 18. 数组去重的多种方法？code
(1) 利用Set<br>
(2) 遍历，添加到新数组，用indexOf()判断<br>
(3) 遍历，添加到一个对象的属性，对象的属性名不能重复，用Object.keys(对象)

#### 19. 如何判断两个对象是否相等？
转换为JSON字符串。<br>
JSON.stringify(obj1) == JSON.stringify(obj2);

#### 20. WeakMap和Map的区别？
WeakMap只接受对象作为键名，而且键名所指向的对象，不计入垃圾回收机制。<br>
WeakMap的好处是可以避免内存泄露，一个仅被WeakMap作为key引用的对象，会被垃圾回收。<br>
WeakMap拥有和Map类似的get、set、delete、has方法，没有与迭代有关的属性或方法。？？？

#### 21. 浏览器渲染页面的运行机制？
(1) 构建DOM树（parse）：渲染引擎解析HTML文档，将标签替换成DOM树中的DOM Node（包括js生成的标签），生成内容树（Content Tree/Dom Tree）。<br>
(2) 构建渲染树（construct）：解析CSS文件样式，以及HTML中可见的指令（如<b></b>），构建渲染树（Rendering Tree/Frame Tree）。<br>
(3) 布局渲染树（reflow/layout）：从根节点递归调用，计算每一个元素的大小、位置，给出每个节点在屏幕的精确位置。<br>
(4) 绘制渲染树（paint/repaint）：遍历渲染树，使用UI后端层（？？？）来绘制每个节点。

#### 22. 重绘和重排？触发的条件？如何优化？
&emsp;&emsp;重绘（repaint/redraw）：当元素的位置、大小、颜色等属性都确定后，浏览器便将这些元素绘制一遍，将内容呈现在页面上。重绘是指一个元素外观的改变触发的浏览器行为，浏览器根据元素的新属性重新绘制，使元素呈现新的外观。<br>
&emsp;&emsp;重排（重构/回流/reflow）：当渲染树的一部分或全部因为元素的尺寸、布局、隐藏等需要重新构建，就称为回流。每个页面至少需要一次回流，就是在页面第一次加载的时候。<br>
&emsp;&emsp;重绘和重排的关系：在重排的时候，浏览器会使渲染树中受到影响的部分失效，并重新构造，完成回流后，重新绘制受影响的部分，即重绘。所以，重排一定会引发重绘，重绘不一定会引发重排。<br>

触发重排的条件：<br>
(1) 页面渲染初始化<br>
(2) 添加或删除可见的DOM元素<br>
(3) 元素位置的改变，或使用动画<br>
(4) 元素尺寸的变化--大小、外边距、边框<br>
(5) 浏览器窗口尺寸的变化（resize事件）<br>
(6) 填充内容的变化（文本的改变或图片大小的变化引起宽度或高度的变化）<br>
(7) 读取某些元素属性<br>

重排和重绘的优化：<br>
(1) 浏览器自身的优化：维护一个队列，将重排、重绘引起的操作放在队列中，数量达到一定值或时间间隔，flush队列，进行批处理，将多次回流重绘合并成一次。<br>
(2) 直接改变元素的className？？？<br>
(3) 使用cloneNode和replaceNode，只引发一次回流和重绘。<br>
(4) 将需要多次重排的元素的position设置为absolute或fixed，元素脱离的文档流，它的变化不会影响其他元素。<br>
(5) 如果需要创建多个DOM节点，可以使用DocumentFragment创建完成后一次性加入document。<br>
(6) 尽量不使用table布局

#### 23. 浏览器缓存？
浏览器缓存分为强缓存和协商缓存。<br>
客户端请求某个资源时，获取缓存的流程如下：<br>
(1) 根据资源的http header判断是否能命中强缓存，命中则从本地获取缓存，不会发送请求到服务端。<br>
(2) 强缓存没有命中，则发送请求到服务端。服务端根据request header判断是否命中协商缓存，称为http再验证，命中则返回请求，但不返回资源，告知客户端从缓存获取。<br>
(3) 强缓存和协商缓存的共同之处：如果命中，服务端不会返回资源<br>
(4) CTRL+F5强制刷新，直接从服务端加载，跳过强缓存和协商缓存。<br>
(5) F5刷新，跳过强缓存，但还是会检查协商缓存。<br>

强缓存：<br>
Expires（HTTP 1.0的规范，绝对时间，表示缓存资源过期时间）<br>
Cache-Control:max-age（HTTP 1.1规范，max-age表示缓存的最大生命周期，单位秒）

协商缓存：<br>
Last-Modified（资源最后更新时间，在服务端response中返回）<br>
If-Modified-Since（通过比较两个时间来判断资源在两次请求间是否发生变化，没有则命中）<br>
ETag（资源的唯一标识，在服务端response中返回）<br>
If-None-Match（比较If-None-Match与当前资源的ETag是否一致来判断资源在两次请求间是否发生修改，没有则命中）

#### 24. 什么版本的浏览器支持Array.indexOf()函数？如何兼容所有浏览器？code
IE9+、Firefox 2+、Safari 3+、Opera 9.5+和Chrome

#### 25. 事件委托（事件代理）？事件注册？code
&emsp;&emsp;事件委托是利用事件冒泡，只指定一个事件处理程序，就可以管理某一类型的所有事件。事件从最深的节点开始，逐步向上传播事件，比如有节点树div>ul>li>a，给a添加click事件，该事件会逐层向外执行，可以只给最上面的div添加点击事件，通过冒泡触发，即委托父级代为执行事件。<br>
&emsp;&emsp;在父级节点的事件中通过事件event的target获取到事件的目标节点，即事件源。

#### 26. 原型和原型链？
prototype是一个显式原型属性，只有函数才有该属性。声明一个函数的时候，这个属性就自动创建了。function foo() {}<br>
\__proto__是每个对象都有的隐式原型属性，指向了创建该对象的构造函数的原型。使用new操作符时，生成的实例对象就有了\__proto__属性。<br>
《深度解析原型中的各个难点 - 掘金》

#### 27. 什么是跨域问题？有哪些解决办法？
浏览器为了安全实施的同源策略导致的，限制了不同源的脚本、document。同源是指两个URL的协议、域名、端口完全相同。<br>
script标签的jsonp跨域、Nginx反向代理、node.js中间件代理、后端在头部信息设置安全域名、后端在服务器上设置cors。

#### 28. 如何判断一个变量是对象还是数组？code
Object.prototype.toString.call()兼容性最好。<br>
不能用typeof，两种类型都会返回object。

#### 29. 定时器的执行机制或顺序？code
&emsp;&emsp;JavaScript是单线程的，浏览器遇到setTimeout或setInterval会先执行完当前的代码块，在此之前会把定时器推入浏览器的待执行事件队列中，等浏览器执行完当前代码块再查看队列中是否有任务，有的话才执行定时器的代码。<br>
&emsp;&emsp;即使把定时器的时间设置为0还是会先执行当前的代码。

#### 30.ES5和ES6的继承有什么区别？
&emsp;&emsp;ES5的继承通过prototype或构造函数机制实现。ES5的继承实际上是先创建子类的实例对象，然后再将父类的方法添加到this上。Parent.apply(this);<br>
&emsp;&emsp;ES6的继承机制完全不同，实际上是先创建父类的实例对象this（所以必须先调用父类的super方法），然后再用子类的构造函数修改this。<br>
&emsp;&emsp;ES6通过class关键字定义类，里面有构造方法，类之间通过extends关键字实现继承。子类必须在constructor方法中调用super，否则创建实例报错。子类没有自己的this对象，继承了父类的this对象，然后对其进行加工，所以不调用super的话子类就得不到this对象。<br>
&emsp;&emsp;Super关键字指代父类的实例，即父类的this对象。

#### 31. 使用typeof obj === “object”判断一个变量是否是对象，有什么潜在的缺陷？code
JavaScript中null也是一个对象，需要先判断变量是否等于null

#### 32. 使用严格模式use strict有什么好处？
是一种在运行时自动执行更严格的JavaScript代码解析和错误处理的方法。
(1) 使调试更加容易<br>
(2) 防止意外全局<br>
(3) 消除隐藏威胁<br>
没有使用严格模式时，对null或undefined值的引用会自动强制到全局，可能会导致许多headfakes和pull-out-your-hear类型的错误。在严格模式下，引用null或undefined的值会引发错误。<br>
(4) 不允许重复的参数值<br>
function foo(val1, val2, val1) {}会引发错误。<br>
(5) 使eval()更加安全<br>
(6) 抛出无效的使用错误的删除符<br>
删除操作符不能用于对象的不可配置属性，非严格代码会自动失败，严格模式下会引发错误。

#### 33. NaN是什么？它的类型是什么？如何可靠的判断一个值是否是NaN？code
NaN表示不是数字的值，但它的类型是数字：<br>
typeof NaN === ‘number’; // true<br>
使用ES6提供的Number.isNaN()函数判断。

#### 34. 如何判断一个字符串是否是回文？code
str === str.split(‘’).reverse().join(‘’);

#### 35. 使用计时器解决递归过多堆栈溢出的问题？code
计时器中的递归函数调用被推送到事件队列，并且退出函数，从而使调用堆栈清零。

#### 36. JavaScript的任务队列？Event Loop事件循环？
&emsp;&emsp;JavaScript是单线程的，意味着所有任务都需要排队，如果前一个任务耗时很长，后一个任务会一直等待，所以把任务分为同步任务和异步任务。<br>
&emsp;&emsp;同步任务在主线程排队，前一个执行完才能执行后一个；异步任务不进入主线程，而进入任务队列，任务队列通知主线程某个异步任务可以执行了，该任务才会进入主线程执行。<br>
&emsp;&emsp;主线程从任务队列中读取事件的过程是不断循环的，所以这种运行机制又叫做Event Loop（事件循环）。

#### 37. 哪些任务会放入任务队列中？
(1) setTimeout和setInterval<br>
(2) DOM事件<br>
(3) ES6的Promise<br>
(4) Ajax异步请求

#### 38. JavaScript的this原理？code
在函数中使用this关键字的时候，this指向的是函数运行时所在的环境。<br>
哪个对象调用函数，函数里面的this就指向哪个对象。

#### 39. JavaScript中的new做了什么事情？
(1) 创建一个新对象<br>
(2) 将构造函数的作用域赋给新对象（this指向了这个新对象）<br>
(3) 执行构造函数中的代码（为新对象添加属性）<br>
(4) 返回新对象

#### 40. Javascript是否支持面向对象？
是。































#### 100
