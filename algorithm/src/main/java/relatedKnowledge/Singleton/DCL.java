package relatedKnowledge.Singleton;

/**
 * @Author: Gpw
 * @Date: 2020/6/22
 * @Description: 双重检查锁定模式DCL(Double-Checked Lock)，即check-加锁-check，也是一种懒加载的单例模式。
 * 如何保证线程安全？
 * 1.synchronized修饰getInstance()方法，但是惨重的效率代价
 * 2.synchronized来同步部分代码块，并且通过volatile避免初始化操作的指令重排序
 * 缺点：在JDK1.5之后才能保证正确性，比较丑陋复杂，不推荐。
 */
public class DCL {
    private volatile static DCL instance = null;
    private DCL() {
    }
    // 相比Lazy降低了同步的粒度，只在初始化对象的时候进行同步。
    public static DCL getInstance() {
        if(instance==null) {
            synchronized (DCL.class) {
                if(instance==null)
                    instance = new DCL();
            }
        }
        return instance;
    }

    /**
     * 上面的写法一方面实现了Lazy-Load，另一个方面也做到了并发度很好的线程安全，一切看上很完美。这是，面试官可能会对你的回答满意的点点头。
     * 但是，你此时提出说，其实这种写法还是有问题的！！问题在哪里？假设线程A执行到了第9行，它判断对象为空，于是线程A执行到第12行去初始化这
     * 个对象，但初始化是需要耗费时间的，但是这个对象的地址其实已经存在了。此时线程B也执行到了第九行，它判断不为空，于是直接跳到15行得到了
     * 这个对象。但是，这个对象还没有被完整的初始化！得到一个没有初始化完全的对象有什么用！！关于这个Double-Checked Lock的讨论有很多，
     * 目前公认这是一个Anti-Pattern，不推荐使用！所以当你的面试官听到你的这番答复，他会不会被Hold住呢？
     *
     * 那么有没有什么更好的写法呢？有！这里又要提出一种新的模式——Initialization on Demand Holder. 这种方法使用内部类来做到延迟加载
     * 对象，在初始化这个内部类的时候，JLS(Java Language Sepcification)会保证这个类的线程安全。这种写法最大的美在于，完全使用了Java
     * 虚拟机的机制进行同步保证，没有一个同步的关键字。
     */
    // 内部类
    private static class SingletonHolder
    {
        public final static DCL instance = new DCL();
    }

    public static DCL getInstance1()
    {
        return SingletonHolder.instance;
    }
}

