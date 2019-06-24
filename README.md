java 基础   

        https://blog.csdn.net/youanyyou/article/details/82142014
        https://blog.csdn.net/u012257955/article/details/70847206

1.java中的几种基本数据类型是什么，各自占用多少字节

    byte(1) int(4) short(2)  long(8)  float(4)  double(8)  char(2)  boolean(jvm中，boolean变量当做int处理；boolean数组当做byte数组处理)
    
2.String类能被继承吗

    不能被继承，String有final修饰符
    
    final修饰符的用法：
    1.修饰类
    　　当用final修饰一个类时，表明这个类不能被继承。final类中的成员变量可以根据需要设为final，但是要注意final类中的所有成员方法都会被隐式地指定为final方法。
   
    2.修饰方法
    　　使用final修饰方法的原因有两个。第一个原因是把方法锁定，以防任何继承类修改它的含义；第二个原因是效率。在早期的Java实现版本中，会将final方法转为内嵌调用。但是如果方法过于庞大，可能看不到内嵌调用带来的任何性能提升。在最近的Java版本中，不需要使用final方法进行这些优化了。
    　　因此，只有在想明确禁止该方法在子类中被覆盖的情况下才将方法设置为final。
    　　注：一个类中的private方法会隐式地被指定为final方法。
    
    3.修饰变量
    　　对于被final修饰的变量，如果是基本数据类型的变量，则其数值一旦在初始化之后便不能更改；如果是引用类型的变量，则在对其初始化之后便不能再让其指向另一个对象。虽然不能再指向其他对象，但是它指向的对象的内容是可变的。
   
3.String, Stringbuffer, StringBuilder 区别

    StringBuffer就是为了解决大量拼接字符串时产生很多中间对象问题而提供的一个类，提供append和add方法，可以将字符串添加到已有序列的末尾或指定位置，它的本质是一个线程安全的可修改的字符序列，把所有修改数据的方法都加上了synchronized。但是保证了线程安全是需要性能的代价的。
    StringBuilder是JDK1.5发布的，它和StringBuffer本质上没什么区别，就是去掉了保证线程安全的那部分，减少了开销。
    
    创建一个字符串时，首先会检查池中是否有值相同的字符串对象，如果有就直接返回引用，不会创建字符串对象；如果没有则新建字符串对象，返回对象引用，并且将新创建的对象放入池中。但是，通过new方法创建的String对象是不检查字符串常量池的，而是直接在堆中创建新对象，也不会把对象放入池中。上述原则只适用于直接给String对象引用赋值的情况。
    
    总结 ;
    1、在字符串不经常发生变化的业务场景优先使用String(代码更清晰简洁)。如常量的声明，少量的字符串操作(拼接，删除等)。
    
    2、在单线程情况下，如有大量的字符串操作情况，应该使用StringBuilder来操作字符串。不能使用String"+"来拼接而是使用，避免产生大量无用的中间对象，耗费空间且执行效率低下（新建对象、回收对象花费大量时间）。如JSON的封装等。
    
    3、在多线程情况下，如有大量的字符串操作情况，应该使用StringBuffer。如HTTP参数解析和封装等。
    
4.ArrayList和linkedList
    
    ArrayList实现了随机访问的接口，LinkedList实现了Quene的接口。
    
    ArrayList是基于数据实现的list，而LinkedList是基于链表实现的list。所以，ArrayList拥有着数组的特性，LinkedList拥有着链表的特性。
    
    优缺点
    　　ArrayList
    
    　　优点：适合随机读取的时候，读取速度快，可以一步get(index)。
    
    　　缺点：添加值很慢——一方面，添加数据在array中间的时候，需要移动后面的数；另一方面，当长度大于初始长度的时候，每添加一个数，都会需要扩容。
    
    　　LinkedList：双向链表
    
    　　优点：添加值很快——添加在list中间也只需要更改指针；长度不固定。
    
    　　实现栈和队列方面，LinkedList要优于ArrayList。
    
    其它
    　　LinkedList的remove(int)和remove(Object)的方法的时间复杂度都是O(n),不是O(1).因为会有一个查找的过程。
    
    　　LinkedList的remove(int)要优于remove(Object)，因为remove(int)在查找的时候，会从链表的中间查找，如果int比中间小，找前半部分，否则找后半部分（类似二分查找）。
    
    　　ArrayList的增删比LinkedList的开销更大，因为除了有查找的时间复杂度外，还有增删的移动过程。
   
