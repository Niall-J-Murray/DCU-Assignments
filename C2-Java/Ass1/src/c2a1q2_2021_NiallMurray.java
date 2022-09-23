/* c2a1q2_2021_NiallMurray
        *
        * Write a program that asks the user to enter the number of rows in the range 3 to 10 inclusive.
        * The program should validate the users input and continue to ask for the value until it is in the correct range.
        * The program should then ask the user to enter the number of columns in the range of 5 to 10.
        * This user entry should also be validated as above.
        * When both inputs are valid, the program should print out a neatly formatted table of the specified number of rows and columns that the user entered.
        * A calculation should be used to output a derived number in each position as can be seen in the table output below.
        * The starting number in row 1, column 1 should be 100. Numbers exceeding 999 should use a comma to separate thousands from hundreds.
        * The numbers in the table should line up correctly under each other.
        * The program class should contain at least one additional method other than the main method.
        * The program should use loops to read and validate the inputs until correct inputs are provided.
        * The program should use loops to output the table.

        Example program execution:
        Enter rows (between 3 and 10 inclusive): 6
        Enter cols (between 5 and 10 inclusive): 8
        100    200    300    400    500    600    700    800
        200    400    600    800  1,000  1,200  1,400  1,600
        300    600    900  1,200  1,500  1,800  2,100  2,400
        400    800  1,200  1,600  2,000  2,400  2,800  3,200
        500  1,000  1,500  2,000  2,500  3,000  3,500  4,000
        600  1,200  1,800  2,400  3,000  3,600  4,200  4,800
        */

        import java.util.Scanner;

public class c2a1q2_2021_NiallMurray {
    // Default main method used.
    // @param args - Startup arguments.
    public static void main(String[] args) {
        // Create a Scanner object (userInput) to allow user input. Delimiter changed to allow for spaces.
        Scanner userInput = new Scanner(System.in).useDelimiter("\\n");
        // Declare int variables to store validated number of rows and columns returned from methods.
        int validRows = getRows(userInput);
        int validCols = getCols(userInput);
        // Call method to create and output properly formatted table, using the validated values from previous methods.
        System.out.printf("Now printing table of (%d rows * %d columns), starting at 100:%n", validRows, validCols);
        printTable(validRows, validCols);
        // Program complete!
    }

    /*
     * Create method to request and validate number of rows as integer from scanner.
     * Requests will clarify what is being sought and prompt user to retry if invalid.
     * Valid input is confirmed and returned as int.
     * @param: userInput
     * @return: users valid "rows' int
     * */
    public static int getRows(Scanner userInput) {
        // Declare int to store number of rows input.
        int rows = 0;
        // Request valid input.
        System.out.println("Please input required number of rows (Min= 3, Max= 10): ");
        // Declare boolean to track if input is invalid. Assume input is invalid by default, i.e. invalidInput = true.
        boolean invalidInput = true;
        // Use while loop to continue requesting until input is valid.
        while (invalidInput) {
            // Check if input is an int, then check if it is in range 3-10.
            if (userInput.hasNextInt()) {
                // Update rows if int is found.
                rows = userInput.nextInt();
                // Output error message if int found, but out of range 3-10.
                if (rows < 3 || rows > 10) {
                    System.out.println("Invalid number selection!");
                    System.out.println("Please input a whole number between 3 and 10 (inclusive): ");
                    // Update boolean when input is valid.
                } else {
                    invalidInput = false;
                } // If input is not int, inform user to only input digits.
            } else {
                //String to return invalid input to user.
                String notInt = userInput.next();
                System.out.printf("'%s' is not valid! Only digits can be input.%n", notInt);
                System.out.println("Please choose a number from 3 to 10: ");
            }
        }// Confirm valid selection to user and return value to main method.
        System.out.printf("You have chosen %d rows.%n%n", rows);
        //System.out.println();
        return rows;
    }

    /*
     * Create method to request and validate number of cols as integer from scanner.
     * Requests will clarify what is being sought and prompt user to retry if invalid.
     * Valid input is confirmed and returned as int.
     * @param: userInput
     * @return: users valid "cols" int
     * */
    public static int getCols(Scanner userInput) {
        // Declare int to store number of columns input.
        int cols = 0;
        // Request valid input.
        System.out.println("Please input required number of columns (Min= 5, Max= 10): ");
        // Declare boolean to track if input is invalid. Assume input is invalid by default, i.e. invalidInput = true.
        boolean invalidInput = true;
        // Use while loop to continue requesting until input is valid.
        while (invalidInput) {
            // Check if input is an int, then check if it is in range 5-10.
            if (userInput.hasNextInt()) {
                // Update cols if int is found.
                cols = userInput.nextInt();
                // Output error message if int found, but out of range 5-10.
                if (cols < 5 || cols > 10) {
                    System.out.println("Invalid number selection!");
                    System.out.println("Please input a whole number between 5 and 10 (inclusive): ");
                    // Update boolean when input is valid.
                } else {
                    invalidInput = false;
                } // If input is not int, inform user to only input digits.
            } else {
                // String to return invalid input to user.
                String notInt = userInput.next();
                System.out.printf("'%s' is not valid! Only digits can be input.%n", notInt);
                System.out.println("Please choose a number from 5 to 10: ");
            }
        }// Confirm valid selection to user and return value to main method.
        System.out.printf("You have chosen %d cols.%n%n", cols);
        return cols;
    }

    /*
     * Create method to create table using previously validated input for rows and columns.
     * Table to be printed with proper formatting as shown in example.
     * Table starts at 100, and increases along with number of rows and columns. i.e. 100 * (rows * cols).
     * @param: validRows
     * @param: validCols
     * void: no return
     * */
    public static void printTable(int validRows, int validCols) {
        // Use nested for loop to print requested number of columns for each requested row.
        // Both loops to start at row 1 and column 1, and count upwards until numbers passed to method.
        for (int i = 1; i <= validRows; i++) {
            for (int j = 1; j <= validCols; j++) {
                // Use print formatting to allow extra space for numbers up to 100 * 100 (10,000), so that table is always neatly laid out.
                // Include commas for numbers over 999.
                System.out.printf("%,8d", ((i * j) * 100));
            }
            // Use empty print line to make new row start on next line.
            System.out.println();
        }
    }
}

