# question-java-jvm
some questions and answers for Java Virtual Machine.

#### 1. 堆内存溢出和栈内存溢出？
堆溢出包括内存泄露和内存溢出。<br>
内存泄露是指无用的对象没有被回收，一直积累；<br>
内存溢出是指程序需要的内存大于虚拟机分配的内存。<br>

栈主要存放栈帧，局部变量表、操作数栈、动态链接、方法出口信息。<br>
栈相关的内存异常包括StackOverFlowError（方法调用次数太多，栈内存不够新建栈帧，比如递归的层次太多）和OutOfMemoryError（线程太多，栈内存不够新建线程）。

#### 2. 32位JVM和64位JVM的最大堆内存分别是多少？
32位堆内存2^32，4GB，寻址的基本单位是B，2^32=4G<br>
64位堆内存2^64。受限于物理内存和操作系统提供的虚拟内存。<br><br>
32位JVM的程序迁移到64位JVM上，性能会损失10%~20%<br>
JVM虚拟机规范包括JIT编译器和垃圾回收，字节码更小更容易编译？？？指针越大GC管理越困难？？？

#### 3. 垃圾回收Serial GC和Parallel GC的区别？Minor GC、Major GC、Full GC的区别？并行收集器和并发收集器？
都会引起stop-the-world。<br>
Serial是默认的收集器，执行GC的时候只有一个线程；<br>
Parallel收集器使用多个线程。<br>
可以通过JVM参数设置：-XX:+UseSerialGC，或者：-XX:+UseParNewGC<br>

Minor GC：从年轻代空间（包括Eden和Survivor）回收内存，不会影响到永久代。<br>
Major GC：清理老年代，由Full GC触发，也会引起stop-the-world。<br>
Full GC：清理整个堆空间，包括年轻代和老年代。<br>

Minor GC触发条件：Eden区满。<br>
Full GC触发条件：<br>
(1) 调用System.gc()，系统建议执行Full GC，但不一定会执行。<br>
(2) 老年代空间不足<br>
(3) 方法区空间不足<br>
(4) 通过Minor GC后进入老年代的平均大小>老年代的可用空间<br>
(5) 由Eden区、From Space区向To Space区复制时，对象大小>To Space区可用空间，则把该对象转到老年代，且老年代可用的空间小于该对象大小。<br>
(6) 在堆中分配很大的对象

SerialGC: 使用简单的标记、清除、压缩方法对年轻代和老年代进行垃圾回收，即Minor GC和Major GC。<br>
Parallel Old GC：和Parallel GC类似，不同的是在对年轻代和老年代进行回收的时候都使用多线程。<br>

并行收集器（Parallel Collector, Throughput Collector）：使用多线程（线程数为系统CPU的核数）的方式，利用多CPU提高GC的效率，以达到一定吞吐量为目标。用户线程处于等待状态。在进行老年代垃圾回收时使用单线程。<br>
并发收集器（Concurrent Low Pause Colllector）：垃圾回收线程和用户线程同时执行。<br>
CMS收集器（Concurrent Mark Sweep，老年代收集器）：以获取最短回收停顿时间为目的，基于标记-清除算法。<br>
G1收集器（Garbage-First）：垃圾收集器的最新成果，不区分年轻代和老年代，将堆分成多个大小相等的独立区域（Region），跟踪各个区域的垃圾堆积的价值大小，维护一个优先级表，优先回收价值最大的区域。

Java 7引入了G1 GC替代CMS GC，Java 9中G1 GC为默认。

#### 4. 什么是Java内存模型？code
a) 程序计数器<br>
一个数据结构，用于保存当前正在执行的程序的内存地址。<br>
Java虚拟机的多线程就是通过线程轮流切换并分配处理器时间来实现的，为了线程切换后能恢复到原来的位置，每个线程需要一个独立的程序计数器，该区域为线程私有。<br>
在Java虚拟机规范中唯一没有规定OutOfMemoryError的区域。<br>

b) 虚拟机栈<br>
线程私有，与线程生命周期相同，用于存储局部变量表，操作栈，方法返回值。<br>
局部变量表存放基本数据类型和对象的引用。<br>
当栈的调用深度大于JVM虚拟机允许的范围，会抛出StackOverflowError错误，这个深度不是一个固定的值。<br>
动态扩展时无法申请足够的内存，会抛出OutOfMemoryeError。

