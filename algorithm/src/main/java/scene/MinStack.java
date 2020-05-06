package scene;

import java.util.Stack;

/**
 * @Author:Gpw
 * @Date:2020/3/23
 * @Description:设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈
 */
public class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    /** initialize your data structure here. */
    public MinStack() {
        this.stack = new Stack<>();
        this.minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty() || x < minStack.peek()) {
            minStack.push(x);
        }
    }

    public void pop() {
        if (!stack.isEmpty()) {
            int data = stack.pop();
            if (data == minStack.peek()) {
                minStack.pop();
            }
        }
    }

    public int top() {
        if (!stack.isEmpty()) {
            return stack.peek();
        }
        throw new RuntimeException("栈为空");
    }

    public int getMin() {
        if (!minStack.isEmpty()) {
            return minStack.peek();
        }
        throw new RuntimeException("栈为空");
    }
}
