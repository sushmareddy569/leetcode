package practice;

//191 - Number of 1 Bits

public class NumberOfOneBits {
	public int hammingWeight(int n) {
		int total = 0;
		while (n != 0) {
			total = total + (n & 1);
			n = n >>> 1;
		}
		return total;
	}
}
