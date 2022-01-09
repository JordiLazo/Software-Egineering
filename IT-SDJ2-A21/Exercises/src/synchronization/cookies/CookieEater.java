package synchronization.cookies;


public class CookieEater implements Runnable{

    private String name;
    private CookieJar queue;

    public CookieEater(CookieJar queue) {
        this.queue = queue;
    }

    @Override
    public void run() {

        while (true){
            Cookie c = queue.eat();
            System.out.println("consumer eat:");

        }

    }
}
