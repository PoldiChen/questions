# question-spring
some questions and answers for Spring.

#### 1. Spring的IoC容器如何为普通的类（非单例模式）创建单例？是线程安全的吗？
Bean的配置有个scope属性，有5种值：singleton、prototype、request、session、global-session，默认使用singleton，比如：<br>
```xml
<bean id="p1" class="com.test.Person" />
<bean id="p2" class="com.test.Person" scope="prototype" />
```
不是线程安全的。<br>
大部分的bean没有可变的状态，但View Model有多种状态，需要自行保证线程安全。<br>
一个简单的方法就是把作用域从默认的singleton改成prototype，每次请求都创建一个新的bean。<br>

bean单例的好处：<br>
(1) 减少生成新实例的消耗<br>
(2) 减少垃圾回收<br>
(3) 可以从缓存中快速获取到bean<br>

Bean的5种作用域：<br>
singleton：默认，在IOC容器中只有一个实例<br>
prototype：可以有多个实例<br>
request：每次请求都会创建一个实例<br>
session：在一个HTTP Session中，一个bean对应一个实例<br>
global-session：在一个全局的HTTP Session中，一个bean对应一个实例

#### 2. SpringMVC工作流程？
(1) 请求request到达DispatcherServlet（DispatcherServlet能够拦截所有请求）<br>
(2) DispatcherServlet查找HandleMapping，将功能代理给HandleMapping<br>
(3) HandleMapping找到具体的处理器，生成处理器对象及处理器拦截器一并返回给DispatcherServlet<br>
(4) DispatcherServlet调用HandleAdapter处理器适配器<br>
(5) HandleAdapter经过适配调用具体的处理器，找到Controller和HandleInterceptor<br>
(6) 把Controller和HandleInterception制作成一个可执行的链条，也就是HandleAdapter<br>
(7) HandleAdapter将信息返回给DispatcherServlet，DispatcherServlet开始调用这个一般化的处理器<br>
(8) Controller生成ModelAndView，返回给DispatcherServlet<br>
(9) DispatcherServlet调用ViewResolver视图解析器，返回到View对象<br>
(10) ModelAndView将数据传递到View<br>
(11) DispatcherServlet响应给用户

![avatar](image/question-java-spring-002.png)

#### 3. Spring有哪些类型的依赖注入方式？
(1) 构造器依赖注入：通过容器触发类的一个构造器，参数可以表示对其他类的依赖<br>
(2) setter方法依赖注入：通过容器调用无参构造器或无参static工厂方法实例化bean，调用bean的set方法<br>
(3) 接口注入

#### 4. Spring框架中bean的生命周期？
一个bean实例初始化时，需要执行一系列的初始化操作以达到可用状态；不再被调用时需要执行相关的析构操作，从bean容器移除。<br>
BeanFactory负责管理bean的生命周期，bean的生命周期由两组回调函数组成：初始化之后调用的回调方法和销毁之前调用的回调方法。<br>
Spring框架提供了4种方式来管理bean的生命周期：<br>

(1) Spring容器从XML文件中读取bean的定义，并实例化bean<br>
(2) 根据bean的定义填充所有属性<br>
(3) 如果bean实现了BeanNameAware接口，传递bean的ID到setBeanName方法<br>
(4) 如果bean实现了BeanFactoryAware接口，传递beanFactory给setBeanFactory方法<br>
(5) 如果有与bean关联的BeanPostProcessors，Spring会在postProcessorBeforeInitialization()方法内调用它们<br>
(6) 如果实现了InitializingBean，调用它的afterPropertySet方法，如果bean声明了初始化方法，调用此初始化方法<br>
(7) 如果有与bean关联的BeanPostProcessors，这些bean的postProcessorAfterInitialization()方法将被调用<br>
(8) 如果bean实现了DisposableBean方法，它将调用destroy方法

#### 5. Spring的bean装配？自动装配？
bean装配是指在spring容器中把bean组装在一起，前提是容器需要知道bean的依赖关系，通过依赖注入装配到一起。<br>
spring容器能够自动装配相互合作的bean。<br>

自动装配的5种模式：<br>
(1) no：默认的方式，不自动装配，通过手动设置ref属性来装配<br>
(2) byName：通过参数名自动装配，查找和bean属性具有相同名字的其他bean<br>
(3) byType：通过参数的类型自动装配，查找和bean属性类型相同的其他bean<br>
(4) constructor：和byType类似<br>
(5) autodetect：如果有默认的构造函数，则通过constructor的方式，否则通过byType的方式<br>

自动装配的局限性：<br>
重写：仍需用<constructor-arg>和<property>配置来定义依赖，意味着总要重写自动装配<br>
基本数据类型：不能自动装配简单的属性，如基本数据类型、String字符串和类<br>
模糊特性：不如显式装配精确

#### 6. Spring支持的事务管理类型？抛出异常时事务是否会回滚？
(1) 编程式事务管理：通过编程的方式管理事务，灵活，但难维护<br>
(2) 声明式事务管理：将业务代码和事务管理分离，只需用注解和XML配置来管理<br>
声明式事务对代码的影响较小，更符合无侵入轻量级容器的思想，但少了一些灵活性。

