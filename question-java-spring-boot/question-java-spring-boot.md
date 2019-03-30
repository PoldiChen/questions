# question-java-spring-boot
some questions and answers for Spring Boot.

#### 1. Spring Boot有哪些优点？
(1) 减少开发、测试的时间<br>
(2) 使用JavaConfig，避免使用XML<br>
(3) 避免大量的Maven导入和版本冲突<br>
(4) 提供默认配置快速开始开发<br>
(5) 不需要单独的web服务器<br>
(6) 需要更少的配置，没有web.xml文件。只需添加@Configuration的类，添加@Bean注释的方法<br>
(7) 基于环境的配置<br>

#### 2. Spring Cloud和Spring Boot的关系？
Spring Cloud是分布式微服务架构下的一站式解决方案，是各个微服务架构落地技术的集合体，俗称微服务栈解决方案。<br>
Spring Cloud是宏观的概念，Spring Boot是具体的技术。<br>
Spring Boot专注于快速、方便集成的单个个体。<br>
Spring Cloud是关注全局的微服务协调整理治理框架，它将Spring Boot开发的多个单体微服务整合并管理起来，为各个服务之间提供配置管理、服务发现、断路器、路由、微代理、事件总线、全局锁、决策竞选、分布式会话等集成服务。

#### 3. 如何不重启服务器而重新加载Spring Boot的更改？
使用DEV工具，DevTools模块。
```xml
<dependency>  
  <groupId>org.springframework.boot</groupId>    
  <artifactId>spring-boot-devtools</artifactId>  
  <optional>true</optional>
</dependency>
```

#### 4. Spring Boot的监视器是什么？
Spring Boot Actuator，可以访问生产环境中正在运行的应用的状态。

#### 5. 什么是YAML？
Yet another Markup Language，一种人类可读的数据序列化语言，常用于配置文件。<br>
能够分层配置，更加架构化，更少混淆。

#### 6. Spring Boot的@SpringBootApplication注解？
一个复合的注解，将三个组合在一起。SpringBoot根据应用的依赖、自定义的bean、classpath的类识别需要的bean。
```java
@Configuration // Spring框架的注解，标明该类是JavaConfig配置类，用来代替applicationContext.xml配置文件
@ComponentScan // 启用组件扫描
@EnableAutoConfiguration // 开启SPringBoot自动配置功能
```






#### 100.
