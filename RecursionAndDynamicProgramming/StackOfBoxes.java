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
		for (Box box : stack) {
			if (hash.containsKey(box)) {
				return hash.get(box);
			}
			int currentHeight = box.height;
			stack.remove(box);
			int nodeHeight = StackOfBoxesHelper(stack, result, currentHeight, box, hash) + box.height;
			if (!hash.containsKey(box) || hash.get(box) < nodeHeight) {
				hash.put(box, nodeHeight);
			}
			stack.add(box);
		}
		return result;
	}

	private int StackOfBoxesHelper(ArrayList<Box> stack, int result, int currentHeight, Box latest,
			Hashtable<Box, Integer> hash) {
		if (stack.size() == 0) {
			if (currentHeight > result) {
				result = currentHeight;
			}
			return 0;
		}
		int nodeHeight = 0;
		for (Box box : stack) {
			if (hash.containsKey(box)) {
				return hash.get(box);
			}
			if (box.depth < latest.depth && box.height < latest.depth && box.width < latest.width) {
				Box temp = latest;
				int tempHeight = currentHeight;
				currentHeight = currentHeight + box.height;
				latest = box;
				stack.remove(box);
				nodeHeight = StackOfBoxesHelper(stack, result, currentHeight, latest, hash) + box.height;
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
