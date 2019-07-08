# question-architecture-dubbo
some questions and answers for Dubbo.

#### 1. 什么是Dubbo？
Dubbo是一个高性能分布式服务框架，致力于提供高性能和透明化的RPC远程服务调用方案，以及SOA服务治理方案，使得应用可以通过高性能RPC实现服务的输入和输出功能，和Spring框架可以无缝集成。<br>
Dubbo**注册中心**和**监控中心**的引入是服务治理的关键。<br>

- 注册中心：<br>
服务提供者向注册中心注册其提供的服务。<br>
服务消费者向注册中心获取服务提供者地址列表，同时加上负载均衡的算法选择服务提供者。<br>
- 监控中心：<br>
服务消费者和提供者累计调用次数和调用时间，定时发送统计数据到监控中心。<br>

对框架稳定性的影响：<br>
注册中心宕机的情况下，消费者在本地缓存了提供者的地址列表，业务暂时不受影响，但是不能注册新的服务。<br>
监控中心宕机的情况下，不影响服务，只影响部分数据采集。<br>
服务提供者宕机后，通过负载均衡算法可将请求发送到同服务的其他提供者，对健壮性起正面作用。<br>
注册中心和监控中心的引入在很大程度上提高了运行期的稳定性。<br>

Dubbo的核心：<br>
远程通讯：提供对多种基于长连接的NIO框架的抽象封装，包括多线程模型、序列化，以及“请求-响应”模式的信息交换方式。<br>
集群容错：提供基于接口方法的透明远程过程调用，包括多协议支持，以及负载均衡、失败容错、地址路由、动态配置等集群支持。<br>
自动发现：基于注册中心目录服务，服务消费者可以动态查找服务提供者、地址透明、服务提供者可以平滑的增加或减少服务。<br>

Dubbo的作用：<br>
(1) 透明化的远程方法调用，就像调用本地方法一样调用远程方法，只需简单的配置，没有API侵入<br>
(2) 软负载均衡及容错机制，可在内网代替F5等硬件负载均衡，降低成本、减少单点<br>
(3) 服务自动注册于发现，不需要写死服务提供者地址，可以平滑的添加或删除服务提供者<br>
(4) 采用全Spring配置方式，透明化接入应用<br>

#### 2. Dubbo支持哪些协议？
Dubbo协议：单一长连接和NIO异步通讯，适合大并发小数据量的服务调用，消费者数量远大于提供者的场景<br>
HTTP：基于HTTP表单提交的远程调用协议，使用Spring的HttpInvoke实现<br>
RMI：采用JDK标准的RMI协议实现，传输参数和返回参数的对象需实现Serializable接口，使用Java标准序列化机制<br>
Hessian：集成Hessian服务，基于HTTP通讯，采用servlet暴露服务<br>
WebService：基于WebService的远程调用协议，集成CXF实现，提供和原生WebService的互操作<br>
Memcache：基于Memcache实现的RPC协议<br>
Redis：基于Redis实现的RPC协议<br>

#### 3. Dubbo有哪些注册中心？
Multicast<br>
Zookeeper<br>
Redis<br>
Simple<br>

#### 4. Dubbo提供了哪些负载均衡策略？
Random: 随机，默认的策略，有利于动态调整提供者权重<br>
RoundRobin: 轮询，平均分布，但存在请求累计的问题<br>
LeastActive: 最少活跃，慢提供者接收更少的请求<br>
ConstantHash: 一致性hash，使相同参数请求总是发送到同一提供者，一台机器宕机，可以基于虚拟节点，分摊到其他提供者

#### 5. Dubbo集群的容错方案？
fail-over: 失败自动切换，默认的方案，，重试其他服务器，通常用于读操作，但重试会带来更长的延迟<br>
fail-fast: 快速失败，只发起一次调用，失败立即报错，通常用于非幂等的写操作，比如新增记录<br>
fail-safe: 失败安全，出现异常时，直接忽略，通常用于写入日志等操作<br>
fail-back: 失败自动恢复，后台记录失败请求，定时重发，通常用于消息通知操作<br>
forking: 并行调用多个服务器，只要一个成功即返回。通常用于实时性要求较高的读操作，但浪费服务资源，可设置最大并行数<br>
broadcast: 广播调用所有提供者，逐个调用，任意一个报错则报错。通常用于通知所有提供者更新缓存或日志等本地资源信息

#### 6. Dubbo设置超时？服务调用超时怎么解决？
服务提供者设置：推荐，因为服务提供者比消费者更清楚自己服务的特性<br>
服务消费者设置：优先级更高，更灵活<br>
服务调用不成功时，默认会重试两次。

#### 7. Dubbo的安全机制？
通过token令牌防止用户绕过注册中心直连，在注册中心管理授权。<br>
提供黑白名单，来控制服务允许的调用方。

#### 8.Dubbox和Dubbo的区别？
Dubbox基于Dubbo做了一些扩展，增加了服务Restful调用，更新了开源组件。

#### 9. Dubbo和Spring Cloud的关系和区别？
Dubbo是SOA时代的产物，关注点主要在于服务的调用、流量分发、流量监控和熔断。<br>
Spring Cloud诞生于微服务架构时代，考虑的是微服务的治理。<br>
Dubbo定位服务治理，Spring Cloud是一个生态。

项 | Dubbo | Spring Cloud
-|-|-
协议 | Netty NIO框架，基于TCP协议，配合以Hessian序列化完成RPC通信 | 基于HTTP协议+Restful接口
服务注册中心 | Zookeeper | Spring Cloud Netflix Eureka
服务调用方式 | RPC | REST API
服务网关 | 无 | Spring Cloud Netflix Zuul
断路器 | 不完善 | Spring Cloud Netflix Hystrix
分布式配置 | 无 | Spring Cloud Config
服务跟踪 | 无 | Spring Cloud Sleuth
消息总线 | 无 | Spring Cloud Bus
数据流 | 无 | Spring Cloud Stream
批量任务 | 无 | Spring Cloud Task







#### 100.
