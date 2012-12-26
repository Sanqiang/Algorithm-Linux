/**
 * Sanqiang Zhao Www.131X.Com Dec 26, 2012
 */
package LeetCode.OnlineJudge;

import java.util.ArrayList;
import java.util.HashMap;

public class Q112_Triangle {

    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        cache = new HashMap<>();
        int count = minimumTotalHelper(0, 0, triangle, triangle.size() - 1);
        return count;
    }
    private HashMap<String, Integer> cache;

    private int minimumTotalHelper(int pos, int level, ArrayList<ArrayList<Integer>> triangle, int end) {
        if (level > end) {
            return 0;
        }
        String key = String.valueOf(level) + "-" + String.valueOf(pos);
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        if (minimumTotalHelper(pos, level + 1, triangle, end) >= minimumTotalHelper(pos + 1, level + 1, triangle, end)) {
            int cur = triangle.get(level).get(pos) + minimumTotalHelper(pos + 1, level + 1, triangle, end);
            cache.put(key, cur);
            return cur;
        } else {
            int cur = triangle.get(level).get(pos) + minimumTotalHelper(pos, level + 1, triangle, end);
            cache.put(key, cur);
            return cur;
        }
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> triangle = new ArrayList<>();
        ArrayList<Integer> level1 = new ArrayList<>();
        level1.add(2);
        ArrayList<Integer> level2 = new ArrayList<>();
        level2.add(3);
        level2.add(4);
        ArrayList<Integer> level3 = new ArrayList<>();
        level3.add(6);
        level3.add(5);
        level3.add(7);
        ArrayList<Integer> level4 = new ArrayList<>();
        level4.add(4);
        level4.add(1);
        level4.add(8);
        level4.add(3);
        triangle.add(level1);
        triangle.add(level2);
        triangle.add(level3);
        triangle.add(level4);
        int count = new Q112_Triangle().minimumTotal(triangle);
        System.out.println(count);

    }
}
