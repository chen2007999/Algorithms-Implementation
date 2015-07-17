package BitsManipulation;

public class NumOfOnes {
	// Give a large integer (bits of 1’s and 0’s), return the total number of
	// 1’s.
	// For example, 10001001 -> 3
	// decimal (15) == binary ( 1111)
	// x = 15;
	// x << 1 11110 -> 30
	// x >> 1 111 -> 7

	public static void main(String[] args) {
	   int num1 = 15;
	   System.out.println(countNumOfOnes(num1));
	   int num2 = 8;
	   System.out.println(countNumOfOnes(num2));
	   int num3 = 5;
	   System.out.println(countNumOfOnes(num3));
	}
	
	public static int countNumOfOnes(int num) {
		int result = 0;
		int mask = 1;
		while(num !=0 ) {
			if((num & mask) == 1) {
				result++;
			}
			num >>= 1;
		}
		return result;
	}

}
