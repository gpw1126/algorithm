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
    public static void traverse02(Node node){
        Stack<Node> stack = new Stack<Node>();

        while(node != null || !stack.isEmpty()){
            while(node != null){
                System.out.println(node.data);
                stack.push(node);
                node = node.left;
            }
            if(!stack.isEmpty()){
                node = stack.pop();
                node = node.right;
            }
        }
    }
}
