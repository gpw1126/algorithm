package WrittenExamination.vivo.mergeKLists;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @Author: Gpw
 * @Date: 2020/6/8
 * @Description: 2021届vivo提前批笔试题3 合并k个有序链表 leetcode 23
 *
 * nextInt() 会读取一个int类型的整数，但是会把空白符留下，也就是说焦点不会移动到下一行，仍在这一行。
 * nextLine() 会读取该行剩余的所有内容，包括换行符，以换行符结束，然后把焦点移动到下一行的开头。
 * next() 是以换行或者空白符为界线接收有效字符，接受到有效字符结束，后面的空格或换行符留给之后的操作。
 */
public class mergeKLists {

    /**
     * 方法一 使用优先队列
     * 时间复杂度：O(n*log(k))，n 是所有链表中元素的总和，k 是链表个数。
     * @param lists
     * @return
     */
    public static ListNode mergeKListsUsePriorityQueue(ListNode[] lists) {
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


    /**
     * 方法二 分而治之
     * @param lists
     * @return
     */
    public static ListNode mergeKListsUseMergeSort(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return merge(lists, 0, lists.length - 1);
    }
    public static ListNode merge(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }
        int mid = left + (right - left) / 2;
        ListNode l1 = merge(lists, left, mid);
        ListNode l2 = merge(lists, mid + 1, right);
        return mergeTwoLists(l1, l2);
    }
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // 这行很重要，目的是换行
        sc.nextLine();

        ListNode[] lists = new ListNode[n];
        String[] input = new String[n];

        // 若是没有上面那个换行操作，nextLine()会把上面nextInt()后输入的回车算作第一个输入导致数组第一个接收的是""
        // 因为nextInt()结束后不会换行，
        for (int i = 0; i < n; i++) {
            input[i] = sc.nextLine();
        }
        for (int i = 0; i < input.length; i++) {
            String in = input[i];
            String[] split = in.trim().split(" ");
            ListNode dummy = new ListNode(0);
            ListNode p = dummy;
            for (int j = 0; j < split.length; j++) {
                p.next = new ListNode(Integer.parseInt(split[j]));
                p = p.next;
            }
            lists[i] = dummy.next;
        }

//        ListNode node = mergeKListsUsePriorityQueue(lists);
        ListNode node = mergeKListsUseMergeSort(lists);
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }
}
