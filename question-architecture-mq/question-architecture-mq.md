# question-architecture-mq
some questions and answers for Message Queue, like RabbitMQ, ActiveMQ, Kafka and so on.

#### 10. 消息中间件有哪些优点？
优点：<br>
系统解耦<br>
异步调用，提高系统性能<br>
流量削峰

**RabbitMQ**：支撑高并发、高吞吐量、性能很高、有完善的后台管理界面，另外还支持集群化、高可用部署架构、消息高可靠支持，功能比较完善；社区活跃、版本迭代频繁。<br>
缺点：基于erlang开发，难分析源码或二次开发。<br>
**RocketMQ**：阿里开源的，经过阿里的生产环境的超高并发、高吞吐量的考验，性能卓越，支持分布式事务等特殊场景。<br>
基于Java语言开发，适合阅读源码，进行二次开发。<br>
**ActiveMQ**：老牌的消息中间件，比较成熟，但性能较差，迭代慢<br>
**Kafka**：功能比较少，优势在于专为超高吞吐量的实时日志采集、实时数据同步、实时数据计算等场景设计。因此在大数据领域中配合实时计算技术（Spark Streaming, Storm, Flink）使用的比较多。

#### 11. 系统架构引入消息中间件的缺点？
系统可用性降低<br>
系统稳定性降低（重复消费、消息丢失、消息顺序正确性）<br>
分布式一致性问题（消息没有被消费）

#### 12. 两种消息队列协议？
项 | JMS (Java Message Service) | AMQP (Advanced Message Queuing Protocol)
- | - | -
定义 | Java API | 协议
跨语言 | 否 | 是
跨平台 | 否 | 是
支持消息模型 | 两种消息模型：<br>(1)Peer-to-Peer<br>(2)Pub/sub | 五种消息模型：
支持消息类型 | 多种消息类型：<br>StreamMessage<br>MapMessage<br>TextMessage<br>ObjectMessage<br>BytesMessage | 二进制

#### 13. 如何保证消息的有序性？
业务逻辑中自己实现？

#### 1. 如何实现消息的重发？
消息重发是指消费者在消费异常时，消费者将消息重新放入队列下次处理。超过重试次数后会放入一个特殊队列Dead Letter Queue中。

#### 1. 如何避免消息重复消费？如何实现幂等？
消息编号、保存消费记录

#### 14. 如何利用消息队列实现最终一致性？












#### 100. question 100
