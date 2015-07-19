package BitsManipulation;

import java.util.HashMap;

public class NumOfOnes {
	// Give a large integer (bits of 1’s and 0’s), return the total number of
	// 1’s.
	// For example, 10001001 -> 3
	// decimal (15) == binary ( 1111)
	// x = 15;
	// x << 1 11110 -> 30
	// x >> 1 111 -> 7

	public static void main(String[] args) {
		/*
		 * int num1 = 15; System.out.println(countNumOfOnes2(num1, 8));
		 */

		int num2 = 8;
		System.out.println(countNumOfOnes2(num2, 4));


		/*
		 * int num3 = 5; System.out.println(countNumOfOnes2(num3, 8));
		 */
	}

	public static int countNumOfOnes1(int num) {
		int result = 0;
		int mask = 1;
		while (num != 0) {
			if ((num & mask) == 1) {
				result++;
			}
			num >>= 1;
		}
		return result;
	}

	// Now the input number is increased from 32 bits to millions of bits
	public static int countNumOfOnes2(int num, int bits) {
		// HashMap<Integer, Integer> hash = new HashMap<>();
		int result = 0;
		
		if (num == 1) {
			return 1;
		} else if (num == 0) {
			return 0;
		}
		
		int halfBits = bits/2;
		int firstHalf =  num >> halfBits;
		int secondHalf = num << halfBits;
		secondHalf >>= halfBits;
		
		System.out.println("num: " + num);
		System.out.println("First:" + firstHalf);
		System.out.println("Second:" + secondHalf);

		if (firstHalf == secondHalf) {

			result = 2 * countNumOfOnes2(firstHalf, halfBits);
		} else {
			result = countNumOfOnes2(firstHalf, halfBits) + countNumOfOnes2(secondHalf, halfBits);
		}
		return result;

	}
}
