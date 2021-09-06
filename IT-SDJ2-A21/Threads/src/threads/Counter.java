package threads;

public class Counter extends Thread {
    private long value;

    public Counter(){
    }

    public void increment(){
        synchronized (this) {//code of block
            value++;
        }
    }

    public synchronized long getValue(){//entire method
        return value;
    }


}
