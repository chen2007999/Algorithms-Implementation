package TreeAndGraph;

import java.util.Random;

public class RandomNode1 {

	private int data;
	public RandomNode1 left;
	public RandomNode1 right;
	private int size = 0;

	public RandomNode1(int d) {
		data = d;
		size = 1;
	}

	public RandomNode1 getRandomNode1() {
		int leftSize = left == null ? 0 : left.size();
		Random random = new Random();
		int index = random.nextInt(size);
		if (index < leftSize) {
			return left.getRandomNode1();
		} else if (index == leftSize) {
			return this;
		} else {
			return right.getRandomNode1();
		}
	}

	public RandomNode1 getRandomNode2() {
		Random random = new Random();
		int i = random.nextInt(size());
		return getIthNode(i);
	}

	private RandomNode1 getIthNode(int i) {
		int leftSize = left == null ? 0 : left.size();
		if (i < leftSize) {
			return left.getIthNode(i);
		} else if (i == leftSize) {
			return this;
		} else {
			return right.getIthNode(i - (leftSize + 1));
		}
	}

	private int size() {
		return size;
	}

	public void insertInOrder(int d) {
		if (d <= data) {
			if (left == null) {
				left = new RandomNode1(d);
			} else {
				left.insertInOrder(d);
			}
		} else {
			if (right == null) {
				right = new RandomNode1(d);
			} else {
				right.insertInOrder(d);
			}
		}
		size++;
	}

	public RandomNode1 find(int d) {
		if (data == d) {
			return this;
		} else if (data < d) {
			return left == null ? null : left.find(d);
		} else {
			return right == null ? null : right.find(d);
		}
	}
}
