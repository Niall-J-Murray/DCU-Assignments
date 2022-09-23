/*
 *c2a1q1_2021_NiallMurray
 *
 * Write a program to calculate and print the first 10 numbers of a series of numbers which adds the previous three numbers.
 * Let the first number in the series be 5.
 * The program should then print the numbers on a separate line in reverse order.
 * Use commas to separate values when printing the output.
 * Expected output:
 * 5, 5, 10, 20, 35, 65, 120, 220, 405, 745
 * Original Array printed in reverse order:
 * 745, 405, 220, 120, 65, 35, 20, 10, 5, 5
 */
public class c2a1q1_2021_NiallMurray {
    // Default main method used.
    // @param args - Startup arguments.
    public static void main(String[] args) {
        //Declare array to contain the series of 10 numbers as ints.
        int[] sumLastThree = new int[10];
        //Define the first three positions, since each position is the sum of the previous 3.
        //First is known to be 5.
        sumLastThree[0] = 5;
        //Second is 5+0+0=5, same as first position.
        sumLastThree[1] = sumLastThree[0];
        //Third position sum of first two (plus zero).
        sumLastThree[2] = sumLastThree[1] + sumLastThree[0];
        //Use for loop to calculate the rest of the array, starting at fourth position.
        for (int i = 3; i < sumLastThree.length; i++) {
            //Each iteration is the sum of the previous 3.
            sumLastThree[i] = sumLastThree[i - 1] + sumLastThree[i - 2] + sumLastThree[i - 3];
        }
        //New string and for loop to add commas to array.
        String forwardString = "";
        for (int i = 0; i < sumLastThree.length; i++) {
            if (i > 0) // Don’t add comma before first position in sequence.
            {
                forwardString += ", ";
            }
            forwardString += sumLastThree[i];
        }
        //Print out array as in expected output.
        System.out.println(forwardString);

        System.out.println("Original Array printed in reverse order: ");
        //New string to add commas and print array in reverse.
        String backwardString = "";
        for (int i = sumLastThree.length - 1; i >= 0; i--) {
            if (i < 9) // Sequence reversed, don’t add comma before first element displayed.
            {
                backwardString += ", ";
            }
            backwardString += sumLastThree[i];
        }//Print out display in reverse order as in expected output.
        System.out.println(backwardString);
    }//Program executed as expected.
}

