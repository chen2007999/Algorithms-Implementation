package TreeAndGraph;

public class CheckBalanced {

	boolean checkBalanced(TreeNode root) {
		if (root == null)
			return true;
		if (root.left == null && root.right == null) {
			return true;
		}
		if (!checkBalanced(root.left)) {
			return false;
		}

		if (!checkBalanced(root.right)) {
			return false;
		}

		int rightHeight = root.right.height;
		int leftHeight = root.left.height;
		root.height = (leftHeight > rightHeight ? leftHeight : rightHeight) + 1;
		return Math.abs(leftHeight - rightHeight) <= 1;
	}

}
