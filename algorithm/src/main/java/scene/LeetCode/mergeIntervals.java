package scene.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * leetcode 56 medium 合并区间
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 */
public class mergeIntervals {

    /**
     * 贪心算法，总是做出在当前看来是最好的选择。
     *
     * 首先，我们将列表中的区间按照左端点升序排序。然后我们将第一个区间加入数组中，并按顺序依次考虑之后的每个区间：
     * 如果当前区间的左端点在数组中最后一个区间的右端点之后，那么它们不会重合，我们可以直接将这个区间加入数组的末尾；
     * 否则，它们重合，用当前区间的右端点更新数组中最后一个区间的右端点，将其置为二者的较大值。
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[0][];
        }
        if (intervals.length < 2) {
            return intervals;
        }

        // 按照区间起点大小排序
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> resList = new ArrayList<>();
        resList.add(intervals[0]);

        for (int i = 1;i < intervals.length;i++) {
            int[] curInterval = intervals[i];
            // 将当前区间与最后区间的末尾断点进行比较
            int[] temp = resList.get(resList.size() - 1);
            if (curInterval[0] > temp[1]) {
                resList.add(curInterval);
            }
            else {
                // 取最大作为末端点
                temp[1] = Math.max(curInterval[1], temp[1]);
            }
        }
        return resList.toArray(new int[resList.size()][]);
    }

    public static void main(String[] args) {
        mergeIntervals mergeIntervals = new mergeIntervals();
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] res = mergeIntervals.merge(intervals);
        for (int i = 0; i < res.length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }
    }
}
