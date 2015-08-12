package TreeAndGraph;

public class Traversal {

	boolean inOrderSearch(TreeNode node, int data) {
		if(node !=null) {		
			inOrderSearch(node.left, data);
			if(node.data == data) {
				return true;
			}
			inOrderSearch(node.right, data);
		}
		return false;
	}
	
	boolean preOrderSearch(TreeNode node, int data) {
		if(node != null) {
			if(node.data == data) {
				return true;
			}
			preOrderSearch(node.left, data);
			preOrderSearch(node.right, data);
		}
		return false;
	}
	
	boolean postOrderSearch(TreeNode node, int data) {
		if(node != null) {
			postOrderSearch(node.left, data);
			postOrderSearch(node.left, data);
			if(node.data == data) {
				return true;
			}
		}
		return false;
	}
}
