/**
 * Sanqiang Zhao Www.131X.Com Dec 18, 2012
 */
package LeetCode.OnlineJudge;

import Util.TestUtil;
import java.util.HashMap;

public class Q26_DecodeWays {

    public int numDecodingsDP2(String s) {
        int[] cache = new int[3];
        cache[0] = 1;
        if (s.charAt(1) <= '6' && s.charAt(1) > '0'
                && s.charAt(0) <= '2' && s.charAt(0) >= '1') {
            cache[1] = 2;
        } else {
            cache[1] = 1;
        }
        int i = 2, length = s.length();
        int index = i % 3;
        int last_index = (i - 1) % 3;
        int last_index2 = (i - 2) % 3;
        for (; i < length; ++i) {
            index = i % 3;
            last_index = (i - 1) % 3;
            last_index2 = (i - 2) % 3;
            int count = 0;
            if (s.charAt(i) == '0') {
                count += cache[last_index2];
            } else {
                count += cache[last_index];
                if (s.charAt(i) <= '6' && s.charAt(i) > '0'
                        && s.charAt(i - 1) <= '2' && s.charAt(i - 1) >= '1') {
                    count += cache[last_index2];
                }
            }
            cache[index] = count;
        }
        return cache[(i - 1) % 3];
    }

    public int numDecodingsDP(String s) {
        HashMap<String, Integer> cache = new HashMap<>();
        cache.put(s.substring(0, 1), 1);
        cache.put("", 1);
        int length = s.length(), i = 2;
        for (; i <= length; ++i) {
            String current_str = s.substring(0, i);
            char c = current_str.charAt(i - 1);
            if (c == '0') {
                cache.put(current_str, cache.get(current_str.substring(0, i - 2)));
            } else {
                int count = cache.get(current_str.substring(0, i - 1));
                if (s.charAt(i - 1) >= '0' && s.charAt(i - 1) <= '6'
                        && s.charAt(i - 2) >= '1' && s.charAt(i - 2) <= '2') {
                    count += cache.get(current_str.substring(0, i - 2));
                }
                cache.put(current_str, count);
            }
        }
        return cache.get(s);
    }

    public int numDecodingsEx(String s) {
        return numDecodingsHelper(s, 0);
    }

    private int numDecodingsHelper(String s, int i) {
        if (i == s.length() - 2) {
            if (s.charAt(i) >= '1' && s.charAt(i) <= '2' && s.charAt(1 + i) <= '6' && s.charAt(1 + i) >= '0') {
                return 2;
            } else {
                return 1;
            }
        } else if (i == s.length() - 1) {
            return 1;
        } else if (i >= s.length()) {
            return 0;
        }
        int ways = 0;
        if (s.charAt(i + 1) == '0') {
            ways += numDecodingsHelper(s, i + 2);
        } else {
            ways += numDecodingsHelper(s, i + 1);
        }
        if (i + 1 < s.length() && s.charAt(i) <= '6'
                && s.charAt(i + 1) <= '2' && s.charAt(i + 1) >= '1'
                && s.charAt(i) > '0') {
            ways += numDecodingsHelper(s, i + 2);
        }
        return ways;
    }

    public static void main(String[] args) {
        String text = "11231213112312312312310021211213";//TestUtil.generateArrayString(20, 9);
        long l1 = System.currentTimeMillis();
        int ways = new Q26_DecodeWays().numDecodingsEx(text);
        long l2 = System.currentTimeMillis();
        int ways2 = new Q26_DecodeWays().numDecodingsMy(text);
        long l3 = System.currentTimeMillis();
        int ways3 = new Q26_DecodeWays().numDecodingsDP2(text);
        long l4 = System.currentTimeMillis();
        long span1 = l2 - l1, span2 = l3 - l2, span3 = l4 - l3;
        System.out.println("EX:" + ways + " Cost " + span1);
        System.out.println("DP:" + ways2 + " Cost " + span2);
        System.out.println("DP2:" + ways3 + " Cost " + span3);
    }

    //most correct one
    public int numDecodingsMy(String s) {
        int len = s.length(), index;
        int[] tab = new int[len];
        if (s.charAt(0) >= '1' && s.charAt(0) <= '9') {
            tab[0] = 1;
        } else {
            tab[0] = 0;
        }
        for (index = 1; index < len; index++) {
            char ch = s.charAt(index);
            char last_ch = s.charAt(index - 1);
            int count = 0;
            if (ch >= '1' && ch <= '9') {
                count += tab[index - 1];
            }
            if (last_ch >= '1' && last_ch <= '2' && ch >= '0' && ch <= '6') {
                if (index - 2 >= 0) {
                    count += tab[index - 2];
                } else {
                    count += 1;
                }
            }
            tab[index] = count;
        }
        return tab[len - 1];
    }
}
