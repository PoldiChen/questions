# question-mybatis
some questions and answers for MyBatis.

#### 1. MyBatis的架构？
抽象为三层：基础支持层、核心处理层、接口层。<br>
基础支持层包括：数据源、事务管理、日志、类型转换、缓存、Bind、解析器等。<br>
核心处理层包括：配置解析、配置映射、SQL解析、SQL执行、结果集映射、插件等。<br>
接口层：提供Java API

#### 2. MyBatis的初始化？
使用Configuration对象作为所有配置信息的容器，初始化的过程就是创建Configuration对象的过程。<br>
configuration配置：
- properties 属性
- settings 设置
- typeAliases 类型命名
- typeHandlers 类型处理器
- objectFactory 对象工厂
- plugins 插件
- environments 环境
- environment 环境变量
- transactionManager 事务管理器
- dataSource 数据源

初始化发生在SqlSessionFactory的创建过程中。
```java
SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
```
(1) 调用SqlSessionFactoryBuilder对象的build()方法<br>
(2) SqlSessionFactoryBuilder根据输入流的信息创建XMLConfigBuilder对象<br>
(3) SqlSessionFactoryBuilder调用XMLConfigBuilder对象的parse()方法<br>
(4) XMLConfigBuilder对象返回Configuration对象<br>
(5) SqlSessionFactoryBuilder根据Configuration对象创建一个DefaultSessionFactory对象<br>
(6) SqlSessionFactoryBuilder返回DefaultSessionFactory给调用者









#### 100.
