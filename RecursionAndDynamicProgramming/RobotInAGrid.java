package RecursionAndDynamicProgramming;

import java.awt.Point;
import java.util.ArrayList;

public class RobotInAGrid {

	ArrayList<Point> robotInAGridTopDown(int[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return null;
		}
		ArrayList<Point> result = new ArrayList<>();
		robotInAGridTopDownHelper(grid, result, grid[grid.length - 1].length - 1, grid.length - 1);
		for(int i=0; i<result.size()/2; i++) {
			Point temp = result.get(i);
			result.set(i, result.get(result.size()-1-i));
			result.set(result.size()-1-i, temp);
		}
		return result;
	}

	private boolean robotInAGridTopDownHelper(int[][] grid, ArrayList<Point> result, int x, int y) {
		if (x == 0 && y == 0) {
			result.add(new Point(x, y));
			return true;
		}
		if (x < 0 || y < 0 || grid[x][y] == -1) {
			return false;
		}
		if (robotInAGridTopDownHelper(grid, result, x - 1, y)) {
			result.add(new Point(x, y));
		} else if (robotInAGridTopDownHelper(grid, result, x, y - 1)) {
			result.add(new Point(x, y));
		}
		return true;
	}

}
