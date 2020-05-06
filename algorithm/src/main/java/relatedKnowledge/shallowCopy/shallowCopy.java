package relatedKnowledge.shallowCopy;

/**
 * @Author:Gpw
 * @Date:2020/3/27
 * @Description:relatedKnowledge.shallowCopy   通过拷贝构造方法实现浅拷贝
 *  对Person类选择了两个具有代表性的属性值：一个是引用传递类型；另一个是字符串类型（属于常量）。
 *  通过拷贝构造方法进行了浅拷贝，各属性值成功复制。其中，p1值传递部分的属性值发生变化时，p2不会随之改变；而引用传递部分属性值发生变化时，p2也随之改变。
 *
 *  要注意：如果在拷贝构造方法中，对引用数据类型变量逐一开辟新的内存空间，创建新的对象，也可以实现深拷贝。而对于一般的拷贝构造，则一定是浅拷贝。
 */
public class shallowCopy {

    public static void main(String[] args) {

        Age age = new Age(24);
        Person p1 = new Person("gpw", age);
        Person p2 = new Person(p1);
        System.out.println("p1：" + p1 + "\n" + "p2：" + p2);

        p1.setName("gaopengwei");
        // 浅拷贝
        age.setAge(25);

//        // 深拷贝
//        Age a = new Age(25);
//        p1.setAge(a);

        System.out.println("\n" + "修改后p1：" + p1 + "\n" + "修改后p2：" + p2);
    }
}
