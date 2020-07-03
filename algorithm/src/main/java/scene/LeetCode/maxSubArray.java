package scene.LeetCode;

import java.util.Scanner;

/**
 * @Author: Gpw
 * @Date: 2019/8/1
 * @Description: 最大连续子数组   剑指offer 42     LeetCode 53
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
            max = Math.max(sum, max);
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