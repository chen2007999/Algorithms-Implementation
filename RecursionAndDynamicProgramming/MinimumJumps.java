package RecursionAndDynamicProgramming;

import java.util.Hashtable;

public class MinimumJumps {

	public static void main(String[] args) {
		int[] a = { 1, 1, 2, 0, 1, 2, 0 };
		//minimumJumps1(a);
		System.out.println(minimumJumps2(a));
	}

	static void minimumJumps1(int[] arr) {
		DFS(arr, 0, 0);
	}

	static int result = Integer.MAX_VALUE;

	private static void DFS(int[] arr, int i, int count) {
		if (i >= arr.length) {
			if (result > count) {
				result = count;
			}
			return;
		}
		int jumps = arr[i];
		while (jumps > 0) {
			DFS(arr, i + jumps, count + 1);
			jumps--;
		}
	}

	static int minimumJumps2(int[] arr) {
		Hashtable<Integer, Integer> hash = new Hashtable<>();
		return DP(arr, arr.length, hash);

	}

	private static int DP(int[] arr, int index, Hashtable<Integer, Integer> hash) {
		if (index == 0) {
			return 0;
		}
		if (hash.containsKey(index)) {
			return (int) hash.get(index);
		}
		int minJumps = Integer.MAX_VALUE;
		for (int i = 0; i < index; i++) {
			if (arr[i] + i >= index) {
				int jumps = DP(arr, i, hash);
				if (jumps < minJumps) {
					minJumps = jumps;
				}
			}
		}
		hash.put(index, minJumps + 1);
		return minJumps + 1;
	}

}
