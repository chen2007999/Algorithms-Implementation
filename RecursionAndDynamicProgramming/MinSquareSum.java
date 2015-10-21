package RecursionAndDynamicProgramming;

import java.util.Hashtable;

public class MinSquareSum {
	
	public static void main(String[] args) {
		System.out.println(minSqrSum(12));
	}

	static int minSqrSum(int num) {
		if (num < 0)
			return -1;
		Hashtable<Integer, Integer> hash = new Hashtable<>();
		hash.put(0, 0);
		recursion(hash, num);
		return hash.get(num);
	}

	private static int recursion(Hashtable<Integer, Integer> hash, int num) {
		if (hash.containsKey(num)) {
			return hash.get(num);
		}
		int max = (int) (Math.sqrt(num) / 1);
		int result = Integer.MAX_VALUE;
		for (int i = 1; i <= max; i++) {
			int var = recursion(hash, num - i * i);
			if (var + 1 < result) {
				result = var + 1;
			}
		}
		hash.put(num, result);
		return result;
	}

}
