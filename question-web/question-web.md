# question-web
some codes and questions of web.

#### 1. cookie是否可以被覆盖？
可以。如果重复写入同名的cookie，将会覆盖之前的cookie。<br>
如果要删除某个cookie，只需新建一个同名的cookie，并将maxAge设为0，添加到response中覆盖原来的cookie。（设置为0而不是负数，负数代表其他意义）

#### 2. js发送ajax请求原生代码？code
实例化XMLHttpRequest对象<br>
设置回调函数onreadystatechange<br>
判断readyState为4，响应完成<br>
判断http状态码<br>
启动请求open<br>
设置请求头信息setRequestHeader<br>
发送请求send

#### 3. jsonp的原理？为什么说jsonp不是真正的ajax？code
&emsp;&emsp;ajax无法跨域，但script标签的src属性可以跨域。<br>
&emsp;&emsp;调用跨域服务器上动态生成的js文件，js文件中包含客户端需要的数据。<br>
&emsp;&emsp;jsonp和ajax的目的一样，都是请求一个url，对服务器返回的数据进行处理，jQueryjsonp封装为ajax的一种形式。<br>
&emsp;&emsp;jsonp和ajax本质上是不同的，ajax的核心是通过XMLHttpRequest获取非本页面的内容，而jsonp的核心是动态加载script来调用服务器提供的js脚本。

#### 4. 强缓存和协商缓存的命中和管理？
##### 浏览器和服务器的行为：<br>
&emsp;&emsp;浏览器加载资源时，先根据资源的http header判断是否命中强缓存，如果命中则直接从浏览器缓存获取，不会发送请求到服务器。<br>
&emsp;&emsp;没有命中强缓存时，浏览器会发送一个请求到服务器，服务器通过资源的http header判断是否命中协商缓存，如果命中，服务器将请求返回，状态码为304，但不返回资源数据，而是告诉浏览器可以从缓存中获取。<br>
&emsp;&emsp;协商缓存也没有命中的时候，浏览器从服务器获取资源数据。<br>

###### 强缓存：Expires和Cache-Control<br>
&emsp;&emsp;Expires：HTTP 1.0提出的表示资源过期时间的header，描述的是绝对时间，由服务器返回。<br>
&emsp;&emsp;浏览器第一次请求一个资源，服务器返回资源的同时在response的header加上Expires。<br>
&emsp;&emsp;浏览器接收后把资源和header都保存起来。<br>
&emsp;&emsp;浏览器再次请求这个资源时，先从缓存找，找到后比较Expires和当前时间，判断是否命中缓存。<br>
&emsp;&emsp;如果没有命中，则从服务器获取该资源，同时更新Expires。<br>

&emsp;&emsp;Cache-Control：Expires比较古老，它是服务器返回的绝对时间，服务器与客户端时间相差较大时缓存管理会出现问题，比如修改客户端时间，可以影响缓存命中判断。HTTP 1.1提出了一个新的header：Cache-Control，这是一个相对时间，以秒为单位，如Cache-Control:max-age=315360000，缓存命中判断过程和Expires类似。<br>
&emsp;&emsp;Expires和Cache-Control可以同时启用，Cache-Control优先级较高。

##### 协商缓存：Last-Modified、If-Modified-Since和ETag、If-None-Match两对header
&emsp;&emsp;Last-Modified和If-Modified-Since：<br>
&emsp;&emsp;浏览器第一次请求一个资源时，服务器返回资源的同时在response的header加上Last-Modified，表示资源在服务器上的最后修改时间。<br>
&emsp;&emsp;浏览器再次请求该资源时，在request的header加上If-Modified-Since，这个值就是前面服务器返回的Last-Modified。<br>
&emsp;&emsp;服务器再次接收到请求时，比较If-Modified-Since和服务器上的资源最后修改时间，如果没有变化则返回304 Not Modified，如果有变化则返回资源和新的最后修改时间Last-Modified。<br>
&emsp;&emsp;浏览器接收到304则会从缓存中获取资源。

