package RecursionAndDynamicProgramming;

import java.util.ArrayList;

public class PowerSet {

	ArrayList<ArrayList<Integer>> powerSet1(ArrayList<Integer> input) {
		if (input == null) {
			return null;
		}
		boolean[] selected = new boolean[input.size()];
		ArrayList<Integer> trace = new ArrayList<Integer>();
		result.add(new ArrayList<Integer>());
		dfs(input, selected, trace);
		return result;
	}

	ArrayList<ArrayList<Integer>> result;

	void dfs(ArrayList<Integer> input, boolean[] selected, ArrayList<Integer> trace) {
		ArrayList<Integer> sameLevelSelected = new ArrayList<Integer>();
		for (int i = 0; i < input.size(); i++) {
			if (!selected[i]) {
				trace.add(input.get(i));
				selected[i] = true;
				sameLevelSelected.add(i);
				result.add(new ArrayList<Integer>(trace));

				dfs(input, selected, trace);

				trace.remove(trace.size() - 1);
				if (i == input.size() - 1) {
					for (int s : sameLevelSelected) {
						selected[s] = false;
					}
					sameLevelSelected.clear();
				}
			}
		}

	}
	
	ArrayList<ArrayList<Integer>> powerSet2(ArrayList<Integer> input) {
		if (input == null) {
			return null;
		}
		if(input.size() == 0) {
			ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
			result.add(new ArrayList<Integer>());
			return result;
		}
		int num = input.remove(input.size()-1);
		ArrayList<ArrayList<Integer>> result = powerSet2(input); 
		for(int i=0; i<result.size(); i++) {
			ArrayList<Integer> toAdd = new ArrayList<Integer>(result.get(i));
			toAdd.add(num);
			result.add(toAdd);
		}
		return result;
	}

}
