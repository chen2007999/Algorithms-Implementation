package LinkedList;

public class SumList {

	LinkedListNode sumList1(LinkedListNode l1, LinkedListNode l2) {
		if (l1 == null || l2 == null) {
			return l1 == null ? l2 : l1;
		}
		LinkedListNode resultHead = null;
		LinkedListNode result = null;
		int carry = 0;
		while (l1 != null || l2 != null || carry != 0) {
			int sum = carry;
			if (l1 != null) {
				sum += l1.data();
				l1 = l1.getNext();
			}
			if (l2 != null) {
				sum += l2.data();
				l2 = l2.getNext();
			}
			int data = sum % 10;
			carry = sum / 10;
			if (result == null) {
				result = new LinkedListNode(data);
				resultHead = result;
			} else {
				LinkedListNode node = new LinkedListNode(data);
				result.setNext(node);
				result = node;
			}
		}
		return resultHead;
	}

	LinkedListNode sumList2(LinkedListNode l1, LinkedListNode l2, int carry) {
		if (l1 == null && l2 == null && carry == 0) {
			return null;
		}
		int sum = carry;
		if (l1 != null) {
			sum += l1.data();
			l1 = l1.getNext();
		}
		if (l2 != null) {
			sum += l2.data();
			l2 = l2.getNext();
		}
		int data = sum % 10;
		carry = sum / 10;
		LinkedListNode result = new LinkedListNode(data);
		result.setNext(sumList2(l1, l2, carry));
		return result;
	}

	LinkedListNode reverseList(LinkedListNode l) {
		LinkedListNode head = l;
		while (l != null) {
			LinkedListNode next = l.getNext();
			l.setNext(head);
			head = l;
			l = next;
		}
		return head;
	}

	LinkedListNode sumListforward(LinkedListNode l1, LinkedListNode l2, int carry) {
		return reverseList(sumList2(reverseList(l1), reverseList(l2), 0));
	}
}
