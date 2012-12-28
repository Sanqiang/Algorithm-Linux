/**
 * Sanqiang Zhao Www.131X.Com Dec 26, 2012
 */
package CareerCup.ThreadsAndLocks.Q16_3_ChopStick;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Lock;

public class Chopstick {

    Lock lock;

    public Chopstick() {
        lock = new ReentrantLock();
    }

    public boolean pickUp() {
        return lock.tryLock();
    }

    public void putDown() {
        lock.unlock();
    }

    public static void main(String[] args) {
    }
}
