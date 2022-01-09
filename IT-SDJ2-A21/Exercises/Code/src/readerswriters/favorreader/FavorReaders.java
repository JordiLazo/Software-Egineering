package readerswriters.favorreader;

public class FavorReaders implements ReadWrite {
    private int readers;
    private int writers;

    public FavorReaders() {
        readers = 0;
        writers = 0;
    }

    @Override
    public synchronized void acquireRead() {
        while(writers > 0){
            try {
                System.out.println(Thread.currentThread().getName() + " WAIT number of readers: " + readers);
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " IS READING ");
        readers++;
    }

    @Override
    public synchronized void releaseRead() {
        readers--;
        if(readers == 0){
            notify();
        }
    }

    @Override
    public synchronized void acquireWrite() {
        while(readers > 0 || writers > 0){
            try {
                System.out.println(Thread.currentThread().getName() + " WAIT number of readers: " + readers);
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " IS WRITING");
        writers++;
    }

    @Override
    public synchronized void releaseWrite() {
        writers--;
        if(writers == 0){
            notifyAll();//notify all writers and readers
        }
    }
}
