package practice;

import java.util.ArrayList;
import java.util.List;

// 412 - Fizz Buzz

public class FizzBuzz {
	public List<String> fizzBuzz(int n) {
		List<String> result_array = new ArrayList<>();

		for (int i = 1, fizz = 0, buzz = 0; i <= n; i++) {
			fizz++;
			buzz++;

			if (fizz == 3 && buzz == 5) {
				fizz = 0;
				buzz = 0;
				result_array.add("FizzBuzz");
			} else if (fizz == 3) {
				fizz = 0;
				result_array.add("Fizz");
			} else if (buzz == 5) {
				buzz = 0;
				result_array.add("Buzz");
			} else {
				result_array.add(Integer.toString(i));
			}
		}
		return result_array;
	}
}
