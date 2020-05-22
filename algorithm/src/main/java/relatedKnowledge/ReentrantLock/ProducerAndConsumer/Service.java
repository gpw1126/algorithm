package relatedKnowledge.ReentrantLock.ProducerAndConsumer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Service {

    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private List<Integer> list = new ArrayList<>();

    public void produce() {
        try {
            int capacity = 5;
            lock.lock();
            while (list.size() == capacity) {
                System.out.println("仓库已满，不能继续生产");
                condition.await();
            }
            int p = new Random().nextInt(100);
            // 模拟一秒生产一个产品
            TimeUnit.MILLISECONDS.sleep(1000);
            System.out.println("生产了"+p);
            list.add(p);
            // 通知消费者
            condition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void consume() {
        try {
            lock.lock();
            while (list.size() == 0) {
                System.out.println("仓库没有资源了。。。");
                condition.await();
            }
            int p = list.remove(0);
            // 模拟一秒消费一个产品
            TimeUnit.MILLISECONDS.sleep(1000);
            System.out.println("消费了"+p);
            condition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}
