package scene.LeetCode.rotateArrayRelated;

/**
 * @Author:Gpw
 * @Date:2020/4/24
 * @Description:scene.LeetCode.rotateArrayRelated
 *  剑指offer 11， LeetCode 154
 *  假设按照升序排序的数组在预先未知的某个点上进行了旋转。找出其中最小的元素。
 *  例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2]，最小值为 0 。
 *  注意数组中可能存在重复的元素。
 *
 *  解法：
 *  1.循环二分：设置 i, j 指针分别指向 numbers 数组左右两端，m=(i+j)//2 为每次二分的中点（ "//" 代表向下取整除法，因此恒有 i≤m<j ），
 *   可分为以下三种情况：
 *     1.当 numbers[m] > numbers[j]时： m 一定在左排序数组中，即旋转点 x 一定在 [m+1,j] 闭区间内，因此执行 i=m+1；
 *     2.当 numbers[m] < numbers[j]时： m 一定在右排序数组中，即旋转点 x 一定在 [i,m] 闭区间内，因此执行 j=m；
 *     3.当 numbers[m] == numbers[j]时：无法判断 m 在哪个排序数组中，即无法判断旋转点 x 在 [i,m] 还是 [m+1,j] 区间中。
 *       解决方案： 执行 j=j−1 缩小判断范围 。
 *  2.返回值： 当 i = j 时跳出二分循环，并返回 numbers[i] 即可。
 *
 *  时间复杂度 O(log2N)
 */
public class minValueInRotateSortArray {

    public int findMin(int[] nums) {
        int i = 0,j = nums.length - 1;
        while (i < j) {
            int m = (i + j) / 2;
            if (nums[m] > nums[j])
                i = m + 1;
            else if (nums[m] < nums[j])
                j = m;
            else j--;
        }
        return nums[i];
    }
}
