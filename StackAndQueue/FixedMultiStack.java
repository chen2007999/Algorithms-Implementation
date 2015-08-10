package StackAndQueue;

import java.util.EmptyStackException;

import sun.misc.Queue;

public class FixedMultiStack {
	
	private int numberOfStacks = 3;
	private int stackCapacity;
	private int[] values;
	private int[] sizes;
	
	
	public FixedMultiStack(int stackSize) {
		stackCapacity = stackSize;
		values = new int[numberOfStacks * stackSize];
		sizes = new int[numberOfStacks];
	}
	
	private int indexOfTop(int stackNum) {
		return stackCapacity * stackNum + sizes[stackNum] - 1;
	}
	
	private boolean isFull(int stackNum) {
		return sizes[stackNum] == stackCapacity;
	}
	
	public boolean isEmpty(int stackNum) {
		return sizes[stackNum] == 0;
	}
	
	public int peek(int stackNum) {
		if(isEmpty(stackNum)) {
			throw new EmptyStackException();
		}
		return values[indexOfTop(stackNum)];
	}
	
	public int pop(int stackNum) {
		if(isEmpty(stackNum)) {
			throw new EmptyStackException();
		}
	    int data = values[indexOfTop(stackNum)];
	    values[indexOfTop(stackNum)] = 0;
	    sizes[stackNum]--;
	    return data;
	}
	
	public void push(int stackNum, int value) /*throws FullStackException*/ {
		if(isFull(stackNum)) {
			//throw new FullStackException();
		}
		sizes[stackNum]++;
		values[indexOfTop(stackNum)] = value;
	}
 }
