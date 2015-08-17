package Array;

public class MaxSubArray {

	// O(n)
	int maxSubArray1(int[] A) {
		int maxSum = Integer.MIN_VALUE;
		int n = A.length;
		int sum = A[0];
		for (int a = 1; a < n; a++) {
			sum += A[a];
			if (sum < A[a])
				sum = A[a];
			if (sum > maxSum)
				maxSum = sum;
		}
		return maxSum;
	}

	int maxSubArray2(int[] A) {
		int maxSum = Integer.MIN_VALUE;
		int n = A.length;
		int sum = 0;
		for (int a = 0; a < n; a++)

		{
			sum += A[a];
			if (sum > maxSum)
				maxSum = sum;
			if (sum < 0)
				sum = 0;
		}
		return maxSum;
	}

	// O(n^2)
	int maxSubArray3(int[] A) {
		int maxSum = Integer.MIN_VALUE;
		int n = A.length;
		for (int a = 0; a < n; a++)

		{
			int sum = Integer.MIN_VALUE;
			for (int b = a; b < n; b++) {
				sum += A[b];
				if (sum > maxSum)
					maxSum = sum;
			}
		}
		return maxSum;
	}

	// O(n^3)
	int maxSubArray4(int[] A) {
		int maxSum = Integer.MIN_VALUE;
		int n = A.length;
		for (int a = 0; a < n; a++)

		{
			for (int b = a; b < n; b++) {
				int sum = 0;
				for (int i = a; i <= b; i++) {
					sum += A[i];
				}
				if (sum > maxSum)
					maxSum = sum;
			}
		}
		return maxSum;
	}
}
