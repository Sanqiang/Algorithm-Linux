/**
 * Sanqiang Zhao Www.131X.Com Jan 24, 2013
 */
package haimenboy;

public class Q14_PrintCoinComb {

    void printCoinComb(int[] coin, int[] count, int cur, int remaing) {
        if (cur == coin.length) {
            if (remaing == 0) {
                for (int i = 0; i < count.length; i++) {
                    if (count[i] > 0) {
                        System.out.print(coin[i] + "=" + count[i] + " , ");
                    }
                }
                System.out.println();
            }
        } else {
            for (int i = 0; remaing - i * coin[cur] >= 0; i++) {
                count[cur] = i;
                printCoinComb(coin, count, cur + 1, remaing - i * coin[cur]);
            }
        }
    }

    public static void main(String[] args) {
        int[] coin = {5, 2, 1};
        int remaing = 20;
        new Q14_PrintCoinComb().printCoinComb(coin, new int[coin.length], 0, remaing);
    }
}
