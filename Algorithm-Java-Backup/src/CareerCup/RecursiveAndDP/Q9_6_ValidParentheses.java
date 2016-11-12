/**
 * Sanqiang Zhao Www.131X.Com Jan 5, 2013
 */
package CareerCup.RecursiveAndDP;

public class Q9_6_ValidParentheses {

    public void printParenthesis(int pair) {
        boolean[] presentation = new boolean[pair * 2];
        printParentheses(pair, pair, presentation, 0);
    }

    private void printParentheses(int left, int right, boolean[] presentation, int index) {
        if (left == 0 && right == 0) {
            for (int i = 0; i < presentation.length; i++) {
                if (presentation[i]) {
                    System.out.print("(");
                } else {
                    System.out.print(")");
                }
            }
            System.out.println();
        }
        if (left > 0) {
            presentation[index] = true;
            printParentheses(left - 1, right, presentation, index + 1);
        }

        if (left < right) {
            presentation[index] = false;
            printParentheses(left, right - 1, presentation, index + 1);
        }
    }

    public static void main(String[] args) {
        Q9_6_ValidParentheses q96 = new Q9_6_ValidParentheses();
        q96.printParenthesis(3);
    }
}
