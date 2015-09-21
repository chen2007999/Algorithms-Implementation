package SortingAndSearching;

import java.util.Arrays;

public class PeaksAndValleys {
	
	public static void main(String[] args) {
		int[] a = {1,2,3,4,5,6,7,8,0};
		peaksAndVallys(a);
		for(int num : a) {
			System.out.print(num);
			System.out.print(" ");
		}
	}

	static void peaksAndVallys(int[] arr) {
		if (arr == null || arr.length <= 2) {
			return;
		}
		Arrays.sort(arr);
		int middle = arr.length / 2;
		int[] left = new int[middle];
		int[] right = new int[arr.length - middle];
		for (int i = 0; i < middle; i++) {
			left[i] = arr[i];
		}
		for (int i = 0; i < right.length; i++) {
			right[i] = arr[middle + i];
		}
		int index = 0;
		for (int i = right.length - 1; i >= 0; i--) {
			arr[index] = right[i];
			index += 2;
		}
		index = 1;
		for (int i = 0; i < left.length; i++) {
			arr[index] = left[i];
			index += 2;
		}
	}

}
