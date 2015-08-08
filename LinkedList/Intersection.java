package LinkedList;

public class Intersection {

	LinkedListNode intersection1(LinkedListNode l1, LinkedListNode l2) {
		while(l1 != null) {
			LinkedListNode l2Iterator = l2;
			while(l2Iterator != null) {
				if(l2Iterator == l1) {
					return l2Iterator;
				}
				l2Iterator = l2Iterator.getNext();
			}
			
			
			l1 = l1.getNext();
		}
		return null;
	}
	
	LinkedListNode intersection2(LinkedListNode l1, LinkedListNode l2) {
		LinkedListNode l1Iterator = l1;
		LinkedListNode l2Iterator = l2;
		int length1 = 1;
		while(l1Iterator.getNext() != null) {
			l1Iterator = l1Iterator.getNext();
			length1++;
		}
		int length2 = 1;
		while(l2Iterator.getNext() != null) {
			l2Iterator = l2Iterator.getNext();
			length2++;
		}
		if(l1Iterator != l2Iterator) {
			return null;
		}
		int diff = length1 > length2 ? length1 - length2 : length2 - length1;
		LinkedListNode l = length1 > length2 ? l1 : l2;
		LinkedListNode s = length1 <= length2 ? l1 : l2;
		for(int i=0; i<diff; i++) {
			l = l.getNext();
		}
		while(l != null) {
			if(l == s) {
				return l;
			}
			l = l.getNext();
			s = s.getNext();
		}
		return null;
 		
	}
	

}
