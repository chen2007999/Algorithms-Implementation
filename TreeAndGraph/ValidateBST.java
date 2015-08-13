package TreeAndGraph;

public class ValidateBST {
	
	boolean validateBST1(TreeNode root) {
		int result =validateBST1Helper(root);
		return result != -1;
	}
	
	int validateBST1Helper(TreeNode root) {
		if(root == null) return 1;
		if(root.left != null) {
			if(validateBST1Helper(root.left) == -1) {
				return -1;
			}
			if(root.left.data > root.data) {
				return -1;
			}
		}
		if(root.right != null) {
			if(validateBST1Helper(root.right) == -1) {
				return -1;
			}
			if(root.right.data <= root.data) {
				return -1;
			}
		}
		return 1;
	}
	
	boolean validateBST2(TreeNode root) {
		return validateBST2Helper(root, null, null);
	}

	private boolean validateBST2Helper(TreeNode root, Integer min, Integer max) {
		if(root == null) {
			return true;
		}
		if((min != null && root.data <= min) || (max != null && root.data > max)) {
			return false;
		}
		if(!validateBST2Helper(root.left, min, root.data) || !validateBST2Helper(root.right, root.data, max)) {
			return false;
		}
		return true;
	}

}
