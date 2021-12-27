package readerswriters.favorreader;

public class ReaderClass implements Runnable {
    private ReadWrite lock;

    public ReaderClass(ReadWrite lock) {
        this.lock = lock;
    }


    @Override
    public void run() {
        while(true){
            doSOmeOpr("PREP",1000,2000);
            lock.acquireRead();
            doSOmeOpr("READ",3000,4000);
            lock.releaseRead();
        }
    }

    private void doSOmeOpr(String prep, int min, int max) {
        long time = (long) (Math.random() * (max-min) + min);
        try {
            System.out.println("Doing some " + prep + " operation");
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
