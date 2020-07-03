package relatedKnowledge.dp.longestPalindrome;

/**
 * @Author:Gpw
 * @Date:2020/07/01
 * @Description: leetcode 516  给定一个字符串s，找到其中最长的回文子序列。
 *
 * 思考：
 * f[i][j] 表示 s 的第 i 个字符到第 j 个字符组成的子串中，最长的回文序列长度是多少
 * 如果 s 的第 i 个字符和第 j 个字符相同的话 f[i][j] = f[i + 1][j - 1] + 2
 * 如果 s 的第 i 个字符和第 j 个字符不同的话 f[i][j] = max(f[i + 1][j], f[i][j - 1])
 * 然后注意遍历顺序，i 从最后一个字符开始往前遍历，j 从 i + 1 开始往后遍历，这样可以保证每个子问题都已经算好了。
 * 初始化：f[i][i] = 1 单个字符的最长回文序列是 1   结果：f[0][n - 1]
 */
public class longestPalindromeSubseq {

    public int longestPalindromeSubseq(String str){
        int len = str.length();
        int[][] arr = new int[len][len];
        for(int i = len - 1;i >= 0;i--){
            arr[i][i] = 1;
            for(int j = i + 1;j < len;j++){
                if(str.charAt(i) == str.charAt(j)){
                    arr[i][j] = arr[i + 1][j - 1] + 2;
                }else arr[i][j] = Math.max(arr[i + 1][j],arr[i][j - 1]);
            }
        }
        return arr[0][len-1];
    }
}
