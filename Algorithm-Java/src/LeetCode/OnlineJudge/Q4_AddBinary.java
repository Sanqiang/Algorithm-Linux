/**
 * Sanqiang Zhao Www.131X.Com Dec 17, 2012
 */
package LeetCode.OnlineJudge;

public class Q4_AddBinary {

    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int a_length = a.length(), b_length = b.length(), i = 0;
        int shorter_length = Math.min(a_length, b_length), longer_length = Math.max(a_length, b_length);
        String longer = a_length >= b_length ? a : b;
        boolean carry = false;
        for (; i < shorter_length; i++) {
            if (!carry) {
                if (a.charAt(i) == '1' && b.charAt(i) == '1') {
                    sb.insert(0, '0');
                    carry = true;
                } else if (a.charAt(i) == '0' && b.charAt(i) == '0') {
                    sb.insert(0, '0');
                    carry = false;
                } else {
                    sb.insert(0, '1');
                    carry = false;
                }
            } else {
                if (a.charAt(i) == '1' && b.charAt(i) == '1') {
                    sb.insert(0, '1');
                    carry = true;
                } else if (a.charAt(i) == '0' && b.charAt(i) == '0') {
                    sb.insert(0, '1');
                    carry = false;
                } else {
                    sb.insert(0, '0');
                    carry = true;
                }
            }
        }
        for (; i < longer_length; i++) {
            if (!carry) {
                if (longer.charAt(i) == '1') {
                    sb.insert(0, '1');
                } else {
                    sb.insert(0, '0');
                }
            } else {
                if (longer.charAt(i) == '1') {
                    sb.insert(0, '0');
                    carry = true;
                } else {
                    sb.insert(0, '1');
                    carry = false;
                }
            }
        }
        if (carry) {
            sb.insert(0, '1');
        }
        return sb.toString();
    }

    public String addBinarySimple(String a, String b) {
        return Integer.toBinaryString(Integer.parseInt(a, 2) + Integer.parseInt(b, 2));
    }

    public static void main(String[] args) {
        String solution = new Q4_AddBinary().addBinary("11", "1");
        System.out.println(solution);
        System.out.println(new Q4_AddBinary().addBinarySimple("11", "1"));
    }
}
