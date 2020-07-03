package scene.serializeBinaryTree;

/**
 * @Author:Gpw
 * @Date:2019/9/25
 * @Description:scene.serializeBinaryTree
 *  请实现两个函数，分别用来序列化和反序列化二叉树
 * @Version:1.0
 */
public class solution {

    //序列化
    static StringBuilder sb = new StringBuilder();

    public static String serialize(Node node){
        if(node == null){
            sb.append("#,");
            return sb.toString();
        }
        sb.append(node.data + ",");
        serialize(node.left);
        serialize(node.right);
        return sb.toString();
    }

    //反序列化
    static int index = 0;

    public static Node deSerialize(String str){
        if(str == null || str.trim().equals(""))
            return null;

        String[] strArr = str.split(",");
        Node node = null;
        if(strArr[index].equals("#")){
            index++;
            return null;
        }else{
            System.out.print(strArr[index] + " ");
            node = new Node(Integer.parseInt(strArr[index++]));
            node.left = deSerialize(str);
            node.right = deSerialize(str);
        }
        return node;
    }

    public static void main(String[] args) {
        Node A = new Node(8);
        Node B = new Node(6);
        Node C = new Node(10);
        Node D = new Node(5);
        Node E = new Node(7);
        Node F = new Node(9);
        Node G = new Node(11);

        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        C.left = F;
        C.right = G;

        String str = serialize(A);
        System.out.println(str);
        deSerialize(str);
    }
}
