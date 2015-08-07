package String;

public class StringRotation {
	
	public static void main(String[] args) {
		String s1 = "waterbottle";
		String s2 = "erbottlewat";
		System.out.println(StringRotation(s1, s2));
		
		String s3 = "wwwwar";
		String s4 = "arwwww";
		System.out.println(StringRotation(s1, s2));
	}
	
	static boolean StringRotation(String s1, String s2) {
		if(s1.length() != s2.length()) {
			return false;
		}
		if(s1 == " ") {
			return true;
		}
		char c = s1.charAt(0);
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<s2.length(); i++) {
			if(s2.charAt(i) == c) {
				String s2Half = s2.substring(i);
				String str = sb.toString();
				if((s2Half + str).equals(s1)) {
					return true;
				}
			} 
			sb.append(s2.charAt(i));	
		}
		return false;
	}
	
	/*static boolean isRotation(String s1, String s2) {
		int len = s1.length();
		if(len == s2.length() && len > 0) {
			String s1s1 = s1 + s1;
			return isSubstring(s1s1, s2);
		}
		return false;
	}*/

}
