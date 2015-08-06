package String;

public class IsUnique {

	// Implement an algorithm to determine if a string has all unique characters. What if you cannot use additional data structures?
	
	public static void main(String[] args) {
		System.out.println(isUnique1("werty"));
		System.out.println(isUnique2("werty"));
		System.out.println(isUnique1("wertyw"));
		System.out.println(isUnique2("wertyw"));
	}
	
	static boolean isUnique1(String s) {
		for(int i=0; i<s.length(); i++) {
			char temp = s.charAt(i);
			for(int j=i+1; j<s.length(); j++) {
				if(temp ==s.charAt(j)) {
					return false;
				}
			}
		}
		return true;
	}
	
	static boolean isUnique2(String s) {
		if(s.length() > 128) return false;
		boolean[] char_set = new boolean[128];
		for(int i=0; i<s.length(); i++) {
			int val = s.charAt(i);
			if(char_set[val]) {
				return false;
			}
			char_set[val] = true;
		}	
		return true;
	}
	
	static boolean isUnique3(String s) {
		int checker = 0;
		for(int i=0; i<s.length(); i++) {
			int val = s.charAt(i) - 'a';
			if((checker & (1 << val)) > 0) {
				return false;
			}
			checker |= (1 << val);
		}
		return true;
	}
	
	
}