&emsp;&emsp;ETag和If-None-Match：<br>
&emsp;&emsp;服务器资源被修改，但没有更新最后修改时间，则Last-Modified和If-Modified-Since的判断不可靠。<br>
&emsp;&emsp;浏览器第一次请求一个资源时，服务器返回资源的同时在header加上ETag，根据资源生成的一个唯一标识字符串，资源有变化则会更新，和最后更新时间没有关系。<br>
&emsp;&emsp;浏览器再次请求该资源时在request的header加上If-None-Match，值就是ETag。<br>
&emsp;&emsp;服务器再次接收到请求时判断If-None-Match和资源生成的ETag是否相同，是则表示资源没有更新，返回304，同时会返回ETag，即使是同一个值。

##### 以下行为可能改变缓存的处理方式：<br>
&emsp;&emsp;Ctrl+F5，强制刷新，跳过强缓存和协商缓存，直接从服务器获取。<br>
&emsp;&emsp;F5，跳过强缓存，但会检查协商缓存。

#### 5. 如何在response的header中禁止浏览器缓存？
Expires：-1或0，告诉浏览器不缓存资源<br>
Cache-Control: no-cache<br>
Pragma: no-cache

#### 6. js实现异步的方法？？？
&emsp;&emsp;js语言的执行环境是单线程，一次只能执行一个任务，如果有多个任务则需要排队。<br>
&emsp;&emsp;js将任务的执行分成两种模式：同步（Synchronous）和异步（Asynchronous）。异步模式：每一个任务都有一个回调函数，一个任务执行完成后，不是执行后一个任务，而是执行回调函数，后一个任务则是不等前一个任务执行完就执行。<br>
&emsp;&emsp;实现异步的方法：<br>
&emsp;&emsp;回调函数<br>
&emsp;&emsp;事件监听：采用事件驱动模式，任务的执行不取决于代码的顺序，而是取决于某个事件是否发生。<br>
&emsp;&emsp;观察者模式<br>
&emsp;&emsp;promise对象：每一个异步任务返回一个promise对象，该对象有一个then方法，允许指定回调函数。<br>

#### 7. 浏览器输入网址后到页面展示的过程？
(1) 用户输入网址<br>
&emsp;&ensp;浏览器通过DNS获取服务器的IP地址客户端先检查本地是否有对应的IP地址，没有则请求上级DNS服务器，直到找到或到根节点。<br>
&emsp;&ensp;DNS查找IP地址的顺序：浏览器缓存、系统缓存、互联网服务提供商（ISP）的DNS缓存。<br>
(2)浏览器发送HTTP请求<br>
&emsp;&ensp;HTTP请求包括请求报头和请求主体两部分。<br>
(3) 传输层TCP传输报文<br>
&emsp;&ensp;TCP通过三次握手等方法保证传输的安全可靠。<br>
(4) 网络层IP协议查询MAC地址<br>
&emsp;&ensp;IP协议的作用是把TCP分割好的各种数据包传送给接收方，需要接收方的MAC地址，即物理地址。<br>
&emsp;&ensp;IP地址和MAC地址是一一对应的关系，IP地址可以更换，但MAC地址一般固定不变。ARP协议可以将IP地址解析成对应的MAC地址。<br>
&emsp;&ensp;当通信的双方不在一个局域网时，需要多次中转才能到达最终目标，在中转的过程中需要通过下一个中转站的MAC地址来搜索下一个中转目标。
？？？<br>
(5) 数据到达数据链路层<br>
&emsp;&ensp;找到对方的MAC地址后，就将数据发送到数据链路层传输，客户端发送结束。<br>
(6) 服务器接收数据<br>
&emsp;&ensp;服务器在数据链路层接收到数据，再向上发送到应用层，其中在传输层通过TCP协议将分段的数据包重新组成原来的HTTP请求报文。<br>
(7) 服务器响应请求<br>
&emsp;&ensp;服务器接收到请求后查找请求的资源，并返回响应报文。<br>
(8) 服务器返回响应文件<br>
&emsp;&ensp;请求成功后，服务器返回相应的资源文件（HTML文件）。<br>
(9) 浏览器页面渲染<br>
&emsp;&ensp;解析HTML构建DOM树->构建渲染树->布局渲染树->绘制渲染树<br>
&emsp;&ensp;DOM树是由HTML文件中的标签排列组成，渲染树是DOM树中加入CSS或HTML中的style样式而形成。<br>
&emsp;&ensp;浏览器还没接收到完成的HTML文件时就开始渲染页面了，在遇到外部链入的脚本标签、样式标签、图片时，会再次发送HTTP请求。收到CSS文件后会对已经渲染的页面重新渲染。

