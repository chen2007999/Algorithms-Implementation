package LinkedList;

public class SumList {

	LinkedListNode2 sumList1(LinkedListNode2 l1, LinkedListNode2 l2) {
		if (l1 == null || l2 == null) {
			return l1 == null ? l2 : l1;
		}
		LinkedListNode2 resultHead = null;
		LinkedListNode2 result = null;
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
				result = new LinkedListNode2(data);
				resultHead = result;
			} else {
				LinkedListNode2 node = new LinkedListNode2(data);
				result.setNext(node);
				result = node;
			}
		}
		return resultHead;
	}

	LinkedListNode2 sumList2(LinkedListNode2 l1, LinkedListNode2 l2, int carry) {
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
		LinkedListNode2 result = new LinkedListNode2(data);
		result.setNext(sumList2(l1, l2, carry));
		return result;
	}

	LinkedListNode2 reverseList(LinkedListNode2 l) {
		LinkedListNode2 head = l;
		while (l != null) {
			LinkedListNode2 next = l.getNext();
			l.setNext(head);
			head = l;
			l = next;
		}
		return head;
	}

	LinkedListNode2 sumListforward(LinkedListNode2 l1, LinkedListNode2 l2, int carry) {
		return reverseList(sumList2(reverseList(l1), reverseList(l2), 0));
	}
}
