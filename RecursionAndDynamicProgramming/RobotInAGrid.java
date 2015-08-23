package RecursionAndDynamicProgramming;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;

public class RobotInAGrid {

	ArrayList<Point> robotInAGridBruteForce(int[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return null;
		}
		ArrayList<Point> result = new ArrayList<>();
		robotInAGridBruteForceHelper(grid, result, grid.length - 1, grid[0].length - 1);
		for(int i=0; i<result.size()/2; i++) {
			Point temp = result.get(i);
			result.set(i, result.get(result.size()-1-i));
			result.set(result.size()-1-i, temp);
		}
		return result;
	}

	private boolean robotInAGridBruteForceHelper(int[][] grid, ArrayList<Point> result, int x, int y) {
		if (x == 0 && y == 0) {
			result.add(new Point(x, y));
			return true;
		}
		if (x < 0 || y < 0 || grid[x][y] == -1) {
			return false;
		}
		if (robotInAGridBruteForceHelper(grid, result, x - 1, y)) {
			result.add(new Point(x, y));
		} else if (robotInAGridBruteForceHelper(grid, result, x, y - 1)) {
			result.add(new Point(x, y));
		}
		return true;
	}
	
	ArrayList<Point> robotInAGridTopDown(int[][] grid) {
		if(grid == null || grid.length == 0 || grid[0].length == 0) {
			return null;
		}
		ArrayList<Point> path = new ArrayList<Point>();
		HashMap<Point, Boolean> cache = new HashMap<Point, Boolean>();
		int lastRow = grid.length - 1;
		int lastColumn = grid[lastRow].length - 1;
		if(getPath(grid, lastRow, lastColumn, path, cache)) {
			return path;
		}
		return null;
	}

	private boolean getPath(int[][] grid, int r, int c, ArrayList<Point> path,
			HashMap<Point, Boolean> cache) {
		if(c < 0 || r < 0 || grid[r][c] == -1) {
			return false;
		}
		Point p = new Point(r, c);
		if(cache.containsKey(p)) {
			return cache.get(p);
		}
		boolean isAtOrigin = (r == 0) && (c == 0);
		boolean success = false;
		if(isAtOrigin || getPath(grid, r, c-1, path, cache) || getPath(grid, r-1, c, path, cache)) {
			path.add(p);
			success = true;
		}
		cache.put(p, success);
		return success;
	}

}
