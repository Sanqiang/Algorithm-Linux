/**
 * Sanqiang Zhao Www.131X.Com Dec 27, 2012
 */
package CareerCup.ThreadsAndLocks.Q16_5_Foo;

import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FooLock extends Thread {

    public ReentrantLock lock1, lock2, lock3;

    public FooLock() {
        if (lock1 == null) {
            lock1 = new ReentrantLock();
        }
        if (lock2 == null) {
            lock2 = new ReentrantLock();
            lock2.lock();
        }
        if (lock3 == null) {
            lock3 = new ReentrantLock();
            lock3.lock();
        }
    }

    public boolean first() throws InterruptedException {
        if (lock1.isLocked()) {
            Thread.sleep(10000);
            first();
        }
        System.out.println("first");
        lock2.unlock();
        return false;
    }

    public boolean second() throws InterruptedException {
        if (lock2.isLocked()) {
            Thread.sleep(10000);
            second();

        }
        System.out.println("second");
        lock3.unlock();
        return false;
    }

    public boolean third() throws InterruptedException {
        if (lock3.isLocked()) {
            Thread.sleep(10000);
            third();
        }
        System.out.println("third");
        return false;
    }

    public static void main(String[] args) throws InterruptedException {
    }
}
