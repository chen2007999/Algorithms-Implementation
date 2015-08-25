package RecursionAndDynamicProgramming;

import java.util.ArrayList;

public class PowerSet {

	ArrayList<ArrayList<Integer>> powerSet(ArrayList<Integer> input) {
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

}
