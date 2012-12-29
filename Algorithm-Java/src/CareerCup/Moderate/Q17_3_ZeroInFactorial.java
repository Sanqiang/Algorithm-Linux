/**
 * Sanqiang Zhao Www.131X.Com Dec 28, 2012
 */
package CareerCup.Moderate;

public class Q17_3_ZeroInFactorial {

    public int factorOf5(int n) {
        int count = 0;
        while (n % 5 == 0) {
            ++count;
            n /= 5;
        }
        return count;
    }

    public int countZero(int num) {
        int count = 0;
        for (int i = 2; i <= num; i++) {
            count += factorOf5(i);
        }
        return count;
    }

    public int countZero2(int num) {
        int count = 0;
        for (int i = 5; num / i > 0; i *= 5) {
            count += num / i;
        }
        return count;
    }

    public static void main(String[] args) {
        int num = 19;
        Q17_3_ZeroInFactorial q17 = new Q17_3_ZeroInFactorial();
        int ways = q17.countZero(num);
        System.out.println(ways);
        int ways2 = q17.countZero2(num);
        System.out.println(ways2);
    }
}
