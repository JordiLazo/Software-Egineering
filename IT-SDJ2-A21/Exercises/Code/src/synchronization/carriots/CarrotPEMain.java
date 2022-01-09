package synchronization.carriots;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class CarrotPEMain {

    public static void main(String[] args) {
        int peelers = 4;
        int eaters = 3;

        BlockingQueue<Carrot> queue = new LinkedBlockingQueue<>(20);

        for(int i = 0; i < peelers; i++){
            new Thread(new CarriotPeleer(queue)).start();
        }

        for(int i = 0; i < eaters; i++){
            new Thread(new CarrotEater(queue)).start();
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