5.讲讲类的实例化顺序，比如父类静态数据，构造函数，字段，子类静态数据，构造函数，字段，当new的时候，他们的执行顺序。

    父类静态变量
    父类静态代码块
    子类静态变量
    子类静态代码块
    父类非静态变量
    父类构造函数
    子类非静态变量
    子类构造函数
    
    一个类的实例化过程：
    
    1，首先会执行类中static代码块(不管代码块是否在类的开头还是末尾处)，如果这个类有父类，同样会优先查找父类中的static代码块，然后是当前类的static。
    
    2，然后会从父类的第一行开始执行，直至代码末尾处，中间不管是有赋值还是method调用，都会按顺序一一执行（method），普通代码块{ }...
    
    3，其次才是父类的构造函数，执行带参数或不带参数的构造函数，依赖于实例化的类的构造函数有没有super父类的带参或不带参的构造函数
    
    4，然后会从子类（当前类）的第一行开始执行，直至代码末尾处，中间不管是有赋值还是method调用，都会按顺序一一执行（method），普通代码块{ }...
    
    5，其次会是子类（当前类）的构造函数，按顺序执行。
    
    6，最后是类方法的调用执行，如果子类覆盖了父类的method，执行时会先执行子类覆盖的method，method内如果有super.method()，才会调用父类的同名method，否则不会。

6.用过哪些Map类，都有什么区别，HashMap是线程安全的吗,并发下使用的Map是什么，他们内部原理分别是什么，比如存储方式，hashcode，扩容，默认容量等。

    最常用的Map实现类有:HashMap，ConcurrentHashMap（jdk1.8），LinkedHashMap，TreeMap,HashTable；
    
    其中最频繁的是HashMap和ConcurrentHashMap，他们的主要区别是HashMap是非线程安全的。ConcurrentHashMap是线程安全的。
    
    并发下可以使用ConcurrentHashMap和HashTable，他们的主要区别是：
    
    1.ConcurrentHashMap的hash计算公式：(key.hascode()^ (key.hascode()>>> 16)) & 0x7FFFFFFF
    
       HashTable的hash计算公式：key.hascode()& 0x7FFFFFFF
    
    2.HashTable存储方式都是链表+数组，数组里面放的是当前hash的第一个数据，链表里面放的是hash冲突的数据
    
     ConcurrentHashMap是数组+链表+红黑树
    
    3.默认容量都是16，负载因子是0.75。就是当hashmap填充了75%的busket是就会扩容，最小的可能性是（16*0.75），一般为原内存的2倍
    
    4.线程安全的保证：HashTable是在每个操作方法上面加了synchronized来达到线程安全，ConcurrentHashMap线程是使用CAS(compore and swap)来保证线程安全的
    
7.java8的concurrentHashMap 为什么放弃了分段锁，接口可以继承多个接口吗，如何设计合理

    jdk8 放弃了分段锁而是用了Node锁，减低锁的粒度，提高性能，并使用CAS操作来确保Node的一些操作的原子性，取代了锁。
    
    但是ConcurrentHashMap的一些操作使用了synchronized锁，而不是ReentrantLock,虽然说jdk8的synchronized的性能进行了优化，但是我觉得还是使用ReentrantLock锁能更多的提高性能
   
8.有没有有顺序的Map实现类，如果有，他们是怎么保证有序的。

    LinkedListMap  TreeMap
    
    LinkedHashMap 是基于元素进入集合的顺序或者被访问的先后顺序排序，TreeMap 则是基于元素的固有顺序 (由 Comparator 或者 Comparable 确定)。
    
9.抽象类和接口的区别

10.继承和聚合的区别

    继承：指的是一个类继承另一个类的功能，并可以增加他自己的新功能的能力，继承是类与类或者接口与接口之间最常见的关系；在java中此类关系通过关键字extends明确标志，在设计师一般没有争议性
    
    聚合：聚合是关联关系的一种特例，他体现的是整体与部分、拥有的关系，即has-a的关系，此时整体与部分之间是可分离的，他们可以具有各自的生命周期，部分可以属于多个整体对象，也可以为多个整体对象共享；比如计算机与CPU、公司与员工的关系等；表现在代码层面，和关联关系是一致的，只能从语义级别来区分；
    
