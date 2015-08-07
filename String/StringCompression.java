package String;

public class StringCompression {

	public static void main(String[] args) {
		System.out.println(compress("aabbbccd"));
		System.out.println(compress("aabbbccdddd"));
		System.out.println(compress("aa"));
		System.out.println(compress("aaaaaa"));
		System.out.println(compress("abcd"));
	}
	
	static String compress(String s) {
		if(s.length() < 3) {
			return s;
		}
		int counter = 1;
		String result = "";
		for(int i=0; i+1<s.length(); i++) {
			if(s.charAt(i) == s.charAt(i+1)) {
				counter++;
			} else {
				StringBuilder sb = new StringBuilder();
				sb.append(counter);
				String str = sb.toString();
				result = result + str + s.charAt(i);
				counter = 1;
			}
		}
		if(s.charAt(s.length() - 1) == s.charAt(s.length() - 2)) {
			StringBuilder sb = new StringBuilder();
			sb.append(counter);
			String str = sb.toString();
			result = result + str + s.charAt(s.length() - 1);
		} else {
			StringBuilder sb = new StringBuilder();
			sb.append(counter);
			String str = sb.toString();
			result = result + str + s.charAt(s.length() - 1);
		}
		result = result.length() < s.length() ? result : s;
		return result;
	} 
	
	static String compress2(String s) {
		StringBuilder sb = new StringBuilder();
		int counter = 0;
		for(int i=0; i<s.length(); i++) {
			counter++;
			if(i+1 >= s.length() || s.charAt(i) != s.charAt(i+1)) {
				sb.append(counter);
				sb.append(s.charAt(i));
				counter = 0;
			}
		}
		return sb.length() < s.length() ? sb.toString() : s;
	}
	
}
