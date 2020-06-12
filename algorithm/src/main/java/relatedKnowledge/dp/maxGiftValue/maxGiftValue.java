package relatedKnowledge.dp.maxGiftValue;

/**
 * @Author: Gpw
 * @Date: 2020/6/11
 * @Description: 剑指offer 47 礼物的最大价值
 *  动态规划：转移方程 f(i,j)=max[f(i,j−1),f(i−1,j)]+grid(i,j)
 *  dp[i][j] 只与 dp[i-1][j] , dp[i][j−1] , grid[i][j] 有关系，因此可以将原矩阵 grid 用作 dp 矩阵，即直接在 grid 上修改即可
 *  初始状态： dp[0][0] = grid[0][0] ，即到达单元格 (0,0) 时能拿到礼物的最大累计价值为 grid[0][0] ；
 *  返回值： dp[m−1][n−1] ，m, n 分别为矩阵的行高和列宽，即返回 dp 矩阵右下角元素。
 */
public class maxGiftValue {

    public  int maxGiftValue(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        for (int i = 0;i < row;i++) {
            for (int j = 0;j < col;j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if (i == 0) {
                    grid[i][j] += grid[i][j-1];
                }
                else if (j == 0) {
                    grid[i][j] += grid[i - 1][j];
                }
                else grid[i][j] += Math.max(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        return grid[row - 1][col - 1];
    }
}
