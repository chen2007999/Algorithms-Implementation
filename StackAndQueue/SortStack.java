package StackAndQueue;

import java.util.Stack;

import sun.misc.Queue;

public class SortStack {

	Stack<Integer> sortStack(Stack<Integer> stack1) {
		Stack<Integer> stack2 = new Stack<Integer>();
		while (!stack1.isEmpty()) {
			int cur = stack1.pop();
			while (!stack2.isEmpty() && cur > stack2.peek()) {
				stack1.push(stack2.pop());
			}
			stack2.push(cur);
		}
		return stack2;
	}

}
