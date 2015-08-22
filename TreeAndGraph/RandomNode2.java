package TreeAndGraph;

import java.util.ArrayList;
import java.util.Random;

public class RandomNode2 {
		
	private int data;
	public RandomNode2 left;
	public RandomNode2 right;
	ArrayList<RandomNode2> store = new ArrayList<>();
	
    RandomNode2 find(int d) {
    	if(data == d) {
    		return this;
    	} else if(d < data){
    		return left == null ? null : left.find(d);
    	} else {
    		return right == null ? null : right.find(d);
    	}
    }
    
    void insert(RandomNode2 n) {
    	store.add(n);
    	if(n.data <= data) {
    		if(left == null) {
    			left = n;
    		} else {
    			left.insert(n);
    		}
    	} else {
    		if(right == null) {
    			right = n;
    		} else {
    			right.insert(n);
    		}
    	}
    }
    
    RandomNode2 getRandomNode() {
    	Random random = new Random();
    	return store.get(random.nextInt(store.size()));
    }
}
