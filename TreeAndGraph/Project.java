package TreeAndGraph;

import java.util.ArrayList;
import java.util.HashMap;

public class Project {
	private ArrayList<Project> children = new ArrayList<Project>();
	private HashMap<String, Project> map = new HashMap<>();
	private String name;
	private int dependencies = 0;
	
	public Project(String n) {
		name = n;
	}
	
	public void addNeighbor(Project node) {
		if(!map.containsKey(node.getName())) {
			children.add(node);
			node.incrementDependencies();
		}
	}

	private void incrementDependencies() {
		dependencies++;		
	}
	
	public void decrementDependencies() {
		dependencies--;		
	}

	private Object getName() {
		return name;
	}
	
	public ArrayList<Project> getChildren() {
		return children;
	}
	
	public int getNumberDenpendencies() {
		return dependencies;
	}
}