c) 本地方法栈<br>
和虚拟机栈很像，为虚拟机使用的Native方法服务。<br>
也会抛出StackOverflowError和OutOfMemoryError。<br>

d) Java堆<br>
虚拟机中最大的一块内存，所有线程共享的内存区域，存放对象实例。<br>
垃圾收集器管理的主要区域。<br>
申请不到空间时会抛出OutOfMemoryError。<br>

e) 方法区<br>
各个线程共享的区域。<br>
存储虚拟机加载的类信息、常量、静态变量，编译后的代码。

f) 运行时常量池<br>
运行时每个class文件中的常量表，包括编译时的数字常量、方法、	域的引用。

Java内存模型定义了一种多线程访问Java内存的规范。主要有几个部分：<br>
(1) 将内存分为主内存和工作内存。<br>
类的状态存储在主内存中，即类之间共享的变量。<br>
线程需要使用这些变量的时候，从主存中读取，并在自己的工作内存拷贝一份。<br>
操作这些变量的时候操作的是自己工作内存的那一份。<br>
执行完后将最新的值更新到主内存中。<br>
(2) 定义了几个原子操作，用于操作主内存和工作内存中的变量。<br>
(3) 定义了volatile变量的使用规则<br>
(4) happens-before，即先行发生原则。

#### 5. Java垃圾回收GC的时机，具体做了什么事情？
- 应用程序空闲（没有应用线程在运行）的时候
- 堆内存不足的时候

(1) 虚拟机内存分为新生代、老年代、永久代三部分。<br>
(2) 新生代有一个Eden区和两个Survivor区（Eden和Survivor比例8:1:1），首先将对象放入Eden区，如果空间不足就往其中一个Survivor区放，如果仍然不足就会引发一次新生代的minor GC，将存活的对象放入另一个Survivor区，然后清空Eden区和原来那个Survivor区的内存。在某次GC的过程中，发现仍然后放不下的对象，就将这些对象放入到老年代中。<br>
(3) 大对象及长期存活的对象直接放入老年区中。<br>
(4) 每次执行Minor GC的时候对晋升到老年代的对象进行分析，如果这些对象大小超过了老年区的剩余大小，那么执行一次Full GC以尽可能的获得老年区的空间。<br>
(5) 回收的对象：从GC Roots搜索不到，而且经过一次标记清理之后仍然没有复活的对象。<br>
(6) 操作<br>
新生代：复制清理<br>
老年代：标记-清除和标记-压缩算法<br>
永久代：存放Java中的类和加载类的类加载器本身<br>
(7) GC Roots有哪些：<br>
虚拟机栈中的引用的对象<br>
方法区中静态属性引用的对象<br>
方法区中常量引用的对象<br>
本地方法栈中JNI（Native方法）引用的对象<br>
活跃线程的引用对象<br>
方法的参数或者方法中的局部变量

#### 6.Java 8和Java 9的内存模型，有什么新的地方？？？
Java 8取消了永久代，新增了元空间（MetaSpace），使用的是物理内存。

#### 7. 类加载器的工作机制？
(a) 装载：通过类的全限定名获取二进制字节流，将二进制字节流转换成方法区中的运行时数据结构，在内存中生成java.lang.Class对象。<br>
(b) 链接：<br>
   &emsp;&emsp;(1) 校验：检查载入class文件数据的正确性<br>
   &emsp;&emsp;(2) 准备：给类的静态变量分配存储空间<br>
   &emsp;&emsp;(3) 解析：将常量池中的符号引用转成直接引用<br>
(c) 初始化：对类的静态变量、静态方法和静态代码块执行初始化

#### 8. 什么情况下会发生栈内存溢出？
如果线程请求的栈深度大于虚拟机所允许的最大深度，会抛出StackOverflowError异常。<br>
如果虚拟机在动态扩展栈时无法申请到足够的内存空间，则抛出OutOfMemoryError异常。

#### 9. 类装载的显式方式和隐式方式？
隐式装载：程序运行时遇到new方式创建对象时，隐式调用类装载器加载对应的类到JVM中。<br>
显式装载：显式加载需要的类。
```java
class.forName();
```

