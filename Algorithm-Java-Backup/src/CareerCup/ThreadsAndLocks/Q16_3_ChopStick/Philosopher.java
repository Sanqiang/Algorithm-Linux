/**
 * Sanqiang Zhao Www.131X.Com Dec 26, 2012
 */
package CareerCup.ThreadsAndLocks.Q16_3_ChopStick;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Philosopher extends Thread {

    private Chopstick LeftStick;
    private Chopstick RightStick;
    int index;

    public Philosopher(Chopstick _left, Chopstick _right, int index) {
        this.LeftStick = _left;
        this.RightStick = _right;
        this.index = index;
    }

    public boolean pickUp() {
        if (!LeftStick.pickUp()) {
            return false;
        }
        if (!RightStick.pickUp()) {
            LeftStick.putDown();
            return false;
        }
        return true;
    }

    public void putDown() {
        System.out.println(index + " put down!");
        LeftStick.putDown();
        RightStick.putDown();
    }

    public void chew() {
        System.out.println(index + "Chew!");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            System.out.println("Sleep:" + ex.getMessage());
            //Logger.getLogger(Philosopher.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eat() {
        if (pickUp()) {
            chew();
            putDown();
            System.out.println(index + " success to pick up.");
        } else {
            try {
                //System.out.println(index + " fail to pick up.");
                Thread.sleep(1000);
                eat();
            } catch (InterruptedException ex) {
            }

        }
    }

    @Override
    public void run() {
        eat();
    }

    public static void main(String[] args) {
    }
}
