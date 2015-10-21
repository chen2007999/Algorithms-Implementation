package RecursionAndDynamicProgramming;

public class LongestPalindrome {

	public static void main(String[] args) {
		char[] str = {'a','z','k','c','d','e','d','b','a','k','z'};
		System.out.println(longestLength(str, 0, str.length-1));
	}

	private static int longestLength(char[] str, int targetIndex, int end) {
		int result = 1;
		for (int a = targetIndex; a <= end; a++) {
			for (int i = end; i > a; i--) {
				if (str[i] == str[targetIndex]) {

					int var = 2 + longestLength(str, a+1, i - 1);
					if (var > result) {
						result = var;
					}

					break;
				}
			}
		}
		return result;
	}

}
