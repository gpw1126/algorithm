package scene.LeetCode.TopK;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class topK {

    /**
     * 剑指offer 40   找出最小的k个数
     *
     *  保持堆的大小为K，然后遍历数组中的数字，遍历的时候做如下判断：
     *  1. 若目前堆的大小小于K，将当前数字放入堆中。
     *  2. 否则判断当前数字与大根堆堆顶元素的大小关系，如果当前数字比大根堆堆顶还大，这个数就直接跳过；
     *     反之如果当前数字比大根堆堆顶小，先poll掉堆顶，再将该数字放入堆中。
     *
     *  由于使用了一个大小为 k 的堆，空间复杂度为 O(k)
     *  入堆和出堆操作的时间复杂度均为 O(logk)，每个元素都需要进行一次入堆操作，故算法的时间复杂度为 O(nlogk)。
     *
     * @param arr
     * @param k
     * @return
     */
    public int[] leastK(int[] arr, int k) {
        if (k == 0) {
            return new int[0];
        }

        // 维护一个最大堆
        // Java 的 PriorityQueue 默认是小顶堆，添加 comparator 参数使其变成最大堆
        Queue<Integer> heap = new PriorityQueue<>(k, (i1, i2) -> Integer.compare(i2, i1));

//        // 另一种写法
//        Queue<Integer> heap = new PriorityQueue<>(k, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2.compareTo(o1);
//            }
//        });

        for (int num : arr) {
            if (heap.size() < k) {
                heap.offer(num);
            }
            else if (heap.peek() > num){
                heap.poll();
                heap.offer(num);
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
