/**
 * Sanqiang Zhao Www.131X.Com Dec 29, 2012
 */
package CareerCup.Moderate;

public class Q17_4_Max {

    public int max(int a, int b) {
        int k = positive(a - b);
        int q = flip(k);
        return k * b + q * a;
    }

    public int flip(int n) {
        return n ^ 0x1;
    }

    public int positive(int n) {
        return (n >> 31) & 0x1;
    }

    public int max2(int a, int b) {
        int sa = positive(a);
        int sb = positive(b);
        int sc = positive(a - b);
        int use_sign_a = sa ^ sb;
        int use_sign_c = flip(use_sign_a);
        int k = use_sign_a * sa + use_sign_c * sc;
        int q = flip(k);
        return k * b + q * a;
    }

    public static void main(String[] args) {
        Q17_4_Max q174 = new Q17_4_Max();
        System.out.println(q174.max(-3, 9));
        System.out.println(q174.max2(3, 5));
    }
}
