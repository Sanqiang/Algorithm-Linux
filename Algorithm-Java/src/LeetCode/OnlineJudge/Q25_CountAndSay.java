/**
 * Sanqiang Zhao Www.131X.Com Dec 18, 2012
 */
package LeetCode.OnlineJudge;

public class Q25_CountAndSay {

    public String countAndSay(int n) {
        StringBuilder sb = new StringBuilder();
        int last_digit = -1, digit = -1, count = 0;
        while (n > 0) {
            digit = n % 10;
            if (last_digit >= 0 && last_digit != digit) {
                sb.insert(0, count).insert(0, last_digit).insert(0, " ");
                count = 1;
            } else {
                ++count;
            }
            last_digit = digit;
            n = n / 10;
        }
        if (last_digit >= 0) {
            sb.insert(0, count).insert(0, last_digit);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
       int num = 1223334445;
       String text = new Q25_CountAndSay().countAndSay(num);
       System.out.println(text);
    }
}
