package TreeAndGraph;

import java.util.ArrayList;

public class PathsWithSum {

	int result = 0;
	int pathsWithSum1(TreeNode n, int target) {
		if (n == null)
			return 0;
		if (n.left != null) {
			pathsWithSum1(n.left, target);
		}
		sum = 0;
		counter = 0;
		result += havePaths(n, target);
		if (n.right != null) {
			pathsWithSum1(n.right, target);
		}
		return result;
	}

	int sum = 0;
	int counter = 0;
	private int havePaths(TreeNode n, int target) {
		if (n == null)
			return 0;
		sum += n.data;
		if (sum == target) {
			counter++;
		}
		if (n.left != null) {
			counter += havePaths(n.left, target);
			sum -= n.left.data;
		}
		if (n.right != null) {
			counter += havePaths(n.right, target);
			sum -= n.right.data;
		}
		return counter;
	}

	ArrayList<Integer> store = new ArrayList<>();
	int pathsWithSum2(TreeNode n, int target) {
		if(n == null) return 0;
		pathsWithSum2(n.left, target);
		pathsWithSum2(n.right, target);
		
		int size = store.size();
		if(size == 0) {
			store.add(n.data);
		} else {
			for (int i = 0; i < size; i++) {
				int sum = store.get(i) + n.data;
				if (sum == target)
					result++;
				store.add(store.get(i) + n.data);
			}
		}		
		
		return counter;
	}
	
}
