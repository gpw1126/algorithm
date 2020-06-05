package scene.TraversingBinaryTree.BFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author:Gpw
 * @Date:2019/9/23
 * @Description:scene.TraversingBinaryTree.BFS
 *  二叉树的广度优先搜索
 *  数据结构：队列
 *
 *  BFS：从根节点出发，在横向遍历二叉树层段节点的基础上纵向遍历二叉树的层次
 * 实现：队列（先进先出）
 * 过程：父节点入队，父节点出队列，先左子节点入队，后右子节点入队。递归遍历全部节点。这样一来，左子树结点就存在队头，可以先被访问到。
 */
public class BFS_traversing {

    public void traverse(Node root){

        if(root == null)
            return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            Node node = queue.poll();
            System.out.println(node.data);
            if(node.left != null)
                queue.add(node.left);
            if(node.right != null)
                queue.add(node.right);
        }
    }
}