package scene.rebuildBinaryTree;

/**
 * @Author:Gpw
 * @Date:2019/9/22
 * @Description:scene.rebuildBinaryTree
 * 题目描述：
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回
 *
 * 思考：
 * 从前序遍历中拿出第一个，其一定是根节点对应的值，然后以其为分界点将中序遍历分为left和right两部分对应其左子树和右子树，然后将left
 * 和right当做新的中序遍历的结果，从前序遍历中拿出前 left个当做新的左子树的前序遍历结果，拿出后 right当做新的右子树的前序遍历结果，
 * 递归求解其left和right对应的二叉树，这样最终即可恢复整棵树。
 * @Version:1.0
 **/
public class rebuildBinaryTree {

    public static BinaryTreeNode rebuildBinaryTree(int[] preOrder, int[] inOrder){
        BinaryTreeNode root = rebuildBinaryTree(preOrder,0,preOrder.length-1,inOrder,0,inOrder.length-1);
        return root;
    }

    public static BinaryTreeNode rebuildBinaryTree(int[] preOrder, int startPre, int endPre, int[] inOrder, int startIn, int endIn){
        if(startPre > endPre || startIn > endIn)
            return null;

        BinaryTreeNode root = new BinaryTreeNode(preOrder[startPre]);

        for(int i = startIn;i < endIn;i++){
            if(inOrder[i] == preOrder[startPre]){
                root.left = rebuildBinaryTree(preOrder,startPre+1,startPre+i-startIn,inOrder,startIn,i-1);
                root.right = rebuildBinaryTree(preOrder,startPre+i-startIn+1,endPre,inOrder,i+1,endIn);
            }
        }

        return root;
    }

    //结果打印有待改善
    public static void main(String[] args) {
        int[] preOrder = {1,2,4,7,3,5,6,8};
        int[] inOrder = {4,7,2,1,5,3,8,6};
        System.out.println(rebuildBinaryTree(preOrder,inOrder));
    }
}