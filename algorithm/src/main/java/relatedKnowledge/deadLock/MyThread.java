package relatedKnowledge.deadLock;

/**
 * @Author: Gpw
 * @Date: 2020/7/3
 * @Description:
 */
public class MyThread implements Runnable {
    public static A a = new A();
    public static B b = new B();
    public boolean flag = false;
    public void run(){
        if(flag){
            synchronized(a){
                a.get();
                try{
                    Thread.sleep(500);
                }catch(InterruptedException e){}

                synchronized(b){     //此同步代码块在另一同步代码块里
                    a.say();
                }
            }
        }else{
            synchronized(b){
                b.get();
                try{
                    Thread.sleep(500);
                }catch(InterruptedException e){}

                synchronized(a){     //此同步代码块在另一同步代码块里
                    b.say();
                }
            }
        }
    }
}
