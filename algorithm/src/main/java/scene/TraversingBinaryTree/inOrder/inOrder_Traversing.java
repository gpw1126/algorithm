package scene.TraversingBinaryTree.inOrder;

import java.util.Stack;

/**
 * @Author:Gpw
 * @Date:2019/9/22
 * @Description:scene.TraversingBinaryTree.inOrder
 * @Version:1.0
 */
public class inOrder_Traversing {

    //递归
    public static void traverse01(Node node){
        if(node != null){
            traverse01(node.left);
            System.out.println(node.data);
            traverse01(node.right);
        }
    }

    //非递归
    public static void traverse02(Node node){
        Stack<Node> stack = new Stack<Node>();

        while(!stack.isEmpty() || node != null){
            while(node != null){
                stack.push(node);
                node = node.left;
            }
            while(!stack.isEmpty()){
                node = stack.pop();
                System.out.println(node.data);
                node = node.right;
            }
        }

    }
}
