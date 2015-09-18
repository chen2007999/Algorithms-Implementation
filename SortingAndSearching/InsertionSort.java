package SortingAndSearching;

public class InsertionSort {

	void insertionSort(int[] array) {
		for (int i = 1; i < array.length; i++) {
			int toInsert = array[i];
			for (int j = i - 1; j >= 0; j--) {
				if (array[j] > toInsert) {
					array[j + 1] = array[j];
				} else {
					array[j + 1] = toInsert;
				}
			}
		}
	}

}
