package relatedKnowledge.priorityQueue;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author: Gpw
 * @Date: 2020/6/8
 * @Description: leetcode 23 合并k个有序链表，使用优先队列
 */
public class priorityQueue {
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        // 根据传入链表首节点大小升序排列
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if (o1.val < o2.val) return -1;
                else if (o1.val == o2.val) return 0;
                else return 1;
            }
        });

        ListNode dummy = new ListNode(0);
        ListNode p = dummy;

        // 看似将每个节点挨个入队，其实是入队多个链表
        // 入队完成后队列结构为 1->3->4
        //                   2->4->5
        // 不是 2->4->5->1->3->4
        for (ListNode node : lists) {
            if (node != null) {
                queue.add(node);
            }
        }
        while (!queue.isEmpty()) {
            p.next = queue.poll();
            p = p.next;
            if (p.next != null) {
                queue.add(p.next);
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {

        ListNode p1 = new ListNode(2);
        p1.next = new ListNode(4);
        p1.next.next = new ListNode(5);

        ListNode p2 = new ListNode(1);
        p2.next = new ListNode(3);
        p2.next.next = new ListNode(4);

        ListNode[] lists = {p1, p2};

        ListNode node = mergeKLists(lists);
        System.out.println();
    }
}
