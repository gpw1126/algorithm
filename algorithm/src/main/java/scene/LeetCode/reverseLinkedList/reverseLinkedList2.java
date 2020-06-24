package scene.LeetCode.reverseLinkedList;

/**
 * @Author: Gpw
 * @Date: 2020/6/24
 * @Description: leetcode 92，反转链表2
 *  反转从位置 m 到 n 的链表，使用一趟扫描完成反转。
 *  输入: 1->2->3->4->5->NULL, m = 2, n = 4， 输出: 1->4->3->2->5->NULL
 */
public class reverseLinkedList2 {

    /**
     * 思路：head表示需要反转的头节点，pre表示需要反转头节点的前驱节点。将 [m+1,n] 的节点按顺序依次插到位置 m 之前，这样就完成了反转。
     * @param head
     * @param m
     * @param n
     * @return
     */
    public static Node reverseLinkedList(Node head, int m, int n) {
        Node dummy = new Node(0);
        dummy.next = head;
        Node pre = dummy;
        for (int i = 1; i < m; i++) {
            pre = pre.next;
            head = pre.next;
        }
        for (int i = m; i < n; i++) {
            Node next = head.next;
            head.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        Node res = reverseLinkedList(head, 2, 4);
    }
}
