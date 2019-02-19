# question-nosql
some questions and answers for NoSql, like Redis, Memcached, MongoDB and so on.

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

#### 2. 如何计算Memcached的命中率？
使用stats命令，列出cmd_get和get_hits，get_hits/cmd_get即为命中率。

#### 3. ElasticSearch全文搜索？
一个基于Lucene的搜索服务器

####










#### 100.
