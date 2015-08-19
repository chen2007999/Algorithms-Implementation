package TreeAndGraph;

public class CheckSubtree {

	boolean checkSubtree(TreeNode t1, TreeNode t2) {
		if (t2 == null)
			return true;
		if (t1 == null)
			return false;

		if (t1.left != null) {
			checkSubtree(t1.left, t2);
		}
		if (t1 == t2) {
			boolean identical = compareTwoTrees(t1, t2);
			return identical ? true : checkSubtree(t1.left, t2);
		}
		if (t1.right != null) {
			checkSubtree(t1.right, t2);
		}
		return false;
	}

	private boolean compareTwoTrees(TreeNode t1, TreeNode t2) {
		if(t1 != t2) return false;
		if(!compareTwoTrees(t1.left, t2.left)) {
			return false;
		}
		if(compareTwoTrees(t1.right, t2.right)) {
			return false;
		}
		return true;
	}
}
