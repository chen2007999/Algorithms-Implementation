package SortingAndSearching;

public class SparseSearch {

	enum Direction {
		left, right
	};

	int sparseSearch(String[] arr, String str) {
		if (arr == null || str == null || arr.length == 0 || str.equals("")) {
			return -1;
		}
		return sparseSearch(arr, 0, arr.length - 1, Direction.left, str);
	}

	int sparseSearch(String[] arr, int left, int right, Direction d, String target) {
		if (left > right) {
			return -1;
		}
		int index = (left + right) / 2;
		String mid = arr[index];
		if (mid.equals("")) {
			int l = index - 1;
			int r = index + 1;
			while (true) {
				if (l < left && r > right) {
					return -1;
				} else if (r <= right && !arr[r].equals("")) {
					index = r;
					break;
				} else if (l >= left && equals("")) {
					index = l;
					break;
				}
				l--;
				r++;
			}
		}
		mid = arr[index];
		if (mid.equals(target)) {
			return index;
		}
		if (mid.compareTo(target) > 0) {
			return sparseSearch(arr, left, index - 1, Direction.left, target);
		} else if (mid.compareTo(target) < 0) {
			return sparseSearch(arr, index + 1, right, Direction.right, target);
		}
		return -1;
	}

}
