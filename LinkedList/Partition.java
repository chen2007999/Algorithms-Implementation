package LinkedList;

public class Partition {
	
	LinkedListNode partition1(LinkedListNode node, int x) {
		LinkedListNode beforeStart = null;
		LinkedListNode beforeEnd = null;
		LinkedListNode afterStart = null;
		LinkedListNode afterEnd = null;
		
		while(node != null) {
			LinkedListNode next = node.getNext();
			node.setNext(null);
			if(node.data() < x) {
				if(beforeStart == null) {
					beforeStart = node;
					beforeEnd = beforeStart;
				}	else {
					beforeEnd.setNext(node);
					beforeEnd = node;
				}
 			} else {
 				if(afterStart == null) {
 					afterStart = node;
 					afterEnd = afterStart;
 				} else {
 					afterEnd.setNext(node);
 					afterEnd = node;
 				}
 				
 			}
			node = next;
		}
		beforeEnd.setNext(afterStart);
		return beforeStart;
	}
	
	LinkedListNode partition2(LinkedListNode node, int x) {
		LinkedListNode head = node;
		LinkedListNode tail = node;
		
		while(node != null) {
			LinkedListNode next = node.getNext();
			if(node.data() < x) {
				node.setNext(head);
				head = node;
			} else {
				tail.setNext(node);
				tail = node;
			}
			node = next;
		}
		tail.setNext(null);
		return head;
 	}

}
