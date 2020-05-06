package scene.LeetCode.oddBeforeEven;

/**
 * @Author:Gpw
 * @Date:2020/4/24
 * @Description:scene.LeetCode.oddBeforeEven  剑指offer 21
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 *  输入：nums = [1,2,3,4]  输出：[1,3,2,4]
 *  注：相对位置可变，[3,1,2,4] 也是正确的答案之一。
 *
 * 解法：
 *  1.头尾双指针
 *  2.快慢指针
 */
public class topic {

    /**
     * 头尾指针
     * x&1 位运算等价于 x%2 取余运算，即皆可用于判断数字奇偶性
     * @param nums
     */
    public static int[] solution1(int[] nums) {
        int i = 0,j = nums.length - 1,temp;
        while (i < j) {
            //错误记录：while中的i<j不能少
            while (i < j && (nums[i] & 1) == 1) i ++;
            while (i < j && (nums[j] & 1) == 0) j --;
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        return nums;
    }

    /**
     * 快慢指针
     * x&1 位运算等价于 x%2 取余运算，即皆可用于判断数字奇偶性
     * @param nums
     * @return
     */
    public static int[] solution2(int[] nums) {
        int slow = 0,fast = 0,temp;
        while (fast < nums.length) {
            if ((nums[fast] & 1) == 1) {
                temp = nums[fast];
                nums[fast] = nums[slow];
                nums[slow] = temp;
                slow ++;
            }
            fast ++;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {1,4,8,3,6,7};
//        int[] ans = solution1(nums);
        int[] ans = solution2(nums);
        for (int i = 0;i < ans.length;i ++)
            System.out.println(nums[i]);
    }
}
