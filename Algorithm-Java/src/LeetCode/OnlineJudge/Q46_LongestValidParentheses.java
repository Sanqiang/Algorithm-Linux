/**
 * Sanqiang Zhao Www.131X.Com Dec 21, 2012
 */
package LeetCode.OnlineJudge;

import java.util.Stack;

public class Q46_LongestValidParentheses {

    public int longestValidParentheses(String s) {
        int length = s.length(), i, max = 0, start = length, cur = 0;
        Stack<Integer> st = new Stack<>();
        for (i = 0; i < length; ++i) {
            char ch = s.charAt(i);
            if (ch == '(') {
                st.push(i);
            } else if (ch == ')') {
                if (st.isEmpty()) {
                    start = length;
                } else {
                    start = Math.min(start, st.pop());
                    if (st.isEmpty()) {
                        cur = i - start + 1;
                        max = Math.max(cur, max);
                    } else {
                        cur = i - st.peek();
                        max = Math.max(cur, max);
                    }
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "()()(()";
        int max = new Q46_LongestValidParentheses().longestValidParenthesesMy(s);
        System.out.println(max);
    }

    //my way
    public int longestValidParenthesesMy(String s) {
        int len = s.length(), max = 0, i = 0, left = 0;
        Stack<Integer> stack = new Stack<>();
        while (i < len) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(i);
            } else if (ch == ')') {
                if (!stack.isEmpty()) {
                    int pos = stack.pop();
                    if (stack.isEmpty()) {
                        max = Math.max(max, i - left + 1);
                    } else {
                        max = Math.max(max, i - (stack.peek() + 1) + 1);
                    }
                } else {
                    left = i + 1;
                }
            }
            ++i;
        }
        return max;
    }
}
