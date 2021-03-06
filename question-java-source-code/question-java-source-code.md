# question-java-source-code
some questions and answers for Java source code.

#### 1. BlockingQueue
LinkedBlockingQueue
```java
public class LinkedBlockingQueue<E> extends AbstractQueue<E> implements BlockingQueue<E>, java.io.Serializable {
    private final AtomicInteger count = new AtomicInteger(); // 当前元素个数
    private final int capacity; // 最大容量，构造时未指定则为Integer.MAX_VALUE
    private final ReentrantLock takeLock = new ReentrantLock();
    private final Condition notEmpty = takeLock.newCondition();
    private final ReentrantLock putLock = new ReentrantLock();
    private final Condition notFull = putLock.newCondition();

    public void put(E e) throws InterruptedException {
        int c = -1;
        Node<E> node = new Node<E>(e);
        final ReentrantLock putLock = this.putLock;
        final AtomicInteger count = this.count;
        putLock.lockInterruptibly();
        try {
            while (count.get() == capacity) { // 如果队列已满，在notFull条件上等待
                notFull.await();
            }
            enqueue(node);
            c = count.getAndIncrement(); // 这里的c是未添加元素时的数量
            if (c + 1 < capacity) { // 添加元素后仍未满，唤醒在notFull条件等待的某个线程
                notFull.signal();
            }
        } finally {
            putLock.unlock();
        }
        if (c == 0) { // 添加元素前个数为0，已有线程在notEmpty条件等待，需要唤醒
            signalNotEmpty();
        }
    }
}
```
![avator](image/question-java-source-code-001.png)

#### 2. Collection和Collections

#### 3. InputStream、OutputStream、Reader、Writer

#### 4. String，intern()方法，substring()方法不同版本的区别（1.6和1.7）
```java
public final class String implements java.io.Serializable, Comparable<String>, CharSequence {
    private final char[] value; // 将string的值保存在char数组中
    public native String intern(); // 使用C++实现的native方法

    public String(String original) {
        this.value = original.value;
        this.hash = original.hash;
    }

    public String(char[] value) {
        this.value = Arrays.copyOf(value, value.length);
    }

    public String(StringBuffer buffer) {
        synchronized(buffer) {
            this.value = Arrays.copyOf(buffer.getValue(), buffer.length());
        }
    }

    public String(StringBuilder builder) {
        this.value = Arrays.copyOf(builder.getValue(), builder.length());
    }

    public boolean equals(Object anObject) {
        if (this == anObject) {
            return true;
        }
        if (anObject instanceof String) {
            String anotherString = (String)anObject;
            int n = value.length;
            if (n == anotherString.value.length) {
                char v1[] = value;
                char v2[] = anString.value;
                int i = 0;
                while (n-- != 0) { // 逐个比较两个string的char字符
                    if (v1[i] != v2[i]) {
                        return false;
                    }
                    i++;
                }
                return true;
            }
        }
        return false;
    }

    public int hashcode() {
        int h = hash;
        if (h == 0 && value.length > 0) {
            char val[] = value;
            for (int i = 0; i < value.length; i++) {
                h = 31 * h + val[i]; // 31是大小适中的质数；31 = 32 - 1，方便位移运算
            }
            hash = h;
        }
        return h;
    }
}
```

#### 5. StringBuilder和StringBuffer
```java
public final class StringBuffer extends AbstractStringBuilder implements Serializable, CharSequence {
    @Override
    public synchronized StringBuffer append(Object obj) { // 同步的方法
        toStringCache = null;
        super.append(String.valueOf(obj));
        return this;
    }

    @Override
    public synchronized StringBuffer append(String str) { // 同步的方法
        toStringCache = null;
        super.append(str);
        return this;
    }
}
```
```java
public final class StringBuilder extends AbstractStringBuilder implements Serializable, CharSequence {
    @Override
    public StringBuilder append(Object obj) {
        return append(String.valueOf(obj));
    }

    @Override
    public StringBuilder append(String str) {
        super.append(str);
        return this;
    }
}
```
#### 5. Properties

#### 6. Queue和Stack

