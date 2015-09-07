package RecursionAndDynamicProgramming;

import java.util.ArrayList;
import java.util.Hashtable;

public class StackOfBoxes {

	private class Box {
		public int width;
		public int height;
		public int depth;
	}

	int StackOfBoxes(ArrayList<Box> stack) {
		if (stack == null || stack.size() == 0) {
			return 0;
		}
		Hashtable<Box, Integer> hash = new Hashtable<>();
		int result = 0;
		StackOfBoxesHelper(stack, result, 0, null, hash);
		return result;
	}

	private int StackOfBoxesHelper(ArrayList<Box> stack, int result, int currentHeight, Box latest,
			Hashtable<Box, Integer> hash) {
		if (stack.size() == 0) {
			if (currentHeight > result) {
				result = currentHeight;
			}
			return currentHeight;
		}
		int nodeHeight = 0;
		for (Box box : stack) {
			if (hash.containsKey(box)) {
				return hash.get(box);
			}
			if (latest == null || (box.depth < latest.depth && box.height < latest.depth && box.width < latest.width)) {
				Box temp = latest;
				int tempHeight = currentHeight;
				latest = box;
				currentHeight = currentHeight + box.height;
				stack.remove(box);
				nodeHeight = StackOfBoxesHelper(stack, result, currentHeight, latest, hash);
				if (!hash.containsKey(box) || hash.get(box) < nodeHeight) {
					hash.put(box, nodeHeight);
				}
				stack.add(box);
				latest = temp;
				currentHeight = tempHeight;
			}
		}
		return nodeHeight;
	}

}
