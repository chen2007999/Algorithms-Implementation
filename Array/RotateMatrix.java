package Array;

public class RotateMatrix {

	void rotate(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return;
		}
		int boundary = matrix[0].length;
		for (int row = 0; row < matrix.length / 2; row++) {
			int col = row;
			while (col <= boundary - 2) {
				int temp = matrix[col][boundary - 1 - row];
				matrix[col][boundary - 1 - row] = matrix[row][col];
				matrix[row][col] = matrix[boundary - col - 1][row];
				matrix[boundary - col - 1][row] = matrix[boundary - 1 - row][boundary - 1 - col];
				matrix[boundary - 1 - row][boundary - 1 - col] = temp;
				col++;
			}
			boundary = boundary - 1;
		}
	}

}
