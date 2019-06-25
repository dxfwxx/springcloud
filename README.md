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

    error  错误，系统级别的错误和不必处理的异常，是java运行环境中的内部错误或者硬件问题，java虚拟机抛出。比如：内部资源不足，
    
    expection 异常，表示需要捕获或者处理的异常，
        
        运行时异常 runtimeException 
        编译时异常 checkException  程序可以修复
        
    Java异常机制主要依赖于try、catch、finally、throw、throws五个关键字。
    
             1.try：它里面放置可能引发异常的代码
    
             2.catch：后面对应异常类型和一个代码块，用于表明该catch块用于处理这种类型的代码块，可以有多个catch块。
    
             3.finally：主要用于回收在try块里打开的物力资源（如数据库连接、网络连接和磁盘文件），异常机制总是保证finally块总是被执行。只有finally块，执行完成之后，才会回来执行try或者catch块中的return或者throw语句，
                如果finally中使用了return或者   throw等终止方法的语句，则就不会跳回执行，直接停止。
    
             4.throw：用于抛出一个实际的异常，可以单独作为语句使用，抛出一个具体的异常对象。
    
             5.throws：用在方法签名中，用于声明该方法可能抛出的异常。
             
        执行步骤：
        
        1.如果执行try块中的业务逻辑代码时出现异常，系统自动生成一个异常对象，该异常对象被提交给java运行环境，这个过程称为抛出（throw）异常。
        
        2.当java运行环境收到异常对象时，会寻找能处理该异常对象的catch块，如果找到合适的cathc块并把该异常对象交给catch块处理，那这个过程称为捕获（catch）异常；如果java运行时环境找不到捕获异常的catch块，则运行时环境终止，jav程序也将退出。
        
        注意1：不管程序代码块是否处于try块中，甚至包括catch块中代码，只要执行该代码时出现了异常，系统都会自动生成一个异常对象，如果程序没有为这段代码定义任何catch块，java运行环境肯定找不到处理该异常的catch块，程序肯定在此退出。
        
        注意2：try块后可以有多个catch块，try块后使用多个catch块是为了针对不同异常类提供的不同的异常处理方式。当系统发生不同意外情况时，系统会生成不同的异常对象，java运行时就会根据该异常对象所属的异常类来决定使用哪个catch块来处理该异常。
        
        注意3：通常情况下，如果try块被执行一次，则try块后只有一个catch块会被执行，绝不可能有多个catch块被执行，除非在循环中使用类continue开始下一次循环，下一次循环又重新运行了try块，这才可能导致多个catch块被执行。
        
        注意4：进行异常捕获时，一定要记住先捕获小的异常，再捕获大的异常。
        
        注意5：除非在try块或者catch块中调用了退出虚拟机的方法（即System.exit(1);），否则不管在try块、catch块中执行怎样的代码，出现怎样的情况，异常处理的finally块总是会被执行的。不过，一般情况下，不要再finally块中使用renturn或throw等导致方法终止的语句，因为一旦使用，将会导致try块、catch块中的return、throw语句失效。
            

24.5个运行时异常
    
    NullPointerException
    IndexOutOfBoundException
    ClassCastException
    ArrayStoreException
    BufferrOverflowException
    
25.在自己的代码中，如果创建一个java.lang.String类，这个类是否可以被类加载器加载？为什么。

    1.、双亲委派模型
    类加载器可分为两类：一是启动类加载器(Bootstrap ClassLoader)，是C++实现的，是JVM的一部分；另一种是其它的类加载器，是Java实现的，独立于JVM，全部都继承自抽象类java.lang.ClassLoader。jdk自带了三种类加载器，分别是启动类加载器（Bootstrap ClassLoader），扩展类加载器（Extension ClassLoader），应用程序类加载器（Application ClassLoader）。后两种加载器是继承自抽象类java.lang.ClassLoader。
    
    一般是： 自定义类加载器 >> 应用程序类加载器 >> 扩展类加载器 >> 启动类加载器
    
    上面的层次关系被称为双亲委派模型(Parents Delegation Model)。除了最顶层的启动类加载器外，其余的类加载器都有对应的父类加载器。
    再简单说下双亲委托机制：当一个类加载器收到类加载的请求，它将这个加载请求委派给父类加载器进行加载，每一层加载器都是如此，最终，所有的请求都会传送到启动类加载器中。只有当父类加载器自己无法完成加载请求时，子类加载器才会尝试自己加载。
    
    经过不同加载器进行加载的类是无法访问彼此的。由不同加载器加载的类处于不同的运行时包。所有的访问权限都是基于同一个运行时包而言的。
    
