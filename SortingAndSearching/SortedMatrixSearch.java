package SortingAndSearching;

public class SortedMatrixSearch {

	boolean SortedMatrixSearch(int[][] m, int startR, int startC, int boundaryR, int boundaryC, int target) {
		if (m == null || m.length == 0 || m[0].length == 0) {
			return false;
		}
		if (startR < boundaryR || startC < boundaryR || startR == m.length || startC == m[startR].length) {
			return false;
		}
		if (m[startR][boundaryC] > target) {
			for (int i = startC; i < boundaryC; i++) {
				if (m[startR][i] == target) {
					return true;
				}
				if (m[startR][i] > target) {
					boundaryC = i - 1;
					break;
				}
			}
		}
		if (m[boundaryR][startC] > target) {
			for (int i = startR; i < boundaryR; i++) {
				if (m[i][startC] == target) {
					return true;
				}
				if (m[i][startC] > target) {
					boundaryR = i - 1;
					break;
				}
			}
		}
		startR++;
		startC++;
		return SortedMatrixSearch(m, startR, startC, boundaryR, boundaryC, target);
	}

}
