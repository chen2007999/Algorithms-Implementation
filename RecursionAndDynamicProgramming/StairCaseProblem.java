package RecursionAndDynamicProgramming;

import java.util.HashMap;

public class StairCaseProblem {

	/*
	 * You are climbing a stair case. It takes n steps to reach to the top. (n >
	 * 0) Each time you can either climb 1 or 2 steps. In how many distinct ways
	 * can you climb to the top?
	 */

	// bottom up:
	int numOfWays1(int n) {
		if (n == 1)
			return 1;
		int[] result = new int[n + 1];
		result[0] = 1;
		result[1] = 1;
		for (int i = 2; i < n; i++) {
			result[i] = result[i - 1] + result[i - 2];
		}
		return result[n];
	}

	// top down:
	// global
	HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();

	int numOfWays2(int n) {
		if (n == 0)
			return 1;
		if (n < 0)
			return 0;

		if (hash.containsKey(n)) {
			return hash.get(n);
		}
		return hash.put(n, numOfWays2(n - 1) + numOfWays2(n - 2));

	}

}
