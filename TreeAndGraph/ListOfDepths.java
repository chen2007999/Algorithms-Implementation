package TreeAndGraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import sun.misc.Queue;

public class ListOfDepths {

	// BFS
	List<List<TreeNode>> listOfDepths1(TreeNode root) throws InterruptedException {
		if (root == null) {
			return null;
		}
		List<List<TreeNode>> result = new ArrayList<>();
		Queue<TreeNode> current = new Queue<>();
		Queue<TreeNode> next = new Queue<>();
		current.enqueue(root);

		while(!current.isEmpty()) {
			List<TreeNode> list = new LinkedList<>();
			while (!current.isEmpty()) {
				TreeNode node = current.dequeue();
				next.enqueue(node.left);
				next.enqueue(node.right);
				list.add(node);
			}
			
			result.add(list);
			
			Queue<TreeNode> tmp = current;
			current = next;
			next = tmp;
		}

		return result;
	}
	
	// BFS 
	ArrayList<LinkedList<TreeNode>> listOfDepth2(TreeNode root) {
		ArrayList<LinkedList<TreeNode>> result = new ArrayList<>();
		LinkedList<TreeNode> current = new LinkedList<TreeNode>();
		if(root != null) {
			current.add(root);
		}
		while(current.size() > 0) {
			result.add(current);
			LinkedList<TreeNode> parents = current;
			current = new LinkedList<TreeNode>();
			for(TreeNode n : parents) {
				if(n.left != null) {
					current.add(n.left);
				}
				if(n.right != null) {
					current.add(n.right);
				}
			}
		}
		return result;
	}
	
	// DFS
	ArrayList<LinkedList<TreeNode>> listOfDepth3(TreeNode root) {
		ArrayList<LinkedList<TreeNode>> result = new ArrayList<>();
		listOfDepth3Helper(root, result, 0);
		return result;
	}

	private void listOfDepth3Helper(TreeNode root, ArrayList<LinkedList<TreeNode>> result, int depth) {
		if(result.get(depth) == null) {
			LinkedList<TreeNode> current = new LinkedList<TreeNode>();
			current.add(root);
			result.add(depth, current);
		} else {
			result.get(depth).add(root);
		}
		if(root.left != null) {
			listOfDepth3Helper(root.left, result, depth+1);
		}
		if(root.right != null) {
			listOfDepth3Helper(root.right, result, depth+1);
		}
	}
	
	

}