26.java.lang.Object对象中hashCode()和equals()方法。

    equals()：反映的是对象或变量具体的值，即两个对象里面包含的值--可能是对象的引用，也可能是值类型的值。如果不重写equals方法，则默认调用Object中的equals方法，此时等同于 (==) 方法

    hashCode()：计算出对象实例的哈希码，并返回哈希码，又称为散列函数。根类Object的hashCode()方法的计算依赖于对象实例的D（内存地址），故每个Object对象的hashCode都是唯一的；当然，当对象所对应的类重写了hashCode()方法时，结果就截然不同了。
    
    关于这两个方法的重要规范： 
    
        规范1：若重写equals(Object obj)方法，有必要重写hashcode()方法，确保通过equals(Object obj)方法判断结果为true的两个对象具备相等的hashcode()返回值。说得简单点就是：“如果两个对象相同，那么他们的hashcode应该相等”。不过请注意：这个只是规范，如果你非要写一个类让equals(Object obj)返回true而hashcode()返回两个不相等的值，编译和运行都是不会报错的。不过这样违反了Java规范，程序也就埋下了BUG。 
        规范2：如果equals(Object obj)返回false，即两个对象“不相同”，并不要求对这两个对象调用hashcode()方法得到两个不相同的数。说的简单点就是：“如果两个对象不相同，他们的hashcode可能相同”。 

    hashCode的作用:

    总的来说，Java中的集合（Collection）有两类，一类是List，再有一类是Set。前者集合内的元素是有序的，元素可以重复；后者元素无序，但元素不可重复。

    那么这里就有一个比较严重的问题了：要想保证元素不重复，可两个元素是否重复应该依据什么来判断呢？ 
    
    这就是Object.equals方法了。但是，如果每增加一个元素就检查一次，那么当元素很多时，后添加到集合中的元素比较的次数就非常多了。也就是说，如果集合中现在已经有1000个元素，那么第1001个元素加入集合时，它就要调用1000次equals方法。这显然会大大降低效率。   
    于是，Java采用了哈希表的原理。  
    
        当集合要添加新的元素时，
        先调用这个元素的hashCode方法，就一下子能定位到它应该放置的物理位置上。 
        如果这个位置上没有元素，它就可以直接存储在这个位置上，不用再进行任何比较了；
        如果这个位置上已经有元素了，就调用它的equals方法与新元素进行比较，相同的话就不存，不相同就散列其它的地址。所以这里存在一个冲突解决的问题。这样一来实际调用equals方法的次数就大大降低了，几乎只需要一两次。
        
27. 在jdk1.5中，引入了泛型，泛型的存在是用来解决什么问题。

  
28.hashSet 内部是如何工作的

    HashSet 内部实现是基于 HashMap ，实现了 Set 接口。
    利用了 HashMap 的 key 不能重复这个原理来实现 HashSet 。

JVM知识：

1.什么情况下会发生栈内存溢出

    【情况一】： 
    　　java.lang.OutOfMemoryError: Java heap space：这种是java堆内存不够，一个原因是真不够，另一个原因是程序中有死循环； 
    　　如果是java堆内存不够的话，可以通过调整JVM下面的配置来解决： 
    　　< jvm-arg>-Xms3062m < / jvm-arg> 
    　　< jvm-arg>-Xmx3062m < / jvm-arg> 
    【情况二】 
    　　java.lang.OutOfMemoryError: GC overhead limit exceeded 
    　　【解释】：JDK6新增错误类型，当GC为释放很小空间占用大量时间时抛出；一般是因为堆太小，导致异常的原因，没有足够的内存。 
    　　【解决方案】： 
    　　1、查看系统是否有使用大内存的代码或死循环； 
    　　2、通过添加JVM配置，来限制使用内存： 
    　　< jvm-arg>-XX:-UseGCOverheadLimit< /jvm-arg>  
    【情况三】： 
    　　java.lang.OutOfMemoryError: PermGen space：这种是P区内存不够，可通过调整JVM的配置： 
    　　< jvm-arg>-XX:MaxPermSize=128m< /jvm-arg> 
    　　< jvm-arg>-XXermSize=128m< /jvm-arg> 
    　　【注】： 
    　　JVM的Perm区主要用于存放Class和Meta信息的,Class在被Loader时就会被放到PermGen space，这个区域成为年老代，GC在主程序运行期间不会对年老区进行清理，默认是64M大小，当程序需要加载的对象比较多时，超过64M就会报这部分内存溢出了，需要加大内存分配，一般128m足够。   
    【情况四】： 
    　　java.lang.OutOfMemoryError: Direct buffer memory 
    　　调整-XX:MaxDirectMemorySize= 参数，如添加JVM配置： 
    　　< jvm-arg>-XX:MaxDirectMemorySize=128m< /jvm-arg> 
    【情况五】： 
    　　java.lang.OutOfMemoryError: unable to create new native thread 
    　　【原因】：Stack空间不足以创建额外的线程，要么是创建的线程过多，要么是Stack空间确实小了。 
    　　【解决】：由于JVM没有提供参数设置总的stack空间大小，但可以设置单个线程栈的大小；而系统的用户空间一共是3G，除了Text/Data/BSS /MemoryMapping几个段之外，Heap和Stack空间的总量有限，是此消彼长的。因此遇到这个错误，可以通过两个途径解决： 
    　　1.通过 -Xss启动参数减少单个线程栈大小，这样便能开更多线程（当然不能太小，太小会出现StackOverflowError）； 
    　　2.通过-Xms -Xmx 两参数减少Heap大小，将内存让给Stack（前提是保证Heap空间够用）。 
    【情况六】： 
    　　java.lang.StackOverflowError 
    　　【原因】：这也内存溢出错误的一种，即线程栈的溢出，要么是方法调用层次过多（比如存在无限递归调用），要么是线程栈太小。 
    　　【解决】：优化程序设计，减少方法调用层次；调整-Xss参数增加线程栈大小
    
