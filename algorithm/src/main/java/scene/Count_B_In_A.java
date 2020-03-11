package scene;

import java.util.Scanner;

/**
 * @Author:Gpw
 * @Date:2019/10/10
 * @Description:scene
 *  编写一个方法，输出在一个字符串中，指定字符串出现的次数
 * @Version:1.0
 */
public class Count_B_In_A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入原字符串：");
        String st = sc.next();
        System.out.println("请输入指定字符串：");
        String m = sc.next();
        solution1(st,m);
        solution2(st,m);
    }

    /**
     * 方法一：使用indexOf和subString方法，循环判断并截取
     * @param st
     * @param m
     */
    private static void solution1(String st, String m) {
        int count = 0;
        while(st.indexOf(m) >= 0){
            st = st.substring(st.indexOf(m)+m.length());
            count++;
        }
        System.out.println("指定字符串在原字符串中出现："+count+"次");
    }

    /**
     * 方法二：使用replace方法将字符串替换为空，然后求长度
     * @param st
     * @param m
     */
    private static void solution2(String st, String m) {
        int count = (st.length()-st.replace(m,"").length())/m.length();
        System.out.println("指定字符串在原字符串中出现："+count+"次");
    }
}
