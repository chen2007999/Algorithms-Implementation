package String;

public class BracketDepth {
	
	public static void main(String[] args) {
		System.out.println(bracketDepth("(1+2) * (3+2) /2"));
		System.out.println(bracketDepth("(1+2+(9-8)-*(7-8))"));
		System.out.println(bracketDepth("(1+2+(9-8)-*(7-8)) + (6+1)"));
		System.out.println(bracketDepth("(1+2+(9-8)-*(7-8 + (1-2))) + (6+1)"));
	}
	
	static int bracketDepth(String s) {
		int currentDepth = 0;
		int maxDepth = 0;
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i) == '(') {
				currentDepth++;
				if(currentDepth > maxDepth) {
					maxDepth = currentDepth;
				}
			}
			if(s.charAt(i) == ')') {
				currentDepth--;
			}
		}
		return maxDepth;
		
	}

}
