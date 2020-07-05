package relatedKnowledge.Generic;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:Gpw
 * @Date:2020/7/5
 * @Description: List、List＜Object＞的区别
 *  List ：完全没有类型限制和赋值限定。
 *  List<Object> ：看似用法与List一样，但是在接受其他泛型赋值时会出现编译错误。
 */
public class a {
    public void test() {
        List l1 = new ArrayList();
        List<Object> l2 = new ArrayList<>();
        List<String> l3 = new ArrayList<>();

        l1.add(new Object());
        l1.add(new Integer(2));
        l1 = l3;

        l2.add(new Integer(2));
        // 编译报错
//        l2 = l3;
    }
}
