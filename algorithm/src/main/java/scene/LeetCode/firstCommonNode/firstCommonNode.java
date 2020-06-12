package scene.LeetCode.firstCommonNode;

/**
 * @Author:Gpw
 * @Date:2020/5/8
 * @Description: 剑指offer 52  LeetCode 160  找到两个单链表相交的起始节点
 */
public class firstCommonNode {

    /**
     * 两个链表相交，可能有环可能无环
     * 若有环，从头开始，快指针每次走两步，慢指针走一步，相遇后快指针指向头，每次两个指针都走一步，再次相遇结点就是所求
     * 若无环
     *  方法一：首先遍历两个链表得到它们的长度，就能知道哪个链表比较长，以及长的链表比短的链表多几个结点。在第二次遍历的时候，在较长的链表
     *  上先走若干步，接着再同时在两个链表上遍历，找到的第一个相同的结点就是它们的第一个公共结点。
     *  方法二：
     *  1.创建两个指针 pA 和 pB，分别初始化为链表 A 和 B 的头结点。然后让它们向后逐结点遍历。
     *  2.当 pA 到达链表的尾部时，将它重定位到链表 B 的头结点 ; 类似的，当 pB 到达链表的尾部时，将它重定位到链表 A 的头结点。
     *  3.若在某一时刻 pA和 pB 相遇，则 pA/pB 为相交结点。
     *  时间复杂度：O(M+N)
     *  空间复杂度：O(1)
     * 注：如果两个链表存在相交，它们末尾的结点必然相同。
     * @param head1
     * @param head2
     * @return
     */
    public ListNode findFirstCommonNode(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {
            return null;
        }

        ListNode pA = head1, pB = head2;
        while (pA != pB) {
            pA = pA == null ? head2 : pA.next;
            pB = pB == null ? head1 : pB.next;
        }
        return pA;
    }
}
