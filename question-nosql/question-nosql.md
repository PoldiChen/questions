# question-nosql
some questions and answers for NoSql, like Redis, Memcached, MongoDB and so on.

#### 1. Redis和Memcached的区别？
Redis | Memcached
-|-
不仅支持key-value，还支持list，set，hash等数据结构 | /
/ | 还可用于缓存图片、视频
物理内存不足时，可以将一些很久没有的value交换到磁盘 | /
可以持久化 | 不能持久化
数据量较小的性能操作和运算 | 在动态系统中减少数据库负载，缓存，适合读多写少的场景

项 | Redis | Memcached
- | - | -
网络IO模型 | - | -
数据支持类型 | - | -
内存管理机制 | - | -
数据存储及持久化 | - | -
数据一致性问题 | - | -
集群管理 | - | -

11










#### 100.
