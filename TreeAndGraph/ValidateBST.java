package TreeAndGraph;

public class ValidateBST {

	Integer last = null;

	boolean validateBST1(TreeNode root) {
		if (root == null)
			return true;

		if (!validateBST1(root.left))
			return false;

		if (last != null && root.data > last)
			return false;

		last = root.data;

		if (!validateBST1(root.right))
			return false;
		return true;
	}

	boolean validateBST2(TreeNode root) {
		return validateBST2Helper(root, null, null);
	}

	private boolean validateBST2Helper(TreeNode root, Integer min, Integer max) {
		if (root == null) {
			return true;
		}
		if ((min != null && root.data <= min) || (max != null && root.data > max)) {
			return false;
		}
		if (!validateBST2Helper(root.left, min, root.data) || !validateBST2Helper(root.right, root.data, max)) {
			return false;
		}
		return true;
	}

}
