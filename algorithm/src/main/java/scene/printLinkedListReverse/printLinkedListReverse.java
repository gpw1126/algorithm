package scene.printLinkedListReverse;

import java.util.Stack;

/**
 * @Author:Gpw
 * @Date:2019/9/22
 * @Description:scene
 * 题目描述：
 * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList.不希望打印时修改内容(反转指针方向直接打印)
 *
 * 思考：
 *     第一个遍历到的结点最后一个输出，而最后一个遍历到的结点第一个输出，典型的“后进先出”，用栈来实现
 *     基于递归的代码看起来很简洁，但当链表非常长的时候，会导致函数调用的层数很深，有可能导致函数调用栈溢出
 *     显示用栈基于循环实现的代码的鲁棒性要好一些
 * @Version:1.0
 **/
public class printLinkedListReverse {

    //方法一：递归
    public static void print_Recursively(Node headNode){
        if(headNode != null){
            if(headNode.next != null){
                print_Recursively(headNode.next);
            }
        }
        System.out.println(headNode.data);
    }

    //方法二：非递归方式
    public static void print(Node headNode){
        Stack<Node> stack = new Stack<Node>();
        while(headNode != null){
            stack.push(headNode);
            headNode = headNode.next;
        }
        while(!stack.isEmpty()){
            System.out.println(stack.pop().data);
        }
    }

    public static void main(String[] args) {
        Node n1 = new Node();
        Node n2 = new Node();
        Node n3 = new Node();

        n1.data = 8;
        n1.next = n2;
        n2.data = 3;
        n2.next = n3;
        n3.data = 10;

//        print_Recursively(n1);
        print(n1);
    }
}
