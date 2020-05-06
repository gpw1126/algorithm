package scene.LeetCode.rotateArrayRelated;


/**
 * @Author:Gpw
 * @Date:2020/3/24
 * @Description:旋转数组。数组中的元素向右移动 k 个位置，其中 k 是非负数
 *
 *  基于这个事实：当我们旋转数组 k 次，k%n 个尾部元素会被移动到头部，剩下的元素会被向后移动。首先将所有元素反转。然后反转前 k 个元素，
 *  再反转后面 n−k 个元素，就能得到想要的结果。
 *
 *  其余解决方法见 LeetCode 189
 */

public class rotateArray {

    public static void rotate(int[] nums, int k) {
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
    }

    public static void reverse(int[] nums, int start, int end){

        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {

        int[] nums = {-1,3,100,99,-30,8,66,0};
        rotate(nums, 3);
        for (int i : nums) {
            System.out.println(i);
        }
    }
}