#### 7. HashMap, ConcurrentHashMap(Java 8), WeakHashMap
```java
public class HashMap<K, V> extends AbstractMap<K, V> implements Map<K, V>, Cloneable, Serializable {
    static final int DEFAULT_INITIAL_CAPACITY = 1 << 4; // 16
    static final int MAXIMUM_CAPACITY = 1 << 30;
    static final float DEFAULT_LOAD_FACTOR = 0.75f;
    static final int TREEIFY_THRESHOLD = 8; // 从列表转换为树的阈值
    static final int UNTREEIFY_THRESHOLD = 6; // 从树转换为列表的阈值
    static final int MIN_TREEIFY_CAPACITY = 64;

    static class Node<K, V> implements Map.Entry<K, V> {
        //
    }

    transient Node<K, V>[] table;
    transient Set<Map.Entry<K, V>> entrySet;
    transient int size;
    transient int modCount;
    int thrshold;
    final float loadFactor;

    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16); // 高16位不变，低16位与高16位异或
    }

    public V get(Object key) {
        Node<K, V> e;
        return (e == getNode(hash(key), key)) == null ? null: e.value;
    }

    final Node<K, V> getNode(int hash, Object key) {
        //
    }

    public V put(K key, V value) {
        return putVal(hash(key), key, value, false, true);
    }

    final V putValue(int hash, K key, V value, boolean onlyIfAbsent, boolean evict) {
        //
    }

    final Node<K, V>[] resize() {
        //
    }

    final void treeifyBin(Node<K, V>[] tab, int hash) {
        //
    }
}
```
```java
public class ConcurrentHashMap<K, V> extends AbstractMap<K, V> implements ConcurrentMap<K, V>, Serializable {
    //
}
```

#### 8. TreeMap，和HashMap的区别
```java
// 实现了Navigable接口，该接口继承了SortedMap接口，元素是有序的
public class TreeMap<K, V> extends AbstractMap<K, V> implements NavigableMap<K, V>, Cloneable, Serializable {
    //
}
```

#### 8. TreeSet, HashSet, LinkedHashSet
```java
public class TreeSet<E> extends AbstractSet implements NavigableSet<E>, Cloneable, Serializable {
    private transient NavigableMap<E, Object> m; // 用来存储元素的map，不一定是TreeMap
    private static final Object PRESENT = new Object(); // 虚拟的对象，用来作为value放到map中
}
```
```java
public class HashSet<E> extends AbstractSet<E> implements Set<E>, Cloneable, Serializable {
    private transient HashMap<E, Object> map; // 使用HashMap来存储元素
    private static final Object PRESENT = new Object(); // 虚拟的对象，用来作为value放到map中
    HashSet(int initialCapacity, float loadFactor, boolean dummy) { // 被LinkedHashSet构造时调用
        map = new LinkedHashMap<>(initialCapacity, loadFactor);
    }
}
```
```java
public class LinkedHashSet<E> extends HashSet<E> implements Set<E>, Cloneable, Serializable {
    //
}
```
```java
public interface NavigableMap<E> extends SortedMap<E> {
    //
}
```
```java
public interface SortedMap<E> extends Set<E> {
    //
}
```


#### 8. Runtime

#### 9. TreeList（Apache）

#### 10. Arrays（copyOf方法）

#### 11. BigInteger，如何使用位运算实现算数运算

#### 12. Hibernate，缓存，getCurrentSession()，ThreadLocal使用

#### 14. CopyOnWriteArrayList
volatile修饰的数组，写入后对其他线程立即可见。
```java
public class CopyOnWriteArrayList<E> implements List<E>, RandomAccess, Cloneable, java.io.serializable {
    final transient ReentrantLock lock = new ReentrantLock();
    private transient volatile Object[] array;
    public boolean add(E e) {
        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            Object[] elements = getArray();
            int len = elements.length;
            Object[] newElements = Arrays.copyOf(elements, len + 1); // 复制原来的数组
            newElements[len] = e;
            setArray(newElements); // 设置array变量，该变量用volatile修饰，对其他线程可见
            return true;
        } finally {
            lock.unlock();
        }
    }
}
```

#### 15. Spring，getBean()方法如何实现单例

#### 16. ArrayList，ConcurrentModificationException异常

#### 17. ThreadLocal

#### 18. Integer IntegerCache
```java
public final class Integer extends Number implements Comparable<Integer> {
    private static class IntegerCache { // 静态内部类
        static final int low = -128;
        static final int high;
        static {
            int h = 127;
        }
    }
}

```

#### 19. Iterator

#### 20. Comparable和Comparator
```java
public interface Comparable<T> {
    public int compareTo(T o);
}
```
```java
@FunctionalInterface
public interface Comparator<T> {
    int compare(T o1, T o2);
    boolean equals(Object obj);

}
```
Comparable是排序接口，一个类实现了Comparable接口，意味着该类支持排序。<br>
Comparator是比较器，如果需要控制某个类的顺序，可以建立一个该类的比较器来排序。<br>
Comparable相当于内部比较器，Comparator相当于外部比较器。

