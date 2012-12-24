/**
 * Sanqiang Zhao Www.131X.Com Dec 23, 2012
 */
package LeetCode.OnlineJudge;

public class Q71_PlusOne {

    public int[] plusOne(int[] digits) {
        int length = digits.length, i, carry = 0;
        int solution[] = new int[length + 1];
        digits[length - 1] += 1;
        for (i = length - 1; i >= 0; --i) {
            solution[i + 1] = (carry + digits[i]) % 10;
            carry = (carry + digits[i]) / 10;
        }
        if (carry > 0) {
            solution[0] = carry;
        }
        return solution;
    }

    public static void main(String[] args) {
        int[] digits = {2, 9, 9};
        int[] solution = new Q71_PlusOne().plusOne(digits);
        for (int i : solution) {
            System.out.print(i);
        }
    }
}
