# question-java-web
some questions and answers for Java Web.

#### 1. JSP九大内置对象？
out对象：是JspWriter类的实例，向客户端输出内容<br>
request对象：表示客户端的一次请求，封装了请求的信息，是HttpServletRequest类的实例，在请求完成之前一直是有效的。<br>
response对象：包含了响应客户端的信息，是HttpServletResponse类的实例，具有页面的作用域<br>
session对象：会话，一个客户端打开浏览器连接到服务器，到客户端关闭浏览器。HttpSession类的实例。<br>
application对象：实现了用户间数据的共享，可以存放全局变量，生命周期从服务器启动到关闭<br>
page对象<br>
pageContext对象<br>
exception对象<br>
config对象

#### 2. servlet的生命周期？tomcat servlet生命周期？tomcat如何创建servlet类实例？
加载--实例化--服务--销毁<br>
init()：在servlet的生命周期中仅执行一次init()。在服务器装入servlet的时候执行，负责初始化servlet对象。<br>
service()：servlet的核心，负责响应客户端的请求。每当一个客户端请求一个HttpServlet对象，该对象的service()方法就被调用，并且传递给这个方法一个请求对象（ServletRequest）和一个响应对象（ServletResponse）作为参数。<br>
destroy()：仅执行一次，在服务端停止且卸载servlet时执行。

(1) 加载servlet。Tomcat负责创建servlet的实例。<br>
(2) 初始化。Servlet被实例化后，tomcat调用其init()方法初始化这个对象。<br>
(3) 处理服务。浏览器访问的时候，servlet会调用service()方法处理请求。<br>
(4) 销毁。Tomcat关闭时或者检测到servlet要从tomcat删除的时候自动调用destroy()方法，让该实例释放占用的资源。一个servlet如果长时间不被使用的话，也会被tomcat自动销毁。<br>
(5) 卸载。Servlet调用完destroy()方法后，等待垃圾回收，如果需要再次使用，会重新调用init()方法进行初始化。

容器启动时，读取webapps目录下所有应用的web.xml文件，进行解析，得到servlet注册信息。然后将每个应用中注册的servlet类都进行加载，并通过反射的方式实例化。<br>
在servlet注册时，如果<load-on-startup>1</load-on-startup>为正数，则一开始就实例化，不写或为负数则第一次请求才实例化。

#### 3. servlet和CGI的区别？
servlet处于服务器进程中，通过多线程的方式运行其service方法，一个实例可以服务于多个请求，并且实例一般不会销毁。<br>
而CGI对每一个请求产生一个新的进程，服务完成就销毁，效率较低。

#### 4. request.getAttribute()和request.getParameter()有什么区别？
getParameter()通过容器的实现来取得通过类似post、get等方式传入的数据。<br>
getAttribute()和setAttribute()只在web容器内部流转，仅是处理请求阶段。<br>
getAttribute()返回对象，getParameter()返回字符串。<br>
getAttribute()和setAttribute()一起使用，先set才能get，在同一个request中才有效。<br>
getParameter()接收表单的get或post传递过来的参数。<br>

#### 5. Java实现短URL生成？code
