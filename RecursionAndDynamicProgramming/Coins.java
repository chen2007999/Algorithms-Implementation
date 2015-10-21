package RecursionAndDynamicProgramming;

import java.util.Hashtable;

public class Coins {

	static int coins(int amount, int[] coins, int index) {
		if (amount == 0) {
			return 1;
		}
		if (amount < 0) {
			return 0;
		}
		if (amount > 0 && index >= coins.length) {
			return 0;
		}
		return coins(amount - coins[index], coins, index) + coins(amount, coins, index + 1);

	}

	static int coinsDP(int amount, int[] coins, int index) {
		int[][] arr = new int[amount + 1][coins.length + 1];
		for (int i = 0; i < coins.length + 1; i++) {
			arr[0][i] = 1;
		}
		for (int i = 1; i < amount + 1; i++) {
			arr[i][0] = 0;
		}
		
		for (int row = 1; row < arr.length; row++) {
			for (int col = 1; col < arr[0].length; col++) {

				int ways = 0;
				// include
				if (coins[col - 1] <= row) {
					ways += arr[row - coins[col - 1]][col];
				}
				// exclude
				ways += arr[row][col - 1];
				arr[row][col] = ways;
			}
		}

		for (int row = 0; row < arr.length; row++) {
			for (int col = 0; col < arr[0].length; col++) {
				System.out.print(arr[row][col] + " ,");
			}
			System.out.println(" ");
		}
		return arr[amount][coins.length];
	}

	public static void main(String[] args) {
		int[] a = { 10,25,50,1,5};
		System.out.println(coinsDP(100, a, 0));
	}
}
