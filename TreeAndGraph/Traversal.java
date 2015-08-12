package TreeAndGraph;

import sun.misc.Queue;

public class Traversal {

	boolean inOrderSearch(TreeNode node, int data) {
		if (node != null) {
			inOrderSearch(node.left, data);
			if (node.data == data) {
				return true;
			}
			inOrderSearch(node.right, data);
		}
		return false;
	}

	
	boolean preOrderSearch(TreeNode node, int data) {
		if (node != null) {
			if (node.data == data) {
				return true;
			}
			preOrderSearch(node.left, data);
			preOrderSearch(node.right, data);
		}
		return false;
	}

	
	boolean postOrderSearch(TreeNode node, int data) {
		if (node != null) {
			postOrderSearch(node.left, data);
			postOrderSearch(node.left, data);
			if (node.data == data) {
				return true;
			}
		}
		return false;
	}

	
	boolean DFS(GraphNode root, int data) {
		if (root != null) {
			if (root.data == data) {
				return true;
			}
			root.visited = true;
			for (GraphNode node : root.getAdjacent()) {
				if (node.visited == false) {
					DFS(node, data);
				}
			}
		}
		return false;
	}

	
	boolean BFS(GraphNode root, int data) throws InterruptedException {
		if (root != null) {
			Queue<GraphNode> q = new Queue<>();
			q.enqueue(root);
			while(!q.isEmpty()) {
				GraphNode node = q.dequeue();
				if(node.data == data) {
					return true;
				}
				node.visited = true;
				for(GraphNode n : node.getAdjacent()) {
					if(n.visited == false) {
						q.enqueue(n);
					}
				}
			}
		}
		return false;
	}

}
