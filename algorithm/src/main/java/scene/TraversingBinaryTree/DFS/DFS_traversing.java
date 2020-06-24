package scene.TraversingBinaryTree.DFS;

import scene.TraversingBinaryTree.BFS.BFS_traversing;

import java.util.Stack;

/**
 * @Author:Gpw
 * @Date:2019/9/23
 * @Description:scene.TraversingBinaryTree.DFS
 *  二叉树的深度优先搜索
 *  数据结构：栈
 *  注：就是先序遍历
 *
 *  DFS：从根节点出发，沿着左子树方向进行纵向遍历，直到找到叶子节点为止。然后回溯到前一个节点，进行右子树节点的遍历，直到遍历完所有可达节点为止。
 *  实现：栈（后进先出）
 *  过程：父节点入栈，父节点出栈，先右子节点入栈，后左子节点入栈。递归遍历全部节点。这样一来，左子树结点就存在了栈顶上，因此某结点的左子树
 *       能在它的右子树遍历之前被遍历。
 * @Version:1.0
 */
public class DFS_traversing {

    //方法一
    public void traverse(Node root){

        if(root == null)
            return;

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()){
            Node node = stack.pop();
            System.out.println(node.data);
            //先将右子节点压栈
            if(node.right != null)
                stack.push(node.right);
            //再将左子节点压栈
            if(node.left != null)
                stack.push(node.left);
        }
    }


    //方法二：递归
    public void recursive(Node root){
        DFS_recursive(root);
    }
    public void DFS_recursive(Node root) {
        if(root == null)
            return;
        System.out.println(root.data);
        DFS_recursive(root.left);
        DFS_recursive(root.right);
    }

}
