/**
 * Sanqiang Zhao Www.131X.Com Jan 5, 2013
 */
package CareerCup.RecursiveAndDP;

import java.util.HashMap;

public class Q9_8_CountCoin {
    
    HashMap<Integer, Integer> cache = new HashMap<>();
    
    public int count(int charge, int coin) {
        if (cache.containsKey(charge)) {
            //System.out.println(charge + ":" + cache.get(charge));
            //return cache.get(charge);
        }
        int ways = 0;
        int next_coin = 0;
        switch (coin) {
            case 25:
                next_coin = 10;
                break;
            case 10:
                next_coin = 5;
                break;
            case 5:
                next_coin = 1;
                break;
            case 1:
                return 1;
            default:
                return 0;
        }
        for (int i = 0; charge - i * coin >= 0; i++) {
            ways += count(charge - i * coin, next_coin);
        }
        //cache.put(charge, ways);
        return ways;
    }
    
    public static void main(String[] args) {
        Q9_8_CountCoin q98 = new Q9_8_CountCoin();
        int ways = q98.count(50, 25);
        System.out.println(ways);
    }
}
