package threads;

public class CounterUpdater implements Runnable{
    private Counter thread;
    private int update;
    private String name;

    public CounterUpdater(Counter thread, int update, String name) {
        this.thread = thread;
        this.update = update;
        this.name = name;
    }

    @Override
    public void run() {
        for(int i = 0; i<update;i++){
            thread.increment();
        }
        System.out.println(this.name + " finished with counter value=" + thread.getValue() );
    }
    public static void main(String[] args) {
        Counter c = new Counter();
        CounterUpdater c1 = new CounterUpdater(c,20000,"jordi");
        CounterUpdater c2 = new CounterUpdater(c,20000,"lazo");

        Thread ct1 = new Thread(c1);
        Thread ct2 = new Thread(c2);

        ct1.start();
        ct2.start();
        System.out.println("end");
    }

}
