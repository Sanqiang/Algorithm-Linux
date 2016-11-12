/**
 * Sanqiang Zhao Www.131X.Com Dec 26, 2012
 */
package CareerCup.ThreadsAndLocks.Q16_3_ChopStick;

public class App {

    public static void main(String[] args) {
        Chopstick left = new Chopstick();
        Chopstick right = new Chopstick();
        Philosopher philosophers[] = new Philosopher[10];
        for (int i = 0; i < 10; i++) {
            philosophers[i] = new Philosopher(left, right, i + 1);
        }
        for (int i = 0; i < 10; i++) {
            philosophers[i].start(); 
        }
    }
}
