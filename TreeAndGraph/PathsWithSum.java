package TreeAndGraph;

import java.util.ArrayList;

public class PathsWithSum {

	int result = 0;
	int pathsWithSum1a(TreeNode n, int target) {
		if (n == null)
			return 0;
		if (n.left != null) {
			pathsWithSum1a(n.left, target);
		}
		sum = 0;
		counter = 0;
		result += havePaths(n, target);
		if (n.right != null) {
			pathsWithSum1a(n.right, target);
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
	
	int pathsWithSum1b(TreeNode n, int target) {
		if(n == null) return 0;
		int pathFromRoot = countPathWithSumFromNode(n, target, 0);
		int pathOnLeft = pathsWithSum1b(n.left, target);
		int pathOnRight = pathsWithSum1b(n.right, target);
		return pathFromRoot + pathOnLeft + pathOnRight;
	}

	private int countPathWithSumFromNode(TreeNode n, int target, int currentSum) {
		if(n == null) return 0;
		currentSum += n.data;
		int totalPaths = 0;
		if(currentSum == target) {
			totalPaths++;
		}
		totalPaths += countPathWithSumFromNode(n.left, target, currentSum);
		totalPaths += countPathWithSumFromNode(n.right, target, currentSum);
		return totalPaths;
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
