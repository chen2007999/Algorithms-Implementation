package LinkedList;

import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;

public class RemoveDups {

	
	static void RemoveDups1(LinkedListNode n) {
		Hashtable<Character, Integer> hash = new Hashtable<Character, Integer>();
		LinkedListNode prev = n;
		while(n != null) {
			if(hash.contains(n.data())) {
				prev.setNext(n.getNext());
			} else {
				hash.put(n.data(), 1);
				prev = n;
			}
			
			n= n.getNext();
		}
		
	}
	
	static void RemoveDups2(LinkedListNode n) {
		LinkedListNode cur = n;
		while(cur != null) {
			LinkedListNode check = cur.getNext();
			LinkedListNode prevCheck = cur;
			while(check != null) {
				if(cur.data() == cur.data()) {
					prevCheck.setNext(check.getNext());
				} else {
					prevCheck = check;
				}
				check = check.getNext();
			}
			cur = cur.getNext();
		}
	}
}