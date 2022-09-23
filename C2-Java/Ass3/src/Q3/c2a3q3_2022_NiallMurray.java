/*
Question 3   							         (30 marks)
Write a Java program that:
o	Prompts the user to enter seven even integers in the range of 10 to 30 inclusive.
o	Validates the user entry and stores them in an array called nums.
o	Calls a recursive static method named findSum in a class called ArraySum.
	The nums array should be passed as a parameter to the findsum method (along with other parameters to make the recursion work effectively).
	findsum should replace every element at an even position of the array passed in with the sum of every other element in the array.
Example screen output (user interaction shown in green):

Recursive program on 7 user inputs
Enter an even integer in the range of 10 to 30 (inclusive): 10
Enter an even integer in the range of 10 to 30 (inclusive): 30
Enter an even integer in the range of 10 to 30 (inclusive): 20
Enter an even integer in the range of 10 to 30 (inclusive): 22
Enter an even integer in the range of 10 to 30 (inclusive): 11
Invalid entry, number must be even.
Enter an even integer in the range of 10 to 30 (inclusive): 12
Enter an even integer in the range of 10 to 30 (inclusive): 8
Invalid entry, number must be in range.
Enter an even integer in the range of 10 to 30 (inclusive): 14
Enter an even integer in the range of 10 to 30 (inclusive): 20
Original array: [10, 30, 20, 22, 12, 14, 20]
Modified array: [118, 30, 108, 22, 116, 14, 108]
*/

// Imported utilities.
import java.util.Arrays;
import java.util.Scanner;

// Class containing main method  to request and validate user input, and store it in nums array.
// Then call findSum() from ArraySum class to modify nums[] and return and print modified array.
public class c2a3q3_2022_NiallMurray {
	// Main method.
	public static void main(String[] args) {
		// Output to begin program as in example given.
		System.out.println("Recursive program on 7 user inputs.");
		// Size of nums array stored in variable called arraySize.
		// This is good practice as it makes changing array size easier since it will be
		// passed to findSum() method as a variable.
		int arraySize = 7;
		// Declare empty nums array with arraySize(7) index positions.
		int[] nums = new int[arraySize];
		// Iterate through nums to add valid ints to each index.
		// inputValidator() method called at each position, which will only return valid
		// ints to be added.
		// Valid ints are even whole numbers between 10 and 30 inclusive.
		for (int i = 0; i < nums.length; i++) {
			// Value at position i is equal to validated user input, as returned by
			// inputValidator() method.
			nums[i] = inputValidator();
			// Confirm to user that accepted input has been added to array.
			System.out.println(nums[i] + " added to array at index " + i + ".");
		}
		// Output array of valid user inputs using .toString().
		System.out.println("Original array: " + Arrays.toString(nums));
		// Call findSum() from ArraySum class, and pass necessary parameters to allow
		// recursive method.
		// Params (nums array, arraySize, sum of left sub-array, current array index).
		// left and i start at 0 and will be incremented by findSum().
		ArraySum.findSum(nums, arraySize, 0, 0);
		// Output modified nums array as calculated by findSum().
		System.out.println("Modified array: " + Arrays.toString(nums));

		// End of program output.

	}

	// Method to validate user input.
	// Valid inputs are even whole numbers between 10 and 30 inclusive.
	// Method will continue to ask for valid input until nums array is full.
	public static int inputValidator() {
		try (// Scanner to allow user input.
				Scanner userIn = new Scanner(System.in)) {
			// Declare int for valid inputs, which will be updated and returned when user
			// enters valid int.
			int validInt;
			// while loop to continue requesting valid input until input is acceptable.
			while (true) {
				// Output to tell user what is valid.
				System.out.println("Enter an even integer in the range of 10 to 30 (inclusive): ");
				// try/catch blocks to test user input and inform if input is invalid.
				try {
					// Store user input as int, if user input can be parsed as int.
					// If user inputs non-int, try block exits and catch block requests ints only.
					int userInt = Integer.parseInt(userIn.nextLine());
					// If user enters int, check if it is an even number, then if it is between
					// 10-30 inclusive.
					if (userInt % 2 == 0) {
						if ((userInt >= 10) && (userInt <= 30)) {
							validInt = userInt;
							// If user input is valid, update validInt with userInt and return.
							return validInt;
							// Request input is in range if it is even.
						} else
							System.out.println("Invalid entry, number must be in range 10-30!");
						// Request even numbers only.
					} else
						System.out.println("Invalid entry, even numbers only!");
					// Catch block to handle user entering non-ints without crashing.
				} catch (NumberFormatException e) {
					System.out.println("Invalid entry, whole digits only. No decimal points or letters allowed!");
				}
			}
		}
	}
	// End of main class.
}
