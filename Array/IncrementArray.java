package Array;

public class IncrementArray {

	int[] incrementArray(int[] input) {
		if (input == null || input.length == 0)
			return null;
		int index = input.length - 1;
		while (index >= 0) {
			if (input[index] != 9) {
				input[index]++;
				return input;
			} else {
				input[index] = 0;
				index--;
				if (index < 0) {
					int[] output = new int[input.length + 1];
					output[0] = 1;
					for (int i = 1; i < output.length; i++) {
						output[i] = 0;
					}
					return output;
				}
			}
		}
		return input;
	}

	int[] incrementArray1(int[] input) {
		if (input == null || input.length == 0)
			return null;
		return incrementArray1Helper(input, input.length - 1);
	}

	int[] incrementArray1Helper(int[] input, int index) {
		if (index < 0) {
			int[] output = new int[input.length + 1];
			output[0] = 1;
			for (int i = 1; i < output.length; i++) {
				output[i] = 0;
			}
			return output;
		}
		if (input[index] != 9) {
			input[index]++;
			return input;
		} else {
			input[index] = 0;
			return incrementArray1Helper(input, index--);
		}
	}

}
