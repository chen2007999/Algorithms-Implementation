package SortingAndSearching;

public class SelectionSort {

	void selectionSort(int[] array) {
		for (int i = 0; i < array.length; i++) {
			int indexSmallest = findIndexSmallest(array, i);
			if (array[indexSmallest] < array[i]) {
				int temp = array[i];
				array[i] = array[indexSmallest];
				array[indexSmallest] = temp;
			}
		}
	}

	private int findIndexSmallest(int[] array, int i) {
		int num = array[i];
		int index = i;
		i++;
		for (; i < array.length; i++) {
			if (array[i] < num) {
				num = array[i];
				index = i;
			}
		}
		return index;
	}
}
