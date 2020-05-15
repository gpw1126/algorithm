package scene.LeetCode.mergeTwoSortedList;

/**
 * @Author:Gpw
 * @Date:2020/5/8
 * @Description: 剑指offer 25  合并两个有序链表
 */
public class mergeTwoSortedList {

    /**
     * 方法一：递归实现
     *  如果 l1 或者 l2 一开始就是空链表 ，那么没有任何操作需要合并，所以我们只需要返回非空链表。否则，我们要判断 l1 和 l2 哪一个链表的
     *  头节点的值更小，然后递归地决定下一个添加到结果里的节点。如果两个链表有一个为空，递归结束。
     *
     *  时间复杂度：O(n + m)
     *  空间复杂度：O(n + m)
     * @param l1
     * @param l2
     * @return
     */
    public ListNode recursive(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        else if (l2 == null) {
            return l1;
        }
        else if (l1.val < l2.val) {
            l1.next = recursive(l1.next, l2);
            return l1;
        }
        else {
            l2.next = recursive(l1, l2.next);
            return l2;
        }
    }

    /**
     * 方法二：迭代
     *  当 l1 和 l2 都不是空链表时，判断 l1 和 l2 哪一个链表的头节点的值更小，将较小值的节点添加到结果里，当一个节点被添加到结果里之后，
     *  将对应链表中的节点向后移一位。
     *
     *  时间复杂度：O(n + m)
     *  空间复杂度：O(1)
     * @param l1
     * @param l2
     * @return
     */
    public ListNode iterate(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode cur = dummyHead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            }
            else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
        cur.next = l1 ==null ? l2 : l1;

        return dummyHead.next;
    }
}
