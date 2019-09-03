# question-hibenate
some questions and answers for Hibernate.

#### 1. 什么情况下不建议使用hibernate？
数据量大、表关系复杂

#### 2. Hibernate的SessionFactory和Session是线程安全的吗？SessionFactory如何保证线程安全？？？
SessionFactory是线程安全的，Session不是。<br>
Session表示与数据库交互的一个单元，由SessionFactory创建。<br>
为避免创建太多session，可用ThreadLocal将session将当前线程绑定在一起，同一个线程获得的都是同一个session（Hibernate 3中SessionFactory的getCurrentSession()方法）

#### 3. Hibernate实体对象的三种状态（四种）？
瞬时态、持久态、游离态、移除态<br>
(1) 瞬时态（new/transient）：new一个实体对象后，处于瞬时态，只是保存在内存中，如果没有变量引用则会被垃圾回收机制回收，可以通过Session的save()、saveOrUpdate()、persist()、merge()插入到数据库中，变成持久态<br>
(2) 持久态（managed/persistent）：在数据库中有对应的记录，并拥有一个持久化标识（ID）。对持久态的对象执行delete后，会将数据库对应的记录删除，持久态变成移除态（或瞬时态）。持久态对象修改后，事务提交才会更新到数据库。<br>
(3) 游离态（detached）：session进行close、clear、evict、flush后，实体对象从持久态变成游离态

#### 4. 如何理解Hibernate的延迟加载机制？如何处理延迟加载和session关闭的矛盾？
不是在读取的时候就把数据加载进来，而是在实际使用的时候再加载。<br>
Hibernate使用虚拟代理的机制实现延迟加载，使用session的load方法，或者一对多的映射关系一的一方加载多的一方，得到的都是虚拟代理，返回的不是实体本身，而是实体对象的代理，代理对象在被调用getter方法的时候才会从数据库加载数据。<br>

加载数据需要连接数据库，而session关闭后相当于断开了数据库连接，二者存在矛盾。<br>
延迟加载和session关闭的矛盾处理方式：<br>
(1) 关闭延迟加载<br>
较简单。但出现这种矛盾说明存在外键关联，关闭延迟加载的话查询的开销会很大。<br>
(2) 在session关闭之前获取需要查询的数据<br>
使用hibernate的isInitialized方法判断对象是否已经加载，如果未加载则使用<br>
initialize方法、加载对象。<br>
(3) 使用拦截器或过滤器延长session的生命周期直到视图获得数据

#### 5. Hibernate的一级缓存、二级缓存和查询缓存？
(1) 一级缓存<br>
默认开启。修改持久化实体时不会立即提交到数据库，而是缓存在当前session中, 除非显式调用session的flush方法，通过这种方式可以减少与数据库的交互，提高程序性能。<br>
(2) 二级缓存<br>
默认关闭。开启并设置需要使用二级缓存的实体类，SessionFactory就会缓存访问过得实体类的每个对象。<br>
(3) 查询缓存<br>
默认关闭。一级缓存和二级缓存都是对整个实体进行缓存，如果需要缓存普通属性,可以使用查询缓存。查询缓存将HQL和SQL语句及查询结果作为键值对进行缓存，对于同样的查询可以从缓存中获取。

#### 6. Hibernate的SessionFactory的openSession和getCurrentSession的区别？
openSession | getCurrentSession
-|-
得到一个新的session对象 | 得到一个和当前线程绑定的session对象
需要手动关闭，手动提交 | 事务回滚或提交时自动关闭
不需要配置 | 需要配置<br>&lt;property name="current_session_context_class"&gt;thread&lt;/property&gt;

#### 7. Hibernate工作流程？
(1) 读取并解析配置文件（Configuration对象，hibernate.cfg.xml，\*.hbm.xml）<br>
(2) 读取并解析映射信息，创建SessionFactory（单例）<br>
(3) 打开Session（openSession()，getCurrentSession()，两种方式，question89）<br>
(4) 创建事务Transaction<br>
(5) 持久化操作<br>
(6) 提交事务<br>
(7) 关闭Session<br>
(8) 关闭SessionFactory

#### 8. Hibernate的查询方式有哪些？
(1) 对象导航查询<br>
(2) HQL查询<br>
 	   属性，参数，关联，分页，统计<br>
(3) Criteria查询<br>
(4) SQLQuery本地SQL查询<br>

#### 9. Hibernate关联关系？inverse属性？
关联关系有many-to-one，one-to-many，many-to-many。<br>

inverse属性的作用是让对方来维护关联管理，默认值是false，即双方都维护。<br>
如果是多对多的关系，建议只由一方来维护。<br>
如果是一对多的关系，只能由“一”的一方来维护。<br>

#### 10. Hibernate的get()和load()的区别？save()、update()、merge()、persist()、saveOrUpdate()？
get() | load()
-|-
立即查询 | 懒加载
没有找到会返回null | 没有找到会抛出异常
先查一级缓存，再查二级缓存，然后查数据库 | 先查一级缓存，没有找到就创建代理对象，等需要的时候去查二级缓存和数据库

save()和update？<br>
save()的作用是把一个新的对象保存。<br>
update()是把一个脱管状态的对象或自由态对象更新到数据库。

#### 11. Hibernate的主键生成策略有哪些？
(1) identity自增长（MySQL，DB2）<br>
(2) Sequence自增长序列（Oracle）<br>
(3) Native自增长（根据底层数据库自增长的方式选择identity或sequence）<br>
(4) Increment自增长（在集群中使用会有并发的问题）<br>
(5) 手动指定主键，assigned<br>
(6) UUID生成<br>
(7) Foreign外键

#### 12. 为什么Hibernate的实体类需要提供一个无参数的构造函数？
Hibernate框架使用Reflection API，通过Class.newInstance()来创建实体类的实例，如果找不到无参数的构造函数，会抛出InstantiationException异常。
