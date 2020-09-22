package relatedKnowledge.SlideWindow;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Gpw
 * @Date: 2020/7/6
 * @Description: 剑指offer 57  和为s的连续正数序列  滑动窗口
 */
public class continuousSquence {

    public List<int[]> continuousSequence(int target) {
        // 滑动窗口的左右边界
        int i = 1, j = 1;
        // 滑动窗口中数字的和
        int sum = 0;
        List<int[]> res = new ArrayList<>();

        while (i <= target / 2) {
            if (sum < target) {
                // 右边界向右移动
                sum += j;
                j++;
            }
            else if (sum > target) {
                // 左边界向右移动
                sum -= i;
                i++;
            }
            else {
                // 记录结果
                int[] arr = new int[j - i];
                for (int m = i;m < j;m++) {
                    arr[m - i] = m;
                }
                res.add(arr);
                // 左边界向右移动
                sum -= i;
                i++;
            }
        }
        return res;
    }
}
