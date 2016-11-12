/**
 * Sanqiang Zhao Www.131X.Com Jan 5, 2013
 */
package CareerCup.RecursiveAndDP;

import java.util.HashMap;

public class Q9_1_CountWays {

    private HashMap<Integer, Integer> cache = new HashMap<>();

    public int count(int n) {
        if (n == 0) {
            return 1;
        } else if (n < 0) {
            return 0;
        }
        if (cache.containsKey(n)) {
            return cache.get(n);
        }
        int ways = count(n - 1) + count(n - 2) + count(n - 3);
        cache.put(n, ways);
        return ways;
    }

    public static void main(String[] args) {
        Q9_1_CountWays q91 = new Q9_1_CountWays();
        int ways = q91.count(3);
        System.out.println(ways);

    }
}
