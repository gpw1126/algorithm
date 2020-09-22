package relatedKnowledge.DFS.islandProblem;

/**
 * @Author: Gpw
 * @Date: 2020/7/3
 * @Description: leetcode 695 岛屿的最大面积
 */
public class maxAreaOfIsland {

    public int solution(int[][] grid) {
        int cur = 0;
        int maxArea = 0;
        for (int i = 0;i < grid.length;i++) {
            for (int j = 0;j < grid[0].length;j++) {
                if (grid[i][j] == 1) {
                    cur = dfs(grid, i, j);
                    maxArea = Math.max(cur, maxArea);
                }
            }
        }
        return maxArea;
    }

    private int dfs(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) {
            return 0;
        }
        grid[i][j] = 0;
        return 1 + dfs(grid, i + 1, j) + dfs(grid, i, j + 1) + dfs(grid, i - 1, j) + dfs(grid, i, j - 1);
    }
}
