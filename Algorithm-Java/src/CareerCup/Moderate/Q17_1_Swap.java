/**
 * Sanqiang Zhao Www.131X.Com Dec 28, 2012
 */
package CareerCup.Moderate;

public class Q17_1_Swap {

    void swap(int a, int b) {
        //diff = a - b
        a = a - b;
        b = a + b;
        a = b - a;
        System.out.println("a:" + a);
        System.out.println("b:" + b);
    }

    void swap2(int a, int b) {
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("a:" + a);
        System.out.println("b:" + b);
    }

    public static void main(String[] args) {
        Q17_1_Swap swap = new Q17_1_Swap();
        swap.swap(1, 3);
        swap.swap2(3, 4);
    }
}
