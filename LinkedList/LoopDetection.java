package LinkedList;

public class LoopDetection {
	
	LinkedListNode loopDetection(LinkedListNode n) {
		if(n == null) {
			return null;
		}
		LinkedListNode fast = n;
		LinkedListNode slow = n;
		while(fast != null) {
			if(fast == slow) {
				break;
			}
			if(fast.getNext() == null) {
				return null;
			}
			fast = fast.getNext().getNext();
			slow = slow.getNext();
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

}