#### 8. js实现跨域的方法？？？
###### 图像Ping<br>
使用<img>标签，图片加载没有跨域限制。请求数据通过字符串形式发送，而响应可以是任何内容。<br>
只能发送get请求；<br>
浏览器无法获取响应数据；<br>
只适用于浏览器和服务器之间的单向通信。<br>
##### JSONP<br>
##### 后台代理<br>
本域的后台发送同样的http请求向其他域获取数据，再返回给前台。<br>
##### 设置document.domain<br>
只适用于主域相同而子域不同。<br>
##### 使用window.name + iframe<br>
使用HTML5新方法window.postMessage(message, targetOrigin)

#### 9. redirect和forward的区别？
redirect：服务器返回一个新的url，浏览器自己去请求，地址栏显示的是新的url<br>
forward：服务器直接请求资源，把响应的内容读取回来再发送给浏览器，浏览器地址栏不变。

#### 10.iframe的使用场景？
导航栏和具体功能，实现每个功能分离<br>
加载其他网站的内容<br>
ajax上传文件<br>
上传图片时，不使用flash实现无刷新？？？<br>
跨域的时候作用中间人？？？

#### 11. webSocket的原理？Java服务端的实现？？？
HTML5提供的一种浏览器与服务器进行全双工通讯的应用层协议，基于TCP传输协议，复用了HTTP的握手通道。<br>
客户端发起协议升级请求，使用HTTP报文格式，只支持GET。<br>
持久化的协议。<br>
```
GET / HTTP/1.1
Host:  localhost:8080
Origin:  http://127.0.0.1:3000
Connection:  Upgrade                   # 需要升级协议
Upgrade:  websocket                    # 需要升级到websocket协议
Sec-WebSocket-Key:  x3JJHMbDL1EhXDw==  # 对应响应的Sec-WebSocket-Accept，防护
Sec-WebSocket-Version:  13
Sec-WebSocket-Protocol:  chat, superchat
```
服务端响应协议升级，状态码101表示切换协议。<br>
```
HTTP/1.1 101 Switching Protocols
Connection:  Upgrade
Upgrade:  websocket
Sec-WebSocket-Accept:  OyNC7bP8dTKb4PTU=
```
客户端和服务端通信的最小单位是帧，有一个或多个帧组成一条完成的消息，发送消息时将消息切割成多个帧，接收消息时将多个帧拼接成消息。
<br>
为了保持客户端和服务端的实时双向通信，需要保持TCP连接不断开，采用心跳来实现。<br>
发送方->接收方：ping<br>
接收方->发送方：pong<br>

传统的HTTP协议实现服务端实时推送的方式有ajax轮询和long poll。<br>
ajax轮询：每隔几秒就发一个请求<br>
long poll：阻塞模型，客户端发起请求后，如果没有消息，就一直不返回response。

#### 12. sessionStorage、localStorage、cookie的区别？localStorage的存储？code
项 | sessionStorage | localStorage | cookie
-|-|-|-
相同点 | / | 都是浏览器端的数据存储，同源 | /
传递 | / | / | 在同源的http请求中携带，有路径的概念，大小不超过4k
有效期 | 浏览器关闭窗口前有效 | 一直有效 | 在设置的有效期前有效
不同的浏览器窗口 | 不共享 | 共享 | 共享
事件机制 | 支持 | 支持 | 不支持

#### 13. 同源策略指的是什么？
同源是指协议、域名、端口相同。<br>
同源策略是指浏览器对不同源的脚本或文本的访问进行限制，比如源a的js不能操作源b的元素属性。<br>
限制主要为：cookie和localStorage的读取、DOM的获取、发送ajax请求。

