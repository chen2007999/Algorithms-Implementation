package Array;

public class ThreeSum {

	/*
	 * Three sum problem: Given an array of integers, and a target number, find
	 * three numbers in the array, such that the sum of the three numbers is
	 * closest to the target number.
	 * 
	 * Given each number can be only chosen once. The array does not contain
	 * duplicates. And the array has at least 3 elements.
	 */

	/*
	 * [1,3,4,2,6,7,9,10], target = 20; [1,2,3,4,5,6,7,8,9,10], target = 9;
	 */
	
	
	public static void main(String[] args) {
		int[] array1 = {1,3,4,2,6,7,9,10};
		int target1 = 20;
		System.out.println(findClosetSum1(array1, target1));
		int[] array2 = {1,3,4,2,6,7,9,10};
		int target2 = -10;
		System.out.println(findClosetSum1(array2, target2));
	}

	// Brute force way takes O(n^3) where n is the number of elements in the array;
	public static int findClosetSum1(int[] array, int target) {
		int closet = array[0] + array[1] + array[2];
		for(int i=0; i<array.length; i++) {
			int oneSum = array[i];
			for(int j=i+1; j<array.length; j++) {
				int twoSum = oneSum + array[j];
				for(int k=j+1; k<array.length; k++) {
					int threeSum = twoSum + array[k]; 
					if(Math.abs(target-threeSum) < Math.abs(target-closet)) {
						closet = threeSum;
					}
				}
			}
		}
		return closet;
	}
	
	// Optimisation1
	public static int findClosestSum2(int[] array, int target) {
		// sort the array in ascending order
		for(int i=0; i<array.length; i++) {
			int subTarget = target - array[i];
			// meet in the middle??
		}
		return 0;
	}
	
	
	
	
	
}
