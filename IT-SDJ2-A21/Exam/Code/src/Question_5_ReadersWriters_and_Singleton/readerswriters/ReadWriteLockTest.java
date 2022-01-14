package Question_5_ReadersWriters_and_Singleton.readerswriters;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReadWriteLockTest {

    static int a = 10;

    @Test
    public void testRead() throws InterruptedException {
        ReadWriteLock readWriteLock = new ReadWriteLock();
        Thread t1 = new Thread(() -> {
            try {
                readWriteLock.readLock();
                System.out.println(a);
                Thread.sleep(3000);
                readWriteLock.readUnLock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                readWriteLock.readLock();
                System.out.println(a);
                Thread.sleep(2000);
                readWriteLock.readUnLock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t3 = new Thread(() -> {
            try {
                readWriteLock.writeLock();
                a = 100;
                System.out.println(a);
                readWriteLock.writeUnlock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();
        t3.start();

        t3.join();
    }

    @Test
    public void testWrite() throws InterruptedException {
        ReadWriteLock readWriteLock = new ReadWriteLock();
        Thread t1 = new Thread(() -> {
            try {
                readWriteLock.readLock();
                System.out.println(a);
                readWriteLock.readUnLock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                readWriteLock.readLock();
                System.out.println(a);
                readWriteLock.readUnLock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t3 = new Thread(() -> {
            try {
                readWriteLock.writeLock();
                a = 100;
                System.out.println(a);
                Thread.sleep(2000);
                readWriteLock.writeUnlock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


        t3.start();
        t1.start();
        t2.start();

        t2.join();
    }

}