package RecursionAndDynamicProgramming;

public class MinimumJumps {

	public static void main(String[] args) {
		int[] a = { 1, 1, 2, 0, 1, 2, 0 };
		minimumJumps1(a);
		System.out.println(result);
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

}