编译时异常不会回滚，运行时异常会回滚。
默认只把Runtime, Unchecked Exception标记为回滚，即RuntimeException及其子类，Error默认也会回滚。Checked Exception默认不会回滚。

#### 7. Spring的BeanFactory和ApplicationContext的区别？
BeanFactory是spring IoC的具体实现，提供了一种先进的配置机制，能配置任何类型的对象。<br>
ApplicationContext对BeanFactory进行扩展，添加了其他功能，如国际化、统一的资源文件读取方式。<br>
三种常见的ApplicationContext实现方式：<br>
(1) ClassPathXmlApplicationContext<br>
(2) FileSystemXmlApplicationContext<br>
(3) XmlWebApplicationContext

#### 8. Spring中使用的设计模式？
(1) 代理模式：AOP的底层实现，采用JDK Proxy（目标类实现了接口）和CgLib类库（目标类没有实现接口）<br>
(2) 单例模式：实例化的bean默认是singleton的<br>
(3) 工厂模式：BeanFactory、ApplicationContext用来创建对象的实例<br>
(4) 模板方法：用来解决代码重复的问题，如RestTemplate<br>
(5) 委派模式：Spring提供了DispatcherServlet对请求进行转发<br>
(6) 观察者模式：Spring事件驱动模型<br>
(7) 适配器模式：SpringMVC的HandlerAdapter

#### 9. Spring的依赖注入（DI，Dependency Injection）和控制反转（IoC，Inversion of Control Container）？
&emsp;&emsp;依赖注入：在运行时将类的依赖注入到代码中，将依赖定义为接口，将实现了这个接口的实体类注入到主类的构造器中。<br>
&emsp;&emsp;依赖注入可以通过单一责任原则来提高代码的内聚，因为依赖的对象通常都是能独立完成一个功能的对象。<br>
&emsp;&emsp;控制反转容器：一个支持依赖注入的中心容器，如spring框架，定义哪个依赖应该使用哪个实体类。<br>
&emsp;&emsp;不实际生成对象，而是定义如何生成对象。<br>
&emsp;&emsp;依赖注入和控制反转能够在运行时绑定类之间的关系，而不是编译时。<br>
&emsp;&emsp;松耦合也更易于单元测试。

#### 10. Spring如何使用ThreadLocal解决线程安全问题？
&emsp;&emsp;ThreadLocal是线程的一个本地化对象。多线程环境的对象使用ThreadLocal维护变量时，为每个线程分配一个变量副本，每个线程可以独立的改变自己的副本，相当于线程的本地变量。<br>
&emsp;&emsp;ThreadLocal类中有一个内部类ThreadLocalMap，key为线程对象，value为线程的变量副本。<br>
&emsp;&emsp;数据连接和会话一般是非线程安全的，

管理request作用域的bean、事务管理、任务调度、AOP

#### 11. Spring源码-IoC？
BeanFactory：bean的管理工厂，所有bean都在其中创建、存储、销毁<br>
DefaultListableBeanFactory：BeanFactory的实现类<br>
Resource：spring的配置信息，可以来自xml文件、网络、数据流<br>
BeanDefinition：封装bean的所有信息，包括参数值、方法名、是否懒加载、是否单例<br>
BeanDefinitionReader：构建BeanDefinition，从Resource中读取信息封装成BeanDefinition<br>
ApplicationContext：上下文，实现了各种接口，封装了各种bean对象<br>
Environment：运行环境配置信息<br>
Document：从xml文件中抽取出来的文本对象<br>
Element：从Document中抽取出来的node节点<br>
spring-test

#### 12. Spring的AOP？在项目中的使用？和拦截器、过滤器的区别？？？
两种代理的方式：默认使用JDK动态代理，目标类无接口的时候用cglib（code generation library），代码生成类库，可以在运行时时期扩展Java类实现Java接口，动态生成新的class。<br>
项目中的使用：权限验证、异常处理、日志、事务管理。

#### 13. Spring有哪些优点？
轻量级。基本的版本大约2MB.<br>
控制反转。注入依赖的对象，实现了松耦合。<br>
面向切面编程。将业务逻辑和系统服务分离。<br>
容器。管理对象的配置和生命周期。<br>
MVC框架。<br>
事务管理。统一的事务管理接口。<br>
异常处理。将特定技术（如JDBC、Hibernate）的异常转化为一致的unchecked异常。

#### 14. 如何在Spring中注入Java集合类？
使用集合配置元素：
```xml
<list></list><!-- 注入一系列的值，允许重复 -->
<set></set><!-- 注入一系列的值，不允许重复 -->
<map></map><!-- 注入一组键值对，键和值可以是任意类型 -->
<props></props><!-- 注入一组键值对，键和值都是字符串 -->
```

#### 15. Spring初始化bean的过程？
(1) 容器寻找bean的定义信息并实例化<br>
(2) 使用依赖注入，按照bean定义信息配置其属性<br>
(3) 如果实现了BeanNameAware接口，调用bean的setBeanName()方法传递bean的id<br>
(4) 如果实现了BeanFactoryAware接口，调用setBeanFactory()方法传入工厂自身<br>
(5) 如果BeanPostProcessor和bean关联，调用postProcessBeforeInitialization()方法<br>
(6) 如果bean指定了init-method方法，将被调用

