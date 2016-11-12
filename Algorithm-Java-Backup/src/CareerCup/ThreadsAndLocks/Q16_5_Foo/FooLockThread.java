/**
 * Sanqiang Zhao Www.131X.Com Dec 27, 2012
 */
package CareerCup.ThreadsAndLocks.Q16_5_Foo;

import java.util.logging.Level;
import java.util.logging.Logger;

public class FooLockThread extends Thread {

    int i;
    FooLock fl;

    public FooLockThread(int i) {
        this.i = i;
        fl = new FooLock();
    }

    @Override
    public void run() {
        try {
            switch (i) {
                case 1:

                    fl.first();

                    break;
                case 2:
                    fl.second();
                    break;
                case 3:
                    fl.third();
                    break;
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(FooLockThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            FooLockThread flt = new FooLockThread(i + 1);
            flt.start();
        }
    }
}