2.jvm内存区域

    https://www.cnblogs.com/haitaofeiyang/p/8392268.html
    
3.jvm为什么要分新生代、老年代、持久带，新生代为什么要分 eden和survivor

    JVM在程序运行过程当中，会创建大量的对象，这些对象，大部分是短周期的对象，小部分是长周期的对象，对于短周期的对象，需要频繁地进行垃圾回收以保证无用对象尽早被释放掉，对于长周期对象，则不需要频率垃圾回收以确保无谓地垃圾扫描检测。为解决这种矛盾，Sun JVM的内存管理采用分代的策略。
    https://blog.csdn.net/asleepysheep/article/details/82180284
    
4.你知道哪几种垃圾收集器，各自的优缺点，重点讲下cms和G1，包括原理，流程，优缺点。g1和cms区别,吞吐量优先和响应优先的垃圾收集器选择。垃圾回收算法原理。
    
    https://www.jianshu.com/p/61b885def3cd
    
5.内存溢出排错

    https://www.cnblogs.com/lcword/p/5857909.html
    
    jvm管理的内存大致包括三种不同类型的内存区 域：Permanent Generation space（永久保存区域）、Heap space(堆区域)、Java Stacks(Java栈）。其中永久保存区域主要存放Class（类）和Meta的信息，Class第一次被Load的时候被放入PermGen space区域，Class需要存储的内容主要包括方法和静态属性。
    堆区域用来存放Class的实例（即对象），对象需要存储的内容主要是非静态属性。每 次用new创建一个对象实例后，对象实例存储在堆区域中，这部分空间也被jvm的垃圾回收机制管理。而Java栈跟大多数编程语言包括汇编语言的栈功能相 似，主要基本类型变量以及方法的输入输出参数。
    Java程序的每个线程中都有一个独立的堆栈。容易发生内存溢出问题的内存空间包括：Permanent Generation space和Heap space。
    
    第一种OutOfMemoryError： PermGen space
        发生这种问题的原意是程序中使用了大量的jar或class，使java虚拟机装载类的空间不够，与Permanent Generation space有关。
        解决这类问题有以下两种办法：
        
            增加java虚拟机中的XX:PermSize和XX:MaxPermSize参数的大小
            清理应用程序中web-inf/lib下的jar
            
    第二种OutOfMemoryError：  Java heap space
        发生这种问题的原因是java虚拟机创建的对象太多，在进行垃圾回收之间，虚拟机分配的到堆内存空间已经用满了，与Heap space有关。
        解决这类问题有两种思路：
        
            检查程序，看是否有死循环或不必要地重复创建大量对象
            增加Java虚拟机中Xms（初始堆大小）和Xmx（最大堆大小）参数的大小。
    
    第三种OutOfMemoryError：unable to create new native thread
    
6.JVM内存模型的相关知识了解多少，比如重排序，内存屏障，happen-before，主内存，工作内存等。

    指令重排序
        在执行程序时，为了提高性能，编译器和处理器会对指令做重排序。
        
            编译器优化重排序：编译器在不改变单线程程序语义的前提下，可以重新安排语句的执行顺序。
            指令级并行的重排序：如果不存l在数据依赖性，处理器可以改变语句对应机器指令的执行顺序。
            内存系统的重排序：处理器使用缓存和读写缓冲区，这使得加载和存储操作看上去可能是在乱序执行。
        
        但是，可以通过插入特定类型的Memory Barrier来禁止特定类型的编译器重排序和处理器重排序。
       
    内存屏障（Memory Barrier ）
        上面讲到了，通过内存屏障可以禁止特定类型处理器的重排序，从而让程序按我们预想的流程去执行。
        
        内存屏障，又称内存栅栏，是一个CPU指令，基本上它是一条这样的指令：
    
            保证特定操作的执行顺序。
            影响某些数据（或则是某条指令的执行结果）的内存可见性。
            
        java内存模型volatile是基于Memory Barrier实现的。
        
            如果一个变量是volatile修饰的，JMM会在写入这个字段之后插进一个Write-Barrier指令，并在读这个字段之前插入一个Read-Barrier指令。这意味着，如果写入一个volatile变量，就可以保证：
        
            一个线程写入变量a后，任何线程访问该变量都会拿到最新值。
            在写入变量a之前的写入操作，其更新的数据对于其他线程也是可见的。因为Memory Barrier会刷出cache中的所有先前的写入。
            
    Happens-Before
        在JMM中，如果一个操作的执行结果需要对另一个操作可见，那么这两个操作之间必须要存在happens-before关系，这个的两个操作既可以在同一个线程，也可以在不同的两个线程中。
        
        我们需要关注的happens-before规则如下： (发生在...之前)
        
            程序顺序规则：一个线程中的每个操作，happens-before于该线程中任意的后续操作。
            监视器锁规则：对一个锁的解锁操作，happens-before于随后对这个锁的加锁操作。
            volatile域规则：对一个volatile域的写操作，happens-before于任意线程后续对这个volatile域的读。
            传递性规则：如果 A happens-before B，且 B happens-before C，那么A happens-before C。
            
7.简单说说你了解的类加载器，可以打破双亲委派么，怎么打破

    https://blog.csdn.net/fuzhongmin05/article/details/57404890

    类加载器就是根据指定全限定名称将class文件加载到JVM内存，转为Class对象。如果站在JVM的角度来看，只存在两种类加载器:
    
        启动类加载器（Bootstrap ClassLoader）：由C++语言实现（针对HotSpot）,负责将存放在<JAVA_HOME>\lib目录或-Xbootclasspath参数指定的路径中的类库加载到内存中。
        
        其他类加载器：由Java语言实现，继承自抽象类ClassLoader。如：
    
            扩展类加载器（Extension ClassLoader）：负责加载<JAVA_HOME>\lib\ext目录或java.ext.dirs系统变量指定的路径中的所有类库。
            应用程序类加载器（Application ClassLoader）。负责加载用户类路径（classpath）上的指定类库，我们可以直接使用这个类加载器。一般情况，如果我们没有自定义类加载器默认就是用这个加载器。
     
     双亲委派模型工作过程是：如果一个类加载器收到类加载的请求，它首先不会自己去尝试加载这个类，而是把这个请求委派给父类加载器完成。每个类加载器都是如此，只有当父加载器在自己的搜索范围内找不到指定的类时（即ClassNotFoundException），子加载器才会尝试自己去加载。
    
    打破双亲委派机制则不仅要继承ClassLoader类，还要重写loadClass和findClass方法
    
8.讲讲JAVA的反射机制。


开源框架知识

1.tomcat结构，以及类加载器流程，线程模型

    https://blog.csdn.net/fuzhongmin05/article/details/57404890

    在Tomcat目录结构中，有3组目录（“/common/*”、“/server/*”和“/shared/*”）可以存放Java类库，另外还可以加上Web应用程序自身的目录“/WEB-INF/*”，一共4组，把Java类库放置在这些目录中的含义分别如下：
    
          ①放置在/common目录中：类库可被Tomcat和所有的Web应用程序共同使用。
    
          ②放置在/server目录中：类库可被Tomcat使用，对所有的Web应用程序都不可见。
    
          ③放置在/shared目录中：类库可被所有的Web应用程序共同使用，但对Tomcat自己不可见。
    
          ④放置在/WebApp/WEB-INF目录中：类库仅仅可以被此Web应用程序使用，对Tomcat和其他Web应用程序都不可见。
    
2.tomcat调优

3.spring加载流程
