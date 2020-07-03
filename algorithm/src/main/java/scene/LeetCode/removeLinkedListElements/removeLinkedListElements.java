package scene.LeetCode.removeLinkedListElements;

/**
 * @Author:Gpw
 * @Date:2020/3/30
 * @Description:scene.LeetCode.removeLinkedListElements
 *  移除链表元素 输入: 1->2->6->3->4->5->6, val = 6 输出: 1->2->3->4->5
 * 思考：
 *   加入哨兵结点,广泛应用于树和链表中，如伪头、伪尾、标记等，它们是纯功能的，通常不保存任何数据，其主要目的是使链表标准化，如使链表永不为空、
 *  永不无头、简化插入和删除。
 */
public class removeLinkedListElements {

    public ListNode remove(ListNode head, int val) {

        ListNode sentinel = new ListNode(0);
        sentinel.next = head;

        ListNode pre = sentinel, cur = head;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
            }
            else {
                pre.next = cur;
            }
            cur = cur.next;
        }
        return sentinel.next;
    }
}
