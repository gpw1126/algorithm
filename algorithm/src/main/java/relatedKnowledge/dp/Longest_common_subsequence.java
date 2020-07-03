package relatedKnowledge.dp;

import java.util.Scanner;

/**
 * @Author:Gpw
 * @Date:2019/10/11
 * @Description: LeetCode 1143
 *  1.最长公共子序列
 *  2.最长连续公共子序列
 *
 * 思考：采用动态规划思想，因为子问题重合了
 *  问题2，外循环从a数组开始，使用数组c存储中间值。对于数组a的前i个元素组成的子数组，和数组b的前j个元素组成的子数组，设它们
 * 的最大连续子数组为c[i][j]，若a的第i个元素等于b的第j个元素，则c[i][j]=c[i-1][j-1]+1，每次再与前一次保存的最大值比较即可。
 *  问题1，多了一个条件，a的第i个元素不等于b的第j个元素时，c[i][j]是从c[i-1][j]和c[i][j-1]中取最大值的，此时不要求连续，则可以
 * 跨过不等于的元素去后面找。
 */
public class Longest_common_subsequence {

    //最长公共子序列
    public static int LCS1(char[] a,char[] b){
        int m = a.length;
        int n = b.length;
        int[][] c = new int[m+1][n+1];
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(a[i]==b[j])
                    c[i+1][j+1] = c[i][j] + 1;
                else
                    c[i+1][j+1] = Math.max(c[i + 1][j], c[i][j + 1]);
            }
        }
        return c[m][n];
    }

    //最长连续公共子序列
    public static int LCS2(char[] a,char[] b){
        int m = a.length;
        int n = b.length;
        int[][] c = new int[m+1][n+1];
        int maxlen = 0;
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(a[i]==b[j])
                    c[i+1][j+1] = c[i][j] + 1;  //int[] 默认值为0
                if(c[i+1][j+1] > maxlen)
                    maxlen = c[i+1][j+1];
            }
        }
        return maxlen;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入第一个字符串");//asdfghjkl
        String str1 = sc.nextLine();
        System.out.println("请输入第二个字符串");//ardfbghjkp
        String str2 = sc.nextLine();
        char[] a = str1.toCharArray();
        char[] b = str2.toCharArray();
        System.out.println("最长公共子序列:" + LCS1(a,b) +"\n" + "最长连续公共子序列:" + LCS2(a,b));
    }
}