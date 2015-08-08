package LinkedList;

public class LoopDetection {
	
	LinkedListNode loopDetection1(LinkedListNode n) {
		if(n == null) {
			return null;
		}
		LinkedListNode fast = n;
		LinkedListNode slow = n;
		while(fast != null) {
			if(fast.getNext() == null) {
				return null;
			}
			fast = fast.getNext().getNext();
			slow = slow.getNext();
			if(fast == slow) {
				break;
			}
		}
		if(fast == null) {
			return null;
		}
		while(n != null) {
			if(slow == n) {
				return slow;
			}
			slow = slow.getNext();
			while(slow != fast) {
				if(slow == n) {
					return slow;
				}
				slow = slow.getNext();
			}
			
			n = n.getNext();
		}
		return null;
	}
	
	LinkedListNode loopDetection2(LinkedListNode n) {
		LinkedListNode slow = n;
		LinkedListNode fast = n;
		while(fast != null && fast.getNext() != null) {
			slow = slow.getNext();
			fast = fast.getNext().getNext();
			if(slow == fast) {
				break;
			}
		}
		if(fast == null || fast.getNext() == null) {
			return null;
		}
		slow = n;
		while(slow != fast) {
			slow = slow.getNext();
			fast = fast.getNext();
		}
		return fast;
	}

}
