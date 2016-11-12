/**
 * Sanqiang Zhao Www.131X.Com Dec 25, 2012
 */
package CareerCup.Hard;

public class Q18_1_Add {
    
    public int add(int a, int b) {
        if (b == 0) {
            return a;
        }
        int addition = a ^ b;
        int carry = (a & b) << 1;
        return add(addition, carry);
    }
    
    public static void main(String[] args) {
        int a = 10;
        int b = 200;
        int add = new Q18_1_Add().add(a, b);
        System.out.println(add);
    }
}
