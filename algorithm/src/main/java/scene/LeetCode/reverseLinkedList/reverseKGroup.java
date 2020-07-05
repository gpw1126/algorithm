package scene.LeetCode.reverseLinkedList;

/**
 * @Author:Gpw
 * @Date:2020/7/5
 * @Description: leetcode 25 k个一组翻转链表
 */
public class reverseKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode tail = pre;
        while (tail.next != null) {
            for (int i = 0;i < k && tail != null;i++) {
                tail = tail.next;
            }
            if (tail == null) {
                break;
            }
            ListNode next = tail.next;
            tail.next = null;
            pre.next = reverse(head);
            head.next = next;
            pre = head;
            tail = pre;
            head = next;
        }
        return dummy.next;
    }

    public ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
