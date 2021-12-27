package readerswriters.favorreader;

public class Writer implements Runnable{

    private ReadWrite lock;

    public Writer(ReadWrite lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        while(true){
            //before writing
            doSOmeOpr("PREP",1000,2000);
            lock.acquireWrite();
            //do some writing
            doSOmeOpr("READ",3000,4000);
            lock.releaseWrite();
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
