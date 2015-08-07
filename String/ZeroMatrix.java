package String;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class ZeroMatrix {

	public static void main(String[] args) {
		int[][] m = {{1,2,3,0}, {0,2,3,0}, {4,5,6,7}, {0,1,2,3}};
		printMatrix(m);
		System.out.println("Processing");
		zeroMatrix1(m);
		printMatrix(m);
		
		System.out.println("     ");
		
		int[][] n = {{1,2,3,1}, {0,2,3,0}, {4,5,6,7}, {9,1,2,3}};
		printMatrix(n);
		System.out.println("Processing");
		zeroMatrix1(n);
		printMatrix(n);
	}
	
	static void zeroMatrix1(int[][] matrix) {
		List<Integer> rows = new ArrayList<Integer>();
		List<Integer> colomns = new ArrayList<Integer>();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == 0) {
					if (!rows.contains(i)) {
						rows.add(i);
					}
					if (!colomns.contains(j)) {
						colomns.add(j);
					}
				}
			}
		}

		for (int row : rows) {
			for (int j = 0; j < matrix[row].length; j++) {
				matrix[row][j] = 0;
			}
		}
		for (int colomn : colomns) {
			for (int j = 0; j < matrix.length; j++) {
				matrix[j][colomn] = 0;
			}
		}
	}

	/*static void zeroMatrix2(int[][] m) {
		boolean rowHasZero = false;
		boolean colomnHasZero = false;
		
		for(int j=0; j<m[0].length; j++) {
			if(m[0][j] == 0) {
				rowHasZero = true;
				break;
			}
		}
		
		for(int i=0; i<m.length; i++) {
			if(m[i][0] == 0) {
				colomnHasZero = true;
				break;
			}
		}
		
		for(int i=1; i< m.length ; i++) {
			for(int j=1; j<m[i].length; j++) {
				if(m[i][j] == 0) {
					m[i][0] = 0;
					m[0][j] = 0;
				}
			}
		}
		
		for(int i=1; i<m.length; i++) {
			if(m[i][0] == 0) {
				nullifyRow(m, i);
			}
		}
		
		for(int i=1; i<m[0].length; i++) {
			if(m[0][i] == 0) {
				nullifyColoumn(m, i);
			}
		}
		
		if(rowHasZero) {
			nullifyRow(m, 0);
		}
		
		if(colomnHasZero) {
			nullifyColomn(m, 0);
		}
	}*/
	
	static void printMatrix(int[][] m) {
		for (int i = 0; i < m.length; i++) {
			System.out.println("               ");
			for (int j = 0; j < m[i].length; j++) {
				System.out.print(" " + m[i][j]);
			}
		}
	}

}
