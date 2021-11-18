package synchronization.cookies;

import synchronization.carriots.CarrotEater;

import java.util.concurrent.BlockingQueue;

public class main {
    public static void main(String[] args) {
        CookieJar queue = new CookieJar(16);

        for(int i = 0; i < 16; i++){
            Thread p = new Thread(new CookieBaker(queue,16));
            Thread c = new Thread(new CookieEater(queue));
            p.start();
            c.start();
        }
    }
}
