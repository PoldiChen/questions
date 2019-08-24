# question-java-spring-cloud
some questions and answers for and Spring Cloud.

#### 1. Spring Cloud和Spring Boot的关系？
Spring Cloud是分布式微服务架构下的一站式解决方案，是各个微服务架构落地技术的集合体，俗称微服务栈解决方案。<br>
Spring Cloud是宏观的概念，Spring Boot是具体的技术。<br>
Spring Boot专注于快速、方便集成的单个个体。<br>
Spring Cloud是关注全局的微服务协调整理治理框架，它将Spring Boot开发的多个单体微服务整合并管理起来，为各个服务之间提供配置管理、服务发现、断路器、路由、微代理、事件总线、全局锁、决策竞选、分布式会话等集成服务。

#### 2. Spring Cloud分布式微服务架构相关技术？
服务发现：Netflix Eureka<br>
客户端负载均衡：Netflix Ribbon<br>
断路器：Netflix Hystrix<br>
服务网关：Netflix Zuul<br>
分布式配置：Spring Cloud Config<br>

#### 3. Spring Cloud路由网关Zuul和Gateway？
Zuul和Gateway两个组件。

项 | Zuul | Spring Cloud Gateway
-|-|-
开源组织 | Netflix公司开源项目 | Spring Cloud微服务平台的子项目，属于Spring开源社区
底层实现 | 构建于servlet 2.5，阻塞式API，不支持长连接 | 构建于Spring 5+，基于Spring Boot 2.x响应式的、非阻塞式的API。支持websocket
性能 | / | /

网关的职责：
(1) 安全认证。提供统一的认证方式和鉴权功能，避免重复开发。<br>
(2) 熔断、限流。针对问题服务进行熔断，对流量进行预估、限制访问。<br>
(3) 日志监控。统一流量入口，进行流量分析和监控。<br>
(4) 屏蔽内部细节，对外提供一致的接口。<br>
(5) 实现灰度。使用自定义策略实现分流，达到测试的目的。<br>

#### 4. 客户端负载均衡Ribbon和Feign？
Ribbon的作用：<br>
(1) 优先选择在一个zone且负载较少的Eureka Server进行连接<br>
(2) 定期从Eureka Server更新、过滤服务和实例列表<br>
(3) 根据负载均衡策略，从注册表中选择一个真实的实例地址<br>
- 轮询
- 随机
- 响应时间加权
- 自定义
(4) 通过RestClient对服务发起调用

Feign使用Java的动态代理，将需要调用其他服务的方法定义成抽象方法，不需要自己构建HTTP请求，和Ribbon配合提供RPC远程调用功能。

#### 4. Spring Cloud Sleuth分布式链路监控？

#### 4. Spring Cloud和Dubbo的对比？
微服务功能 | Spring Cloud | Dubbo
-| - | -
服务注册和发现 | Eureka | Zookeeper
服务调用方式 | RESTful API | RPC
断路器 | Hystrix | 有
负载均衡 | Ribbon | 有
服务路由和过滤 | Zuul | 有
分布式配置 | Spring Cloud Config | 无
分布式锁 | 计划开发 | 无
集群选主 | Spring Cloud Cluster | 无
分布式消息 | Spring Cloud Stream | 无

#### 5. Eureka和Zookeeper的比较？
Zookeeper：CP原则<br>
Eureka：AP原则<br>

Zookeeper有一个master节点，master挂了会在30~120s内进行选举，在选举期间Zookeeper是不可用的。<br>
这就是Zookeeper的CP，保持节点的一致性，牺牲了高可用（A）。<br>

Eureka有部分节点挂掉，其他节点还可以使用，节点间保持平级的关系，但信息可能不一致，这就是AP，牺牲了一致性（C）。




#### 100.
