/**
 * Sanqiang Zhao Www.131X.Com Dec 25, 2012
 */
package LeetCode.OnlineJudge;

public class Q103_StringToInteger {

    public int atoi(String str) {
        int i = 0, length = str.length();
        int val = 0;
        boolean neg = false;
        if (str.charAt(i) == '-') {
            neg = true;
            ++i;
        } else if (str.charAt(i) == '+') {
            ++i;
        }
        for (; i < length; ++i) {
            if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                System.out.println("ERROR");
                return -1;
            }
            if ((Integer.MAX_VALUE - str.charAt(i)) / 10 < val) {
                System.out.println("Overflow");
                return -1;
            }
            val *= 10;
            val += str.charAt(i) - '0';
        }
        if (neg) {
            val *= -1;
        }
        return val;
    }

    public static void main(String[] args) {
        String str = "-1234567890";
        int num = new Q103_StringToInteger().atoi(str);
        System.out.println(num);
    }
}
