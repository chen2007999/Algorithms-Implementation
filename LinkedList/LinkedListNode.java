package LinkedList;

public class LinkedListNode {
	
	private char c;
	private LinkedListNode next; 
	
	public LinkedListNode(char c) {
		this.c = c;
	}
	
	LinkedListNode getNext() {
		return next;
	}
	
	void setNext(LinkedListNode next) {
		this.next = next;
	}
	
	char data() {
		return c;
	}

}
