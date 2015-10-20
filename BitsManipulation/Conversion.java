package BitsManipulation;

public class Conversion {

	int conversion(int n1, int n2) {
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

}
