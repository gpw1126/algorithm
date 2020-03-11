package scene;

/**
 * @Author:Gpw
 * @Date:2019/9/22
 * @Description:scene.isBinarySortTreePostOrder
 * 题目描述：
 *  输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则返回true。否则返回false。假设输入的数组的任意两个数字都互不相同。
 *
 * 思考：
 *  1.最后一个元素是根节点
 *  2.整个序列一定可以分为两部分。前半部分都比根节点小，后半部分都比根节点大，且两部分也为二叉搜索时树
 *  3.递归实现
 * @Version:1.0
 */
public class isBinarySortTreePostOrder {

    public static boolean isPostOrder(int[] postOrder){
        if(postOrder == null || postOrder.length == 0)
            return false;
        return isPostOrder(postOrder,0,postOrder.length-1);
    }

    public static boolean isPostOrder(int[] postOrder,int start,int end){
        if(start >= end)
            return true;

        //找左右子树分界点
        int root = postOrder[end];
        int i = 0;
        for(i = start;i < end;i++){
            if(postOrder[i] > root)
                break;
        }

        //若右子树有结点比根小，则不是后序遍历序列
        for(int j = i;j < end;j++){
            if(postOrder[j] < root)
                return false;
        }

        return (isPostOrder(postOrder,start,i-1) && isPostOrder(postOrder,i,end-1));
    }

    public static void main(String[] args) {
        int[] a = {5, 7, 6, 9, 11, 10, 8};
        int[] b = {7, 4, 6, 5};
        System.out.println(isPostOrder(a));
        System.out.println(isPostOrder(b));
    }
}
