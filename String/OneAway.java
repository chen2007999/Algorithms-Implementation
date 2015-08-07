package String;

public class OneAway {

	public static void main(String[] args) {
		System.out.println(oneAway1("pale", "ple"));
		System.out.println(oneAway1("pal", "pale"));
		System.out.println(oneAway1("pales", "pale"));
		System.out.println(oneAway1("pale", "bale"));
		System.out.println(oneAway1("pale", "bae"));
		System.out.println(oneAway1("ple", "pale"));
		System.out.println(oneAway1("ple", "palk"));
	}

	static boolean oneAway1(String s1, String s2) {
		int s1length = s1.length();
		int s2length = s2.length();
		if (s1length != s2length && s1length != s2length + 1 && s1length != s2length - 1) {
			return false;
		}
		if (s1length == s2length) {
			int replaceCounter = 0;
			for (int i = 0; i < s1length; i++) {
				if (s1.charAt(i) != s2.charAt(i)) {
					replaceCounter++;
					if (replaceCounter > 1) {
						return false;
					}
				}
			}
		} else if (s1length == s2length + 1) {
			int removeCounter = 0;
			int j = 0;
			for (int i = 0; i < s1length; i++) {
				if (j == s2length && i == s1length - 1) {
					removeCounter++;
					if (removeCounter > 1) {
						return false;
					} else {
						break;
					}
				}
				if (s1.charAt(i) != s2.charAt(j)) {
					removeCounter++;
					if (removeCounter > 1) {
						return false;
					}
				} else {
					j++;
				}
			}
		} else if (s1length == s2length - 1) {
			int insertCounter = 0;
			int j = 0;
			for (int i = 0; i < s2length; i++) {
				if (j == s1length && i == s2length - 1) {
					insertCounter++;
					if (insertCounter > 1) {
						return false;
					} else {
						break;
					}
				}
				if (s1.charAt(j) != s2.charAt(i)) {
					insertCounter++;
					if (insertCounter > 1) {
						return false;
					}
				} else {
					j++;
				}
			}
		}
		return true;
	}

	static boolean oneAway2(String s1, String s2) {
		if (s1.length() == s2.length()) {
			return oneReplace(s1, s2);
		} else {
			return oneEditAway(s1, s2);
		}
	}

	static boolean oneReplace(String s1, String s2) {
		boolean foundDifference = false;
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) != s2.charAt(i)) {
				if (foundDifference) {
					return false;
				}
				foundDifference = true;
			}
		}
		return true;
	}

	static boolean oneEditAway(String s1, String s2) {
		if (Math.abs(s1.length() - s2.length()) > 1) {
			return false;
		}
		String str1 = s1.length() < s2.length() ? s1 : s2;
		String str2 = s1.length() < s2.length() ? s2 : s1;

		int index1 = 0;
		int index2 = 0;
		boolean foundDifference = false;
		while (index2 < s2.length() && index1 < s1.length()) {
			if (str1.charAt(index1) != str2.charAt(index2)) {
				if (foundDifference) {
					return false;
				}
				foundDifference = true;
				if (str1.length() < str2.length()) {
					index2++;
				}
			} else {
				index1++;
				index2++;
			}
		}
		return true;
	}

}
