/**
 * Sanqiang Zhao Www.131X.Com Mar 7, 2013
 */
package MultiThread;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Common {

    public static void main(String[] args) {
        Common c = new Common();
        E1 e1 = c.new E1();
        E2 e2 = c.new E2();
        Thread t1 = new Thread(e1), t2 = new Thread(e2);
        t1.start();
        t2.start();
    }
    Integer x = 1, lock = 0;

    public class E1 implements Runnable {

        @Override
        public void run() {
            synchronized (x) { // cannot change to lock
                try {
                    x.wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Common.class.getName()).log(Level.SEVERE, null, ex);
                }
                for (int i = 0; i < 10; i++) {
                    System.out.println("Awaked");
                }
                
            }
        }
    }

    public class E2 implements Runnable {

        @Override
        public void run() {
            synchronized (x) {
                System.out.println("Pulse!!!");
                x.notifyAll();
                System.out.println("Heihei!");
            }
        }
    }
}
