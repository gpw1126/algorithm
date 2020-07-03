package scene.LeetCode.lowestCommonAncestor;

/**
 * @Author: Gpw
 * @Date: 2020/7/2
 * @Description:
 */
public class lowestCommonAncestor {

    /**
     * leetcode 235  二叉搜索树的最近公共祖先
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode BST(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (root.val > p.val && root.val > q.val) {
                root = root.left;
            }
            else if (root.val < p.val && root.val < q.val) {
                root = root.right;
            }
            else {
                break;
            }
        }
        return root;
    }

    /**
     * leetcode 236  二叉树的最近公共祖先
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode BT(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = BT(root.left, p, q);
        TreeNode right = BT(root.right, p, q);
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return root;
    }
}
