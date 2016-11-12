/**
 * Sanqiang Zhao Www.131X.Com Jan 3, 2013
 */
package CareerCup.StacksAndQueues;

import java.util.ArrayList;
import java.util.Stack;

public class Q3_3_SetOfStacks {

    final int NUM_LIMIT = 3;

    public class SetOfStacks {

        ArrayList<Stack<Integer>> stacks;

        public SetOfStacks() {
            stacks = new ArrayList<>();
            //stacks.add(new Stack<Integer>());
        }

        public int popAt(int target) {
            if (target == stacks.size()) {
                System.out.println("No Data!!!");
                return Integer.MIN_VALUE;
            }
            Stack<Integer> stack = stacks.get(target);
            int val = stack.pop();
            shift(target);
            return val;
        }

        private void shift(int target) {
            if (target + 1 < stacks.size()) {
                Stack<Integer> stack = stacks.get(target);
                Stack<Integer> next_stack = stacks.get(target + 1);
                stack.push(next_stack.firstElement());
                next_stack.removeElementAt(next_stack.size() - 1);
                shift(target + 1);
                if (next_stack.isEmpty()) {
                    stacks.remove(target + 1);
                }
            }
        }

        private Stack<Integer> getStack() {
            if (stacks.isEmpty()) {
                return null;
            } else {
                return stacks.get(stacks.size() - 1);
            }
        }

        public void push(int e) {
            Stack<Integer> stack = getStack();
            if (stack == null || stack.size() == NUM_LIMIT) {
                stack = new Stack<>();
                stacks.add(stack);
            }
            stack.add(e);
        }

        public int pop() {
            Stack<Integer> stack = getStack();
            if (stack == null) {
                System.out.println("No Data!!!");
                return Integer.MIN_VALUE;
            }
            int val = stack.pop();
            if (stack.isEmpty()) {
                stacks.remove(stacks.size() - 1);
            }
            return val;
        }

        public int peek() {
            Stack<Integer> stack = getStack();
            if (stack == null) {
                System.out.println("No Data!!!");
                return Integer.MIN_VALUE;
            }
            return stack.peek();
        }

        public void print() {
            for (Stack<Integer> stack : stacks) {
                for (int i = 0; i < stack.size(); i++) {
                    System.out.print(stack.get(i));
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        Q3_3_SetOfStacks q33 = new Q3_3_SetOfStacks();
        Q3_3_SetOfStacks.SetOfStacks sos = q33.new SetOfStacks();
        for (int i = 0; i < 10; i++) {
            sos.push(i);
        }
        sos.print();
        sos.popAt(1);
        sos.print();
    }
}
