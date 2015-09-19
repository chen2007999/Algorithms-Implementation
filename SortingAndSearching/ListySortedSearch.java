package SortingAndSearching;

public class ListySortedSearch {

	public static void main(String[] args) {
		int[] listy = { 1, 2, 5, -1, -1, -1 };
		System.out.println(listySortedSearch1(listy, 5));
	}

	static int listySortedSearch1(int[] listy, int num) {
		if (listy == null) {
			return -1;
		}
		int left = 0;
		int right = num;
		while (listy[right] <= num) {
			if (listy[right] == num) {
				return right;
			}
			if (listy[right] == -1) {
				right = (right - left) / 2;
			} else {
				left = right;
				right = right * 2;
			}
		}
		return helper(listy, left, right, num);
	}

	static int listySortedSearch2(int[] listy, int num) {
		int index = 1;
		while (listy[index] != -1 && listy[index] < num) {
			index = index * 2;
		}
		return helper(listy, index / 2, index, num);
	}

	private static int helper(int[] listy, int left, int right, int num) {
		if (left > right) {
			return -1;
		}
		int index = (left + right) / 2;
		if (listy[index] == num) {
			return index;
		} else if (listy[index] > num) {
			return helper(listy, left, index - 1, num);
		} else {
			return helper(listy, index + 1, right, num);
		}
	}

}
