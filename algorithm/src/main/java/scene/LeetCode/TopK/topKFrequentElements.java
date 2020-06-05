package scene.LeetCode.TopK;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Author: Gpw
 * @Date: 2020/6/3
 * @Description: leetcode 347,前k个高频元素
 *  输入: nums = [1,1,1,2,2,3], k = 2，输出: [1,2]
 *
 *  时间复杂度：O(Nlog(k))，N是数组长度。维护元素频率O(N),N个元素入堆出堆O(Nlog(K)),总的时间复杂度为O(Nlog(K))。
 *  空间复杂度：O(N)，存储哈希表的开销（最坏情况下需要存储N个键值对）。
 *
 *  leetcode 692相似，题解中的lambda表达式需要看下
 */
public class topKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {

        // 维护元素频率
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        // 按频率升序初始化堆（小顶堆）
        Queue<Integer> heap = new PriorityQueue<>((n1, n2) -> countMap.get(n1) - countMap.get(n2));

        // 在堆中维护最常见的k个元素
        for (int n : countMap.keySet()) {
            heap.add(n);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        // 返回堆中元素
        int[] ans = new int[heap.size()];
        int index = 0;
        for (int e : heap) {
            ans[index++] = e;
        }
        return ans;
    }
}
