package RecursionAndDynamicProgramming;

public class LongestPalindrome {

	public static void main(String[] args) {
		char[] str = { 'z','q', 'a', 'a', 'c', 'd', 'e', 'd', 'b', 'a', 'k', 'a' };
		System.out.println(longestLength(str, 0, str.length - 1));
		//System.out.println(DP(str));
	}

	private static int longestLength(char[] str, int targetIndex, int end) {
		int result = 1;
		for (int a = targetIndex; a <= end; a++) {
			for (int i = end; i > a; i--) {
				if (str[i] == str[a]) {
					int var = 2 + longestLength(str, a + 1, i - 1);
					if (var > result) {
						result = var;
					}
					break;
				}
			}
		}
		return result;
	}
/*
	static int DP(char[] str) {
		int[][] store = new int[str.length][str.length];
		for (int i = 0; i < str.length; i++) {
			for (int j = 0; j < str.length; j++) {
				store[i][j] = 1;
			}
		}
		return longestLengthDP(str, 0, str.length - 1, store);
	}

	private static int longestLengthDP(char[] str, int targetIndex, int end, int[][] store) {
		if (store[targetIndex][end] != 1) {
			return store[targetIndex][end];
		}
		int result = 1;
		for (int a = targetIndex; a <= end; a++) {
			for (int i = end; i > a; i--) {
				if (str[i] == str[a]) {
					int var = 2 + longestLength(str, a + 1, i - 1);
					if (var > result) {
						result = var;
					}

					break;
				}
			}
			store[a][end] = result;
		}
	
		return result;
	}*/

}
