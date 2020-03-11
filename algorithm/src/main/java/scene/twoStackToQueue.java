package scene;

import java.util.Stack;

/**
 * @Author:Gpw
 * @Date:2019/10/10
 * @Description:scene
 *  用两个栈来实现一个队列，完成队列的add poll peek操作。队列中的元素为int类型
 * @Version:1.0
 */
public class twoStackToQueue {

    //压入数据栈
    Stack<Integer> stackPush = new Stack<>();
    //弹出数据栈
    Stack<Integer> stackPop = new Stack<>();

    /**
     * 入队操作
     * 直接将数据压入压入数据栈
     * @param push
     */
    public void add(int push){
        stackPush.push(push);
    }

    /**
     * 出队操作
     * @return
     * @throws Exception
     */
    public int poll() throws Exception{
        if(stackPush.isEmpty() && stackPop.isEmpty()){
            throw new Exception("队列中没有数据");
        }else if(stackPop.isEmpty()){
            //弹出数据栈为空，可以将整个压入数据栈中的数据倒入弹出数据栈
            while(!stackPush.isEmpty()){
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.pop();
    }

    /**
     * 返回队头元素
     * @return
     * @throws Exception
     */
    public int peek() throws Exception{
        if(stackPush.isEmpty() && stackPop.isEmpty()){
            throw new Exception("队列中没有数据");
        }else if(stackPop.isEmpty()){
            //弹出数据栈为空，可以将整个压入数据栈中的数据倒入弹出数据栈
            while(!stackPush.isEmpty()){
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.peek();
    }
}
