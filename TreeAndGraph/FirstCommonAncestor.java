package TreeAndGraph;

import java.util.HashSet;

import sun.misc.Queue;

public class FirstCommonAncestor {

	TreeNode withLinksToParents1(TreeNode root, TreeNode a, TreeNode b) throws InterruptedException {
		if (a == b)
			return a;
		while (!BFS1(a, b)) {
			if (a.parent == null) {
				return null;
			} else {
				a = a.parent;
				if (a == b)
					return a;
			}
		}
		return a;
	}

	boolean BFS1(TreeNode a, TreeNode b) throws InterruptedException {
		Queue<TreeNode> q = new Queue<>();
		q.enqueue(a);
		while (!q.isEmpty()) {
			TreeNode var = q.dequeue();
			for (TreeNode n : var.adjacents) {
				if (n == b)
					return true;
				q.enqueue(n);
			}
		}
		return false;
	}

	Queue<TreeNode> BFS2(TreeNode root, TreeNode b, TreeNode c, TreeNode lookUp) throws InterruptedException {
		Queue<TreeNode> q = new Queue<>();
		Queue<TreeNode> q2 = new Queue<>();
		q.enqueue(root);
		while (!q.isEmpty()) {
			boolean found = false;
			while (!q.isEmpty()) {
				TreeNode var = q.dequeue();
				for (TreeNode n : var.adjacents) {
					if (n == b || n == c) {
						found = true;
						lookUp = n == b ? c : b;
					}
					q2.enqueue(n);
				}
			}
			q = q2;
			q2 = new Queue<TreeNode>();
			if (found)
				return q;
		}
		return null;
	}

	TreeNode withLinksToParents2(TreeNode root, TreeNode a, TreeNode b) throws InterruptedException {
		if(a == b) return a;
		TreeNode lookUp = null;
		Queue<TreeNode> q = BFS2(root, a, b, lookUp);
		HashSet<TreeNode> hash = new HashSet<>();
		TreeNode ready = lookUp == a ? b : a;
		while(!q.isEmpty()) {
			hash.add(q.dequeue());
		}
		while(!hash.contains(lookUp)) {
			lookUp = lookUp.parent;
		}
		while(ready != lookUp) {
			ready = ready.parent;
			lookUp = lookUp.parent;
		}
		return ready;
	}

	
	
	
	
	
}
