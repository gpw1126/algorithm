package scene.LeetCode.reverseLinkedList;

/**
 * @Author: Gpw
 * @Date: 2020/7/8
 * @Description: leetcode 61  链表向右移动k个位置
 */
public class rotateRightLinkedList {
    
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }

        int n;
        ListNode old_tail = head;
        for (n = 1;old_tail.next != null;n++) {
            old_tail = old_tail.next;
        }
        old_tail.next = head;

        ListNode new_tail = head;
        for (int i = 0; i < n - k % n - 1; i++) {
            new_tail = new_tail.next;
        }
        ListNode new_head = new_tail.next;

        new_tail.next = null;

        return new_head;
    }
}
