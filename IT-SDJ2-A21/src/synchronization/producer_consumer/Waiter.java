package synchronization.producer_consumer;

import java.util.concurrent.BlockingQueue;

public class Waiter implements Runnable{

    BlockingQueue<Customer> queue;

    public Waiter(BlockingQueue<Customer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {

        try{
            Customer c = new Customer("");
            while(!c.getName().equalsIgnoreCase("Receptionist")){
               //take -- waits if its empty
                c = queue.take();
                if( c != null){
                    System.out.println(c.getName() + " is received. Taking to the table");
                }
            }
            System.out.println("All have been attended to....");

        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