#### 10. Java垃圾回收的算法？<br>
(1) 标记回收法<br>
遍历对象图并记录可到达的对象，以便删除不可到达的对象，一般使用单线程工作，可能产生内存碎片。<br>
(2) 标记-压缩回收法<br>
前期和第一种算法一样，多了一步，将所有存活的对象压缩到内存的一端，这样内存碎片就可以合成一大片可再利用的内存区域，提高了内存利用率。<br>
(3) 复制回收法<br>
将现有内存分成两部分，GC的时候将可到达的对象复制到另一半空间，清空正在使用的一半空间的全部对象。可用的内存只有一半。<br>
适合短生存期的对象，持续复制长生存期的对象会导致效率降低。<br>
(4) 分代回收法<br>
将内存空间分成两个或多个区域，如年轻代和老年代。<br>
年轻代的特点是对象很快会被回收，因此使用效率较高的复制回收法。<br>
当一个对象经过几次回收后仍然存活，就会被放入老年代，老年代使用标记-压缩算法。<br>
年轻代分为Eden，Survivor from和Survivor to三个区域，比例是8:1:1，from和to有一个区域是空白的，Eden和一个Survivor区域为新创建的对象分配内存，年轻代需要回收时，将存活的对象复制到空白的survivor区，存放不下的复制到老年代，创建大对象时同样复制到老年代。<br>
(5) 引用计数法<br>
最简单古老的的方法，将资源（对象、内存或磁盘空间）的被引用次数保存起来，引用次数为0的时候就释放。<br>
(6) 对象引用遍历法<br>
现在大多数JVM使用的算法，从一组根对象（GC Roots）开始，沿着整个对象图的每条链接，递归确定可到达（reachable）的对象，如果某个对象不能从这些根对象到达，则标记为回收。

#### 11. Java垃圾回收统计？
```
jstat -gc $pid 1000
```
S0C：第一个survivor区的大小<br>
S1C：第二个survivor区的大小<br>
S0U：第一个survivor区使用的大小<br>
S1U：第二个survivor区使用的大小<br>
EC：Eden区的大小<br>
EU：Eden区使用的大小<br>
OC：老年代的大小<br>
OU：老年代使用的大小<br>
MC：方法区的大小<br>
MU：方法区使用的大小<br>
CCSC：压缩类空间的大小<br>
CCSU：压缩类空间使用的大小<br>
YGC：年轻代垃圾回收的次数<br>
YGCT：年轻代垃圾回收的耗时<br>
FGC：Full GC的次数<br>
FGCT：Full GC的耗时<br>
GCT：垃圾回收总耗时<br>

![avatar](image/question-java-jvm-011.png)

#### 11. 内存中的栈（stack）、堆（heap）、方法区（method area）？
栈保存基本数据类型变量、对象的引用、函数调用现场；<br>
堆保存new关键字和构造器创建的对象，堆是垃圾收集的主要区域，可以分为新生代和老年代；<br>
方法区和堆都是各个线程共享的内存区域，用于存储已经被JVM加载的类信息、常量、静态变量、JIT编辑器编译后的代码。<br>
常量池是方法区的一部分。<br>

栈空间操作起来最快但是空间很小，通常大量的对象都放在堆空间，栈和堆的大小可以通过JVM的启动参数来调整。<br>
栈空间用完了会引发StackOverflowError，堆和常量池空间不足会引发OutOfMemoryError。

#### 12. Java内存模型的PermGen（永久代）和Metaspace（元空间）？code
HotSpot虚拟机使用PermGen来实现方法区，方法区是虚拟机的一个规范。<br>
永久代主要存放类定义、字节码和常量等很少会变更的信息。<br>
永久代也是会被回收，如果满了或者超过临界值，会触发Full GC。

从JDK 1.8开始，HotSpot虚拟机取消PermGen，取而代之的是Metaspace（元空间）。字符串常量从永久代转移到堆内存中。<br>
元空间和永久代都是对方法区的实现，不同的是元空间不在虚拟机中，而是使用本地内存，默认情况下，元空间只受本地内存大小限制。

