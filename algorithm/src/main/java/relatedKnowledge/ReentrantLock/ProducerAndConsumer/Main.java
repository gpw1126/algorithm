package relatedKnowledge.ReentrantLock.ProducerAndConsumer;

public class Main {

    public static void main(String[] args) {
        Service service = new Service();
        Thread prodecer = new Thread(new ProducerThread(service));
        Thread consumer = new Thread(new ConsumeThread(service));
        prodecer.start();
        consumer.start();
    }
}
