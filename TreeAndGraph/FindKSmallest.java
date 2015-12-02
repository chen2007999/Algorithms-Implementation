package TreeAndGraph;

public class FindKSmallest {
	
	public int counter = 0;
	public Integer findKSmallest(TreeNode root, int K) {
		int resultLeft = 0;
		if(root.left != null) {
			resultLeft = findKSmallest(root.left, K);
		}
		if(counter >= K) {
			return resultLeft;
		}
		counter++;
		if(counter == K) {
			return root.data;
		}
		if(root.right != null) {
			return findKSmallest(root.right, K);
		}
		return null;
	}

}
