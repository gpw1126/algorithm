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
        Node curNode = node;
        //上次访问结点
        Node lastNode = node;

        Stack<Node> stack = new Stack<Node>();

        //将左下角作为当前访问节点
        while(curNode != null){
            stack.push(curNode);
            curNode = curNode.left;
        }

        while(!stack.isEmpty()){
            curNode = stack.pop();
            //根节点不被访问前提是右子树不为空或右子树未被访问
            if(curNode.right != null && curNode.right != lastNode){
                //根节点再次入栈
                stack.push(curNode);
                curNode = curNode.right;
                while(curNode != null){
                    stack.push(curNode);
                    curNode = curNode.left;
                }
            }else{
                curNode = stack.pop();
                lastNode = curNode;
            }
        }
    }
}
