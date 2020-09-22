import org.junit.Test;
import scene.LeetCode.MinStack;
import scene.serializeBinaryTree.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.logging.Logger;

/**
 * @Author:Gpw
 * @Date:2020/3/11
 * @Description:PACKAGE_NAME
 * @Version:1.0
 */

public class test {

    Logger log = Logger.getLogger("test");

    /**
     * 快速失败机制，java集合(Collection)中的一种错误检测机制，集合修改时使用集合本身的方法会触发。
     */
    @Test
    public void failFast() {
        List<String> list = new ArrayList<>();
        for (int i = 0;i < 5;i++) {
            list.add(i + "");
        }

        for (String s : list) {
            if (s.equals("1")) {
                list.remove(s);
            }
            System.out.println(s);
        }
    }

//    // 异或
//    public static void xor(int[] nums) {
//        int ans = nums[0];
//        if (nums.length > 1) {
//            for (int i = 1; i < nums.length; i++) {
//                ans = ans ^ nums[i];
//            }
//        }
//        System.out.println(ans);
//    }

    @Test
    public void test2() {
        MinStack stack = new MinStack();
        stack.push(0);
        stack.push(1);
        stack.push(0);
        System.out.println(stack.getMin());
    }

    @Test
    public void t() {
        byte a = 127;
        byte b = 127;

//        // 编译出错，可能超范围，丢失精度，可强转
//        a = a + b;

        // 结果 -2
//        01111111
//       +01111111
//        11111110  补码
//        11111101  反码
//        10000010  原码 -2
        a += b;
        System.out.println(a);
    }

    @Test
    public void split() {
//        String s = "a good   example";
//        String[] array = s.split(" ");
//        for (String str : array) {
//            str.trim();
//            System.out.println(str);
//        }
//        log.info("hhh");

        // 删除字符串中连续的abc
        String ans = "";
        String s = "wnabcagaabcsi";
        String[] strArr = s.split("abc");
        for (String str : strArr) {
            ans = ans + str;
        }
        System.out.println(ans);
    }

    @Test
    public void listTest() {
        List<String> list = new ArrayList<>();
        list.add("i");
        list.add("love");
        list.add("you");
//        for (String s : list.subList(0, 2)) {
//            System.out.println(s);
//        }

        // lambda
//        list.forEach(s -> System.out.println(s));
        new Thread(() -> System.out.println(Thread.currentThread().getName())).start();
    }

    @Test
    public void yiwei() {
        System.out.println(1 << 4);
        System.out.println("flow".indexOf("flower"));

        int i = 0;
        System.out.println(i++ == 0);
        System.out.println(++i == 1);
        System.out.println(i == 2);

        int x = 10;
        int a = x + x++;
        System.out.println(a);
    }

    @Test
    public void arraylist() {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        cur.add(3);
        cur.add(4);
//        list.add(new ArrayList<>(cur));
        list.add(cur);
        System.out.println(list.toString());
    }

    @Test
    public void compare() {
//        Integer a =1, b = 1;
//        System.out.println(a == b); // true
//
//        int c = 7;
//        Integer d = new Integer(7);
//        System.out.println(c == d); // true
//
//        String s1 = "abc";
//        String s2 = "abc";
//        System.out.println(s1 == s2); // true
//
        String str1 = "abc";
        Object o = new Object();
        o.getClass();
        String str2 = new String("abc");
        System.out.println(str1 == str2); // false
        System.out.println(str1 == str2.intern()); // true
    }
}
