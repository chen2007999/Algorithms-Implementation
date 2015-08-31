package RecursionAndDynamicProgramming;

public class Coins {

	int coinsBottomUp(int n) {
		if (n <= 0)
			return 0;
		int[] results = new int[n + 1];
		results[1] = 1;
		for (int i = 2; i <= n; i++) {
			int mid = i / 2;
			int result = 0;
			for (int j = 1; j <= i / 2; j++) {
				result += results[j] * results[n - j];
			}
			if (i == 5 || i == 10 || i == 25) {
				result++;
			}
			results[i] = result;
		}
		return results[n];
	}

	int coinsTopDown(int n) {
		if (n <= 0)
			return 0;
		int[] results = new int[n + 1];
		results[1] = 1;
		return coinsTopDownHelper(n, results);
	}

	private int coinsTopDownHelper(int n, int[] results) {
		if (results[n] != 0) {
			return results[n];
		}
		int result = 0;
		int mid = n / 2;
		for (int i = 0; i <= mid; i++) {
			result += coinsTopDownHelper(i, results) * coinsTopDownHelper(n - i, results);
			if (i == 5 || i == 10 || i == 25) {
				result++;
			}
		}
		results[n] = result;
		return result;
	}

}
