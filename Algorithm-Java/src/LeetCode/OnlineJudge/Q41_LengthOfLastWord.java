/**
 * Sanqiang Zhao Www.131X.Com Dec 20, 2012
 */
package LeetCode.OnlineJudge;

public class Q41_LengthOfLastWord {

    public int lengthOfLastWord(String s) {
        int length = s.length(), i = length - 1, e = length - 1;
        while (i >= 0) {
            if (s.charAt(i) == ' ') {
                if (e - i == 0) {
                    e = i - 1;
                } else {
                    return e - i;
                }
            }
            --i;
        }
        return -1;
    }

    public static void main(String[] args) {
        String text = "hello world  h";
        int l = new Q41_LengthOfLastWord().lengthOfLastWord(text);
        System.out.println(l);
    }
}
