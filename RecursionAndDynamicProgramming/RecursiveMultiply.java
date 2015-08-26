package RecursionAndDynamicProgramming;

import java.util.ArrayList;

public class RecursiveMultiply {

	int recursiveMultiply1(int a, int b) {
		int[] results = new int[a + 1];
		results[0] = 0;
		results[1] = b;
		int index = recursiveMultiply1Helper(1, a, results);
		if (index < a) {
			recursiveIncrement(a - index, results);
		}

		return results[a];
	}

	private void recursiveIncrement(int i, int[] results) {
		if (i == 0) {
			return;
		}
		results[i + 1] = results[i] + results[i];
		recursiveIncrement(i - 1, results);
	}

	private int recursiveMultiply1Helper(int index, int a, int[] results) {
		int newIndex = index += index;
		if (newIndex > a) {
			return index;
		}
		results[newIndex] = results[index] + results[index];
		return recursiveMultiply1Helper(newIndex, a, results);
	}

	int recursiveMultiply2(int a, int b) {
		int bigger = a > b ? a : b;
		int smaller = a > b ? b : a;
		return recursiveMultiply2Helper(smaller, bigger);
	}

	private int recursiveMultiply2Helper(int smaller, int bigger) {
		if (smaller == 0)
			return 0;
		if (smaller == 1) {
			return bigger;
		}
		int s = smaller >> 1;
		int half = recursiveMultiply2Helper(s, bigger);
		if (smaller % 2 == 0) {
			return half + half;
		} else {
			return half + half + bigger;
		}
	}
}
