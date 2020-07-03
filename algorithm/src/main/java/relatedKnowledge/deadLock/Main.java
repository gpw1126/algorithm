package relatedKnowledge.deadLock;

/**
 * @Author: Gpw
 * @Date: 2020/7/3
 * @Description: 嵌套synchronized 造成死锁
 */
public class Main {

    public static void main(String args[]) {
        MyThread mt1 = new MyThread();
        MyThread mt2 = new MyThread();
        mt1.flag = true;
        mt2.flag = false;
        Thread th1 = new Thread(mt1);
        Thread th2 = new Thread(mt2);
        th1.start();
        th2.start();
    }
}
