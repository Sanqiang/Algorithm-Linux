/**
 * Sanqiang Zhao Www.131X.Com Dec 20, 2012
 */
package LeetCode.OnlineJudge;

public class Q32_GenerateParentheses {

    public static void main(String[] args) {
        new Q32_GenerateParentheses().generateParenthesisMy(3);
    }

    //my way
    public void generateParenthesisMy(int n) {
        presentation = new boolean[n * 2];
        generateHelper(n, n, 0);
    }
    boolean[] presentation;

    private void generateHelper(int left, int right, int index) {
        if (left == 0 && right == 0) {
            for (boolean b : presentation) {
                if (b) {
                    System.out.print("[");
                } else {
                    System.out.print("]");
                }
            }
            System.out.println();
        }
        if (left > 0) {
            presentation[index] = true;
            generateHelper(left - 1, right, index + 1);
        }
        if (right > left) {
            presentation[index] = false;
            generateHelper(left, right - 1, index + 1);
        }
    }
}
