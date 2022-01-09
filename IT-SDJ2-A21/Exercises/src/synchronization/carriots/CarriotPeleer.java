package synchronization.carriots;

import java.util.concurrent.BlockingQueue;

public class CarriotPeleer implements Runnable{

    private BlockingQueue<Carrot> queue;

    public CarriotPeleer(BlockingQueue<Carrot> queue) {
        this.queue = queue;
    }


    @Override
    public void run() {

        while(true){
            try {
                Carrot c = peelCarrot();
                queue.put(c);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private Carrot peelCarrot(){

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new Carrot("Dk");
    }
}
