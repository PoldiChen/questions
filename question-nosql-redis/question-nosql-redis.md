# question-nosql-redis
some questions and answers for Redis(Remote Dictionary Server).

#### 1. Redis和Memcached的区别？
Redis | Memcached
-|-
不仅支持key-value，还支持list，set，hash等数据结构 | key-value
/ | 还可用于缓存图片、视频
物理内存不足时，可以将一些很久没有的value交换到磁盘 | /
可以持久化 | 不能持久化
数据量较小的性能操作和运算 | 在动态系统中减少数据库负载，缓存，适合读多写少的场景

项 | Redis | Memcached
- | - | -
网络IO模型 | 单线程的IO复用模型 | 多线程、非阻塞IO复用的网络模型，分为监听主线程和worker子线程
数据支持类型 | 还提供set、list、zset、hash数据结构 | 使用key-value形式存储和访问数据
内存管理机制 | 将内存划分为特定长度的块，解决碎片的问题 | 普通的malloc/free
数据存储及持久化 | 支持持久化，快照和追加文件两种方式 | 不支持持久化，数据保存在内存
数据一致性问题 | 没有cas命令，但提供了事务功能 | cas命令，保证多个并发访问的一致性
集群管理 | 在服务器端构建分布式存储 | 本身不支持分布式，在客户端实现分布式存储
底层实现 | 构建了VM，速度更快 | 调用系统函数，会消耗比较多的请求时间

#### 2. Redis支持的数据结构？
数据类型 | 可存储的值 | 操作 | 应用
- | - | - | -
String | 字符串、整数、浮点数 | 对整个字符串或字符串的一部分执行操作<br>对整数或浮点数执行自增或自减操作 | 缓存、限流、计数器、分布式锁、分布式session
Set | 无序集合 | 添加、获取、移除单个元素<br>检查一个元素是否在集合中<br>计算交集、并集、差集<br>随机获取元素 | 赞、踩、标签、好友关系
ZSet | 有序集合 | 添加、获取、删除元素<br>根据范围或成员获取元素<br>计算一个键的排名 | 排行榜
List | 链表 | 从两端压入或弹出元素<br>读取单个或多个元素<br>筛选，只保留一个范围内的元素 | 关注人时间轴列表、简单队列
Hash | 包含键值对的无序散列表 | 添加、获取、移除单个键值对<br>获取所有键值对<br>检查某个键是否存在 | 用户信息、主页访问量、组合查询

Redis保存的都是二进制数据，本质是字节数组（byte[]），字节数据本身没有类型，按合理的格式解码后，可以变成字符串、整数、对象，此时才有数据类型。任何东西只要能转化成字节数组，都可以保存到Redis中。

#### 3. Redis的rehash和Java的HashMap的rehash有什么区别？

#### 4. 为什么Redis把所有数据都放在内存中？
为了达到最快的读写速度。通过异步的方式将数据写入磁盘。如果不放在内存中，磁盘IO速度回严重影响性能。

#### 5. Redis如何持久化？为什么不能做专门的持久化存储？

#### 6. Redis常用命令？
- 连接：redis-cli
- 列出所有key：keys *
- 取值：get key
- 赋值：set key value

#### 7. Redis的数据淘汰策略？
volatile-lru：从已经设置过期时间的数据集中，挑选最近最少使用的数据淘汰<br>
volatile-ttl：从已经设置过期时间的数据集中，挑选将要过期的数据淘汰<br>
volatile-random：从已经设置过期时间的数据集中，随机挑选数据淘汰<br>
allkeys-lru：从所有数据集中，挑选最近最少使用的数据淘汰<br>
allkeys-random：从所有数据集中，随机挑选数据淘汰<br>
no-enviction：禁止淘汰数据<br>

#### 8. Redis过期key的删除策略？
定时删除：在设置key的过期的时候同时设置一个timer，让定时器在过期时间到达时立即删除。<br>
对内存友好，但是对CPU时间不友好，有较多过期key时占用CPU时间。<br>
惰性删除：不管过期key，但是每次从key空间获取key时，检查取到的key是否过期，是则删除，不是则返回。<br>
对CPU时间友好，对内存不友好。<br>
定期删除：每隔一段时间进行检查，删除过期的key。<br>
对内存和CPU时间折中。

#### 9. Redis的并发竞争问题如何解决？
Redis为单进程单线程模式，采用队列模式将并发访问变为串行访问。本身没有锁的概念，对多个客户端连接不存在竞争，但是在Jedis客户端对Redis进行并发访问时会产生一系列问题，这些问题是客户端连接混乱造成的，有两种解决方案：<br>
(1) 在客户端对连接进行池化，同时对客户端读写Redis操作采用内部锁synchronized<br>
(2) 在服务端，采用setnx实现锁

#### 10. Redis的哨兵模式？
对Redis进行实时的监控，主要有两个功能：<br>
(1) 监测主数据库和从数据库是否正常运行<br>
(2) 主数据库出现故障时，自动将一个从数据库切换为主数据库，实现自动切换<br>

#### 11. Redis单线程模型？
Redis集群中每个节点只有一个线程负责接收和执行所有客户端发送的请求，技术上使用多路复用I/O，使用Linux的epoll函数，一个线程可以管理很多socket连接。
选择单线程还有以下原因：
(1) Redis都是对内存的操作，速度极快（10W+QPS）
(2) 时间主要消耗在网络传输
(3) 如果使用多线程，需要同步，实现起来复杂
(4) 线程加锁的时间甚至超过了内存操作的时间
(5) 多线程上下文频繁的切换消耗更多的CPU时间
(6) 单线程天然支持原子操作，单线程的代码写起来更简单

#### 12. Redis的事务？
分为两步：定义事务、执行事务。使用multi命令开启一个事务，然后把要执行的所有命令依次排上去。使用exec命令来执行这个事务，或使用discard命令放弃这个事务。
可以使用watch命令监视key，如果开始执行前这些key被其他命令操作了则会取消事务，也可以使用unwatch命令取消对key的监视。
Redis事务的特点：
(1) 如果开始执行事务前出错，则所有命令都不执行
(2) 一旦开始，则保证所有命令一次按顺序执行完不被打断
(3) 如果执行过程中遇到错误，会继续执行，不会停止
(4) 执行过程中遇到错误，不会回滚


#### 100.