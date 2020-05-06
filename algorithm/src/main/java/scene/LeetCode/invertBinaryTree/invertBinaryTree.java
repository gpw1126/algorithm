package scene.LeetCode.invertBinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author:Gpw
 * @Date:2020/4/1
 * @Description:scene.LeetCode.invertBinaryTree LeetCode 226
 *  翻转二叉树
 *       4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 */
public class invertBinaryTree {

    /**
     * 方法一：递归实现
     * 树中的每个节点都只被访问一次，时间复杂度就是 O(n)，n 是树中节点的个数
     * 本方法使用了递归，在最坏情况下栈内需要存放 O(h)个方法调用，其中 h 是树的高度。由于 h 属于 O(n)，可得空间复杂度为 O(n)
     * @param root
     * @return
     */
    public TreeNode recursive(TreeNode root) {

        if (root == null) {
            return null;
        }

        TreeNode right = recursive(root.right);
        TreeNode left = recursive(root.left);
        root.right = left;
        root.left = right;
        return root;
    }

    /**
     * 方法二：迭代实现，与 BFS接近
     * 树中的每个节点都只被访问 /入队一次，时间复杂度是 O(n)，其中 n 是树中节点的个数
     * @param root
     * @return
     */
    public TreeNode iterate(TreeNode root) {

        if (root == null) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            TreeNode temp = cur.left;
            cur.left = cur.right;
            cur.right = temp;
            if (cur.left != null) queue.add(cur.left);
            if (cur.right != null) queue.add(cur.right);
        }
        return root;
    }
}
