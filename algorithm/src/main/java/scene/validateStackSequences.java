package scene;

import java.util.Stack;

/**
 * @Author: Gpw
 * @Date: 2020/7/6
 * @Description: 剑指offer 31 栈的压入。弹出序列
 */
public class validateStackSequences {
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for(int n : pushed){
            stack.push(n);
            while(!stack.isEmpty() && stack.peek() == popped[i]){
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 2, 1}));
    }
}
