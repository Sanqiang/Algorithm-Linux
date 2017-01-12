package Lintcode.Base.Ladders.DataStructureLadder;

import java.util.Stack;

public class MinStack {

	Stack<Integer> stack = null, stack_min = null;

	public MinStack() {
		stack = new Stack<>();
		stack_min = new Stack<>();
	}

	public void push(int number) {
		stack.push(number);
		int cur_min = min();
		if (cur_min > number) {
			stack_min.push(number);
		} else {
			stack_min.push(cur_min);
		}
	}

	public int pop() {
		stack_min.pop();
		return stack.pop();
	}

	public int min() {
		if(stack_min.isEmpty()){
			return Integer.MAX_VALUE;
		}else{
			return stack_min.peek();
		}
	}
}
