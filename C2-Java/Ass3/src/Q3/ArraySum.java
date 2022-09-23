// Separate ArraySum class as required.
public class ArraySum {
    // Recursive static method named "findSum" to replace even numbered index elements with the sum of every other element in the array.
    // Split nums into left and right sub-arrays and iterate through nums using parameter i to track current index.
    // The updated sum of the left sub-array will be passed back to recursive function, where the right sub-array will be calculated.
    // Params (nums array, arraySize, sum of left sub-array, current array index).
    // left and i passed as 0 to start at index 0.
    public static int findSum(int[] nums, int arraySize, int left, int i) {
        // Base case, exit recursive method and return 0 when end of array reached (i.e. i = 7).
        if (i == arraySize) {
            return 0;
        }
        // Store current element as int.
        int current = nums[i];
        // Calculate the sum of right sub-array recursively.
        int right = findSum(nums, arraySize, (left + nums[i]), (i + 1));
        // Check if current index is even number.
        if (i % 2 == 0) {
            // Replace the even numbered index elements with the sum of the left and right sub-arrays, which is the sum of every other element.
            nums[i] = left + right;
        }
        // Return sum of current element and right sub-array.
        return current + right;
    }

    // End of ArraySum class.

}