#### 16. Spring如何解决类循环依赖？
(1) setter对象的依赖（单例）<br>
&emsp;&emsp;A类需要设置B类，B类需要设置C类，C类需要设置A类，形成循环。<br>
&emsp;&emsp;Spring的解决方案是，初始化A类的时间将Bean放入缓存中，然后set B类，再把B类的Bean放入缓存中，然后set C类，初始化C类的时候需要A类的Bean，这是不需要初始化，从缓存中获取。<br>
&emsp;&emsp;这种只对singleton的Bean起作用，因为prototype的Bean不做缓存。<br>
(2) 构造器中对其他类的依赖<br>
&emsp;&emsp;创建A类需要在构造器中初始化B类，创建B类需要在构造器中初始化C类，创建C类需要在构造器中初始化A类，形成循环。<br>
&emsp;&emsp;Spring的解决方案是，把创建中的Bean放入到一个“当前创建Bean池”中，初始化类的时候如果发现Bean类已经存在，抛出BeanCurrentInCreationException异常。<br>
(3) setter方法原型，prototype<br>
&emsp;&emsp;对于作用域为prototype的bean，Spring容器无法完成依赖注入，因为这种作用域的bean不进行缓存，因此无法提前暴露一个正在创建的bean。

#### 17. Spring的核心容器？
应用上下文模块，提供Spring框架的基础功能，BeanFacory是任何以Spring为基础的应用的核心。<br>
Spring框架建立在此模块之上，它使Spring成为一个容器。

#### 18. Bean的生命周期方法？能否重载？？？
setUp方法，在容器加载bean的时候被调用。<br>
tearDown方法，容器卸载类的时候被调用

#### 19. Spring常用的注解？
- @Configuration
- @Bean
- @Component
- @Service
- @ComponentScan
- @Required<br>
bean的属性必须在配置的时候设置，通过一个bean定义的显式的属性值或通过自动装配<br>
- @Autowired <br>
提供了更细粒度的控制，包括在何处以及如何完成自动装配<br>
- @Qualifier <br>
有多个相同类型的bean但只有一个需要自动装配，将@Qualifier和@Autowired结合消除这种混淆，指定需要装配的确切的bean
- @Resource
- @PostConstruct
- @PreDestroy

#### 20. Spring的controller是单例还是多例？如何保证线程安全？
单例。<br>
不要在controller中定义成员变量。如果需要定义一个非静态成员变量，通过注解@Scope("prototype")设置为多例。<br>
Service也是单例。

#### 21. Spring事务隔离级别？
- ISOLATION_DEFAULT：使用后端数据库默认的隔离级别
- ISOLATION_READ_UNCOMMITTED：允许读取未提交的数据变更，可能会导致脏读、幻读或不可重复读
- ISOLATION_READ_COMMITTED：允许读取未提交的数据，可以阻止脏读，但是幻读和不可重复读仍可能发生
- ISOLATION_REPEATABLE_READ：对同一字段多次读取结果是一样的，除非数据是被本事务修改，可以阻止脏读、幻读，但不可重复读仍可能发生。
- ISOLATION_SERIALIZABLE：完全服从ACID

#### 22. Spring 5新特性？
- JDK基准版本为8
- 响应式编程
- 函数式web框架
- Kotlin支持

#### 23. Spring加载bean的过程？
(1) 转换beanName<br>
beanName可能是别名，需要转换<br>
(2) 从缓存中加载实例<br>
一个实例在同一个容器中只会创建一次，再次获取的时候会尝试从缓存中获取，获取不到再从singletonFactories中加载<br>
(3) 实例化bean<br>
缓存中的bean是最原始的状态<br>
(4) 检测parentBeanFactory<br>
如果缓存中没有数据会到父类工厂去加载<br>
(5) 存储XML配置文件的GenericBeanDefinition转换成RootBeanDefinition<br>
(6) 初始化依赖的bean<br>
(7) 创建bean<br>
https://weknow619.iteye.com/blog/2367637

#### 24. Spring的事务传播机制？
7种类型的事务传播行为：

类型 | 说明
-|-
PROPAGATION_REQUIRED | 如果当前没有事务，就新建一个事务；如果已经存在一个事务，则加到这个事务中。最常见的选择
PROPAGATION_SUPPORTS | 支持当前事务，如果当前没有事务，就以非事务方式执行
PROPAGATION_MANDATORY | 使用当前的事务，如果没有事务，则抛出异常
PROPAGATION_REQUIRES_NEW | 新建事务，如果当前存在事务，则将事务挂起
PROPAGATION_NOT_SUPORTED | 以非事务方式执行，如果当前存在事务，则将事务挂起
PROPAGATION_NEVER | 以非事务方式执行，如果当前存在事务，则抛出异常
PROPAGATION_NESTED | 如果当前存在事务，则在嵌套事务内执行。如果没有事务，则执行与PROPAGATION_REQUIRED类型的操作



#### 100.
