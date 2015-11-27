package BitsManipulation;

public class BasicManipulation {
	
	public int getBit(int num, int i) {
		int mask = 1 << i;
		return (num & mask) >> i;
	}
	
	public int setBit(int num, int i) {
		int mask = 1 << i;
		return num | mask;
	}
	
	public int clearBit(int num, int i) {
		int mask = ~(1 << i);
		return num & mask;
	}
	
	public int clearBitsThroughITo0(int num, int i) {
		int mask = i >>> (31 - i);
		mask = ~(mask);
		return num & mask;
	}
	
	public int clearBitsMSThroughI(int num, int i) {
		int mask = 1 << i;
		mask--;
		return num & mask;
	}

}
