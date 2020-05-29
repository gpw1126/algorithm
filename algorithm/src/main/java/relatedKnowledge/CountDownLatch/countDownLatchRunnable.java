package relatedKnowledge.CountDownLatch;

import java.util.concurrent.CountDownLatch;

public class countDownLatchRunnable implements Runnable{

    private CountDownLatch countDownLatch;

    public countDownLatchRunnable(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            synchronized (countDownLatch) {
                // 每次减少1个容量
                countDownLatch.countDown();
                System.out.println(Thread.currentThread().getName() + " thread counts = " + (countDownLatch.getCount()));
            }
            // 调用await()方法的线程会被挂起，它会等待直到count值为0才继续执行
            countDownLatch.await();
            System.out.println(Thread.currentThread().getName() + " concurrency counts = " + (10 - countDownLatch.getCount()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
