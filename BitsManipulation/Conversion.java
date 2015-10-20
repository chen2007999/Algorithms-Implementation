package BitsManipulation;

public class Conversion {

	int conversion1(int n1, int n2) {
		int result = 0;
		while (n1 > 0 || n2 > 0) {
			if (n1 % 2 != n2 % 2) {
				result++;
			}
			n1 = n1 / 2;
			n2 = n2 / 2;
		}
		return result;
	}

	int conversion2(int n1, int n2) {
		int result = 0;
		for (int n = n1 ^ n2; n > 0; n >>= 1) {
			result += n & 1;
		}
		return result;
	}

	int conversion3(int n1, int n2) {
		int result = 0;
		for (int n = n1 ^ n2; n > 0; n = n & (n - 1)) {
			result++;
		}
		return result;
	}
}
