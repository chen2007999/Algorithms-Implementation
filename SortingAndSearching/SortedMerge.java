package SortingAndSearching;

public class SortedMerge {

	void sortedMerge(int[] a, int[] b, int lastA, int lastB) {
		int newLast = lastA + lastB + 1;
		while (lastB >= 0) {
			if (lastA >= 0 && b[lastB] < a[lastA]) {
				a[newLast] = a[lastA];
				lastA--;
			} else {
				a[newLast] = b[lastB];
				lastB--;
			}
			newLast--;
		}

	}

}
