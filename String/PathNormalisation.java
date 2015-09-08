package String;

import java.util.Stack;

public class PathNormalisation {

	String pathNormalisation(String input) {
		if (input == null)
			return null;
		Stack<String> stack = new Stack<>();
		int index = 1;
		String current = "";
		// Walking through the stack, store the result in the stack or return
		// null if wrong input given
		while (index != input.length()) {
			current += input.charAt(index);
			if (input.charAt(index) == '/') {
				if (current.equals("../")) {
					if (stack.isEmpty()) {
						return null;
					} else {
						stack.pop();
					}
				} else {
					stack.push(current);
					current = "";
				}
			}
			index++;
		}
		// Creating final result;
		while (!stack.isEmpty()) {
			current = stack.pop() + current;
		}
		return "/" + current;
	}

}
