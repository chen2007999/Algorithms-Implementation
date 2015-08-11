package TreeAndGraph;

import java.util.ArrayList;

import sun.misc.Queue;

public class RouteBetweenNodes {

	enum State {
		Unvisited, Visited, Visiting;
	}

	public class Node {

		public State state;

		public ArrayList<Node> getAdjacent() {
			// TODO Auto-generated method stub
			return null;
		}

	}

	public class Graph {

		public ArrayList<Node> getNodes() {
			// TODO Auto-generated method stub
			return null;
		}

	}

	boolean search(Graph g, Node start, Node end) throws InterruptedException {
		if (start == end)
			return true;

		Queue<Node> q = new Queue<Node>();

		for (Node n : g.getNodes()) {
			n.state = State.Unvisited;
		}
		
		start.state = State.Visiting;
		q.enqueue(start);
		while(!q.isEmpty()) {
			Node node = q.dequeue();
			if(node != null) {
				for(Node n : node.getAdjacent()) {
					if(n == end) {
						return true;
					} else {
						n.state = State.Visiting;
						q.enqueue(n);
					}
				}
			}
			node.state = State.Visited;
		}
		return false;
	}
}
