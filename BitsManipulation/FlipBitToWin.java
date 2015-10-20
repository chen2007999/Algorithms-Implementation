package BitsManipulation;

import java.util.ArrayList;

public class FlipBitToWin {

	public static void main(String[] args) {
		System.out.println(flipBitToWin(118));
	}

	static int flipBitToWin(int num) {
		ArrayList<Integer> list = new ArrayList<>();
		while (num > 0) {
			list.add(num % 2);
			num = num / 2;
		}
		int oldCounter = 0;
		int newCounter = 0;
		int max = 0;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) == 0) {
				if (oldCounter > max) {
					max = oldCounter;
				}

				oldCounter = newCounter;

				newCounter = 0;
			} else {
				newCounter++;
			}
			oldCounter++;
		}
		if (oldCounter > max) {
			max = oldCounter;
		}
		return max;
	}
}
