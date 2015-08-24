package RecursionAndDynamicProgramming;

import java.util.ArrayList;
import java.util.Collections;

public class PermutationNoDup {

	ArrayList<ArrayList<Integer>> perm(ArrayList<Integer> input) {
		int n = input.size();
		Collections.sort(input);
		boolean[] isSelected = new boolean[n];
		ArrayList<Integer> trace = new ArrayList<Integer>();
		dfs(input, isSelected, trace);
		return result;
	}

	ArrayList<ArrayList<Integer>> result;

	void dfs(ArrayList<Integer> input, boolean[] isSelected, ArrayList<Integer> trace) {
		int n = input.size();
		int isSelectedTotal = trace.size();

		for (int i = 0; i < n; i++) {
			if (i != 0 && input.get(i) == input.get(i - 1)) {
				continue;
			}
			if (!isSelected[i]) {
				isSelected[i] = true;
				trace.add(input.get(i));
				dfs(input, isSelected, trace);
				trace.remove(isSelectedTotal - 1);
				isSelected[i] = false;
			}
		}
	}

}
