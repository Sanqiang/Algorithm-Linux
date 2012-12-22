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
        String s = "()(()()";
        int max = new Q46_LongestValidParentheses().longestValidParentheses(s);
        System.out.println(max);
    }
}
