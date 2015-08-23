package RecursionAndDynamicProgramming;

public class TripleStep {

	int tripleStepBottomUp(int n) {
		int[] store = new int[n + 1];
		if (n <= 0)
			return 0;
		store[0] = 1;
		store[1] = 1;
		store[2] = 2;
		for (int i = 3; i <= n; i++) {
			store[i] = store[i - 1] + store[i - 2] + store[i - 3];
		}
		return store[n];
	}

	int tripleStepTopDown(int n) {
		if (n <= 0)
			return 0;
		int[] store = new int[n + 1];
		store[0] = 1;
		return tripleStepTopDownHelper(n, store);
	}

	private int tripleStepTopDownHelper(int n, int[] store) {
		if (n < 0)
			return 0;
		if (store[n] == 0) {
			store[n] = tripleStepTopDownHelper(n-1, store) + tripleStepTopDownHelper(n-2, store) + tripleStepTopDownHelper(n-3, store);
		}
		return store[n];
	}

}
