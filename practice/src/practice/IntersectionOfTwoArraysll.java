package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//350 - Intersection of Two Arrays ||

public class IntersectionOfTwoArraysll {
	public int[] intersect(int[] nums1, int[] nums2) {
		List<Integer> resultList = new ArrayList<Integer>();
		Arrays.sort(nums1);
		Arrays.sort(nums2);

		int i = 0, j = 0;
		while (i < nums1.length && j < nums2.length) {
			if (nums1[i] < nums2[j]) {
				i++;
			} else if (nums1[i] > nums2[j]) {
				j++;
			} else {
				resultList.add(nums1[i]);
				i++;
				j++;
			}
		}
		int[] result = new int[resultList.size()];
		int k = 0;
		for (Integer num : resultList) {
			result[k] = num;
			k++;
		}
		return result;
	}

	public static void main(String[] args) {
		IntersectionOfTwoArraysll i = new IntersectionOfTwoArraysll();
		int[] input1 = { 1, 2, 2, 1 };
		int[] input2 = { 2, 2 };
		int[] result = i.intersect(input1, input2);
		for (int n : result) {
			System.out.println(n + " ");
		}
	}

}
