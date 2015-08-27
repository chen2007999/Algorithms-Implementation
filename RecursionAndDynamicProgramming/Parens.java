package RecursionAndDynamicProgramming;

import java.util.HashSet;
import java.util.Iterator;

public class Parens {

	HashSet<String> parens(int num) {
		if (num < 0) {
			return null;
		}
		if (num == 0) {
			HashSet<String> results = new HashSet<String>();
			return results;
		}
		if (num == 1) {
			HashSet<String> results = new HashSet<String>();
			results.add("()");
		}

		HashSet<String> results = parens(num - 1);
		Iterator<String> it = results.iterator();
		while (it.hasNext()) {
			addNewParen(it.next(), results);
		}
		return results;
	}

	private void addNewParen(String next, HashSet<String> results) {
		for (int i = 0; i < next.length(); i++) {
			if (next.charAt(i) == '(') {
				String firstPart = next.substring(0, i + 1);
				String secondPart = next.substring(i + 1, next.length());
				String result = firstPart + "()" + secondPart;
				results.add(result);
			}
			results.add("()" + next);
		}
	}

}
