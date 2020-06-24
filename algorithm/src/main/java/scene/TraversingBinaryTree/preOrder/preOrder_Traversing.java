package scene.TraversingBinaryTree.preOrder;

import java.util.Stack;

/**
 * @Author:Gpw
 * @Date:2019/9/22
 * @Description:scene.TraversingBinaryTree.preOrder
 * @Version:1.0
 */
public class preOrder_Traversing {

    //递归
    public static void traverse01(Node node){
        if(node != null){
            System.out.println(node.data);
            traverse01(node.left);
            traverse01(node.right);
        }
    }

    //非递归
    public static void traverse02(Node root){
        if (root == null) {
            return;
        }

        Stack<Node> stack = new Stack<Node>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            System.out.println(node.data);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }
}
