package relatedKnowledge.ReentrantLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * https://www.bbsmax.com/A/kmzLb8Mb5G/
 */
public class reentrantlockTest {

    private static final Lock lock = new ReentrantLock();

    public static void main(String[] args) {
//        new Thread(() -> testLock(), "线程A").start();
//        new Thread(() -> testLock(), "线程B").start();

        Thread thread1 = new Thread(new interruptDemo(lock));
        Thread thread2 = new Thread(new interruptDemo(lock));
        thread1.start();
        thread2.start();
        // 第二个线程没有获取到锁，将其中断
        thread2.interrupt();
    }

    public static void testLock() {
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName()+"获取了锁");
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName()+"释放了锁");
            lock.unlock();
        }
    }

    /**
     * 响应中断就是一个线程获取不到锁，不会傻傻的一直等下去，ReentrantLock会给予一个中断回应。
     * lock() 和 lockInterruptibly()
     * lockInterruptibly()方法能够中断等待获取锁的线程。当两个线程同时通过lock.lockInterruptibly()获取某个锁时，
     * 假若此时线程A获取到了锁，而线程B只有等待，那么对线程B调用threadB.interrupt()方法能够中断线程B的等待过程。
     */
    public static class interruptDemo implements Runnable {

        Lock lock;
        public interruptDemo(Lock lock) {
            this.lock = lock;
        }
        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName()+" 开始获取锁");
                lock.lockInterruptibly();
                System.out.println(Thread.currentThread().getName()+" 已获取到锁，开始干活");
                for (int i = 0; i < 5 ; i++) {
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName()+" : "+i);
                }
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName()+" 被中断");;
            } finally {
                try {
                    lock.unlock();
                    System.out.println(Thread.currentThread().getName()+" 释放锁");
                } catch (Exception e) {
                    System.out.println(Thread.currentThread().getName()+" 没有得到锁而运行结束");
                }
            }
        }
    }
}
