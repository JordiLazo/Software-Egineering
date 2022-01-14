package Question_5_ReadersWriters_and_Singleton.readerswriters;

import java.util.concurrent.Semaphore;

public class ReadWriteLock {

    /* Two mutually exclusive semaphores */
    private Semaphore readSemaphore = new Semaphore(1);
    private Semaphore writeSemaphore = new Semaphore(1);

    /* Number of read threads */
    private int count = 0;

    /**
     * Get read lock
     */
    public void readLock() throws InterruptedException {
        readSemaphore.acquire();
        if(count == 0){
            writeSemaphore.acquire();
        }
        count++;
        readSemaphore.release();
    }

    /**
     * Release read lock
     */
    public void readUnLock() throws InterruptedException {
        readSemaphore.acquire();
        count--;
        if(count == 0){
            writeSemaphore.release();
        }
        readSemaphore.release();
    }

    /**
     * Get write lock
     */
    public void writeLock() throws InterruptedException {
        writeSemaphore.acquire();
    }

    /**
     * Release write lock
     */
    public void writeUnlock(){
        writeSemaphore.release();
    }

}
