package RecursionAndDynamicProgramming;

import java.util.Hashtable;

public class Coins {

	/*
	 * int coinsBottomUp(int n) { if (n <= 0) return 0; int[] results = new
	 * int[n + 1]; results[1] = 1; for (int i = 2; i <= n; i++) { int mid = i /
	 * 2; int result = 0; for (int j = 1; j <= i / 2; j++) { result +=
	 * results[j] * results[n - j]; } if (i == 5 || i == 10 || i == 25) {
	 * result++; } results[i] = result; } return results[n]; }
	 * 
	 * int coinsTopDown(int n) { if (n <= 0) return 0; int[] results = new int[n
	 * + 1]; results[1] = 1; return coinsTopDownHelper(n, results); }
	 * 
	 * private int coinsTopDownHelper(int n, int[] results) { if (results[n] !=
	 * 0) { return results[n]; } int result = 0; int mid = n / 2; for (int i =
	 * 0; i <= mid; i++) { result += coinsTopDownHelper(i, results) *
	 * coinsTopDownHelper(n - i, results); if (i == 5 || i == 10 || i == 25) {
	 * result++; } } results[n] = result; return result; }
	 */

	int coins1(int target) {
		return recursion(target, 25);
	}

	int recursion(int target, int coin) {
		if (coin > target) {
			return recursion(target, levelDown(coin));
		}
		if (coin == 1) {
			return 1;
		}
		if (target == 0) {
			return 1;
		}
		int combination = target / coin;
		int result = 0;

		for (int i = 1; i <= combination; i++) {
			result += recursion(target - i * coin, levelDown(coin));
		}
		result += recursion(target, levelDown(coin));
		return result;
	}

	int levelDown(int coin) {
		switch (coin) {
		case 25:
			return 10;
		case 10:
			return 5;
		case 5:
			return 1;
		}
		return coin;
	}

	int coins2(int n) {
		int[] denoms = { 25, 10, 5, 1 };
		return makeChange(n, denoms, 0);
	}

	private int makeChange(int amount, int[] denoms, int i) {
		if (i >= denoms.length - 1)
			return 1;
		int denomAmount = denoms[i];
		int ways = 0;
		for (int j = 0; j * denomAmount <= amount; j++) {
			int amountRemaining = amount - j * denomAmount;
			ways += makeChange(amountRemaining, denoms, i + 1);
		}
		return ways;
	}

}
