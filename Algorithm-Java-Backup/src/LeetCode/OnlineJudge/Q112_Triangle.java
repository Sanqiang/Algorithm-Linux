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
        int count = new Q112_Triangle().minimumTotalMyDP(triangle);
        System.out.println(count);

    }

    public int minimumTotalMy(ArrayList<ArrayList<Integer>> triangle) {
        my_cache = new HashMap<>();
        return getMinimum(0, 0, triangle);
    }
    HashMap<String, Integer> my_cache = null;

    int getMinimum(int level, int i, ArrayList<ArrayList<Integer>> triangle) {
        if (level == triangle.size()) {
            return 0;
        }
        String key = String.valueOf(level) + "|" + String.valueOf(i);
        if (my_cache.containsKey(key)) {
            return my_cache.get(key);
        }
        if (getMinimum(level + 1, i, triangle) <= getMinimum(level + 1, i + 1, triangle)) {
            int count = getMinimum(level + 1, i, triangle) + triangle.get(level).get(i);
            my_cache.put(key, count);
            return count;
        } else {
            int count = getMinimum(level + 1, i + 1, triangle) + triangle.get(level).get(i);
            my_cache.put(key, count);
            return count;
        }
    }

    public int minimumTotalMyDP(ArrayList<ArrayList<Integer>> triangle) {
        ArrayList<ArrayList<Integer>> DP = new ArrayList<>();
        for (int level = 0; level < triangle.size(); level++) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int row = 0; row < triangle.get(level).size(); row++) {
                if (level == 0) {
                    temp.add(triangle.get(level).get(0));
                } else {
                    if (row == 0) {
                        temp.add(DP.get(level - 1).get(row) + triangle.get(level).get(row));
                    } else if (row == triangle.get(level).size() - 1) {
                        temp.add(DP.get(level - 1).get(row - 1) + triangle.get(level).get(row));
                    } else {
                        if (DP.get(level - 1).get(row) <= DP.get(level - 1).get(row - 1)) {
                            temp.add(DP.get(level - 1).get(row) + triangle.get(level).get(row));
                        } else {
                            temp.add(DP.get(level - 1).get(row - 1) + triangle.get(level).get(row));
                        }
                    }
                }
            }
            DP.add(temp);
        }
        ArrayList<Integer> last_layer = DP.get(DP.size() - 1);
        int min = Integer.MAX_VALUE;
        for (Integer integer : last_layer) {
            if (integer < min) {
                min = integer;
            }
        }
        return min;
    }
}
