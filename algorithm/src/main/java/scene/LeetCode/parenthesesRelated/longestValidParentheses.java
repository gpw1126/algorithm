package scene.LeetCode.parenthesesRelated;

import java.util.Stack;

/**
 * @Author: Gpw
 * @Date: 2020/6/2
 * @Description: leetcode.32 最长有效括号
 *  题目描述：给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 */
public class longestValidParentheses {

    /**
     * 方法一：使用栈
     *  首先将 −1 放入栈顶。
     *  对于遇到的每个 ‘(’ ，将它的下标放入栈中。
     *  对于遇到的每个 ‘)’ ，弹出栈顶的元素并将当前元素的下标与弹出元素后的栈顶元素下标作差，得出当前有效括号字符串的长度。
     *
     *  时间复杂度： O(n) ，n 是给定字符串的长度。
     *  空间复杂度： O(n) ，栈的大小最大达到 n。
     * @param s
     * @return
     */
    public static int method1(String s) {

        int maxLength = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            }
            else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                }
                else {
                    maxLength = Math.max(maxLength, i - stack.peek());
                }
            }
        }
        return maxLength;
    }

    /**
     * 方法二：不使用额外的空间
     *  利用两个计数器 left 和 right
     *  (1)首先，从左到右遍历字符串，对于遇到的每个 ‘(’，增加 left 计数器，对于遇到的每个 ‘)’ ，增加 right 计数器。
     *  每当 left 计数器与 right 计数器相等时，计算当前有效字符串的长度，并且记录目前为止找到的最长子字符串。如果 right 计数器比
     *  left 计数器大时，将 left 和 right 计数器同时变回 0 。
     *  (2)从右到左做一遍类似的工作。如果left计数器比right计数器大时，将 left 和 right 计数器同时变回 0 。
     *
     *  时间复杂度： O(n) 。遍历两遍字符串。
     *  空间复杂度： O(1) 。仅有两个额外的变量 left 和 right 。
     *
     * @param s
     * @return
     */
    public static int method2(String s) {

        int left = 0, right = 0, maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxLength = Math.max(maxLength, 2 * right);
            } else if (right >= left) {
                left = right = 0;
            }
        }

        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxLength = Math.max(maxLength, 2 * left);
            } else if (left > right) {
                left = right = 0;
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String s = "()((())";
        System.out.println("方法一结果：" + method1(s) + "\n" + "方法二结果：" + method2(s));
    }
}
