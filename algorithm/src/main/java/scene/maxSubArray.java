package scene;

import java.util.Scanner;

/**
 * @Author: Gpw
 * @Date: 2019/8/1
 * @Description: PACKAGE_NAME
 * 输入一个整形数组（可能有正数和负数），求数组中连续子数组（最少有一个元素）的最大和。要求时间复杂度为O(n)。
 * 输入描述:
 * 【重要】第一行为数组的长度N（N>=1）
 * 接下来N行，每行一个数，代表数组的N个元素
 * 输出描述:最大和的结果
 * 输入
 * 8
 * 1
 * -2
 * 3
 * 10
 * -4
 * 7
 * 2
 * -5
 * 输出
 * 18
 * 说明
 * 最大子数组为 3, 10, -4, 7, 2
 * @Version: 1.0
 */
public class maxSubArray {
    public static void main(String[] args){
//        FindGreatestSumOfSubArray1();
        FindGreatestSumOfSubArray2();
    }

    public static void FindGreatestSumOfSubArray2(){
        /**
         * 时间复杂度为O(n)
         */
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int sum = arr[0],max = arr[0];
        for(int i = 1; i < n; i++){
            sum = (sum < 0) ? arr[i] : sum + arr[i];
            max = (sum > max) ? sum : max;
        }
        System.out.println(max);
    }

    public static void FindGreatestSumOfSubArray1(){
        /**
         * 时间复杂度为O(n2)
         */
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int max = arr[0];
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n ; j++) {
                sum = sum + arr[j];
                if (sum > max)
                    max = sum;
            }
        }
        System.out.println(max);
    }
}