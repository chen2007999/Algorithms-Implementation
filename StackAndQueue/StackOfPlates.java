package StackAndQueue;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;

public class StackOfPlates {
	
	private int threshold;
	private Stack<StackPlates> stackOfStacks = new Stack<>();
	private StackPlates current = null;
	
	public StackOfPlates(int threashold) {
		this.threshold = threashold;
	}
	
	public class StackPlates {
		private int threshold;
		private Stack<Integer> stack = new Stack<Integer>();
		private int size = 0;
		
		public StackPlates(int threashold) {
			this.threshold = threashold;
		}
	}
	
	void push(int data) {
		if(current == null || current.threshold == current.size) {
			StackPlates sp = new StackPlates(threshold);
			current = sp;
			stackOfStacks.push(current);
		}		
		current.stack.push(data);
		current.size++;
	}
	
	int pop() {
		if(current == null) throw new EmptyStackException();
		int data = current.stack.pop();
		current.size--;
		if(current.size == 0) {
			stackOfStacks.pop();
			current = stackOfStacks.peek();
		}
		return data;
	}

}
