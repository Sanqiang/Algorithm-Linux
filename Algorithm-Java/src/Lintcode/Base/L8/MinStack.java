package Lintcode.Base.L8;

import java.util.Stack;

public class MinStack {

	Stack<Integer> num_stack = null, min_stack = null;

	public MinStack() {
		num_stack = new Stack<>();
		min_stack = new Stack<>();
	}

	public void push(int number) {
		num_stack.push(number);
		if (min_stack.isEmpty() || min_stack.peek() > number) {
			min_stack.push(number);
		} else {
			min_stack.push(min_stack.peek());
		}
	}

	public int pop() {
		int num = num_stack.pop();
		min_stack.pop();
		return num;
	}

	public int min() {
		return min_stack.peek();
	}
}
