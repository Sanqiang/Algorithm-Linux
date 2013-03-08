/**
 * Sanqiang Zhao Www.131X.Com Jan 27, 2013
 */
package haimenboy;

public class Q29_CountWays {

    int count(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else if (n == 3) {
            return 4;
        }
        int[] tab = {1, 2, 4};
        if (n-- > 3) {
            int ways = tab[0] + tab[1] + tab[2];
            tab[0] = tab[1];
            tab[1] = tab[2];
            tab[2] = ways;
        }

        return tab[2];
    }

    public static void main(String[] args) {
    }
}
