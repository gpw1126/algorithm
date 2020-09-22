package scene.sort.heap_sort;

import java.util.Arrays;

/**
 * @Author: Gpw
 * @Date: 2020/7/21
 * @Description:
 *  堆排序是一种选择排序，整体主要由构建初始大顶堆+交换堆顶元素和末尾元素并重建堆两部分组成。
 *  构建初始堆复杂度为O(n)，交换并重建堆的过程中，需交换n-1次，而重建堆的过程中，根据完全二叉树的性质，[log2(n-1),log2(n-2)...1]逐步递
 *  减，近似为nlogn。所以堆排序时间复杂度最好最坏一般认为就是O(nlogn)，空间复杂度O(1)。
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void heapSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int len = arr.length;
        // 将堆中所有数据重新排序，使其成为最大堆
        buildMaxHeap(arr, len);

        // 交换堆顶和当前末尾的节点，重置大顶堆
        for (int i = len - 1;i > 0;i--) {
            swap(arr, 0, i);
            len--;
            maxHeapify(arr, 0, len);
        }
    }

    private static void buildMaxHeap(int[] arr, int len) {
        // 从最后一个非叶子节点开始向前遍历，调整节点性质使之成为大顶堆
        for (int i = len/2 -1; i >= 0; i--) {
            maxHeapify(arr, i, len);
        }
    }

    private static void maxHeapify(int[] arr, int i, int len) {
        // 先根据堆性质，找出它左右节点的索引
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        // 默认当前节点（父节点）是最大值。
        int largestIndex = i;
        if (left < len && arr[left] > arr[largestIndex]) {
            // 如果有左节点，并且左节点的值更大，更新最大值的索引
            largestIndex = left;
        }
        if (right < len && arr[right] > arr[largestIndex]) {
            // 如果有右节点，并且右节点的值更大，更新最大值的索引
            largestIndex = right;
        }

        if (largestIndex != i) {
            // 如果最大值不是当前非叶子节点的值，那么就把当前节点和最大值的子节点值互换
            swap(arr, i, largestIndex);
            // 因为互换之后，子节点的值变了，如果该子节点也有自己的子节点，仍需要再次调整。
            maxHeapify(arr, largestIndex, len);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
