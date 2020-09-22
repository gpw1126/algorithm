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

    /**
     * 递归解法
     * @param head
     * @return
     */
    public static ListNode reverseLinkedListRecur(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 递归到最后一个结点，该结点就是发转后的头结点
        ListNode tail = reverseLinkedListRecur(head.next);
        // head的下一个结点指向head，完成一次反转
        head.next.next = head;
        head.next = null;
        return tail;
    }
}
