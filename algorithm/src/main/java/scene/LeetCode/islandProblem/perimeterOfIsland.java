package scene.LeetCode.islandProblem;

/**
 * @Author: Gpw
 * @Date: 2020/7/3
 * @Description: leetcode 463 岛屿周长
 */
public class perimeterOfIsland {

    public int solution(int[][] grid) {
        for (int i = 0;i < grid.length;i++) {
            for (int j = 0;j < grid[0].length;j++) {
                if (grid[i][j] == 1) {
                    return dfs(grid, i, j);
                }
            }
        }
        return 0;
    }

    private int dfs(int[][] grid, int i, int j) {
        // 从一个岛屿走向边界或水域，周长加一
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) {
            return 1;
        }
        // 已遍历过（值为2）的岛屿直接返回，不会重复遍历
        if (grid[i][j] != 1) {
            return 0;
        }
        // 标记为已遍历
        grid[i][j] = 2;
        return dfs(grid, i + 1, j) + dfs(grid, i, j + 1) + dfs(grid, i - 1, j) + dfs(grid, i, j - 1);
    }
}
