package scene.LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: Gpw
 * @Date: 2020/7/9
 * @Description: leetcode 128 最长连续子序列
 *  [100, 4, 200, 1, 3, 2] ——> 输出4(1,2,3,4)   要求算法的时间复杂度为 O(n)。
 */
public class longestConsecutiveSequece {

    public int longestConsecutiveSequece(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int longestLength = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int curNum = num;
                int curLength = 1;
                while (set.contains(curNum + 1)) {
                    curNum += 1;
                    curLength += 1;
                }
                longestLength = Math.max(longestLength, curLength);
            }
        }
        return longestLength;
    }
}
