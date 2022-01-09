package synchronization.carriots;

import java.util.concurrent.BlockingQueue;

public class CarrotEater implements Runnable{

    private BlockingQueue<Carrot> queue;

    public CarrotEater(BlockingQueue<Carrot> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {

        try {
            while(true) {
                Carrot c = queue.take();
                System.out.println("Eating carrot....bunch size= " + queue.size());
                eatCarrot(c);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private void eatCarrot(Carrot c) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Eating carrot...");
    }
}
