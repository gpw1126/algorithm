package relatedKnowledge.ReentrantLock.ProducerAndConsumer;

public class ConsumeThread implements Runnable {

    private Service service;

    public ConsumeThread(Service service) {
        this.service = service;
    }

    @Override
    public void run() {
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            service.consume();
        }
    }
}
