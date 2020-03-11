package scene;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: Gpw
 * @Date: 2019/8/8
 * @Description: PACKAGE_NAME
 * 给定一个无序的整型数组A[n],数组大小大于等于3,允许有值相同的元素;
 * 请设计算法找到该数组排序后第三大的元素值并输出.
 * 输入描述:
 * 一个非空的整数数组(至少有3个元素,可正可负)
 * 输出描述:
 * 第三大的元素值
 * 输入
 * [1,2,3,4,5]
 * 输出
 * 3
 * 输入
 * [6,5,4,4,1,2]
 * 输出
 * 4
 * @Version: 1.0
 */
public class test5 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入数组大小：");
        int n = sc.nextInt();

        int[] arr = new int[n];
        for(int i = 0;i < n;i++){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        System.out.println(arr[n-3]);
    }
}
