/*
 * c2a1q4_2021_NiallMurray
 *
 * Write a program that asks the user to input an integer, a double and a string.
 * The program should validate the user inputs, and display helpful error messages when an invalid input occurs by asking the user to try again.
 * When all the inputs are valid, the program should pass the inputs to a method that converts the string to its equivalent numeric value, and adds this value to the sum of the remaining inputs.
 * The program should display the result to the user.
 * Note on equivalent numeric value:
 * • If the user enters a string of ‘ace’, the equivalent numeric value corresponding to the position of each letter in the alphabet would be 1+3+5 (9).
 * • Lowercase letters have the same equivalent numeric value as uppercase letters.
 * • Numbers in the string are worth their face value for each character, every other character entered has a numeric value of 0.
 */
import java.util.Scanner;

public class c2a1q4_2021_NiallMurray {
    // Default main method used.
    // @param args - Startup arguments.
    public static void main(String[] args) {
        // Create a Scanner object (userInput) to allow user input.
        // Change default delimiter to next line to avoid errors if user inputs spaces.
        // Note next[int/double/input]() methods used, and user prompted to hit enter when finished.
        // This allows spaces to be input in string but not int or double, without causing errors.
        Scanner userInput = new Scanner(System.in).useDelimiter("\\n");
        // Call methods to request and validate user input for integer and double.
        // Valid input is returned and stored as "userInt" and "userDouble" to be added to converted string later.
        int userInt = validateInt(userInput);
        double userDouble = validateDouble(userInput);

        // Define what is meant by a "string" for user, then request one from user.
        System.out.println("A string can be any combination of letters and numbers, other characters will not be counted.");
        System.out.println("Please input a string to be converted to numbers, then press enter:");
        // Store characters input as string, then confirm input to user.
        String userString =  userInput.next();
        System.out.println("You have entered: " + userString);
        // Convert userString to lowercase to simplify calculations, and pass to method to calculate string as numbers.
        // Method returned and stored as int since potential decimal numbers in string are treated as integers.
        int finalString = stringToNums(userString.toLowerCase());
        // Confirm numeric value of string to user, then confirm all three inputs to be added to user.
        System.out.println(userString + " equates to " + finalString);
        System.out.println("Your integer + double + string= " + userInt + " + " + userDouble + " + " + finalString);
        // Display result to user.
        System.out.println("Your total is: " + (userInt + userDouble + finalString));
        // Program complete.
    }
    /*
     * Create method to request and validate integer from scanner.
     * Requests will clarify what is being sought and prompt user to retry if invalid.
     * Valid input is confirmed and returned as int.
     * @param: userInput
     * @return: users valid int
     * */
    public static int validateInt(Scanner userInput) {
        //Declare int to store value.
        int userInt;
        //Request valid input.
        System.out.println("Please input your integer and press enter (digits only, no spaces): ");
        // Validate input is an integer, if not clarify request and try again until valid.
        while (!userInput.hasNextInt()) {
            // String to return invalid input to user.
            String notInt = userInput.next();
            System.out.println(notInt + " is invalid!");
            System.out.println("An integer is any whole number with no spaces or other characters.");
            System.out.println("Please try again: ");
        }
        // When input is valid, confirm selection to user and return value to main method.
        userInt = userInput.nextInt();
        System.out.println("You have entered: " + userInt);
        return userInt;
    }
    /*
     * Create method to request and validate double from scanner.
     * Requests will clarify what is being sought and prompt user to retry if invalid.
     * Valid input is confirmed and returned as double.
     * @param: userInput
     * @return: users valid double
     * */
    public static double validateDouble(Scanner userInput) {
        //Declare double to store value.
        double userDouble;
        //Request valid input.
        System.out.println("Please input your double and press enter (digits only with no spaces, decimal point optional): ");
        // Validate input is a double, if not clarify request and try again until valid.
        while (!userInput.hasNextDouble()) {
            // String to return invalid input to user.
            String notDouble = userInput.next();
            System.out.println(notDouble + " is not a double!");
            System.out.println("A double is a number with a decimal point, no spaces or other characters.");
            System.out.println("Please try again: ");
        }
        // When input is valid, confirm selection to user and return value to main method.
        userDouble = userInput.nextDouble();
        System.out.println("You have entered: " + userDouble);
        return userDouble;
    }
    /*
     * Create method to convert string to numbers.
     * Since no validation needed, users input is stored as string in main method and passed to this method.
     * Use String.charAt() method to read characters as ASCII values.
     * String total numeric value is returned as int.
     * @param: userString
     * @return: users string summed as int
     * */
    public static int stringToNums(String userString) {
        // Declare an int to store ASCII values of each character in string.
        int charValue = 0;
        // Declare int to sum the ASCII values of each character.
        int stringValue = 0;
        // For loop to iterate through string and extract each character's ASCII value.
        for (int i = 0; i < userString.length(); i++) {
            // ASCII values stored as int.
            charValue = userString.charAt(i);
            // Check if value is in digit range.
            if ((charValue > 48) && (charValue < 58)) {
                // If digit, (-48) to give face value of digit, then add to total string value.
                stringValue += (charValue - 48);
                // Do same for lowercase letters, string was converted and passed as lowercase only.
            } else if ((charValue > 96) && (charValue < 123)) {
                // If letter, (-96) to make (a= 1 ... z= 26), then add to total.
                stringValue += (charValue - 96);
                // Any other characters added as zero.
            } else stringValue += 0;
        }
        // Total value of string returned.
        return stringValue;
    }
}

