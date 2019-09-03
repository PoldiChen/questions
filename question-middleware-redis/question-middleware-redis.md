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
-| - | -
网络IO模型 | 单线程的IO复用模型 | 多线程、非阻塞IO复用的网络模型，分为监听主线程和worker子线程
数据支持类型 | 还提供set、list、zset、hash数据结构 | 使用key-value形式存储和访问数据
内存管理机制 | 将内存划分为特定长度的块，解决碎片的问题 | 普通的malloc/free
数据存储及持久化 | 支持持久化，快照和追加文件两种方式 | 不支持持久化，数据保存在内存
数据一致性问题 | 没有cas命令，但提供了事务功能 | cas命令，保证多个并发访问的一致性
集群管理 | 在服务器端构建分布式存储 | 本身不支持分布式，在客户端实现分布式存储
底层实现 | 构建了VM，速度更快 | 调用系统函数，会消耗比较多的请求时间

#### 2. Redis支持的数据结构？
数据类型 | 可存储的值 | 操作 | 应用
-| - | - | -
String | 字符串、整数、浮点数 | 对整个字符串或字符串的一部分执行操作<br>对整数或浮点数执行自增或自减操作 | 缓存、限流、计数器、分布式锁、分布式session
Set | 无序集合 | 添加、获取、移除单个元素<br>检查一个元素是否在集合中<br>计算交集、并集、差集<br>随机获取元素 | 赞、踩、标签、好友关系
ZSet | 有序集合 | 添加、获取、删除元素<br>根据范围或成员获取元素<br>计算一个键的排名 | 排行榜
List | 链表 | 从两端压入或弹出元素<br>读取单个或多个元素<br>筛选，只保留一个范围内的元素 | 关注人时间轴列表、简单队列
Hash | 包含键值对的无序散列表 | 添加、获取、移除单个键值对<br>获取所有键值对<br>检查某个键是否存在 | 用户信息、主页访问量、组合查询

Redis保存的都是二进制数据，本质是字节数组（byte[]），字节数据本身没有类型，按合理的格式解码后，可以变成字符串、整数、对象，此时才有数据类型。任何东西只要能转化成字节数组，都可以保存到Redis中。

#### 3. Redis的rehash和Java的HashMap的rehash有什么区别？

#### 4. 为什么Redis把所有数据都放在内存中？
为了达到最快的读写速度。通过异步的方式将数据写入磁盘。<br>
如果不放在内存中，磁盘IO速度回严重影响性能。

#### 5. Redis如何持久化？为什么不能做专门的持久化存储？
有两种<br>
RDB：快照，一次全量的备份，把所有Redis内存的数据进行二进制的序列化存储到磁盘。<br>
恢复时直接读取磁盘即可。<br>
AOF日志：记录数据修改的指令，类似于MySQL的Binlog，AOF日志随时间推移会一直增加。<br>
恢复时需要对指令进行重做，耗时可能会很长。<br>

Redis 4.0引入混合持久化模式，将RDB的文件和局部增量的AOF结合。<br>
RDB可以使用间隔较长的时间保存策略，AOF不需要全量日志，只需要保存前一次RDB存储开始到这段时间的增量AOF日志即可，日志量很小。<br>

不能做专门的持久化：<br>
(1) 占用内存较大<br>
(2) 持久化是异步的，可能出现故障（RDB可能丢失数据，AOF影响性能）<br>
(3) 不利于数据分析<br>

#### 6. Redis常用命令？
- 查看版本：redis-server --version或redis-server -v
- 连接：redis-cli
- 关闭服务：redis-cli shutdown
- 启动服务：redis-server
- 列出所有key：keys *
- 取值：get key
- 赋值：set key value
- 设置过期时间：expire key seconds
- 查看过期时间：pttl key (-2：key不存在；-1：key存在但未设置过期时间；毫秒数：剩余生存时间)
- 删除：del key
- 查看key对应value的类型：type key
- 查看底层数据结构：object encoding key
- 查看内存使用情况：info memory

```
127.0.0.1:6379> info memory
# Memory
used_memory:813824
used_memory_human:794.75K
used_memory_rss:4182016
used_memory_rss_human:3.99M
used_memory_peak:855304
used_memory_peak_human:835.26K
total_system_memory:1043935232
total_system_memory_human:995.57M
used_memory_lua:37888
used_memory_lua_human:37.00K
maxmemory:0
maxmemory_human:0B
maxmemory_policy:noeviction
mem_fragmentation_ratio:5.14
mem_allocator:jemalloc-3.6.0
```

#### 7. Redis的数据淘汰策略？
volatile-lru：从已经设置过期时间的数据集中，挑选最近最少使用的数据淘汰<br>
volatile-ttl：从已经设置过期时间的数据集中，挑选将要过期的数据淘汰<br>
volatile-random：从已经设置过期时间的数据集中，随机挑选数据淘汰<br>
allkeys-lru：从所有数据集中，挑选最近最少使用的数据淘汰<br>
allkeys-random：从所有数据集中，随机挑选数据淘汰<br>
no-enviction：禁止淘汰数据<br>

