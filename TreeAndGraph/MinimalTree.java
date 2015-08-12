package TreeAndGraph;

public class MinimalTree {
	
	TreeNode minimalTree(int[] array) {
		if(array == null) {
			return null;
		}
		return minimalTreeHelper(array, 0, array.length-1);
	}
	
	TreeNode minimalTreeHelper(int[] array, int start, int end) {	
		if(start > end) {
			return null;
		}
		int middle = (start+end) / 2;
		TreeNode node = new TreeNode(array[middle]);
		node.left = minimalTreeHelper(array, start, middle-1);
		node.right = minimalTreeHelper(array, middle+1, end);
		return node;
	}

}
