package scene.QueueImpl.arrayToQueue;

public class arrayToQueue{

    private int head;
    private int rear;
    // 当前元素个数
    private int size;
    private Object[] queue;

    public arrayToQueue(int initSize) {
        this.head = 0;
        this.rear = 0;
        this.size = 0;
        queue = new Object[initSize];
    }

    // 判断队列是否为空
    public boolean isEmpty() {
        return head == rear;
    }

    // 判断队列是否已满
    public boolean isFull() {
        return rear == queue.length;
    }

    // 队列长度
    public int getSize() {
        return size;
    }

    // 入队
    public void put(Object obj) {
        if (size == queue.length) {
            throw new ArrayIndexOutOfBoundsException("queue is full");
        }
        queue[rear++] = obj;
        size++;
    }

    // 出队
    public Object poll() {
        if (size == 0) {
            throw new ArrayIndexOutOfBoundsException("queue is empty");
        }
        Object curHead = queue[head];
        head++;
        size--;
        return curHead;
    }

    // 返回对头元素
    public Object peek() {
        if (size == 0) {
            return null;
        }
        return queue[head];
    }

//    // 测试
//    public static void main(String[] args) {
//        arrayToQueue queue = new arrayToQueue(5);
//        System.out.println("队列为空？" + queue.isEmpty());
//        queue.put("hello");
//        queue.put(1314520);
//        System.out.println("出队：" + queue.poll());
//        queue.put("hahaha");
//        System.out.println("当前队头为：" + queue.peek());
//        queue.put(111);
//        queue.put("gpw");
//        System.out.println("队列已满？" + queue.isFull());
//        System.out.println("当前队列为：");
//        for (int i = queue.head; i < queue.rear; i++) {
//            System.out.println(queue.queue[i]);
//        }
//        // 测试队满异常
//        queue.put(520.0f);
//    }
}
