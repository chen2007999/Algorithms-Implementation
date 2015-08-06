package String;

public class URLify {
	/* Write a method to replace all spaces in  string with '%20'.
	 * You may assume that the string has sufficient space at the end to hold the addition characters,
	 * and you are given the "true" length of the string. (using a character array)  */
	
	public static void main(String[] args) {
		char[] chars1 = "Hi, I'm Jiaqi.????".toCharArray();
		replaceSpaces1(chars1, 14);
		System.out.println(new String (chars1));
		
		char[] chars2 = "Hi, I'm Jiaqi.????".toCharArray();
		replaceSpaces2(chars2, 14);
		System.out.println(new String (chars2));
	}
	
	static void replaceSpaces1(char[] str, int length) {
		int spaceCount = 0;
		for(int i=0; i<length; i++) {
			if(str[i] == ' ') {
				spaceCount++;
			}
		}
		int newLength = length + spaceCount * 2;
		for(int i=length - 1; i>=0; i--) {
			if(str[i] == ' ') {
				str[newLength - 1] = '0';
				str[newLength - 2] = '2';
				str[newLength - 3] = '%';
				newLength = newLength - 3;
			} else {
				str[newLength - 1] = str[i];
				newLength = newLength - 1;
			}
		}
	}
	
	static void replaceSpaces2(char[] str, int length) {
		int i=0;
		while(i<length) {
			if(str[i] == ' ') {
				shift(str, i, length);
				str[i] = '%';
				str[i+1] = '2';
				str[i+2] = '0';
				i += 3;
				length += 2;
			} else {
				i++;
			}
		}
	}
	
	static void shift(char[] str, int i, int length) {
		for(int j=length-1; j>=i; j--) {
			 str[j+2] = str[j];
		}
	}
}