11.IO模型有哪些，讲讲你理解的nio，他和bio，aio的区别，谈谈reactor模型

    BIO：同步阻塞式IO，服务器实现模式为一个连接一个线程，即客户端有连接请求时服务器端就需要启动一个线程进行处理，如果这个连接不做任何事情会造成不必要的线程开销，当然可以通过线程池机制改善。
    NIO：同步非阻塞式IO，服务器实现模式为一个请求一个线程，即客户端发送的连接请求都会注册到多路复用器上，多路复用器轮询到连接有I/O请求时才启动一个线程进行处理。
    
    reactor模型：反应器模式（事件驱动模式）：当一个主体发生改变时，所有的属体都得到通知，类似于观察者模式。

    https://blog.csdn.net/charjay_lin/article/details/81810922
    
12.反射的原理，反射创建实例的三种方式

    如果知道一个类的名称或者他的一个实例对象，就能把这个类的所有方法和变量的信息找出来
    
    Class.forName("com.A")
    new A().getClass()
    A.class
    
13.反射中，Class.forName和ClassLoader区别

    Class.forName()除了将类的.class文件加载到jvm中之外，还会对类进行解释，执行类中的static块
    Classloader 只是将.class文件加载到jvm中，只有在newInstance才会执行static块
 
14.描述动态代理的几种实现方式，分别说出优缺点

    1、代理对象存在的价值主要用于拦截对真实业务对象的访问。
    2、代理对象应该具有和目标对象(真实业务对象)相同的方法。

    动态代理有两种实现方式，分别是：jdk动态代理和cglib动态代理
    
    jdk动态代理的前提是目标类必须实现一个接口，代理对象跟目标类实现一个接口，从而避过虚拟机的校验。
    
    cglib动态代理是继承并重写目标类，所以目标类和方法不能被声明成final。
    
    https://www.jianshu.com/p/9a61af393e41?from=timeline&isappinstalled=0
   
15.动态代理和cglib实现的区别

16.为什么cglib方式可以对接口实现代理

     cglib动态代理是继承并重写目标类，所以目标类和方法不能被声明成final。而接口是可以被继承的。
    

17.final的作用

    被final修饰不可变的是变量的引用，而不是引用指向的内容，引用指向的内容是可以改变的
   
    修饰变量    常与static修饰常量
    修饰方法    final方法比非final方法快，由于在编译时已经被静态绑定了，不需要再运行时动态绑定
    修饰类      当一个类被final修饰后，表示该类是完整的，不能被继承。比如Java中String、Integer类都是final类 
    
    finalkeyword提高了性能。
        JVM和Java应用都会缓存final变量。
    final变量能够安全的在多线程环境下进行共享。而不须要额外的同步开销。
    使用finalkeyword，JVM会对方法、变量及类进行优化。
    不可变类创建不可变类要使用finalkeyword。不可变类是指它的对象一旦被创建了就不能被更改了。String是不可变类的代表。
    不可变类有非常多优点。譬如它们的对象是仅仅读的，能够在多线程环境下安全的共享，不用额外的同步开销等等。
    
18.写出三种单例模式的实现

    https://blog.csdn.net/justloveyou_/article/details/64127789
    
19.如何在父类中为子类自动完成所有的hashcode和equals实现？这么做有何优劣。

20.OO设计理念，访问修饰符 public、private、protected、default在应用的作用

21.深拷贝和浅拷贝的区别
    
    浅拷贝只拷贝指针，深拷贝就是拷贝他的值，重新生成的对像。
    
    深拷贝本身只针对较为复杂的object类型数据。

22.数组和链表数据结构描述，各自的时间复杂度。

    数组是将元素在内存中连续存放，由于每个元素占用内存相同，可以通过下标迅速访问数组中任何元素。
    链表恰好相反，链表中的元素在内存中不是顺序存储的，而是通过存在元素中的指针联系到一起。
    
    访问数组中第 n 个数据的时间花费是 O(1) 但是要在数组中查找一个指定的数据则是 O(N) 。当向数组中插入或者删除数据的时候，最好的情况是在数组的末尾进行操作，时间复杂度是 O(1) ，但是最坏情况是插入或者删除第一个数据，时间复杂度是 O(N) 。在数组的任意位置插入或者删除数据的时候，后面的数据全部需要移动，移动的数据还是和数据个数有关所以总体的时间复杂度仍然是 O(N) 。 
    
    在链表中查找第 n 个数据以及查找指定的数据的时间复杂度是 O(N) ，但是插入和删除数据的时间复杂度是 O(1)

23.error和exception的区别，CheckedException，RuntimeException的区别。

    

    

    