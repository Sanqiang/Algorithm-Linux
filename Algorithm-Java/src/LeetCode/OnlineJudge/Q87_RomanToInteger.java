/**
 * Sanqiang Zhao Www.131X.Com Dec 24, 2012
 */
package LeetCode.OnlineJudge;

import java.util.HashMap;

public class Q87_RomanToInteger {

    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int result = 0, i, length = s.length();
        for (i = 0; i < length; i++) {
            result += map.get(s.charAt(i)) * signature(s, i, map);
        }
        return result;
    }

    private short signature(String s, int i, HashMap<Character, Integer> map) {
        int length = s.length();
        if (i == length - 1) {
            return 1;
        }
        if (map.get(s.charAt(i + 1)) > map.get(s.charAt(i))) {
            return -1;
        } else {
            return 1;
        }
    }

    public static void main(String[] args) {
        String val = "IV";
        int num = new Q87_RomanToInteger().romanToIntMy(val);
        System.out.println(num);
    }

    public int romanToIntMy(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int result = 0, i, length = s.length();
        for (i = 0; i < length; i++) {
            result += map.get(s.charAt(i)) * signature(s, i, map);
        }
        return result;
    }

    short signMy(String s, int i, HashMap<Character, Integer> map) {
        if (i + 1 == s.length()) {
            return 1;
        }
        if (map.get(s.charAt(i + 1)) > map.get(s.charAt(i))) {
            return -1;
        } else {
            return 1;
        }
    }
}
