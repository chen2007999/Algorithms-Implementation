package SortingAndSearching;

public class BubbleSort {

	void bubbleSort(int[] array) {
		boolean flag = true;
		while (flag) {
			flag = false;
			for (int i = 0; i + 1 < array.length; i++) {
				if (array[i] > array[i + 1]) {
					int temp = array[i];
					array[i] = array[i + 1];
					array[i + 1] = temp;
					flag = true;
				}
			}
		}
	}

}
