package RecursionAndDynamicProgramming;

import java.util.HashMap;

public class BooleanEvaluation {

	/*
	 * int booleanEvaluation(String s, boolean toBe) { int result = 0;
	 * recurseDown(s, toBe, result); return result; }
	 * 
	 * void recurseDown(String s, boolean toBe, int result) { if (s.length() ==
	 * 1) { int value = s.charAt(0); if (toBe && value == 1) result++; if (!toBe
	 * && value == 0) result++; }
	 * 
	 * int booleanSoFar = s.charAt(0); for (int i = 1; i < s.length(); i++) { if
	 * (s.charAt(i) == '&') { String newS = s.substring(i + 1); if (booleanSoFar
	 * == 1) { if (toBe) { recurseDown(newS, true, result); } else {
	 * recurseDown(newS, false, result); } } else if (booleanSoFar == 0) { if
	 * (!toBe) { recurseDown(newS, true, result); recurseDown(newS, false,
	 * result); } } } else if (s.charAt(i) == '|') { String newS = s.substring(i
	 * + 1); if (booleanSoFar == 1) { if (toBe) { recurseDown(newS, true,
	 * result); recurseDown(newS, false, result); } } else if (booleanSoFar ==
	 * 0) { if (toBe) { recurseDown(newS, true, result); } else {
	 * recurseDown(newS, false, result); } } } else if (s.charAt(i) == '^') {
	 * String newS = s.substring(i + 1); if (booleanSoFar == 1) { if (toBe) {
	 * recurseDown(newS, false, result); } else { recurseDown(newS, true,
	 * result); } } else if (booleanSoFar == 0) { if (toBe) { recurseDown(newS,
	 * true, result); } else { recurseDown(newS, false, result); } } } else { if
	 * (s.charAt(i - 1) == '&') { if (s.charAt(i) != 1) { booleanSoFar = 0; } }
	 * else if (s.charAt(i - 1) == '|') { if (booleanSoFar == 1 || s.charAt(i)
	 * == 1) { booleanSoFar = 1; } else if (booleanSoFar == 0 && s.charAt(i) ==
	 * 0) { booleanSoFar = 0; }
	 * 
	 * } else if (s.charAt(i - 1) == '^') { if (booleanSoFar == s.charAt(i)) {
	 * booleanSoFar = 1; } else { booleanSoFar = 0; } } } if (toBe &&
	 * booleanSoFar == 1) result++; if (!toBe && booleanSoFar == 0) result++; }
	 * }
	 */

	int booleanEvaluation(String s, boolean result, HashMap<String, Integer> memo) {
		if (s.length() == 0) {
			return 0;
		}
		if (s.length() == 1) {
			return stringToBool(s) == result ? 1 : 0;
		}
		if (memo.containsKey(result + s)) {
			return memo.get(result + s);
		}
		int ways = 0;
		for (int i = 1; i < s.length(); i += 2) {
			char c = s.charAt(i);
			String left = s.substring(0, i);
			String right = s.substring(i + 1, s.length());
			int leftTrue = booleanEvaluation(left, true, memo);
			int leftFalse = booleanEvaluation(left, false, memo);
			int rightTrue = booleanEvaluation(right, true, memo);
			int rightFalse = booleanEvaluation(right, false, memo);
			int total = (leftTrue + leftFalse) * (rightTrue + rightFalse);

			int totalTrue = 0;
			if (c == '^') {
				totalTrue = leftTrue * rightFalse + leftFalse * rightTrue;
			} else if (c == '&') {
				totalTrue = leftTrue * rightTrue;
			} else if (c == '|') {
				totalTrue = leftTrue * rightTrue + leftTrue * rightFalse + leftFalse * rightTrue;
			}

			int subWays = result ? totalTrue : total - totalTrue;
			ways += subWays;
		}
		memo.put(result + s, ways);
		return ways;

	}

	private boolean stringToBool(String s) {
		return s.equals("1") ? true : false;
	}

}
