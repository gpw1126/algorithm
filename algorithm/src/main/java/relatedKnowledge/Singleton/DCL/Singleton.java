package relatedKnowledge.Singleton.DCL;

/**
 * @Author: Gpw
 * @Date: 2020/6/22
 * @Description: 双重检查锁定模式(DCL)，也是一种懒加载的单例模式。
 * 如何保证线程安全？
 * 1.synchronized修饰getInstance()方法，但是惨重的效率代价
 * 2.synchronized来同步部分代码块，并且通过volatile避免初始化操作的指令重排序
 * 缺点：在JDK1.5之后才能保证正确性，比较丑陋复杂，不推荐。
 */
public class Singleton{
    private volatile static Singleton instance = null;
    private Singleton() {
    }
    public static Singleton getInstance() {
        if(instance==null) {
            synchronized (Singleton.class) {
                if(instance==null)
                    instance = new Singleton();
            }
        }
        return instance;
    }
}

