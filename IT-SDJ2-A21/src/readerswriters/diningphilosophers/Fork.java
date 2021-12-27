package readerswriters.diningphilosophers;

public class Fork {
    private boolean isTaken;
    private int id;


    public Fork(int id) {
        this.id = id;
    }

    public synchronized void getFork(){
        while(isTaken){
            try {
                System.out.println("--| " + Thread.currentThread().getName() + " waiting for fork " + id);
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        isTaken = true;
        System.out.println("--> " + Thread.currentThread().getName() + " took fork " + id);
    }

    public synchronized void putbackFork(){
        isTaken = false;
        System.out.println("<--" + Thread.currentThread().getName()+ " returned fork " + id);
        notify();
    }
}
