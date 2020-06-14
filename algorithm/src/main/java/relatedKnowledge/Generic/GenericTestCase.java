package relatedKnowledge.Generic;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:Gpw
 * @Date:2020/6/13
 * @Description: 泛型
 *  1.与普通的 Object 代替一切类型这样简单粗暴而言，泛型使得数据的类别可以像参数一样由外部传递进来。它提供了一种扩展能力。它更
 *    符合面向抽象开发的软件编程宗旨。
 *  2.具体的类型确定后，泛型又提供了一种类型检测的机制，只有相匹配的数据才能正常的赋值，否则编译器就不通过。所以说，它是一种类
 *    型安全检测机制，一定程度上提高了软件的安全性防止出现低级的失误。
 *  3.泛型提高了程序代码的可读性，不必要等到运行的时候才去强制转换，在定义或者实例化阶段，因为 Cache<String>这个类型显化的效果，
 *    程序员能够一目了然猜测出代码要操作的数据类型。
 */
public class GenericTestCase {

    public static void main(String[] args) {

        GenericObj<String> obj1 = new GenericObj<>();
        obj1.setValue("gpw");
        String str = obj1.getValue();

        // 参数一旦确定好，如果类似不匹配，编译器就不通过
//        obj1.setValue(123);

        // 泛型信息只存在于代码编译阶段，在进入 JVM 之前，与泛型相关的信息会被擦除掉，专业术语叫做类型擦除。
        List<String> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        // 返回true。因为 List<String>和 List<Integer>在 jvm 中的 Class 都是 List.class
        System.out.println(list1.getClass() == list2.getClass());
        // 在泛型类被类型擦除的时候，之前泛型类中的类型参数部分如果没有指定上限，如 <T>则会被转译成普通的 Object 类型，
        // 如果指定了上限如 <T extends String>则类型参数就被替换成类型上限。
    }
}
