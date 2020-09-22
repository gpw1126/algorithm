package scene.LeetCode.treeToDoublyList;

/**
 * @Author: Gpw
 * @Date: 2020/7/14
 * @Description: 剑指offer 36  二叉搜索树与双向链表
 */
public class treeToDoublyList {

    Node head, pre;
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    public void dfs(Node cur) {
        if (cur == null) {
            return;
        }
        dfs(cur.left);
        if (pre != null) {
            pre.right = cur;
        }
        else {
            head = cur;
        }
        cur.left = pre;
        pre = cur;
        dfs(cur.right);
    }
}
