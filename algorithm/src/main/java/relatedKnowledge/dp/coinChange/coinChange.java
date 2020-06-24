package relatedKnowledge.dp.coinChange;

import java.util.Arrays;

/**
 * @Author: Gpw
 * @Date: 2020/6/19
 * @Description: leetcode 322 凑硬币
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币
 * 组合能组成总金额，返回 -1。
 */
public class coinChange {

    /**
     * 动态规划：自下而上。
     * dp[i] = x 表示当目标金额为 i 时，至少需要 x 枚硬币。
     *       ⎧ 0, n=0
     * dp(n)=⎨ −1, n<0
     *       ⎩ min{dp(n), dp(n−coin)+1 | coin ∈ coins }, n>0
     * 时间复杂度：O(Sn)，其中 S 是金额，n 是面额数。我们一共需要计算 O(S) 个状态，S 为题目所给的总金额。
     *           对于每个状态，每次需要枚举 n 个面额来转移状态，所以一共需要 O(Sn) 的时间复杂度。
     * 空间复杂度：O(S)。DP 数组需要开长度为总金额 S 的空间。
     */
    public static int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount + 1];
        // dp 数组初始化为 amount + 1 ，因为凑成 amount 金额的数最多只可能等于 amount（全用 1 元面值的），
        // 所以初始化为 amount + 1 就相当于初始化为正无穷，便于后续取最小值。
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin < 0) {
                    continue;
                }
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        // 11 = 5 + 5 +1
        System.out.println(coinChange(coins, amount));
    }
}
