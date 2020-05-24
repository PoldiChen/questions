# question-os-linux
some questions and answers for operate system Linux.

#### 1. Linux和Windows的区别？
项 | Linux | Windows
-|-|-
大小写 | 区分大小写 | dos命令不区分大小写
文件 | 所有内容以文件的形式保存，包括用户、硬件 | 文件和硬件无关
扩展名 | 无扩展名的概念 | 用扩展名区分文件

#### 2. Linux进程间的通信方式？
管道
信号量
消息队列
信号
共享内存
套接字

#### 3. Linux的共享内存如何实现？
共享内存就是映射一段能被其他进程所访问的内存，这段共享内存由一个进程创建，但多个进程都可以访问。<br>
共享内存是最快的IPC方式，它是针对其他进程间通信方式运行效率低而专门设计的。它往往与其他通信机制，如信号量，配合使用，来实现进程间的同步和通信。

#### 4. Linux中select，epoll和poll的区别？
都是多路IO复用模型。<br>
select模型：每个客户端连接的文件描述符（fd），也就是套接字，都放到一个集合中，调用select函数后会一直监视这些文件描述符有哪些可读，如果有可读的文件描述符工作进程则取读取资源。<br>
poll模型：和select类似，但存放fd的数据结构不一样，select模型在一个进程中可以维护1024个连接，poll模型可以维护任意数量的连接。<br>
epoll模型：基于内核的反射机制，有活跃的socket时，系统会调用预设的回调函数，而select和poll都是遍历。

#### 5. 常用的Linux命令？
资源使用情况：<br>
**uptime** 查看负载load average，1分钟、5分钟、15分钟内系统的平均负载<br>
**top** CPU负载数值小于0.7\*CPU个数则表示正常<br>
**netstat** 网络相关<br>
- -l, --listening 显示监听的socket<br>
- -p, --programs 显示socket的PID/Program name<br>
```bash
netstat -nltp | grep 8080 # 查看占用8080端口的进程
netstat -nltp | grep {pid} # 查看某进程占用的端口
```

**ps** 查看进程（process）<br>
**tcpdump** 抓包<br>
**free** 查看内存<br>

文件操作：<br>
**cd**<br>
**ls**<br>
**mkdir**<br>
**touch**<br>
**rm**<br>
**cp**<br>
**df -h** 查看磁盘空间<br>
**dir** 列出文件<br>

#### 6. linux文件名颜色含义？
- 蓝色：目录
- 绿色：可执行文件
- 红色：表示压缩文件
- 浅蓝色：链接文件
- 灰色：其他文件
- 红色闪烁：链接的文件有问题
- 黄色：设备文件

#### 7. 压缩包tar.xz
```shell
tar -cvf file.tar dir
xz -z file.tar

xz -d file.tar.xz
tar -xvf file.tar
```

#### 8. 什么是僵尸进程？
父进程调用fork创建子进程，子进程运行直到终止，立即从内存中移除，但进程描述符仍保留在内存中。子进程的状态变成EXIT_ZOMBIE，并且向父进程发送SIGCHILD信号，父进程此时应该调用wait()来获取子进程的退出状态及其他信息。<br>
在wait()调用后，僵尸进程就完全从内存中移除。<br>
因此一个僵尸进程存在于其终止到父进程调用wait()函数的间隙，一般很快消失。<br>
如果编程不合理，父进程不调用wait()收集僵尸进程，那么这些进程就会一直存在内存中。<br>
不能使用kill加SIGKILL信号的命令去杀死僵尸进程，因为进程进程本身已经死掉了，不能再接收任何信号。<br>
```shell
ps aux | grep Z
```
可以杀死其父进程，使其变成孤儿进程，进而被系统中管理孤儿进程的进程清理。<br>

#### 9. 如何查看一个进程使用的文件？
```shell
lsof -p pid
```

#### 10. crontab一个任务没运行完，如何让下一个任务不运行？
crontab默认不会检查上一个命令执行的状态，下一个任务也会运行。<br>
可以通知设置标志位，运行前检查标志位，决定是否运行。

#### 11. kill -9
9是信号，强制终止，默认信号为15。<br>
接收到默认信号，程序在退出前一般会做一些准备工作，比如释放资源、清理临时文件等，如果在准备工作时遇到阻塞或其他问题导致无法成功，程序可以选择忽略该信号，所以有时kill命令无法停止程序。<br>
接收到-9的信号，程序应该立即结束运行，不能被阻塞或忽略，可能会带来一些副作用，导致数据丢失。<br><br>

Java程序的终止是基于JVM的关闭实现的，JVM关闭有三种：<br>
正常关闭：最后一个非守护进程结束，或者调用了System.exit()，或者通过其他特定平台的方法关闭。<br>
强制关闭：通过调用Runtime.halt()方法或者是在操作系统中强制kill<br>
异常关闭：运行中遇到RuntimeException异常<br>

可以自定义JVM在接收到kill -15信号时的清理动作，通过JDK提供的Java.Runtime.addShutdownHook(Thread hook)实现.
```java
public class Test {
	public static void main(String[] args) {
		Runtime.getRuntime().addShutdownHook(new Thread(() -> {
			System.out.println("execute shutdown hook.");
		}));
		while (true) {
			//
		}
		System.out.println("main thread end.");
	}
}
```









#### 100.
