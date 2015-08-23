package RecursionAndDynamicProgramming;

public class MagicIndex {
	
	// no duplicate values
	int magicIndex1(int[] array) {
		if(array == null) return -1;
		return magicIndex1Helper(array, 0, array.length-1);
	}

	private int magicIndex1Helper(int[] array, int start, int end) {
		if(start > end) {
			return -1;
		}
		int middle = (start + end) / 2;
		if(array[middle] == middle) {
			return middle;
		} else if(array[middle] < middle) {
			return magicIndex1Helper(array, middle+1, end); 
		} else {
			return magicIndex1Helper(array, start, middle-1); 
		}
	}
	
	// with duplicate values
	int magicIndex2(int[] array) {
		return magicFast(array, 0, array.length - 1);
	}
	
	int magicFast(int[] array, int start, int end) {
		if(end < start) return -1;
		int midIndex = (start + end) /2;
		int midValue = array[midIndex];
		if(midValue == midIndex) {
			return midIndex;
		}
		
		int leftIndex = midValue < midIndex ? midValue : midIndex - 1;
		int left = magicFast(array, start, leftIndex);
		if(left >= 0) {
			return left;
		}
		
		int rightIndex = midValue > midIndex ? midValue : midIndex + 1;
		int right = magicFast(array, rightIndex, end);
		return right;
	}

}