#### 14. 为什么js是阻塞加载的？
浏览器需要一个稳定的DOM结构，而js很可能会改变DOM结构，为了防止渲染好的DOM树又被js修改，会阻塞其他js文件的下载和呈现。

#### 15. cookie的缺点？
大小和数目受限制。浏览器限制一个域的cookie数目，且一个cookie的大小不能超过4kb。<br>
存在安全性问题，易被拦截。<br>
需要指定域，不能跨域。<br>
浪费带宽，每次请求都需要带上<br>
有的移动端浏览器不支持或禁用cookie<br>
有些状态不能保持在客户端。比如为了防止表单重复提交，需要在服务端保存一个计数器，如果保存在客户端，起不到任何作用。

#### 16.常见的web攻击有哪些？
**跨站脚本攻击（XSS, Cross Site Script）**<br>
向网页中注入恶意脚本，用户访问网页时在用户浏览器执行。<br>
反射型：诱使用户点击含有恶意脚本的链接。<br>
持久型：将脚本提交到网站的数据库中，用户访问时从数据库加载到页面中执行。<br>
防范：对危险字符进行HTTP转义；使用HTTPOnly，cookie对浏览器不可见。

**分布式拒绝服务（DDOS）**

**跨站请求伪造攻击（CSRF, Cross Site Request Forgery）**<br>
通过跨站的请求，利用浏览器的cookie或服务器的session窃取用户身份，以合法	的身份进行非法的操作。<br>
防范：在表单中添加token令牌；启用验证码；检查请求头中的referer（表明请求	来自哪里）

**sql注入攻击**

#### 17. 什么是微服务？有哪些框架？

#### 18. 什么是URL重写？
URL重写是一个截取传入web请求并自动将请求重定向到其他URL的过程。<br>
URL重写的优点在于：<br>
(1) 缩短URL，隐藏实际路径提高安全性<br>
(2) 便于用户记忆和输入<br>
(3) 便于被搜索引擎收录，大部分搜索引擎对于动态页面的抓取还比较弱

Nginx、Apache、Tomcat都可以配置实现URL重写。

#### 19. 会话跟踪技术有哪些？
session<br>
cookie<br>
表单隐藏域？？？<br>
重写url？？？

#### 20. cookie和token的区别？？？

#### 21. 常用的加密算法？
对称加密：DES、AES<br>
非对称加密：RSA、DSA<br>
单向散列函数加密：MD5、SHA<br>

MD5（Message Digest Algorithm，信息摘要算法第五版），散列函数，不可逆
DES（Data Encrytion Standard，数据加密标准），对称加密，对应算法是DEA
AES（Advanced Encrytion Standard，高级加密标准），对称加密
RSA（Ron Rivest, Adi Shamir, Leonard Adleman 一起提出），非对称加密

#### 22. 什么是session钝化？
正常情况下，session是存放在服务器的内存当中的，用户较多时，服务器的开销会很大，需要把未使用到的session对象序列化到文件系统中，需要用到的时候再反序列化到内存中。

#### 23. 什么是XSS攻击和CSRF攻击？
XSS（Cross Site Script）跨站脚本，向网页中注入恶意脚本，用户浏览网页时在用户浏览器中执行。反射型：诱使用户点击含有恶意脚本的链接；持久型：将脚本提交到网站的数据库中，用户访问时从数据库加载到页面中执行。<br>
防范：<br>
(1) 对危险字符进行http转义<br>
(2) 使用HttpOnly，cookie对浏览器不可见。<br>

CSRF（Cross Site Request Forgery）跨站请求伪造，通过跨站的请求，以合法的身份进行非法的操作。原理是利用浏览器的cookie或服务器的session窃取用户身份。<br>
防范：<br>
(1) 在表单中添加token令牌<br>
(2) 验证码<br>
(3) 检查请求头中的Referer，Referer是http请求头的一个属性，表明请求来自哪里。












#### 100.question 100
