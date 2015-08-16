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
		if (a == b)
			return a;
		TreeNode lookUp = null;
		Queue<TreeNode> q = BFS2(root, a, b, lookUp);
		HashSet<TreeNode> hash = new HashSet<>();
		TreeNode ready = lookUp == a ? b : a;
		while (!q.isEmpty()) {
			hash.add(q.dequeue());
		}
		while (!hash.contains(lookUp)) {
			lookUp = lookUp.parent;
		}
		while (ready != lookUp) {
			ready = ready.parent;
			lookUp = lookUp.parent;
		}
		return ready;
	}

	TreeNode withoutLinksToParents3(TreeNode p, TreeNode q) {
		if (p == q)
			return null;
		TreeNode ancestor = p;
		while (ancestor != null) {
			if (isOnPAth(ancestor, q)) {
				return ancestor;
			}
			ancestor = ancestor.parent;
		}
		return null;
	}

	private boolean isOnPAth(TreeNode ancestor, TreeNode n) {
		while (n != ancestor && n != null) {
			n = n.parent;
		}
		return n == ancestor;
	}

	TreeNode withoutLinksToParents4(TreeNode root, TreeNode p, TreeNode q) {
		if (!covers(root, p) || !covers(root, q))
			return null;
		if (covers(p, q)) {
			return p;
		}
		if (covers(q, p)) {
			return q;
		}
		TreeNode sibling = getSibling(p);
		while(sibling != null && !covers(sibling, q)) {
			sibling = getSibling(sibling.parent);
		}
		return sibling.parent;
	}

	boolean covers(TreeNode root, TreeNode p) {
		if (root == null) {
			return false;
		}
		if (root == p) {
			return true;
		}
		return covers(root.left, p) || covers(root.right, p);
	}

	TreeNode getSibling(TreeNode n) {
		if (n == null || n.parent == null) {
			return null;
		}
		return n.parent.left == n ? n.parent.right : n.parent.left;
	}

}
