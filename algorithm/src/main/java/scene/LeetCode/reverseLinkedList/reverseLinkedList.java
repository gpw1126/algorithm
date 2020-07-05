package scene.LeetCode.reverseLinkedList;

/**
 * @Author:Gpw
 * @Date:2019/9/22
 * @Description: leetcode 206，剑指offer 24
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
    public static ListNode reverseLinkedList(ListNode head){

        if(head == null)
            return null;
        //前一结点
        ListNode preListNode = null;
        //当前结点
        ListNode curListNode = head;

        while(curListNode != null){
            ListNode nextListNode = curListNode.next;
            curListNode.next = preListNode;
            preListNode = curListNode;
            curListNode = nextListNode;
        }

        return preListNode;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        System.out.println(reverseLinkedList(n1).data);
    }
}
