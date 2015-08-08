package LinkedList;

public class Palindrome {

	LinkedListNode reverseList(LinkedListNode n) {
		LinkedListNode head = n;
		while(n != null) {
			LinkedListNode next = n.getNext();
			n.setNext(head);
			head = n;
			n = next;
		}
		return head;
	}
	
	boolean palindrome(LinkedListNode n) {
		LinkedListNode reverse = reverseList(n);
		while(n != null) {
			if(n.data() != reverse.data()) {
				return false;
			}
			n = n.getNext();
			reverse = reverse.getNext();
		}
		return true;
	}
}
