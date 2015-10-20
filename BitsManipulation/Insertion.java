package BitsManipulation;

public class Insertion {

	void insertion(int M, int N, int i, int j) {
		// clear
		int mask = ~(-1 >>> (32 - j));
		mask = mask | (-1 >>> (32 - i));
		N = N & mask;

		// shift
		M = M << i;

		// OR
		N = N | M;

	}

}
