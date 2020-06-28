package relatedKnowledge.dp.maxSquare;

/**
 * @Author:Gpw
 * @Date:2020/6/25
 * @Description: LeetCode 221，最大正方形    在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 *              另见LeetCode 1277 全为1的正方形数量，与本题相似。
 */
public class maximalSquare {

    /**
     * 动态规划：用 dp(i,j) 表示以 (i,j) 为右下角且只包含 1 的正方形的边长最大值。
     *  1.如果该位置的值是 0，则 dp(i,j)=0，因为当前位置不可能在由 1 组成的正方形中；
     *  2.如果该位置的值是 1，则 dp(i,j) 的值由其上方、左方和左上方的三个相邻位置的 dp 值决定。具体而言，当前位置的元素值等于三个
     *   相邻位置的元素中的最小值加 11，状态转移方程如下：dp(i,j)=min(dp(i−1,j),dp(i−1,j−1),dp(i,j−1))+1
     *  3.边界条件：如果 i 和 j 中至少有一个为 0，则以位置 (i,j) 为右下角的最大正方形的边长只能是 1，因此 dp(i,j)=1。
     *
     * 时间复杂度：O(mn)
     * 空间复杂度：O(mn)
     * @return
     */
    public int maximalSquare(char[][] matrix) {

        int maxSide = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return maxSide;
        }

        int row = matrix.length, col = matrix[0].length;
        int[][] dp = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    }
                    else {
                        // Math.min()只能取两数最小，所以三个数只能用两个Math.min()
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                    maxSide = Math.max(dp[i][j], maxSide);
                }
            }
        }
        return maxSide * maxSide;
    }
}
