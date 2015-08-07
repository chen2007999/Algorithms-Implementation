package String;

public class OneAway {

	public static void main(String[] args) {
		System.out.println(oneAway("pale", "ple"));
		System.out.println(oneAway("pal", "pale"));
		System.out.println(oneAway("pales", "pale"));
		System.out.println(oneAway("pale", "bale"));
		System.out.println(oneAway("pale", "bae"));
		System.out.println(oneAway("ple", "pale"));
		System.out.println(oneAway("ple", "palk"));
	}

	static boolean oneAway(String s1, String s2) {
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
				if(j == s2length && i == s1length - 1) {
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
				if(j == s1length && i == s2length - 1) {
					insertCounter++;
					if(insertCounter > 1) {
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
	
}