#### 21. MyBatis设计模式
Builder模式
```java
public class SqlSessionFactoryBuilder {
    // build方法1
    public SqlSessionFactory build(Reader reader) {
        return this.build(reader, (String)null, (Properties)null);
    }
    // build方法2
    public SqlSessionFactory build(Reader reader, String environment, Properties props) {
        SqlSessionFactory var6;
        try {
            XMLConfigBuilder parser = new XMLConfigBuilder(reader, environment, props);
            Configuration config = parser.parse();
            var6 = this.build(config);
        } catch (Exception var15) {
            throw ExceptionFactory.wrapException("Error building SqlSession.", var15);
        } finally {
            ErrorContext.instance().reset();
            try {
                reader.close();
            } catch (IOException var14) {
                // 捕获之后不做任何处理？？？
            }
        }
    }
    // build方法3
    public SqlSessionFactory build(Configuration config) {
        return new DefaultSqlSessionFactory(config);
    }
}
```
```java
public class XMLConfigBuilder extends BaseBuilder {
    private boolean parsed; // 记录是否解析过，只能解析一次
    // 解析得到Configuration对象
    public Configuration parse() {
        if (this.parsed) {
            throw new BuilderException("each MapperConfigParser can only be used once.")
        } else {
            this.parsed = true;
            this.parseConfiguration(this.parser.evalNode("/configuration")); // 根节点是configuration
        }
    }
    // 解析配置文件的第一级节点
    private void parseConfiguration(XNode root) {
        try {
            // 依次解析xml配置文件的第一层节点，因此第一层配置项需要注意顺序
            this.typeAliasesElement(root.evalNode("typeAliases"));
            this.pluginElement(root.evalNode("plugins"));
            /**
            objectFactory
            objectWraperFactory
            properties
            settings
            environments
            typeHandlers
            **/
            this.mapperElement(root.evalNode("mappers"))
        } catch (Exception var3) {
            throw new BuilderException("errpr parsing sql mapper configuration");
        }
    }
}
```
工厂模式
```java
public class DefaultSqlSessionFactory implements SqlSessionFactory {
    private SqlSession openSessionFromDataSource(ExecutorType execType, TransactionIsolationLevel level, boolean autoCommit) {
        DefaultSqlSession var10;
        try {
            Environment environment = this.configuration.getEnvironment();
            DataSource dataSource = this.getDataSourceFromEnvironment(environment);
            TransactionFactory transactionFactory = this.getTransactionFactoryFromEnvironment(environment);
            Connection connection = dataSource.getConnection();
            if (level != null) { // 设置隔离级别
                connnection.setTransactionIsolation(level.getLevel());
            }
            connection = this.wrapConnection(connection);
            Transaction tx = transactionFactory.newTransaction(connection, autoCommit);
            Executor executor = this.configuration.newExecutor(tx, execType);
            var10 = new DefaultSqlSession(this.configuration, executor, autoCommit);
        } catch (SQLException var14) {
            throw ExceptionFactory.wrapException("error opening session, cause:", var14);
        } finally {
            ErrorContext.instance().reset();
        }
        return var10;
    }
}
```
单例模式
```java
public class ErrorContext {
    private static final ThreadLocal<ErrorContext> LOCAL = new ThreadLocal(); // 将实例保存到ThreadLocal中
    private ErrorContext() {} // 私有的构造方法
    public static ErrorContext instance() {
        ErrorContext context = (ErrorContext)LOCAL.get();
        if (context == null) {
            context = new ErrorContext();
            LOCAL.set(context);
        }
        return context;
    }
}
```
代理模式
```java
public class MapperRegistry {
    private Set<Class> knownMappers = new HashSet<>();
    public <T> T getMapper(Class<T> type, SqlSession sqlSession) {
        if (!this.knownMappers.contains(type)) {
            throw new BindingException("Type" + type + "is not known to MapperRegistry");
        } else {
            try {
                return MapperProxy.newMapperProxy(type, sqlSession);
            } catch (Exception var4) {
                throw new BindingException("Error getting mapper instance, casuse:" + var4, var4);
            }
        }
    }
}
```
```java
public class MapperProxy implements InvocationHandler {
    private static final Set<String> OBJECT_METHODS = new HashSet<String>() {
        {
            this.add("toString");
            this.add("getClass");
            this.add("equals");
            this.add("hashCode");
            this.add("wait");
            this.add("notify");
            this.add("notifyAll");
        }
    };

    public static <T> T new MapperProxy(Class<T> mapperInterface, SqlSession sqlSession) {
        ClassLoader classLoader = mapperInterface.getClassLoader();
        Class[] interfaces = new Class[]{mapperInterface};
        MapperProxy mapperProxy = new MapperProxy(sqlSession);
        return Proxy.newProxyInstance(classLoader, interfaces, mapperProxy);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        try {
            if (!OBJECT_METHODS.contains(method.getName())) {
                Class declaringInterface = this.findDeclaringInterface(proxy, method);
                MapperMethod mapperMethod = new MapperMethod(declaringInterface, method, this.sqlSession);
                Object result = mapperMethod.execute(args);
                if (result == null && method.getReturnType().isPrimitive()) {
                    throw new BindingException();
                }
                return result;
            }
        } catch (SqlException var7) {
            var7.printStackTrace();
        }
    }
    private Class findDeclaringInterface(Object proxy, Method method) {
        //
    }
}
```
```java
public class MapperMethod {
    //
}
```
组合模式（动态sql）
```java
public interface SqlNode {
    boolean apply(DynamicContext var1);
}
public class ChooseSqlNode implements SqlNode {}
public class ForEachSqlNode implements SqlNode {}
public class IfSqlNode implements SqlNode {}
public class MixedSqlNode implements SqlNode {}
public class SetSqlNode implements SqlNode {}
public class TextSqlNode implements SqlNode {}
public class TrimSqlNode implements SqlNode {}
public class WhereSqlNode implements SqlNode {}
```
模板方法模式<br>
适配器模式（日志）
```java
public interface Log {
    boolean isDebugEnabled();
    void error(String var1, Throwable var2);
    void error(String var1);
    void debug(String var1);
    void warn(String var1);
}
```
```java
public class Log4jImpl implements Log {
    private Logger log;
    public Log4jImpl(Class clazz) {
        this.log = Logger.getLogger(clazz);
    }
    public boolean isDebugEnabled() {
        return this.log.isDebugEnabled();
    }
}
```
装饰器模式<br>
迭代器模式

