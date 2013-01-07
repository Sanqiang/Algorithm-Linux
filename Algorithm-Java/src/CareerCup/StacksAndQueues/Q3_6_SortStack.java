/**
 * Sanqiang Zhao Www.131X.Com Jan 4, 2013
 */
package CareerCup.StacksAndQueues;

import java.util.Stack;

public class Q3_6_SortStack {

    private Stack<Integer> Helper = new Stack<>();

    public void sort(Stack<Integer> stack) {
        while (true) {
            while (Helper.isEmpty() || (!stack.isEmpty() && Helper.peek() <= stack.peek())) {
                Helper.push(stack.pop());
            }
            if (stack.isEmpty()) {
                break;
            } else {
                int val = stack.pop();
                while (!Helper.isEmpty()) {
                    stack.push(Helper.pop());
                }
                stack.push(val);
            }
        }
        while (!Helper.isEmpty()) {
            stack.push(Helper.pop());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(2);
        stack.push(5);
        stack.push(4);
        stack.push(3);
        stack.push(6);
        stack.push(1);
        Q3_6_SortStack q36 = new Q3_6_SortStack();
        q36.sort(stack);
        for (int i = 0; i < stack.size(); i++) {
            System.out.println(stack.get(i));
        }
    }
}
