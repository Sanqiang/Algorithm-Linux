/**
 * Sanqiang Zhao Www.131X.Com Dec 22, 2012
 */
package LeetCode.OnlineJudge;

public class Q58_MultiplyString {

    public String multiply(String num1, String num2) {
        int a_length = num1.length(), b_length = num2.length();
        int solution[] = new int[b_length + a_length];
        int i, j, pre_carry = 0, next_carry = 0;
        for (i = a_length - 1; i >= 0; --i) {
            for (j = b_length - 1; j >= 0; --j) {
                int a = num1.charAt(i) - '0';
                int b = num2.charAt(j) - '0';
                solution[a_length - 1 - i + b_length - 1 - j] += a * b;
            }
        }
        for (i = 0; i < a_length + b_length; i++) {
            next_carry = solution[i] / 10;
            solution[i] = (solution[i] + pre_carry) % 10;
            pre_carry = next_carry;

        }
        int val = 0;
        for (i = 0; i < a_length + b_length; ++i) {
            val += Math.pow(10, i) * solution[i];
        }
        return String.valueOf(val);
    }

    public static void main(String[] args) {
        String num1 = "99999999999999999999";
        String num2 = "99999999999999999999";
        String num = new Q58_MultiplyString().multiply(num1, num2);
        System.out.println(num);
    }
}
