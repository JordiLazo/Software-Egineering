package synchronization.cookies;

import java.util.LinkedList;
import java.util.Queue;

public class CookieJar {
    private Queue<Cookie> queue;
    private int capacity;


    public CookieJar(int capacity) {
        this.queue = new LinkedList<>();
        this.capacity = capacity;
    }

    public synchronized void startBaking(Cookie cookie){
        while(queue.size() >= capacity){
            try {
                System.out.println("Baker was full");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        queue.add(cookie);
        notifyAll();
    }

    public synchronized void finishBaking(){
        while (queue.size() <= capacity){
            try {
                System.out.println("Baker was empty");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        notifyAll();
    }

    public synchronized Cookie eat(){
        while(queue.isEmpty()){
            try {
                System.out.println("Baker was empty");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Cookie cookie = queue.poll();
        notifyAll();
        return cookie;
    }
}
