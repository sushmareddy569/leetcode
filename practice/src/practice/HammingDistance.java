package practice;

// 461 - Hamming Distance

public class HammingDistance {
	public int hammingDistance(int x, int y) {
		int result = 0;
		int xor = x ^ y;

		while (xor != 0) {
			result += xor & 1;
			xor >>= 1;
		}
		return result;
	}
}
