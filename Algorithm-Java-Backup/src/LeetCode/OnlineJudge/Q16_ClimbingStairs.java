/**
 * Sanqiang Zhao Www.131X.Com Dec 17, 2012
 */
package LeetCode.OnlineJudge;

import java.util.HashMap;

public class Q16_ClimbingStairs {

    HashMap<Integer, Integer> cache = new HashMap<>();

    public int climbStairs(int n) {
        if (n == 0) {
            return 1;
        } else if (n < 0) {
            return 0;
        }
        if (cache.containsKey(n)) {
            return cache.get(n);
        }
        int ways = climbStairs(n - 2) + climbStairs(n - 1);
        cache.put(n, ways);
        return ways;
    }

    public static void main(String[] args) {
        Q16_ClimbingStairs q16 = new Q16_ClimbingStairs();
        int ways = q16.climbStairs(2);
        System.out.println(ways);
    }
}
