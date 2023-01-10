package practice;

//1346 - Check If N and Its Double Exist

import java.util.HashSet;

public class CheckIfNAndItsDoubleExist {
	public boolean checkIfExist(int[] arr) {

		HashSet<Integer> set = new HashSet<>();
		// for example, arr=[7,1,14,11], when 7 is added into the set there was no 14
		// By the time 14 is added into the set,if there is no set.contains(n/2)
		// condition and
		// if there is only set.contains(n*2), then it will return false
		// for example, arr=[3,1,7,11], 7/2=3 and 3 will be in the set by the time we
		// reach 7 so it returns true if there is no n%2==0 condition.
		for (int n : arr) {
			if (set.contains(n * 2) || (n % 2 == 0 && set.contains(n / 2))) {
				return true;
			}
			set.add(n);
			System.out.println(set);
		}
		return false;

		/*
		 * for (int i = 0; i < arr.length; i++) { for (int j = 0; j < arr.length; j++) {
		 * if (arr[i] == 2 * arr[j]) { return true; } } }
		 * 
		 * return false;
		 */

	}

	public static void main(String[] args) {
		CheckIfNAndItsDoubleExist c = new CheckIfNAndItsDoubleExist();
		int[] input = { 2, 3, 5, 10 };
		boolean result = c.checkIfExist(input);
		System.out.println(result);

		// int[] result = c.checkIfExist(input); for (int n : result) {
		// System.out.println(n + " "); }

	}

}
