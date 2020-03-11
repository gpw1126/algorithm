package scene;

import java.util.Scanner;

/**
 * @Author:Gpw
 * @Date:2019/10/10
 * @Description:scene.getBin1Count
 * 给定一个十进制非负数N，要求出0到N这N+1个数的二进制表示中1的个数
 * 输入：5   输出：[0,1,1,2,1,2]
 *
 * 基本思路：
 *   从二进制数的生成方式考虑这道题，比如说8–1000，接下来的7个数就是8+1，8+2，8+3…,对应二进制数中1的个数就是1（8的那个1）+src[i]
 *   (i中包含的1的个数)，这样就可以一直重复，生成最后结果
 * @Version:1.0
 */
public class getBin1Count {
    public static void main(String[] args) {
        int[] src = new int[1000000];
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.close();
        src[0] = 0;
        for (int i = 1; i <= n; ) {
            int tmp = i;
            for (int j = 0; j < tmp ; j++) {
                src[i++] = 1 + src[j];
            }
        }
        for (int i = 0; i <= n; i++) {
            if(i==0){
                System.out.print("["+src[i]);
            }else{
                System.out.print(","+src[i]);
            }
        }
        System.out.println("]");
    }
}
