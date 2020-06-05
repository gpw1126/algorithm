package scene.QueueImpl.arrayToQueue;

/**
 * 两个线程一个做入队再获取队列长度操作，一个直接获取队列长度，并发获取的长度不一导致错误，故该队列在多线程下不安全
 * 要通过加锁实现一个线程安全的队列
 */
public class concurrentTest {

    public static void main(String[] args) {

        arrayToQueue queue = new arrayToQueue(5);
        queue.put("element1");

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (this) {
                    queue.put("element2");
                    System.out.println(Thread.currentThread().getName() + " 入队element2,此时队列长度为 " + queue.getSize());
//                    for (int i = 0; i < 5; i++) {
//                        System.out.println(Thread.currentThread().getName() + i);
//                    }
                }
            }
        }, "t1");

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (this) {
                    System.out.println(Thread.currentThread().getName() + " 获取队列长度为 " + queue.getSize());
//                    for (int i = 0; i < 5; i++) {
//                        System.out.println(Thread.currentThread().getName() + i);
//                    }
                }
            }
        }, "t2");

        t1.start();
        t2.start();
    }

}
