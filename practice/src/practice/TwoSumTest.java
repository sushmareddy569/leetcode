package practice;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import junit.framework.Assert;

public class TwoSumTest {

	@Test
	public void test() {
		TwoSum two = new TwoSum();
		int[] input = { 1, 5, 7, 3, 4 };
		List<Integer> actual = two.findNumbers(input, 6);
		System.out.println(actual);
		List<Integer> expected = new ArrayList<>();
		expected.add(1);
		expected.add(5);
//		expected.add(5);
//		expected.add(1);
//		expected.add(3);
//		expected.add(3);
		Assert.assertEquals(expected, actual);
	}

}
