package synchronization.producer_consumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Restaurant {

    private static int capacity = 5;

    public static void main(String[] args) {
        BlockingQueue<Customer> queue = new ArrayBlockingQueue<Customer>(capacity);
        Reception producer = new Reception(queue);
        Waiter consumer = new Waiter(queue);
        new Thread(producer).start();
        new Thread(consumer).start();
    }
}
