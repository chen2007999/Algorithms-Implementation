package RecursionAndDynamicProgramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class PermutationWithDups {

	ArrayList<ArrayList<Integer>> permutationWithDups(ArrayList<Integer> input) {
		if (input == null)
			return null;
		Collections.sort(input);
		ArrayList<Integer> trace = new ArrayList<Integer>();
		boolean[] selected = new boolean[input.size()];
		dfs(trace, selected, input);
		return results;
	}

	ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();

	private void dfs(ArrayList<Integer> trace, boolean[] selected, ArrayList<Integer> input) {
		if (trace.size() == input.size()) {
			results.add(new ArrayList<Integer>(trace));
			return;
		}
		HashSet<Integer> sameLevel = new HashSet<>();
		for (int i = 0; i < input.size(); i++) {
			if (!selected[i]) {
				int cur = input.get(i);
				if (!sameLevel.contains(cur)) {
					trace.add(cur);
					selected[i] = true;
					sameLevel.add(cur);
					dfs(trace, selected, input);
					trace.remove(trace.size() - 1);
					selected[i] = false;
				}
			}
		}

	}

}
