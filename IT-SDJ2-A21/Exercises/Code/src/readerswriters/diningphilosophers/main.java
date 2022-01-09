package readerswriters.diningphilosophers;

public class main {
    public static void main(String[] args) {
        Fork[] forks = new Fork[5];

        for (int i = 0; i < forks.length ; i++) {
            forks[i] = new Fork(i);
        }

        Thread[] philosophers = new Thread[forks.length];
        for (int i = 0; i < philosophers.length ; i++) {
            Philosopher p1 = new Philosopher(i,forks[i],forks[(i+1) % forks.length]);
            philosophers[i] = new Thread(p1,"Phil: " + i);
            philosophers[i].start();
        }
    }
}
