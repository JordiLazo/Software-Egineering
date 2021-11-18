package synchronization.cookies;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;

public class CookieBaker implements Runnable{

    private int capacity;
    private CookieJar queue;
    private String name;

    public CookieBaker(CookieJar queue, int capacity) {
        this.queue = queue;
        this.capacity = capacity;
        name = "Producer" + capacity;
    }


    @Override
    public void run() {

        while(true){
            Cookie c = new Cookie("a");
            queue.startBaking(c);
            String x = c.toString();
            System.out.println(name + "added cookie" + x);
        }
    }
}
