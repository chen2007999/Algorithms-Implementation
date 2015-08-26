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
		results[i + i] = results[i] + results[i];
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

}
