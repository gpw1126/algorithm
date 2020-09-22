package relatedKnowledge.SetTest;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: Gpw
 * @Date: 2020/7/17
 * @Description: 阿里面试 Set中add()方法会产生什么问题？
 *  1. person类中注释掉@Data(即没有重写hashcode和equals方法)，返回2
 *  2. person类中没有注释掉@Data(即重写了hashcode和equals方法)，返回1
 *
 *  Set内部实现是一个Map，使用Map的key存值，value固定，这是适配器模式。
 *  我们认为两个new person(1)是一样的，set应该去重，但计算出来hash值是不同的，那么Set会认为他们不一致，为两个对象，所以需要重写hashcode和equals方法。
 */
public class Main {
    public static void main(String[] args) {
        Set set = new HashSet<>();
        set.add(new person(1));
        set.add(new person(1));
        System.out.println(set.size());
    }
}
