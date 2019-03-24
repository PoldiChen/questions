# question-nginx
some questions and answers for Nginx.

#### 1. Nginx简介？Nginx的master和worker进程分别是什么？如何实现热部署？如何实现高并发？
Nginx是一款轻量级的web服务器/反向代理服务器及电子邮件代理服务器。<br>
Nginx主要提供反向代理、负载均衡、动静分离（静态资源服务）等服务。<br>
Nginx负载均衡支持weight轮询、ip_hash、fair、url_hash四种算法。<br>
动静分离是让动态网站动态网页根据规则把不变的资源和常变的资源分开，对静态资源做缓存，即网站静态化处理。<br>

Nginx的优点：<br>
(1) 高并发、高性能（其他web服务器不具备）<br>
(2) 占用内存少，启动极快
(3) 可扩展性好（模块化设计，支持第三方插件）<br>
(4) 高可靠性（持续不间断运行数年）<br>
(5) 热部署（可以在不停止服务的情况下升级Nginx）<br>
(6) BSD许可证（可以下载源码修改）<br>

Nginx的四个主要组成部分：<br>
Nginx 二进制可执行文件，由各模块源码编译出一个文件<br>
Nginx.conf 配置文件<br>
access.log 访问日志<br>
error.log 错误日志

master进程的作用是读取并验证配置文件nginx.conf；管理worker进程。<br>
每一个worker进程都维护一个线程（避免线程切换），处理连接和请求；worker进程的个数由配置文件决定，一般和CPU个数相关，有利于进程切换。<br>

所谓热部署，是指修改配置文件nginx.conf，不需要关闭nginx，不需要中断请求，就能让配置文件生效。<br>
修改配置文件后，重新生成新的worker进程，以新的配置处理请求，新的请求提交给新的worker进程，旧的worker进程等处理完请求后结束掉即可。

采用Linux的epoll模型，epoll模型基于事件驱动机制，监控多个事件是否准备完毕，如果完毕，那么放入epoll队列中，这个过程是异步的，worker进程只需要从epoll队列取出事件处理即可。

#### 2. Nginx配置ip哈希？
nginx配置ip哈希：<br>
```
ipstream simple.com {
    ip_hash;
    server 192.168.1.1;
    server 192.168.1.2;
}
```


#### 100. question 100
