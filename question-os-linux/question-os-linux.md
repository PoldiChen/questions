# question-os-linux
some questions and answers for operate system Linux.

#### 1. Linux和Windows的区别？
项 | Linux | Windows
-|-|-
大小写 | 区分大小写 | dos命令不区分大小写
文件 | 所有内容以文件的形式保存，包括用户、硬件 | 文件和硬件无关
扩展名 | 无扩展名的概念 | 用扩展名区分文件

#### 2. Linux有哪些通信方式？

#### 3. Linux的共享内存如何实现？

#### 4. Linux中select，epoll和poll的区别？
都是多路IO复用模型。<br>
select模型：每个客户端连接的文件描述符（fd），也就是套接字，都放到一个集合中，调用select函数后会一直监视这些文件描述符有哪些可读，如果有可读的文件描述符工作进程则取读取资源。<br>
poll模型：和select类似，但存放fd的数据结构不一样，select模型在一个进程中可以维护1024个连接，poll模型可以维护任意数量的连接。<br>
epoll模型：基于内核的反射机制，有活跃的socket时，系统会调用预设的回调函数，而select和poll都是遍历。

#### 5. 常用的Linux命令？
资源使用情况：
top
netstat
ps
tcpdump 抓包

文件操作：
cd
ls
mkdir
touch
rm
cp












#### 100.
