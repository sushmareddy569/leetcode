package practice;

//326 - Power of Three

public class PowerOfThree {
	public boolean isPowerOfThree(int n) {
		// 1162261467 is 3^19, 3^20 is bigger than int which is 2147483647
		return (n > 0 && 1162261467 % n == 0);
	}
}
