package scene.TraversingBinaryTree.postOrder;

import java.util.Stack;

/**
 * @Author:Gpw
 * @Date:2019/9/22
 * @Description:scene.TraversingBinaryTree.postOrder
 * @Version:1.0
 */
public class postOrder_Traversing {

    //方法一：递归
    public static void traverse01(Node node){
        if(node != null){
            traverse01(node.left);
            traverse01(node.right);
            System.out.println(node.data);
        }
    }

    //方法二：非递归
    public static void traverse02(Node node){
        /**
         * 难点：需要判断上次访问的结点是位于左子树还是右子树
         *  位于左子树：跳过根节点，访问右子树
         *  位于右子树；直接访问根节点
         */
        if(node == null)
            return;

        //当前访问结点
        Node curNode = null;
        //上次访问结点
        Node preNode = null;

        Stack<Node> stack = new Stack<Node>();
        stack.push(node);

        while (!stack.isEmpty()) {
            curNode = stack.peek();
            if ((curNode.left == null && curNode.right == null)
                    || (preNode != null && (preNode == curNode.left || preNode == curNode.right))) {
                System.out.println(curNode.data);
                stack.pop();
                preNode = curNode;
            }
            else {
                if (curNode.right != null) {
                    stack.push(curNode.right);
                }
                if (curNode.left != null) {
                    stack.push(curNode.left);
                }
            }
        }
    }
}
