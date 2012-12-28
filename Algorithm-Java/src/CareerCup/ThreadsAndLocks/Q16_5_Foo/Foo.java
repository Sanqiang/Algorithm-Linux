/**
 * Sanqiang Zhao Www.131X.Com Dec 27, 2012
 */
package CareerCup.ThreadsAndLocks.Q16_5_Foo;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Foo {

    public static Semaphore sp1, sp2, sp3;

    public Foo() {
        try {
            sp1 = new Semaphore(1);
            sp2 = new Semaphore(1);
            sp3 = new Semaphore(1);

            sp1.acquire();
            sp2.acquire();
            sp3.acquire();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
            //Logger.getLogger(Foo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void first() {
        System.out.println("first");
        sp1.release();
    }

    public void second() {
        try {
            sp1.acquire();
            sp1.release();
            System.out.println("second");
            sp2.release();
        } catch (InterruptedException ex) {
            Logger.getLogger(Foo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void third() {
        try {
            sp2.acquire();
            sp2.release();
            System.out.println("third");
            sp3.release();
        } catch (InterruptedException ex) {
            Logger.getLogger(Foo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
    }
}