#### 13. 反射中，Class.forName和ClassLoader.loadClass的区别？加载数据库驱动为什么用Class.forName()？？？（question 147 类加载过程）
```java
Class.forName(className);
Class.forName(className, true, classLoader);
```
内部调用的是Class.forName(className, true, classLoader);<br>
第二个参数表示是否需要初始化（执行static代码块，设置static变量值），默认是true。<br>
```java
ClassLoader.loadClass(className);
ClassLoader.loadClass(className, false);
```
内部去调用的是ClassLoader.loadClass(className, false);<br>
第二个参数表示是否需要进行链接，默认为false。<br>

动态加载一个类时，如果有静态代码块或静态变量，而且想在加载的时候初始化，应该使用Class.forName()。<br>
DriverManager中有一段需要执行的static代码块，用Class.forName(“com.mysql.DriverManager”);调用才能令其执行。

#### 14. 32位/64位的操作系统？CPU？JVM？？？
32位操作系统只能安装32位的JVM，64位的操作系统两种JVM都可以安装。<br>
只有Server VM支持64位，Client VM不支持。？？？

#### 15. 内存溢出实例？hprof文件分析？？？《深入理解Java虚拟机》code
除了程序计数器，虚拟机其他内存区域都可能发生内存溢出，OutOfMemoryError。<br>
堆内存溢出：不断创建对象<br>
虚拟机栈溢出：线程请求的栈深度大于虚拟机允许的最大深度、申请的空间不足<br>
本地方法栈溢出：创建线程（调用本地方法）<br>
本机内存溢出：不断申请空间<br>
方法区（永久代）溢出：不断创建字符串常量<br>

#### 16. Java虚拟机的锁粗化？？？
一般来说同步的范围越小越好，效率越高，但Java虚拟机中有一种“锁粗化”的优化方法，把同步范围变大。<br>
比如线程安全的StringBuffer，append()方法是同步的，反复的append字符串的时候需要反复的加锁解锁，对性能不利，因为虚拟机需要在这条线程上反复在内核态和用户态之间切换。<br>
虚拟机会将多个append方法的调用进行锁粗化操作，将多个的append的操作扩展至append方法的首尾，变成一个大的同步块，减少加锁解锁的次数，提升执行效率。

#### 17. JVM的内存分配规则？
(1) 基本数据类型和对象的引用在栈分配。<br>
(2) 堆内存存放new的对象和数据，不一定是连续的，通过哈希算法得到一串数字，表示其地址。<br>
(3) 程序加载的时候就在堆中为类变量分配内存，堆中的内存地址放在栈中。<br>
(4) 局部变量，执行的时候在栈中分配内存，脱离了作用域立即回收。

#### 18. 对象创建的流程？堆内存分配方式？《深入理解Java虚拟机》
(1) 检查指令的参数能否在常量池中定位到一个类的符号引用<br>
(2) 检查是否已经加载解析和初始化<br>
(3) 从堆内存中划分区域分配给新生对象，使用CAS+失败重试保证分配的原子性（分配内存、修改指针，操作不是原子性的）<br>
(4) 将内存空间初始化为零值<br>
(5) 设置，类名、类的元数据、对象的hashCode、对象的GC分代等<br>
(6) 执行<init>方法

指针碰撞：堆内存是规整的，用过的在左边，没用过的在右边，中间指针指向临界点，则只需向右移动指针即可。<br>
空闲列表：堆内存不规整，需要维护一个列表记录可用的内存块，分配时从列表中找出一块足够大的区域。

#### 19. 对象的内存布局？？？《深入理解Java虚拟机》
对象头、实例数据、对齐填充
压缩指针，内存对齐。。。

#### 20. Class类文件的结构？《深入理解Java虚拟机》
魔数与Class文件的版本<br>
常量池<br>
访问标志<br>
类索引、父类索引、接口索引集合<br>
字段表集合<br>
方法表集合<br>
属性表集合

