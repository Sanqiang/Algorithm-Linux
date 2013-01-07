/**
 * Sanqiang Zhao Www.131X.Com Jan 3, 2013
 */
package CareerCup.StacksAndQueues;

import LeetCode.OnlineJudge.Q34_StrStr;
import java.util.Stack;

public class Q3_4_Hanoi {

    public class Hanoi {

        Stack<Integer>[] stack_list;

        public Hanoi(int n) {
            stack_list = new Stack[3];
            for (int i = 0; i < 3; i++) {
                stack_list[i] = new Stack<>();
            }
            for (int i = 1; i <= n; i++) {
                stack_list[0].push(i);
            }
        }

        public void solve() {
            solve(stack_list[0], stack_list[1], stack_list[2], stack_list[0].size());
        }

        public void solve(Stack<Integer> origin, Stack<Integer> buffer, Stack<Integer> destination, int n) {
            if (n == 1) {
                destination.push(origin.pop());
                return;
            }
            solve(origin, destination, buffer, n - 1);
            destination.push(origin.pop());
            solve(buffer, origin, destination, n - 1);
        }

        private void solve(Stack<Integer> origin, Stack<Integer> buffer, Stack<Integer> destination) {
            buffer.push(origin.pop());
            destination.push(origin.pop());
            destination.push(buffer.pop());
        }

        public void print() {
            for (Stack<Integer> stack : stack_list) {
                for (int i = 0; i < stack.size(); i++) {
                    System.out.print(stack.get(i));
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        Q3_4_Hanoi q34 = new Q3_4_Hanoi();
        Q3_4_Hanoi.Hanoi hanoi = q34.new Hanoi(5);
        hanoi.print();
        hanoi.solve();
        hanoi.print();
    }
}
