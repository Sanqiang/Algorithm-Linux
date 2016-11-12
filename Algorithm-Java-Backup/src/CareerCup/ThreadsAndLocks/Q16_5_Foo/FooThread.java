/**
 * Sanqiang Zhao Www.131X.Com Dec 27, 2012
 */
package CareerCup.ThreadsAndLocks.Q16_5_Foo;

public class FooThread extends Thread {

    Foo f;
    int i;

    public FooThread(int i) {
        f = new Foo();
        this.i = i;
    }

    @Override
    public void run() {
        switch (i) {
            case 1:
                f.first();
                break;
            case 2:
                f.second();
                break;
            case 3:
                f.third();
                break;
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            FooThread th = new FooThread(i + 1);
            th.start();
        }
    }
}
