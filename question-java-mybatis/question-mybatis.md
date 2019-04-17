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

#### 3. MyBatis使用的设计模式？
(1) Builder模式<br>
比如SqlSessionFactoryBuilder，XMLConfigBuilder，XMLMapperBuilder，XMLStatementBuilder，CacheBuilder<br>
Builder模式是将一个复杂对象的构建与它的表示分离，使得同样的构建过程可以创建不同的表示，属于创建类模式。<br>
(2) 工厂模式<br>
SqlSessionFactory，ObjectFactory，MapperProxyFactory<br>
(3) 单例模式<br>
ErrorContext（每个线程范围内），LogFactory（整个MyBatis使用的日志工厂）<br>
(4) 代理模式<br>
MyBatis实现的核心，只需要编写Mapper.java接口，不需要实现。比如MapperFactory，ConnectionLogger，用的是JDK的动态代理。还有executor.loader包使用了CGLib或者javassist达到延迟加载的效果。<br>
(5) 组合模式<br>
SqlNode和各个子类ChooseSqlNode<br>
(6) 模板方法模式<br>
BaseExecutor和SimpleExecutor，BaseTypeHandler和所有子类，比如IntegerTypeHandler<br>
(7) 适配器模式<br>
Log的MyBatis接口，以及对JDBC，Log4j等各种日志框架的适配实现<br>
(8) 装饰者模式<br>
Cache包中的cache.decorators子包中各个装饰者的实现<br>
(9) 迭代器模式<br>
PropertyTokenizer

<br>
<br>
#### 100.
<br>
<br>
<br>
<br>
<br>
<br>
#### 100.
