package relatedKnowledge.Singleton.Hungry;

/**
 * @Author: Gpw
 * @Date: 2020/6/22
 * @Description: 饿汉模式，类加载时完成初始化，所以类加载慢，但获取对象速度快。
 * 优点：这种方式的性能是非常好的，只是简单返回instance，没有做其他任何锁操作，所以在并行程序中，会有良好表现。
 * 缺点：有点明显的不足之处是 Singleton 实例在何时被创建并不受控制，对于静态成员变量instance，会在类第一次初始化的时候被创建，但是
 *      这并不一定是getInstance() 方法第一次调用的时候。
 */
public class Singleton{
    //直接初始化
    private static Singleton instance = new Singleton();
    private Singleton() {
    }
    public static Singleton getInstance() {
        return instance;
    }
}

