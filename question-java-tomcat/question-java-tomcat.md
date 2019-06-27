# question-java-web
some questions and answers for Java Web.

#### 1. 部署在tomcat的web项目启动的过程？
tomcat有三种加载程序的方式：<br>
(1) 配置在conf/server.xml中<br>
(2) 配置在conf/Catalina/localhost下<br>
(3) 配置在webapps下
<br><br>
web.xml加载过程：<br>
context-param->listener->filter->servlet<br>
(1) 读取web.xml文件的两个节点&lt;listener&gt;和&lt;context-param&gt;<br>
(2) 创建一个ServletContext上下文，为web项目共享<br>
(3) 将<context-param>转化为键值对，赋给ServletContext<br>
(4) 创建<listener>中的类实例，即创建监听<br>
(5) 创建filter<br>
(6) 创建servlet<br>

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

#### 3. Https加密方式？Tomcat如何实现https？？
对称加密和非对称加密。<br>
公钥、私钥。<br>

#### 4. Tomcat如何实现并发？Connector运行模式？多线程？NIO模式的项目经验？？？
自带的线程池，使用APR（Apache Portable Runtime）的Pool或Java的ThreadPool实现。<br>

Connector有BIO、NIO、APR三种模式。<br>
BIO：一个线程处理一个请求。传统的Java IO，同步且阻塞。<br>
NIO：JDK1.4开始可以用少量的线程处理大量的请求。同步阻塞或同步非阻塞IO。<br>
AIO：JDK7开始支持，异步非阻塞IO
APR：tomcat以JNI的形式调用Apache HTTP服务器的核心动态链接库来处理文件读取或网络传输的操作，大大提高tomcat对静态文件的处理性能，从操作系统级别解决异步IO的问题。
```xml
<Connector port="8080"
           protocol="org.apache.coyote.http11.Http11NioProtocol"
           connectionTimeout="20000"
           redirectPort="8443"
           maxThreads="500"
           minSpareThreads="100"
           maxSpareThreads="200"
           acceptCount="200"
           enableLookups="false"
    />
```

#### 5.Tomcat原理？
最顶层的容器是Server，代表着整个服务器。一个Server可以包含一个或多个Service。<br>
Service主要包含两个部分，由两个模块协同合作：Connector和Container。<br>

Connector负责解析HTTP请求，生成HttpRequest和HttpResponse后交给Container，由它调用响应的servlet。<br>
Container用于封装和管理Servlet，以及具体处理Request请求。<br>
Tomcat默认的Container为HttpContainer。<br>
Tomcat启动后会开启一个线程，做死循环，通过ServerSocket来等待请求，得到请求后生成socket，交给HttpProcessor处理。每个processor处理都是一个单独的线程。（多个processor就实现了多线程？？？）<br>

四个Container：<br>
Engine：最顶层的容器，可以包含多个Host<br>
Host：代表一个虚拟主机，可以包含多个Context<br>
Context：代表一个web应用，也就是ServletContext，可以包含多个Wrapper<br>
Wrapper：代表一个servlet，不能再包含其他容器，最底层。

#### 6. Tomcat堆内存大小设置？默认大小？
windows系统：catalina.bat，linux系统：catalina.sh<br>
set JAVA_OPTS = -server -Xms512m -Xmx1024m<br>
默认为128m。<br>
JVM默认的最大最小堆内存分别是物理内存的1/4和1/64。

#### 7. 手动部署一个servlet到tomcat？code
