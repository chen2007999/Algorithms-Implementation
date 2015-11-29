package RecursionAndDynamicProgramming;

public class IsMatch {

	
	/*Implement wildcard pattern matching with support for '?' and '*'.

	'?' Matches any single character.
	'*' Matches any sequence of characters (including the empty sequence).

	The matching should cover the entire input string (not partial).

	The function prototype should be:
	boolean isMatch(String s, String p) {
	        
	}
	// only lowercase characters in s
	// only lowercase characters and ? * in p
	// no other special char
	Some examples:
	isMatch("aa","a") → false
	isMatch("aa","aa") → true
	isMatch("aaa","aa") → false
	isMatch("aasddwwfwfwfwf", "*") → true
	isMatch("aa", "a*") → true
	isMatch("ab", "?*") → true
	isMatch("aab", "c*a*b") → false*/


	boolean isMatch(String s, String p) {
		if(s == null || p == null) return false;
		boolean[][] matrix = new boolean[p.length()+1][s.length()+1];
		matrix[0][0] = true;
		for(int row=1; row<matrix.length; row++) {
			for(int col=0; col<matrix[row].length; col++) {
				if(p.charAt(row-1) == '?') {
					if(col >0 && matrix[row-1][col-1]) {
						matrix[row][col] = true;
					}
				} else if(p.charAt(row-1) == '*') {	                                             
					boolean c = matrix[row-1][col];
					if (c) {
						while (col<matrix[row].length) matrix[row][col++] = true;
					}
					/*for(int i=0; i<=col; i++) {
							if(matrix[row-1][col]) {
							matrix[row][col] = true;
							break;
					  }
					}*/
				} else {
					if(p.charAt(row-1) == s.charAt(col) && matrix[row-1][col-1]) {
						matrix[row][col] = true;
					}
				} 
			}
		}
		return matrix[p.length()][s.length()];
	}

}
