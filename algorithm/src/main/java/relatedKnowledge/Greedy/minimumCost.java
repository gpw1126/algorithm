package relatedKnowledge.Greedy;

import java.util.PriorityQueue;

/**
 * @Author: Gpw
 * @Date: 2020/6/10
 * @Description: 分金条的最小花费。输入一个数组，返回分割的最小代价。
 *    一块金条切成两半，是需要花费和长度数值一样的铜板的。比如长度为20的 金条，不管切成长度多大的两半，都要花费20个铜板。
 * 一群人想整分整块金条，怎么分最省铜板？
 *    例如,给定数组{10,20,30}，代表一共三个人，整块金条长度为10+20+30=60. 金条要分成10,20,30三个部分。如果，先把长
 * 度60的金条分成10和50，花费60，再把长度50的金条分成20和30，花费50，一共花费110铜板。但是如果，先把长度60的金条分成30和30，
 * 花费60 再把长度30金条分成10和20，花费30 一共花费90铜板。
 *
 * 贪心策略，将给定的数组中的元素扔进小根堆，每次从小根堆中先后弹出两个元素（如10和20），这两个元素的和（如30）就是某次分割得到这两个元素
 * 的花费，再将这个和扔进小根堆。直到小根堆中只有一个元素为止。（比如扔进30之后，弹出30、30，此次花费为30+30=60，再扔进60，堆中只有
 * 一个60了，结束，总花费30+60=90）
 */
public class minimumCost {

    public static int minimumCost(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i : arr) {
            queue.add(i);
        }

        int res = 0, curCost = 0;
        while (queue.size() > 1) {
            curCost = queue.poll() + queue.poll();
            res += curCost;
            queue.add(curCost);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 30};
        System.out.println(minimumCost(arr));
    }
}
