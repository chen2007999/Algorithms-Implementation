package StackAndQueue;

import java.util.EmptyStackException;
import java.util.Stack;

public class QueueViaStacks {

	private Stack<Integer> stack1 = new Stack<Integer>();
	private Stack<Integer> stack2 = new Stack<Integer>();
	
	void enqueue(int data) {
		stack1.push(data);
	}
	
	void convert() {
		while(!stack1.isEmpty()) {
			stack2.push(stack1.pop());
		}
	}
	
	int dequeue() {
		if(stack2.isEmpty()) {
			convert();
		}
		if(stack2.isEmpty()) {
			throw new EmptyStackException();
		}
		return stack2.pop();
	}
	
	int peek() {
		if(stack2.isEmpty()) {
			convert();
		}
		if(stack2.isEmpty()) {
			throw new EmptyStackException();
		}
		return stack2.peek();
	}
	
	int size() {
		return stack1.size() + stack2.size();
	}
}
