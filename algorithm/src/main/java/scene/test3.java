package scene;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: Gpw
 * @Date: 2019/8/2
 * @Description: PACKAGE_NAME
 * 给定两个长度为N的整型数组A和B。如果Ai==Bj则认为（i，j）为最佳配对。所有的最佳配对在满足以下条件的情况下组成最佳配对集合：
 * A和B中的各个元素最多在集合中出现一次。例如，A =「5， 10， 11，12， 14」，B = 「8， 9 ，11， 11， 5」，配对集合
 * 为「（0，4），（2，2），（2，3）」，因为在集合A中索引2出现了两次，所以上面的配对集合不是最佳配对集合。你的任务是修改B中
 * 的一个元素，使得最佳配对集合的元素最多。并输出最佳配对集合的数量。
 * 输入描述:
 * 输入第一行为一个数字N，表示数组A和B的长度。输入第2行和3行都是N个数字，分别表示数组A和B的元素
 * 输出描述:
 * 修改B中的一个元素，并打印最大的最佳配对集合数量。注意：必须修改B中的一个元素。
 * 示例1
 * 输入
 * 4
 * 1 2 3 4
 * 1 2 3 3
 * 输出
 * 4
 * @Version: 1.0
 */
public class test3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入数组大小:");
        int n = sc.nextInt();
        System.out.println();

        int[] arr1 = new int[n];
        int[] arr2 = new int[n];

        for(int i = 0; i < n; i++){
            arr1[i] = sc.nextInt();
        }
        System.out.println("arr1 SUCCESS!");

        for(int i = 0; i < n; i++){
            arr2[i] = sc.nextInt();
        }
        System.out.println("arr2 SUCCESS!");

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int count = 0;
        int i = 0,j = 0;
        while(i < n && j < n){
            if(arr1[i] == arr2[j]){
                i++;
                j++;
                count++;
            }
            else if(arr1[i] > arr2[j]) j++;
            else if(arr1[i] < arr2[j]) i++;
        }

        if(count == n) count--;
        else count++;

        System.out.println("最佳配对集合的数量:" + count);
    }
}
