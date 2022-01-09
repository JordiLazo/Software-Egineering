package readerswriters.diningphilosophers;

public class Philosopher implements Runnable{

    private int id;
    private Fork leftFork;
    private Fork rightFork;

    public Philosopher(int id, Fork leftFork, Fork rightFork) {
        this.id = id;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }



    @Override
    public void run() {
        while(true){
            doSomeOpr("THINK", 10000, 10000);
            rightFork.getFork();
            leftFork.getFork();
            doSomeOpr("EAT", 5000,5000);
            rightFork.putbackFork();
            leftFork.putbackFork();
        }

    }

    private void doSomeOpr(String prep, int max, int min) {
        long time = (long) (Math.random() * (max-min) + min);
        try {
            System.out.println("Doing some " + prep + " operation");
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
