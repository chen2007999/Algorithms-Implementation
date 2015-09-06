package RecursionAndDynamicProgramming;

import java.util.ArrayList;

public class EightQueens {

	ArrayList<int[][]> eightQueens() {
		int[][] board = new int[8][8];
		eightQueensHelper(board, 0);
		return results;
	}

	ArrayList<int[][]> results = new ArrayList<int[][]>();

	void eightQueensHelper(int[][] board, int r) {
		if (board == null || board.length != 8 || board[0].length != 8 || r < 0) {
			return;
		}
		if (r == 8) {
			int[][] result = board.clone();
			results.add(result);
			return;
		}
		for (int c = 0; c < board[r].length; c++) {
			if (board[r][c] == 0) {
				board[r][c] = 1;
				coloumnAndDiag(board, r, c, -1);
				eightQueensHelper(board, r + 1);
				coloumnAndDiag(board, r, c, 0);
				board[r][c] = 0;
			}
		}
	}

	private void coloumnAndDiag(int[][] board, int r, int c, int num) {
		for (int i = r + 1; i < board.length; i++) {
			board[i][c] = num;
		}
		r++;
		c++;
		while (r < board.length && c < board[r].length) {
			board[r][c] = num;
			r++;
			c++;
		}
	}

	int GRID_SIZE = 8;

	void eightQueens2(int row, Integer[] columns, ArrayList<Integer[]> results) {
		if (row == GRID_SIZE) {
			results.add(columns.clone());
		} else {
			for (int col = 0; col < GRID_SIZE; col++) {
				if (checkValid(columns, row, col)) {
					columns[row] = col;
					eightQueens2(row + 1, columns, results);
				}
			}
		}
	}

	private boolean checkValid(Integer[] columns, int row1, int column1) {
		for (int row2 = 0; row2 < row1; row2++) {
			int column2 = columns[row2];
			if (column1 == column2) {
				return false;
			}
			int columnDistance = Math.abs(column2 - column1);
			int rowDistance = row1 - row2;
			if (columnDistance == rowDistance) {
				return false;
			}
		}
		return true;
	}

}
