package scene.LeetCode.rightSideView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: Gpw
 * @Date: 2020/7/7
 * @Description: leetcode 199 二叉树的右视图  BFS实现
 */
public class rightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0;i < size;i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                // 将当前层的最后一个节点放入结果列表
                if (i == size - 1) {
                    res.add(node.val);
                }
            }
        }
        return res;
    }
}
