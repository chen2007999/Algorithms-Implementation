package String;

import java.util.Hashtable;
import java.util.Iterator;

public class CheckPermutation {

	// Given two strings, write a method to decide if one is a permutation of
	// the other.

	public static void main(String[] args) {
		System.out.println(checkPermutation1("wer yw", "wetr y"));
		System.out.println(checkPermutation1("wertyw", "wetr y"));
		System.out.println(checkPermutation1("wertyw", "WERTYM"));
		System.out.println(checkPermutation1("wertyw", "wyewtr"));
		
		System.out.println(checkPermutation2("wer yw", "wetr y"));
		System.out.println(checkPermutation2("wertyw", "wetr y"));
		System.out.println(checkPermutation2("wertyw", "WERTYM"));
		System.out.println(checkPermutation2("wertyw", "wyewtr"));

		System.out.println(checkPermutation3("wer yw", "wetr y"));
		System.out.println(checkPermutation3("wertyw", "wetr y"));
		System.out.println(checkPermutation3("wertyw", "WERTYM"));
		System.out.println(checkPermutation3("wertyw", "wyewtr"));
		
		System.out.println(checkPermutation4("wer yw", "wetr y"));
		System.out.println(checkPermutation4("wertyw", "wetr y"));
		System.out.println(checkPermutation4("wertyw", "WERTYM"));
		System.out.println(checkPermutation4("wertyw", "wyewtr"));
	}

	static boolean checkPermutation1(String s1, String s2) {
		if (s1.length() != s2.length()) {
			return false;
		}
		boolean[] array = new boolean[s2.length()];
		for (int i = 0; i < s1.length(); i++) {
			char val = s1.charAt(i);
			boolean contains = false;
			for (int j = 0; j < s2.length(); j++) {
				if (s2.charAt(j) == val && !array[j]) {
					contains = true;
					array[j] = true;
					break;
				}
			}
			if (!contains) {
				return false;
			}
		}
		return true;
	}
	
	
	static boolean checkPermutation2(String s1, String s2) {
		if (s1.length() != s2.length()) {
			return false;
		}
		char[] content1 = s1.toCharArray();
		java.util.Arrays.sort(content1);
		char[] content2 = s2.toCharArray();
		java.util.Arrays.sort(content2);
		return new String(content1).equals(new String(content2));		
	}
	
	
	static boolean checkPermutation3(String s1, String s2) {
		if (s1.length() != s2.length()) {
			return false;
		}
		Hashtable<Character, Integer> hash1 = hash(s1);
		Hashtable<Character, Integer> hash2 = hash(s2);
		
		Iterator<Character> iterator = hash1.keySet().iterator();
		while(iterator.hasNext()) {
			char key = iterator.next();
			if(hash2.get(key) != hash1.get(key)) {
				return false;
			}
		}
		return true;
	}
	
	static Hashtable<Character, Integer> hash(String s) {
		Hashtable<Character, Integer> hash = new Hashtable<>();
		for(int i=0; i<s.length(); i++) {
			char key = s.charAt(i);
			if(hash.containsKey(key)) {
				hash.put(key, hash.get(key) + 1);
			} else {
				hash.put(key, 1);
			}
		}
		return hash;
		
	}
	
	static boolean checkPermutation4(String s1, String s2) {
		if (s1.length() != s2.length()) {
			return false;
		}
		
		int[] letters = new int[128];
		
		char[] s1_array = s1.toCharArray();
		for(char c: s1_array) {
			letters[c]++;
		}
		
		for(int i=0; i<s2.length(); i++) {
			int c = s2.charAt(i);
			letters[c]--;
			if(letters[c] < 0) {
				return false;
			}
		}
		return true;
	}
	
}
