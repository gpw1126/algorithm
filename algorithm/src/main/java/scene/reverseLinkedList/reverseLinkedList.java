package scene.reverseLinkedList;

/**
 * @Author:Gpw
 * @Date:2019/9/22
 * @Description:scene.reverseLinkedList
 * 题目描述：定义一个函数，输入一个链表的头结点，反转该链表并输出反转后链表的头结点
 * 思考：当前结点不为空时，循环一下步骤：
 *  1.保存下一结点
 *  2.结点的next指针指向上一节点
 *  3.当前结点成为preNode
 *  4.保存的下一节点成为当前结点
 *
 *  此时当前结点为空，则返回上一结点，即为反转链表的头结点
 *  时间复杂度 O(n)
 **/
public class reverseLinkedList {
    public static Node reverseLinkedList(Node head){

        if(head == null)
            return null;
        //前一结点
        Node preNode = null;
        //当前结点
        Node curNode = head;

        while(curNode != null){
            Node nextNode = curNode.next;
            curNode.next = preNode;
            preNode = curNode;
            curNode = nextNode;
        }

        return preNode;
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        System.out.println(reverseLinkedList(n1).data);
    }
}
