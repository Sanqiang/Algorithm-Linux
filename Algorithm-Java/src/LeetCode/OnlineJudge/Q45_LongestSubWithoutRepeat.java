/**
 * Sanqiang Zhao Www.131X.Com Dec 21, 2012
 */
package LeetCode.OnlineJudge;

import java.util.HashMap;

public class Q45_LongestSubWithoutRepeat {

    public int lengthOfLongestSubstring(String s) {
        int length = s.length(), a = 0, b = 0, MaxLeng = 0;
        boolean[] record = new boolean[0xff];
        while (b < length) {
            if (record[s.charAt(b)]) {
                MaxLeng = Math.max(MaxLeng, b - a);
                while (s.charAt(a) != s.charAt(b)) {
                    record[s.charAt(++a)] = false;
                    ++a;
                }
                ++a;
            } else {
                record[s.charAt(b)] = true;
            }
            ++b;
        }
        return MaxLeng;
    }

    public static void main(String[] args) {
        String s = "abcabcbbe";
        int c = new Q45_LongestSubWithoutRepeat().lengthOfLongestSubstringMy(s);
        System.out.println(c);
        int c2 = new Q45_LongestSubWithoutRepeat().lengthOfLongestSubstring(s);
        System.out.println(c2);
    }

    public int lengthOfLongestSubstringMy(String s) {
        int len = s.length(), l = 0, max = 0, cur = 0;
        HashMap<Character, Integer> mapper = new HashMap<>();
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (mapper.containsKey(ch)) {
                max = Math.max(max, cur);
                int pos = mapper.get(ch);
                for (int j = l; j <= pos; j++) {
                    --cur;
                    mapper.remove(s.charAt(j));
                }
                ++cur;
                mapper.put(ch, i);
                l = pos + 1;
            } else {
                mapper.put(ch, i);
                ++cur;
            }
        }
        max = Math.max(max, cur);
        return max;
    }

    public int lengthOfLongestSubstringSample(String s) {
        //I use hashmap because the string may contain unicode chars that are 0~65535

        //str contains the index of chars that are in the current substring
        //a char is in the substring if str.constainsKey
        HashMap<Character, Integer> str = new HashMap<Character, Integer>();
        int len = 0, max = 0;
        int startIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!str.containsKey(s.charAt(i))) {
                str.put(s.charAt(i), i);
                len++;
            } else { //found a duplicate
                if (max < len) {
                    max = len; //update the max
                }

                //or you can continue from the char after the first duplicate
                int dupIndex = str.get(s.charAt(i));
                for (int j = dupIndex; j >= startIndex; j--) {
                    str.remove(s.charAt(j));
                    len--;
                }
                //add the second duplicate to map (it is not a duplicate anymore)
                str.put(s.charAt(i), i);
                len++;
                startIndex = dupIndex + 1;
            }
        }

        //len is length of the last substring
        if (len > max) {
            max = len;
        }

        return max;
    }
}
