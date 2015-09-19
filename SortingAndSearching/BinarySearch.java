package SortingAndSearching;

public class BinarySearch {

	int binarySearch1(int[] array, int left, int right, int target) {
		if (array == null || array.length == 0) {
			return -1;
		}
		if (left > right) {
			return -1;
		}
		int middle = (left + right) / 2;
		if (array[middle] == target) {
			return middle;
		} else if (array[middle] < target) {
			return binarySearch1(array, middle + 1, right, target);
		} else {
			return binarySearch1(array, left, middle - 1, target);
		}
	}

	int binarySearch2(int[] array, int target) {
		if (array == null || array.length == 0) {
			return -1;
		}
		int left = 0;
		int right = array.length - 1;
		while (left <= right) {
			int middle = (left + right) / 2;
			if (array[middle] == target) {
				return middle;
			} else if (array[middle] < target) {
				left = middle + 1;
			} else {
				right = middle - 1;
			}
		}
		return -1;
	}

}
