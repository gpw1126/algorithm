package scene.StackImpl.LinkedListToStack;

/**
 * @Author: Gpw
 * @Date: 2020/6/11
 * @Description:
 */
public class Stack {

    Node top;
    int count;
    int size;

    // 初始化一个栈
    public Stack(int size) {
        this.top = null;
        this.count = 0;
        this.size = size;
    }

    // 初始化头结点
    public void setTop(Node top) {
        this.top = top;
    }

    public boolean isFull() {
        if (count == size) {
            return true;
        }
        return false;
    }

    public boolean isEmpty() {
        if (count == 0) {
            return true;
        }
        return false;
    }

    public Node peek() {
        if (isEmpty()) {
            throw new RuntimeException("栈为空！");
        }
        return top;
    }

    public void push(Object value) {
        if (this.isFull()) {
            throw new RuntimeException("栈已满，不能入栈！");
        }
        Node curNode = new Node(value, top);
        top = curNode;
        count++;
    }

    public Node pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈为空！");
        }
        top = top.next;
        count--;
        return top;
    }

    public static void main(String[] args) {
        Stack stack = new Stack(5);
    }
}
