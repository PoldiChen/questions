# question-java-spring-boot-cloud
some questions and answers for Spring Boot and Spring Cloud.

#### 1. Spring Cloud和Spring Boot的关系？
Spring Cloud是分布式微服务架构下的一站式解决方案，是各个微服务架构落地技术的集合体，俗称微服务栈解决方案。<br>
Spring Cloud是宏观的概念，Spring Boot是具体的技术。<br>
Spring Boot专注于快速、方便集成的单个个体。<br>
Spring Cloud是关注全局的微服务协调整理治理框架，它将Spring Boot开发的多个单体微服务整合并管理起来，为各个服务之间提供配置管理、服务发现、断路器、路由、微代理、事件总线、全局锁、决策竞选、分布式会话等集成服务。

#### 2. Spring Cloud分布式微服务架构相关技术？
服务发现：Netflix Eureka<br>
客户端负载均衡：Netflix Ribbon<br>
断路器：Netflix Hystrix<br>
服务网关：Netflix zuul<br>
分布式配置：Spring Cloud Config<br>