#### 22. Lock, ReentrantLock,
```java
public interface Lock {
    void lock();
    void lockInterruptibly() throws InterruputedException;
    boolean tryLock();
    boolean tryLock(long time, TimeUnit unit) throws InterruptedException;
    void unlock();
    Condition newCondition();
}
```
```java
public class ReentrantLock implements Lock, Serializable {
    private final ReentrantLock.Sync sync;
    public ReentrantLock() {
        this.sync = new ReentrantLock.NonfairSync(); // 默认的是非公平锁
    }
    public ReentrantLock(boolean var1) { // 重载构造函数，可传入参数指定公平/非公平
        this.sync = (ReentrantLock.Sync)(var1 ? new ReentrantLock.FairSync() : new ReentrantLock.NonfairSync());
    }
    abstract static class Sync extends AbstractQueuedSynchronizer {}
    static final class FairSync extends ReentrantLock.Sync {}
    static final class NonfairSync extends ReentrantLock.Sync {}
}
```
![avator](image/question-java-source-code-022.png)

#### 23. AbstractQueuedSynchronizer，抽象队列同步器（应用：CountDownLatch, Semephore, ThreadPoolExecutor, ReentrantLock, ReentrantReadWriteLock）
```java
public abstract class AbstractQueuedSynchronizer extends AbstractOwnableSynchronizer implements java.io.Serializable {}
```

