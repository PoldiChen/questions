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

#### 4. ${}和#{}的区别？
项 | # | $
-|-|-
解析 | 将传入的数据当成字符串 | 将传入的数据直接显示在sql中
SQL注入 | 能防止sql注入 | 不能防止sql注入
用途 | 尽量用# | 一般用于传入数据库对象，如表名
参数替换 | 发生在DBMS中 | 发生在动态解析过程中

#### 5. MyBatis动态SQL？
if<br>
choose<br>
trim<br>
foreach<br>
bind<br>

#### 6. MyBatis一对多？多对一？多对多？
一对多，使用<collection>标签，比如一个user有多个email
```java
public class User {
	private int id;
	private String userName;
	private List<Email> email;
}
```
```xml
<mapper>
	<resultMap>
		<result property="id" column="id"></result>
		<result property="userName" column="user_name"></result>
		<collection property="email" ofType="com.poldichen.Email" column="user_id">
			<id property="id" column="email_id"></id>
			<result property="address" column="address"></result>
			<result></result>
		</collection>
	</resultMap>
</mapper>
```
多对一，使用<association>标签<br>

多对多，使用\<select>标签，比如用户User和用户组Group

```java
public class User {
	private int id;
	private String userName;
	private List<Group> groups;
}
public class Group {
	private int id;
	private String groupName;
	private List<User> users;
}
```
```xml
<mapper>
	<resultMap>
		<result></result>
	</resultMap>
</mapper>
```

https://www.cnblogs.com/jimisun/p/9414148.html

#### 7. MyBatis接口为什么不需要实现？
通过JDK动态代理，在启动加载配置文件的时候，根据配置mapper的xml文件去生成Dao层接口的实现。<br>
MapperProxy的invoke方法，调用MapperMethod的execute方法。<br>
MapperMethod类根据method方法的methodName和declaringInterface从xml文件中取出sql语句执行。<br>

```java
public class MapperProxy<T> implements InvocationHandler, Serializable {
	//
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		try {
			if (Object.class.equals(method.getDeclaringClass())) { // Object中定义的方法，直接执行
				return method.invoke(this, args);
			}
			if (this.isDefaultMethod()) { // JDK 8的接口方法默认实现
				return this.invokeDefaultMethod(proxy, method, args);
			}
		} catch (Throwable arg5) {
			throw ExceptionUtil.unwrapThrowable(arg5);
		}
		MapperMethod mapperMethod = this.cachedMapperMethod(method);
		return mapperMethod.execute(this.sqlSession, args);
	}
}
```
```java
public class MapperMethod {
	public Object execute(SqlSession sqlSession, Object[] args) {
		//
	}

	// 静态内部类，封装了SQL标签的类型，select, insert, update, delete
	public static class SqlCommand {
		//
	}

	// 静态内部类。封装了方法的参数、返回类型等
	public static class MethodSignature {
		//
	}
}
```

#### 8. MyBatis和Hibernate的对比？
Hibernate是ORM框架，MyBatis是半ORM框架，需要自己编写sql语句。<br>
Hibernate对象/关系映射能力强，数据库无关性好，对关系模型要求高。




#### 100.
