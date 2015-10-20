package BitsManipulation;

public class PairwiseSwap {

	void pairwiseSwap(int num) {
		int numOfBits = (int) (Math.sqrt(num) / 1 + 1);
		for (int i = 0; i < numOfBits; i += 2) {
			int mask1 = 1 << i;
			int mask2 = 1 << (i + 1);
			int bit1 = num | mask1;
			int bit2 = num | mask2;
			if (bit1 != bit2) {
				int mask = ~(1 << i);
				num = (num & mask) | (bit2 << i);
				mask = ~(1 << i + 1);
				num = (num & mask) | (bit1 << (i + 1));
			}
		}
	}

}
