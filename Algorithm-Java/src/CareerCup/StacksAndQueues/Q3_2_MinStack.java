/**
 * Sanqiang Zhao Www.131X.Com Jan 3, 2013
 */
package CareerCup.StacksAndQueues;

import java.util.Stack;

public class Q3_2_MinStack {

    class MinStack extends Stack<Integer> {

        Stack<Integer> Helper;

        public MinStack() {
            super();
            Helper = new Stack<>();
        }

        @Override
        public Integer push(Integer e) {
            if (Helper.isEmpty() || e < Helper.peek()) {
                Helper.push(e);
            }
            return super.push(e);
        }

        @Override
        public synchronized Integer pop() {
            if (Helper.peek() == super.peek()) {
                Helper.pop();
            }
            return super.pop();
        }

        public Integer min() {
            if (Helper.isEmpty()) {
                return Integer.MAX_VALUE;
            }
            return Helper.peek();
        }
    }

    public static void main(String[] args) {
        Q3_2_MinStack q32 = new Q3_2_MinStack();
        Q3_2_MinStack.MinStack ms = q32.new MinStack();
        ms.push(2);
        ms.push(3);
        ms.push(1);
        ms.push(4);
        System.out.println(ms.pop() + " Min:" + ms.min());
        System.out.println(ms.pop() + " Min:" + ms.min());
        System.out.println(ms.pop() + " Min:" + ms.min());
        System.out.println(ms.peek() + " Min:" + ms.min());
    }
}
