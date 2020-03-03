# question-middleware-zookeeper
some questions and answers for Zookeeper.

#### 1. Zookeeper是什么？
无单点问题的分布式协调框架，树型的目录服务的数据存储。<br>
设计目标是将复杂且容易出错分布式一致性服务封装起来，构成一个高效可用的原语集，并以一系列简单易用的接口提供给用户使用。<br>

典型的分布式数据一致性解决方案，分布式应用程序可以基于Zookeeper实现数据发布/订阅、负载均衡、命名服务、分布式协调/通知、集群管理、master选举、分布式锁、分布式队列等功能。<br>

最常用：服务生产者和消费者的注册中心<br>

原语： 操作系统或计算机网络用语范畴。它是由若干条指令组成的，用于完成一定功能的一个过程。具有不可分割性，即原语的执行必须是连续的，在执行过程中不允许被中断。

#### 2. Zookeeper的leader选举算法？
Zookeeper没有master/slave的概念，而是将集群的节点分为三类：<br>
- leader<br>
一个集群中只能存在一个leader，存在多个leader的现象称为脑裂。<br>
leader是集群中事务请求的唯一调度者和处理者，所谓事务请求是指会改变集群状态的请求。leader根据事务ID可以保证事务处理的顺序性。<br>

- follower<br>
只能处理非事务请求，如果接收到客户端事务请求会转发给leader<br>
参与leader选举，参与leader事务处理投票<br>

- observer<br>
和follower类似，可以处理非事务请求，<br>
不参与选举，不参与leader事务处理投票<br>

三种状态：<br>
- looking<br>
- following<br>
- leading<br>

选举原则：<br>
(1) 数据最新的节点优先成为leader，新旧根据事务ID判断，ID越大越新<br>
(2) 比较server.id，大的优先成为leader<br>
(3) 过半原则：leader选举投票、事务提议投票<br>
事务提议投票：<br>
客户端请求添加一个节点，leader接收到请求后给所有follower发送创建节点的提议投票，如果收到超过一半数量的反馈，则给所有follower发送commit（两阶段提交）<br>
leader选举投票：<br>
第一轮，每个follow投处自己的事务ID和server ID，并接收其他follow的投票，如果ID比自己的大，则变更自己第二轮的投票<br>
第二轮，follow投出自己不变的票或变更的票

#### 3. Zookeeper的ZAB协议？
ZAB协议（Zookeeper AtomicBroadcast），为Zookeeper专门设计的一种支持崩溃恢复的原子广播协议，依赖ZAB协议来实现分布式数据一致性。<br>
ZAB协议主要有两种模式：<br>
消息广播模式：有过半的follow完成和leader的状态同步，可以正常对外提供服务<br>
数据恢复模式：选举leader或有新节点加入集群<br>

消息广播模式（改良版的2PC）：<br>
(1) leader接收到消息后赋予全局唯一的64位自增ID，zxid，通过ID大小可以保证顺序<br>
(2) leader将带有zxid的消息作为一个提案发送给所有follower<br>
(3) follower接收到提案，先写入磁盘，再向leader发送一个ack<br>
(4) leader接收到超过半数的ack，再向这些follower发送commit命令<br>
(5) follower接收到commit命令，提交该消息<br>







#### 100.