#### 21. 虚拟机性能监控工具
##### jps
和ps类似，列举正在运行的虚拟机进程并显示虚拟机执行的主类以及进程的ID。
```
jps -l
```
##### jstat
监控虚拟机的运行状态，如类的装载、内存、垃圾回收、JIT编译器等.<br>
可选项：<br>
-class（类加载器）<br>
-gc（GC堆状态）<br>
-gccapacity（各区大小）<br>
-gccause（最近一次GC统计和原因）<br>
-gcmetacapacity（元空间大小）<br>
-gcnew（新区统计）<br>
-gcnewcapacity（新区大小）<br>
-gcold（老区统计）<br>
-gcoldcapacity（老区大小）<br>
-gcutil（GC统计汇总）<br>
-printcompilation（HotSpot编译统计）<br>
```
jstat -class ${pid}
```
##### jstack
用于JVM当前时刻的线程快照，又称thread dump文件，它是JVM当前每一条线程正在执行的堆栈信息的集合。<br>
用于定位线程出现长时间停顿的原因，比如死锁、死循环、请求外部时间过长。
```
jstack -l ${pid} > ${file}
```
##### jmap
用于生成堆快照（heapdump），二进制bin文件
```
jmap -dump:format=b,file=${file} ${pid}
```
##### jhat
解析堆dump的bin文件，并启动一个web服务器，可以通过浏览器访问7000端口查看dump文件内容
```
jhat -J-Xmx512m heap.bin
```
##### jinfo
实时查看虚拟机的各项参数
```
jinfo -flags ${pid}
jinfo -sysprops ${pid}
```
##### jconsole
JDK的bin目录下，监控内存、thread、堆栈等.<br>
windows下的可视化工具。
##### jprofile
类似于jconsole，更全面

#### 22. 类的生命周期？code
- (1) 加载<br>
将类的信息加载到JVM的方法区中，在堆中实例化一个java.lang.Class对象<br>
类加载的方式：<br>
a) 根据类的全名路径找到class文件，从class文件读取内容<br>
b) 从jar文件中读取<br>
c) 从网络中获取，比如applet<br>
d) 根据规则实时生成，比如动态代理模式，自动生成代理类<br>
e) 从非class文件获取，非class文件会被转换为JVM识别的class文件<br>
- (2) 连接<br>
一般和加载交叉进行，做一些加载后的验证工作和初始化前的准备工作，可分为验证、准备和解析<br>
a) 验证：验证类是否合法，是否符合字节码格式<br>
b) 准备：为类的静态变量分配内存设置JVM默认的初始值<br>
c) 解析：将常量池中的符号引用转换为直接引用，比如将方法签名转换为内存具体地址<br>
- (3) 初始化<br>
根据类的直接引用和被动引用决定是否初始化。<br>
直接引用：<br>
a) 通过new关键字实例化对象、读取或设置类的静态变量、调用类的静态方法<br>
b) 通过反射执行以上三种操作<br>
c) 初始化子类的时候，会触发初始化父类<br>
d) 作为程序入口直接运行（直接调用main方法）<br>
被动引用：<br>
a) 引用父类的静态字段，只会引起父类初始化，不会引起子类初始化<br>
b) 定义类数组<br>
c) 引用类的常量<br>
- (4) 使用<br>
- (5) 卸载<br>
满足以下条件会进行类的卸载，在方法区中清空类的信息，类的生命周期结束。<br>
a) 类的所有实例都已经被回收，即堆中不存在类的实例<br>
b) 加载该类的ClassLoader已经被回收<br>
c) 该类对应的java.lang.Class对象没有被引用，无法在任何地方通过反射访问该类的方法<br>

#### 23. 常用的JVM参数？
参数 | 含义
-|-
-Xms | JVM启动时堆的初始化大小
-Xmx | 堆最大值
-Xmn | 设置年轻代的大小，剩下的为老年代的大小
-XX:PermGen | 设置永久代内存的初始化大小
-XX:MaxPermGen | 设置永久代的最大值
-XX:SurvivorRatio | 设置eden区和survivor区的比例。默认为8，即eden : survivor1 : survivor2 = 8 : 1 : 1
-XX:NewRatio | 设置老年代和年轻代的比例，默认是2
-XX:+UseSerialGC | 使用Serial GC垃圾回收
-XX:+UseParNewGC | 使用Parallel GC垃圾回收

#### 24. JVM调优实例？

#### 25. ZGC
JDK 11
降低停顿时间，会导致吞吐量有所降低

4个目标
- 支持TB量级的堆
- 最大GC停顿时间不超过10ms
- 奠定未来GC特性的基础
- 最差情况下吞吐量会降低15%






#### 100. temp