#### 8. Redis过期key的删除策略？
**定时删除**：在设置key的过期的时候同时设置一个timer，让定时器在过期时间到达时立即删除。<br>
对内存友好，但是对CPU时间不友好，有较多过期key时占用CPU时间。<br>

**惰性删除**：不管过期key，但是每次从key空间获取key时，检查取到的key是否过期，是则删除，不是则返回。<br>
对CPU时间友好，对内存不友好。<br>

**定期删除**：每隔一段时间进行检查，删除过期的key。<br>
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
Redis集群中每个节点只有一个线程负责接收和执行所有客户端发送的请求，技术上使用多路复用I/O，使用Linux的epoll函数，一个线程可以管理很多socket连接。<br>
选择单线程还有以下原因：<br>
(1) Redis都是对内存的操作，速度极快（10W+QPS）<br>
(2) 时间主要消耗在网络传输<br>
(3) 如果使用多线程，需要同步，实现起来复杂<br>
(4) 线程加锁的时间甚至超过了内存操作的时间<br>
(5) 多线程上下文频繁的切换消耗更多的CPU时间<br>
(6) 单线程天然支持原子操作，单线程的代码写起来更简单

#### 12. Redis的事务？
分为两步：定义事务、执行事务。<br>
使用multi命令开启一个事务，然后把要执行的所有命令依次排上去。<br>
使用exec命令来执行这个事务，或使用discard命令放弃这个事务。<br>
可以使用watch命令监视key，如果开始执行前这些key被其他命令操作了则会取消事务，也可以使用unwatch命令取消对key的监视。<br>
Redis事务的特点：<br>
(1) 如果开始执行事务前出错，则所有命令都不执行<br>
(2) 一旦开始，则保证所有命令一次按顺序执行完不被打断<br>
(3) 如果执行过程中遇到错误，会继续执行，不会停止<br>
(4) 执行过程中遇到错误，不会回滚

#### 13. Redis主从数据同步？
主从架构可以是一主多从或者是级联结构，主从复制可分为全量同步和增量同步。<br>

全量同步，一般发生在slave的初始化阶段，slave需要将master上所有的数据都复制一份。<br>
(1) 从服务器连接主服务器，发送SYNC命令<br>
(2) 主服务器接收到SYNC命令后，执行BGSAVE命令生成RDB文件，使用缓冲区记录此后执行的写命令<br>
(3) 主服务器向所有从服务器发送快照文件，在发送期间持续记录被执行的写命令<br>
(4) 从服务器接收到快照文件后丢弃所有旧数据，载入快照<br>
(5) 主服务器在快照发送完毕后向从服务器发送缓冲区中的写命令<br>
(6) 从服务器完成快照写入，接收命令请求，执行来自主服务器缓冲区的写命令<br>

增量同步，slave初始化后开始正常工作，主服务器发生的写操作同步到从服务器。<br>
主服务器每执行一条写命令就会向从服务器发送同样的写命令，从服务器接收并执行写命令。<br>

主从同步策略：先尝试进行增量同步，如果不成功，要求从服务器进行全量同步。

#### 14. Redis集群cluster
Redis集群没有统一的入口，客户端可以连接集群的任意节点，集群内部节点间相互通信，每个节点都是一个Redis实例。<br>
Redis集群内置了16384个slot（哈希槽），把所有物理节点映射到这些槽上。<br>
需要在集群中存放一个数据时，先对这个key进行CRC计算，得到结果后对16384求余，决定存放到哪个节点中，所以某一个节点挂了，且没有从节点，则会导致集群无法正常工作。<br>
为了实现集群的高可用，Redis-cluster通过投票容错机制进行健康检查（所以集群至少需要三个节点），如果集群中超过半数的节点投票认为某个节点挂了，则认为该节点挂了。<br>
官方推荐将节点配置为主从架构，主节点失效，Redis Cluster会根据选举算法从slave节点中选取一个升为master，整个集群可以继续提供服务。<br>

#### 15. Redis热点key

#### 16. Redis底层数据结构
类型 | 编码 | 对象
-|-|-
STRING | int | 使用整数值实现
STRING | embstr | 使用embstr编码的简单动态字符串实现
STRING | raw | 使用简单动态字符串实现
LIST | ziplist | 使用压缩列表实现
LIST | linkedlist | 使用双端链表实现
HASH | ziplist | 使用压缩列表实现
HASH | hashtable | 使用字典实现
SET | intset | 使用整数集合实现
SET | hashtable | 使用字典实现
ZSET | ziplist | 使用压缩列表实现
ZSET | skiplist | 使用跳跃表和字典实现

简单动态字符串（Simple Dynamic String, SDS）
```c
struct sdshdr {
	int len; // 记录buf数组中已使用的字节数量，即字符串的长度
	int free; // 记录buf数组中未使用的字节数量
	char buf[]; // 字节数组，用于保存字符串
}
```
https://www.cnblogs.com/jaycekon/p/6227442.html

#### 17. Redis实现乐观锁？
使用watch key命令监听key的变化；<br>
使用multi命令开启一个事务，使用exec命令执行事务，如果有冲突会返回nil














#### 100.
