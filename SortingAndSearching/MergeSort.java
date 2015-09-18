package SortingAndSearching;

public class MergeSort {

	public static void main(String[] args) {
		int[] a = { 5, 6, 9, 2, 169, 91, -8, 0, 10, 18, 7 };
		int[] result = mergeSort(a);
		for (int j : result) {
			System.out.print(j);
			System.out.print(", ");
		}
	}

	static int[] mergeSort(int[] array) {
		if (array.length == 1) {
			return array;
		}
		int[] left = mergeSort(halveArray(array, 0, array.length / 2));
		int[] right = mergeSort(halveArray(array, array.length / 2, array.length));
		return merge(left, right);
	}

	private static int[] halveArray(int[] array, int i, int j) {
		int[] result = new int[j - i];
		int index = 0;
		for (; i < j; i++) {
			result[index] = array[i];
			index++;
		}
		return result;
	}

	private static int[] merge(int[] left, int[] right) {
		int[] result = new int[left.length + right.length];
		int leftIndex = 0;
		int rightIndex = 0;
		while (leftIndex < left.length) {
			if (rightIndex == right.length || left[leftIndex] < right[rightIndex]) {
				result[leftIndex + rightIndex] = left[leftIndex];
				leftIndex++;
			} else {
				result[leftIndex + rightIndex] = right[rightIndex];
				rightIndex++;
			}
		}
		while (rightIndex < right.length) {
			result[leftIndex + rightIndex] = right[rightIndex];
			rightIndex++;
		}
		return result;
	}

}
