package scene;

import java.util.Arrays;
import java.util.Stack;

/**
 * @Author: Gpw
 * @Date: 2020/7/22
 * @Description: 找出数组中每个数右边第一个比他大的数
 *  方法一：暴力遍历求解，O(n2)
 *  方法二：栈，O(n)
 */
public class findFirstBiggerNum {

    /**
     *（1）初始化栈，里面为第一个元素索引0值；
     *
     *（2）遍历到下一个元素A[i]
     *  1）如果栈不为空且当前遍历的元素值A[i]大于栈顶的元素值A[stack.peek()]，说明当前元素正好是栈顶元素右边第一个比它大的元素，将栈顶元
     *     素弹出，result[stack.pop()]=A[i]。继续遍历的元素值A[i]是否大于新栈顶元素值A[stack.peek()]，如果大于，说明A[i]也是比
     *     A[stack.peek()]右边第一个比它大的元素，将栈顶元素弹出，result[stack.pop()]=A[i]，一直循环，直到不满足条件1），即栈顶为空
     *     或是当前遍历的元素值小于栈顶元素索引处的值。
     *  2）如果栈为空，说明前面的元素都找到了比它右边大的元素，则直接将当前元素的索引放入栈中；
     *  3）如果当前遍历的元素值A[i]小于栈顶元素索引的值A[stack.peek()]，说明还未找到栈顶元素中右边第一个比它大的元素，直接将当前遍历的元
     *     素的索引入栈即可stack.push(i)。将i++，重复步骤（2）
     *
     *（3）直到遍历完所有元素，如果栈不为空，说明栈中保存的全是未找到右边第一个比它大的数组索引，我们依次将这些栈元素出栈，并赋值
     *     result[stack.pop()]=-1即可。
     * @param nums
     * @return
     */
    public static int[] solution(int[] nums) {
        if (nums == null) {
            return null;
        }
        int[] ans = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int i = 1;
        while (i < nums.length){
            if (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                ans[stack.pop()] = nums[i];
            }
            else {
                stack.push(i);
                i++;
            }
        }
        while (!stack.isEmpty()) {
            ans[stack.pop()] = -1;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {8, 2, 5, 4, 3, 9, 7, 2, 5};
        System.out.println(Arrays.toString(solution(nums)));
    }
}
