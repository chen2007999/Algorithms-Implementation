package SortingAndSearching;

import java.util.ArrayList;

public class QuickSort {

	public static void main(String[] args) {

		int[] a = { 5, 6, 9, 2, 169, 91, -10, 172 };
		quickSort(a, 0, a.length - 1);
		for (int j : a) {
			System.out.print(j);
			System.out.print(", ");
		}

	}

	static int[] quickSortBruteForce(int[] array) {
		if (array == null || array.length <= 1)
			return array;
		int pivot = array[array.length / 2];

		int[] smaller = getArray(array, pivot, -1);
		int[] bigger = getArray(array, pivot, 1);
		int[] equal = getArray(array, pivot, 0);

		int[] newSmaller = quickSortBruteForce(smaller);
		int[] newBigger = quickSortBruteForce(bigger);
		return combine(newSmaller, equal, newBigger);
	}

	private static int[] getArray(int[] array, int pivot, int flag) {
		int size = 0;
		for (int num : array) {
			if (flag < 0 && num < pivot) {
				size++;
			} else if (flag > 0 && num > pivot) {
				size++;
			} else if (flag == 0 && num == pivot) {
				size++;
			}
		}
		int[] result = new int[size];
		int index = 0;
		for (int num : array) {
			if (flag < 0 && num < pivot) {
				result[index] = num;
				index++;
			} else if (flag > 0 && num > pivot) {
				result[index] = num;
				index++;
			} else if (flag == 0 && num == pivot) {
				result[index] = num;
				index++;
			}
		}
		return result;
	}

	private static int[] combine(int[] smaller, int[] equal, int[] bigger) {
		int[] result = new int[smaller.length + bigger.length + equal.length];
		for (int i = 0; i < smaller.length; i++) {
			result[i] = smaller[i];
		}
		for (int i = 0; i < equal.length; i++) {
			result[i + smaller.length] = equal[i];
		}
		for (int i = 0; i < bigger.length; i++) {
			result[i + smaller.length + equal.length] = bigger[i];
		}
		return result;
	}

	static void quickSort(int[] array, int left, int right) {
		int index = partition(array, left, right);
		if (left < index - 1) {
			quickSort(array, left, index - 1);
		}
		if (right > index) {
			quickSort(array, index, right);
		}
	}

	private static int partition(int[] array, int left, int right) {
		int pivot = array[(left + right) / 2];
		while (left <= right) {
			while (array[left] < pivot) {
				left++;
			}
			while (array[right] > pivot) {
				right--;
			}
			if (left <= right) {
				int temp = array[right];
				array[right] = array[left];
				array[left] = temp;
				left++;
				right--;
			}
		}
		return left;
	}

}
