package String;

import java.util.Hashtable;
import java.util.Iterator;

public class PalindromePermutation {
	
	public static void main(String[] args) {
		System.out.println(isPalindromePermutation("te t"));
		System.out.println(isPalindromePermutation("tte t"));
		System.out.println(isPalindromePermutation("te ttte "));
	}
	
	static boolean isPalindromePermutation(String s) {
		Hashtable<Character, Integer> hash = new Hashtable<>();
		for(int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			if(!Character.isLetter(c) && c != ' ') {
				return false;
			}
			if(c == ' ') {
				continue;
			}
			if(hash.containsKey(c)) {
				hash.put(c, hash.get(c) + 1);
			} else {
				hash.put(c, 1);
			}
		}
		Iterator<Integer> iterator = hash.values().iterator();
		int oddCounter = 0;
		while(iterator.hasNext()) {
			if(iterator.next() % 2 == 1) {
				oddCounter++;
				if(oddCounter > 1) {
					return false;
				}
			} 
		}
		return true;
	}

}
