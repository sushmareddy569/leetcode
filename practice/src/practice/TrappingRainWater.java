package practice;

// 42 - Trapping Rain Water

public class TrappingRainWater {
	public int trap(int[] height) {
		if (height.length == 0 || height == null) {
			return 0;
		}
		int result = 0;
		int leftMax = Integer.MIN_VALUE;
		int rightMax = Integer.MIN_VALUE;

		int left = 0;
		int right = height.length - 1;

		while (left <= right) {
			leftMax = Math.max(leftMax, height[left]);
			rightMax = Math.max(rightMax, height[right]);

			if (leftMax < rightMax) {
				result = result + leftMax - height[left];
				left++;
			} else {
				result = result + rightMax - height[right];
				right--;
			}
		}
		return result;
	}
}
