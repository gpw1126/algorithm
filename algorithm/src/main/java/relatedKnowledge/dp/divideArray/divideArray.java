package relatedKnowledge.dp.divideArray;

/**
 * @Author: Gpw
 * @Date: 2020/7/13
 * @Description: 将数组分为两部分，使得这两部分和最接近。不要求将数组平均分。
 */
public class divideArray {

    /**
     * 动态规划，转移方程dp[i][j] = max(dp[i-1][j],dp[i-1][j-vec[i]]+vec[i]);
     * dp[i][j]表示array中i个元素的和<=j，且是最接近j的元素集合。dp[i-1][j-array[i]]表示array中i-1个元素的和最接近j-array[i]，
     * 所以dp[i][j]应该是[i-1][j-array[i]]+array[i]和f[i-1][j]中最大的那个。有点像0-1背包问题。
     * @param array
     * @return
     */
    public static int divide(int[] array) {
        int sum = getSum(array);
        int length = array.length;
        int[][] dp = new int[length + 1][sum / 2 +1];
        for (int i = 0; i < length; i++) {
            for (int j = 1; j <= sum / 2; j++) {
                dp[i + 1][j] = dp[i][j];
                if (array[i] <= j && dp[i][j - array[i]] + array[i] > dp[i][j]) {
                    dp[i + 1][j] = dp[i][j - array[i]] + array[i];
                }
            }
        }
        return sum - 2 * dp[length][sum / 2];
    }

    public static int getSum(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] array = { 1, 0, 7, 2, 4 };
        System.out.println(divide(array));
    }
}
