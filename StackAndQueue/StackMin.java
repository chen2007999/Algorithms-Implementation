package StackAndQueue;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;

public class StackMin {
	
	private Stack<Integer> stack = new Stack();
	private Stack<Integer> mins = new Stack();
	
	int pop() {
		if(stack.isEmpty()) throw new EmptyStackException();
		int data = stack.pop();
		if(data == mins.peek()) {
			mins.pop();
		}
		return data;
	}
	
	void push(int data) {
		stack.push(data);
		if(data < mins.peek()) {
			mins.push(data);
		}
	}
	
	int min() {
		if(mins.isEmpty()) throw new EmptyStackException();
		return mins.pop();
	}

}
