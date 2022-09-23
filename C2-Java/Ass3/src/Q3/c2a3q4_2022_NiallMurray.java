/*
Question 4 								         (30 marks)
Write JUnit tests to test the findsum method in the ArraySum class of Question 3 so that it produces the correct result on different arrays.
Include each of the following tests:
o	A test for an array of one element
o	A test for an array of two elements
o	A test for an array of three elements
o	A test for an array of seven elements
 */

// Import JUnit tests.
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

// Class to run JUnit tests on ArraySum Class.
class c2a3q4_2022_NiallMurray {

	// ArraySum class only contains one method, findSum().
	// 4 separate tests required for arrays containing 1, 2, 3 and 7 elements
	// respectively.
	// Tests would pass if any ints were tested, even though nums[] can only contain
	// even whole numbers from 10-30.
	// Accordingly, all tests should only use ints which would be valid in nums
	// array.
	// @Test annotation to highlight a unit test.
	@Test
	void testFindSum1() {
		// If nums only contained one element, we would expect an array containing one
		// element returned.
		int[] nums = { 22 };
		// The expected return would be 0 since index position 0 is viewed as an even
		// numbered index.
		// findSum() replaces even numbered indexes with the sum of all elements except
		// this position.
		// The sum of all other elements is zero.
		int[] numsExpected = { 0 };
		// Call findSum method from ArraySum class, and pass (nums, nums.length, 0, 0)
		// as necessary parameters.
		// No ArraySum instance variable needed as findSum() is static.
		// findSum() will modify nums array, and this updated array will be compared to
		// the expected array.
		ArraySum.findSum(nums, nums.length, 0, 0);
		// Use JUnit assertArrayEquals() method to compare the expected return
		// from findSum() to the modified nums array which findSum() actually returns.
		// So if "expected" equals "actual", the test passes. If not the test fails.
		assertArrayEquals(numsExpected, nums);

	}

	// Process is the same as above, but with 2 elements in nums.
	@Test
	void testFindSum2() {

		int[] nums = { 10, 28 };
		// If nums contains only two elements, position 0 will be replaced by the sum of
		// position 1.
		// Position 1 remains unchanged as it is an odd numbered index.
		int[] numsExpected = { 28, 28 };

		ArraySum.findSum(nums, nums.length, 0, 0);
		// As above, compare expected array with actual for testing.
		assertArrayEquals(numsExpected, nums);

	}

	// Repeat process for nums with 3 valid elements.
	@Test
	void testFindSum3() {

		int[] nums = { 14, 20, 16 };
		// Replace positions 0 and 2 with the sum of the other two elements.
		// i.e. 20+16=36 and 14+20=34.
		int[] numsExpected = { 36, 20, 34 };

		ArraySum.findSum(nums, nums.length, 0, 0);

		assertArrayEquals(numsExpected, nums);

	}

	// Finally, run the same test for nums[] of length 7.
	// This is the most valid test as it matches the brief for Q3.
	// Tests could be run the same way for arrays with more than 7 elements.
	@Test
	void testFindSum7() {
		// Double check that expected return values are accurate using manual
		// calculations.
		// Do not use actual output from Q3 as expected output or the test would be
		// flawed.
		int[] nums = { 12, 22, 16, 12, 24, 30, 22 };
		int[] numsExpected = { 126, 22, 122, 12, 114, 30, 116 };

		ArraySum.findSum(nums, nums.length, 0, 0);

		assertArrayEquals(numsExpected, nums);
	}
	// End of JUnit tests.
}