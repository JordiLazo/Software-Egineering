package synchronization.producer_consumer;

import java.util.concurrent.BlockingQueue;

public class Reception implements Runnable{
    BlockingQueue<Customer> queue;

    public Reception(BlockingQueue<Customer> queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        String [] customers = {"Alfonso", "Adrian","Benjamin","Cristopher","Emil","Juraj","Kaled","Mihai","Sachin"};

        System.out.println(customers.length + " customers waiting...");

        for(String c: customers){
            Customer customer = new Customer(c);
            try {
                Thread.sleep(1000);
                queue.put(customer);
                System.out.println("Put: " + customer.getName() + " in the queue");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("No more customers to put in the queue");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
