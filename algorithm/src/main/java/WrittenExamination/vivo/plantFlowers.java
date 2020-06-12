package WrittenExamination.vivo;

import java.util.Scanner;

/**
 * @Author: Gpw
 * @Date: 2020/6/8
 * @Description: 2021届vivo提前批笔试题1 种花问题 leetcode 605
 *  笔试题2 leetcode 887 鸡蛋掉落为问题 再看
 *
 * 时间复杂度：O(N)，其中 N 是数组 flower 的长度。
 * 空间复杂度：O(1)。
 */
public class plantFlowers {

    public static int plantFlowers(int[] flower, int n) {
        int i = 0, count = 0;
        while (i < flower.length) {
            if (flower[i] == 0 && (i == 0 || flower[i - 1] == 0) && (i == flower.length - 1 || flower[i + 1] == 0)) {
                flower[i] = 1;
                count++;
            }
            i++;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] flower = new int[n];
        for (int i = 0;i < n;i++) {
            flower[i] = sc.nextInt();
        }
        System.out.println("该土地还可新种植植物的最大数目为：" + plantFlowers(flower, n));
    }
}
