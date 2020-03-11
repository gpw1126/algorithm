package scene.findMiddleNode;

/**
 * @Author:Gpw
 * @Date:2019/10/21
 * @Description:scene.findMiddleNode
 * 给定一个非空的单链表和头节点头，返回链表的中间节点
 *
 * 思考：
 *  快慢指针：设置两个指针，一个快指针，每次走两步，一个慢指针，每次走一步，当快指针为空(偶数个节点)或者快指针的next指针指向空时(奇数个
 *  节点)，此时慢指针即为中间节点
 * @Version:1.0
 */
public class findMiddlebNode {
    public Node findMiddleNode(Node head){
        Node fast = head;
        Node slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
