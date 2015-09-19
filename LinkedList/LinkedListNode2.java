package LinkedList;

public class LinkedListNode2 {

	private int c;
	private LinkedListNode2 next;

	public LinkedListNode2(int data) {
		this.c = data;
	}

	LinkedListNode2 getNext() {
		return next;
	}

	void setNext(LinkedListNode2 next) {
		this.next = next;
	}

	int data() {
		return c;
	}

	void setData(char c) {
		this.c = c;

	}

}
