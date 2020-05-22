package relatedKnowledge.ReentrantLock.ProducerAndConsumer;

public class ProducerThread implements Runnable {

    private Service service;

    public ProducerThread(Service service) {
        this.service = service;
    }

    @Override
    public void run() {
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            service.produce();
        }
    }
}
