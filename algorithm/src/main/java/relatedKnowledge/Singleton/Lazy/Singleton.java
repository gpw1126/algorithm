package relatedKnowledge.Singleton.Lazy;

/**
 * @Author: Gpw
 * @Date: 2020/6/22
 * @Description: 懒汉模式，使用时才创建对象。
 * 优点：充分利用了延迟加载，只在真正需要的时候创建对象(只在第一次调用时创建对象)。
 * 缺点：为了防止对象被多次创建，不得不使用synchronized进行方法同步。并发环境下，竞争激烈的场合对性能可能产生一定的影响。
 */
public class Singleton {
    private static Singleton instance;
    private Singleton() {
    }
    public static synchronized Singleton getInstance() {
        if(instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}

