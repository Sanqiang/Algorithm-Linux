/**
 * Sanqiang Zhao Www.131X.Com Jan 24, 2013
 */
package haimenboy;

public class Q10_Palindrome {

    public boolean verify(String in) {
        char[] arr = in.toCharArray();
        for (int i = 0; i < arr.length / 2; i++) {
            if (arr[i] != arr[arr.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }

    public boolean verifyRotate(String in) {
        for (int i = 0; i < in.length(); i++) {
            String left = in.substring(0, i);
            String right = in.substring(i);
            if (verify(right + left)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Q10_Palindrome q10 = new Q10_Palindrome();
        System.out.println(q10.verify("12241"));
        System.out.println(q10.verifyRotate("21123"));
    }
}
