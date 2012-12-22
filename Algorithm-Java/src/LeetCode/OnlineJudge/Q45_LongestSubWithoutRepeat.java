/**
 * Sanqiang Zhao Www.131X.Com Dec 21, 2012
 */
package LeetCode.OnlineJudge;

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
        String s = "bbbb";
        int c = new Q45_LongestSubWithoutRepeat().lengthOfLongestSubstring(s);
        System.out.println(c);
    }
}
