package String;

public class MatrixRotate {
	
    static void matrixRotate(int[][] array) {
    	int length = array.length;
    	int layers = length/2;
    	for(int i=0; i<layers; i++) {
    		int boundary = i + length - 2*i -1;
    		for(int a=i; a<boundary; a++) {
    			int temp = array[i][a]; 
    			array[i][a] = array[length - a - 1][i];
    			array[length - a - 1][a] = array[length - a - i][length - a - 1];
    			array[length - a - i][length - a - 1] = array[a][length - a - i];
    			array[a][length - a - i] = temp;
    		}
    	}
    }

}
