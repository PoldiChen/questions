# question-java-source-code
some questions and answers for Java source code.

#### 1. BlockingQueue
![avator](image/question-java-source-code-001.png)

#### 2. Collection和Collections

#### 3. InputStream、OutputStream、Reader、Writer

#### 4. String，substring()方法，不同版本的区别（1.6和1.7）

#### 5. Properties

#### 6. Queue和Stack

#### 7. WeakHashMap

#### 8. Runtime

#### 9. TreeList（Apache）

#### 10. Arrays（copyOf方法）

#### 11. BigInteger，如何使用位运算实现算数运算

#### 12. Hibernate，缓存，getCurrentSession()，ThreadLocal使用

#### 13. ConcurrentHashMap（Java 8）

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

#### 18. Integer

#### 19. Iterator
