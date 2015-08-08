package LinkedList;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Stack;

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
	
	boolean palindrome1(LinkedListNode n) {
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
	
	boolean palindrome2(LinkedListNode n) {
		Hashtable<Character, Integer> hash = new Hashtable();
		int position = 0;
		while(n != null) {
			if(hash.contains(n.data())) {
				hash.put(n.data(), hash.get(n.data())+position);
			} else {
				hash.put(n.data(), position);
			}
			position++;
			n = n.getNext();
		}
		position--;
		Iterator<Integer> it = hash.values().iterator();
		int middle = 0;
		while(it.hasNext()) {
			if(it.next() != position || it.next() != position/2) {
				return false;
			}
			if( it.next() == position/2) {
				middle++;
				if(middle > 1) {
					return false;
				}
			}
		}
		return true;
	}
	
	boolean palindrome3(LinkedListNode n) {
		if(n == null || n.getNext() == null) {
			return false;
		}
		LinkedListNode fast = n;
		LinkedListNode slow = n;
		Stack<LinkedListNode> s = new Stack<>();
		while(fast != null) {
			s.push(slow);
			slow = slow.getNext();
			if(fast.getNext() != null) {
				fast = fast.getNext().getNext();
			} else {
				fast = null;
			}
		}
		while(!s.isEmpty() || slow != null) {
			if(slow == null) return false;
			if(s.isEmpty()) return false;
			if(s.pop().data() != slow.data()) {
				return false;
			}
			slow = slow.getNext();
		}
		return true;
	}

	
	
	
	
	
}
