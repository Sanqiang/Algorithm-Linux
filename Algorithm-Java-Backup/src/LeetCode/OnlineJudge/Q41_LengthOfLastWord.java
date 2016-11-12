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
        String text = "hello world  ha";
        int l = new Q41_LengthOfLastWord().lengthOfLastWordMy(text);
        System.out.println(l);
    }

    //my way
    public int lengthOfLastWordMy(String s) {
        int len = s.length(), i;
        boolean start = false;
        for (i = len - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                start = true;
            }
            if (start) {
                if (s.charAt(i) == ' ') {
                    return len - i - 1;
                }
            }
        }
        return -1;
    }
}
