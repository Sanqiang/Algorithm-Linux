/**
 * Sanqiang Zhao Www.131X.Com Dec 21, 2012
 */
package LeetCode.OnlineJudge;

public class Q43_LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        boolean cont = true;
        while (cont) {
            for (String item : strs) {
                if (index >= item.length() || strs[0].charAt(index) != item.charAt(index)) {
                    cont = false;
                    break;
                }
            }
            if (cont) {
                sb.append(strs[0].charAt(index));
                ++index;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] strs = {"abccce", "abccw", "abccr", "abcss", "abcee"};
        String prefix = new Q43_LongestCommonPrefix().longestCommonPrefixMy(strs);
        System.out.println(prefix);
    }

    //my way
    public String longestCommonPrefixMy(String[] strs) {
        int b = -1;
        String std = strs[0];
        boolean cont = true;
        while (cont) {
            ++b;
            for (int i = 1; i < strs.length; i++) {
                if (strs[i].charAt(b) != std.charAt(b)) {
                    cont = false;
                    --b;
                    break;
                }
            }
        }
        return strs[0].substring(0, b + 1);
    }
}
