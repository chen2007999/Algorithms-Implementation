package RecursionAndDynamicProgramming;

import java.util.HashSet;
import java.util.Iterator;

public class Parens {

	HashSet<String> parens1(int num) {
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

		HashSet<String> results = parens1(num - 1);
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

	HashSet<String> parens2(int num) {
		if (num < 0)
			return null;
		HashSet<String> results = new HashSet<String>();
		String s = "";
		if (num == 0) {
			results.add(s);
			return results;
		}
		int toClose = 0;
		dfs(num, toClose, s, results);
		return results;
	}

	private void dfs(int num, int toClose, String s, HashSet<String> results) {
		if (num == 0 && toClose == 0) {
			results.add(s);
			return;
		}
		int size = s.length();
		if (num != 0) {
			s += "(";
			num--;
			dfs(num, toClose, s, results);
		}
		s = s.substring(0, size);
		if (toClose != 0) {
			s += ")";
			toClose--;
			dfs(num, toClose, s, results);
		}
	}
}
