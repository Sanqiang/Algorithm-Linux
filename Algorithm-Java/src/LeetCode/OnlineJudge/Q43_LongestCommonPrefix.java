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
        String[] strs = {"abce", "abcw", "abcr", "abss", "abee"};
        String prefix = new Q43_LongestCommonPrefix().longestCommonPrefix(strs);
        System.out.println(prefix);
    }
}