#### 24. ThreadPoolExecutor, Executors, ExecutorService
```java
public class ThreadPoolExccutor extends AbstractExecutorService {
    // 32位，前3位记录线程池状态，后29位记录线程数量
    private final AtomicInteger ctl = new AtomicInteger(ctlOf(RUNNING, 0));
    // 用于位运算的位数，32-3=29
    private static final COUNT_BITS = Integer.SIZE - 3;
    // 容量 536870911
    private static final CAPACITY = (1 << COUNT_BITS) - 1;
    // 1110 0000 0000 0000 0000 0000 0000 0000 运行中，最高三位111
    private static final int RUNNING = -1 << COUNT_BITS;
    // 0000 0000 0000 0000 0000 0000 0000 0000 关闭，最高三位000
    private static final int SHUTDOWN = 0 << COUNT_BITS;
    // 0010 0000 0000 0000 0000 0000 0000 0000 停止，最高三位001
    private static final int STOP = 1 << COUNT_BITS;
    // 0100 0000 0000 0000 0000 0000 0000 0000 整理，最高三位010
    private static final int TIDYING = 2 << COUNT_BITS;
    // 0110 0000 0000 0000 0000 0000 0000 0000 终止，最高三位011
    private static final int TERMINATED = 3 << COUNT_BITS;
    // 获取线程池状态，截取前三位
    private static int runStateOf(int c) { return c & ~CAPACITY; }
    // 获取线程个数，截取后29位
    private static int workerCountOf(int c) { return c & CAPACITY; }
    private static int ctlOf(int rs, int wc) { return rs | wc; }

    private final BlockingQueue<Runnable> workQueue; // 阻塞队列，存放待执行的任务
    private int largestPoolSize; // 曾经达到的最大线程数，小于等于maximumPoolSize
    private ThreadFactory threadFactory;
    private RejectedExecutionHandler handler;
    private volatile long keepAliveTime; // 一个线程执行完后不立即结束，而是等待一段时间去执行新的任务
    private volatile int corePoolSize; // 核心线程数
    private volatile int maximumPoolSize; // 最大线程数
    private static final RejectedExecutionHandler defaultHandler = new AbortPolicy(); // 拒绝策略

    private final class Worker extends AbstractQueuedSynchronizer implements Runnable {
        //
    }

    // 没有传入ThreadFactory和RejectedExecutionHandler
    public ThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        this(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, Executors.defaultThreadFactory(), defaultHandler);
    }

    // 没有传入RejectedExecutionHandler
    public ThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory) {
        this(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, defaultHandler);
    }

    // 没有传入ThreadFactory
    public ThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, RejectedExecutionHandler handler) {
        this(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, Executors.defaultThreadFactory, handler);
    }

    public ThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory, RejectedExecutionHandler handler) {
        if (corePoolSize < 0 || maximumPoolSize <= 0 || maximumPoolSize < corePoolSize || keepAliveTime < 0) { // 检查最小线程数和最大线程数
            throw new IllegalArgumentException();
        }
        if (workQueue == null || threadFactory == null || handler == null) {
            throw new NullPointerException();
        }
        this.acc = System.getSecurityManager() == null ? null : AccessController.getContext();
        this.corePoolPoolSize = corePoolSize;
        this.maximumPoolSize = maximumPoolSize;
        this.workQueue = workQueue;
        this.keepAliveTime = util.tuNanos(keepAliveTime);
        this.threadFactory = threadFactory;
        this.handler = handler;
    }

    public void execute(Runnable command) {
        if (command == null) {
            throw new NullPointerException();
        }
        int c = ctl.get();
        if (workerCountOf(c) < corePoolSize) { // 当前线程数小于核心线程数，创建新线程运行任务
            if (addWorker(command, true)) { // 创建新线程成功，返回
                return;
            }
            c = ctl.get();
        }
        if (isRunning(c) && workQueue.offer(command)) { // 线程池处于RUNNING状态，往队列中添加任务
            int recheck = ctl.get();
            if (!isRunning(recheck) && remove(command)) { // 线程池不是RUNNING状态，则从队列中删除任务，并拒绝
                reject(command);
            } else if (workerCountOf(recheck) == 0) { // 线程池为空，则添加创建一个线程
                addWorker(null, true);
            }
        } else if (!addWorker(command, false)) { // 往队列中添加失败（队列已满？），创建新线程执行任务。创建失败（线程池已满？）则拒绝
            reject(command);
        }
    }

    private boolean addWorker(Runnable firstTask, boolean core) {
        //
    }

    final void runWorker(Worker w) {
        //
    }

    private Runnable getTask() {
        //
    }
}
```
![avator](image/question-java-source-code-024.png)

#### 25. SpringBoot
```java
@Target(ElementType.Type)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan(excludeFilters = {
    @Filter(type = FilterType.CUSTOM, classes = TypeExcludeFilter.class),
    @Filter(type = FilterType.CUSTOM, classes = AutoConfigurationExculdeFilter.class)
})
public @interface SpringBootApplication {
    //
}
```
```java
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Configuration
public @interface SpringBootConfiguration {
    //
}
```

#### 26. 注解
```java
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.ANNOTATION_TYPE)
public @interface Retention {
    RetentionPolicy value();
}
```
```java
public enum RetentionPolicy {
    SOURCE, // 保留在源码
    CLASS, // 保留在编译后的class文件
    RUNTIME // 保留至运行时，可以被反射读取
}
```
```java
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.ANNOTATION_TYPE)
public @interface Target {
    ElementType[] value();
}
```
```java
public enum ElementType {
    TYPE,
    FIELD,
    METHOD,
    PARAMETER,
    CONSTRUCTOR,
    LOCAL_VARIABLE,
    ANNOTATION_TYPE,
    PACKAGE,
    TYPE_PARAMETER
}
```
```java
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.ANNOTATION_TYPE)
public @interface Documented {}
```



#### 100.
