package LinkedList;

public class DeleteMiddleNode {
	
	void deleteMiddleNode(LinkedListNode n) {
		LinkedListNode node = n;
		while(node.getNext() != null) {
			node.setData(node.getNext().data());
			node = node.getNext();
		}
		node = null;
	}
	
	
	boolean deleteNode(LinkedListNode n) {
		if(n == null || n.getNext() == null) {
			return false;
		}
		LinkedListNode next = n.getNext();
		n.setData(next.data());
		n.setNext(next.getNext());
		return true;
	}

}
