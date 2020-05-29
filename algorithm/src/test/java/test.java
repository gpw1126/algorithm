import org.junit.Test;
import scene.LeetCode.MinStack;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:Gpw
 * @Date:2020/3/11
 * @Description:PACKAGE_NAME
 * @Version:1.0
 */

public class test {

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
        String s = "a good   example";
        String[] array = s.split(" ");
        for (String str : array) {
            str.trim();
            System.out.println(str);
        }
    }
}
