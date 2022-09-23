/*Question 1   							         (25 marks)

Write a Java program to do the following:
Compose a random sequence of 10 case-sensitive letters.
Allowable letters are:
A   B   C   D   E   F   a   b   c   d   e   f
Assign random values to each letter.
Allowable values are:
0.5   1   1.5   2   2.5   3

Display a comma separated list of each generated letter followed by its assigned value.
Do not include a space between the letter and its assigned value.
The program should determine which letters were not used, and print these on the next line.
Use an ArrayList as part of the solution to this question.

Sample output:
a1,c3,e2.5,f3,c2,B0.5,D3,b1.5,C2,f3
Letters not used: A,E,F,d
*/

// Imported classes

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class c2a2q1_2022_NiallMurray {
    // Default main method used.
    // @param args - Startup arguments.
    public static void main(String[] args) {
        // Create empty <Object> ArrayList for letters.
        // Note, <Object> Arraylists used throughout program to allow for easier mixing of chars, ints and doubles.
        ArrayList<Object> letters = new ArrayList<>();
        // Add allowable letters as elements as chars.
        // Collections.addAll() used to add all in one line instead of one by one.
        Collections.addAll(letters, 'A', 'B', 'C', 'D', 'E', 'F', 'a', 'b', 'c', 'd', 'e', 'f');
        // Repeat previous steps to add allowable values as ints and doubles to new Arraylist.
        ArrayList<Object> numbers = new ArrayList<>();
        Collections.addAll(numbers, 0.5, 1, 1.5, 2, 2.5, 3);
        // Create empty Arraylist to hold the random sequence of letters and numbers to be generated below.
        ArrayList<Object> sequence = new ArrayList<>();
        // Initialise random class
        Random random = new Random();
        // Initialise StringBuilder class to build string which will be randomly generated, then formatted and printed as requested.
        StringBuilder randomValues = new StringBuilder();
        // for loop to generate sequence of 10 letters and assigned numbers.
        for (int i = 0; i < 10; i++) {
            // Declare ints to store random integers which will correspond to index position in Arraylists.
            // Generate random ints in the range of the Arraylists of allowable values using random.nextInt().
            // Arraylists are not altered, elements are chosen at random based on their index position.
            int indexLetters = random.nextInt(letters.size());
            int indexNumbers = random.nextInt(numbers.size());
            // Use random ints generated to get element at that position and add to StringBuilder.
            randomValues.append(letters.get(indexLetters));
            // Repeat above for numbers, but also add "," as requested.
            randomValues.append(numbers.get(indexNumbers)).append(",");
            // Get and add the chosen elements to empty "sequence" Arraylist to compare elements later.
            sequence.add(letters.get(indexLetters));
            sequence.add(numbers.get(indexNumbers));
        }
        // Remove final unwanted comma from StringBuilder.
        randomValues.deleteCharAt(randomValues.length() - 1);
        // Convert properly formatted StringBuilder to String to print out.
        String randomSequence = randomValues.toString();
        // Print random sequence of allowable letters and numbers.
        System.out.println("Random sequence of allowed letters and assigned numbers: ");
        System.out.println(randomSequence);

        // Use .removeAll to remove all the letters chosen from the Arraylist of allowed letters.
        // This means any letters remaining must not have been selected.
        letters.removeAll(sequence);
        // New StringBuilder to build string of letters not chosen.
        StringBuilder remainingLetters = new StringBuilder();
        // Use enhanced for loop to add remaining unused letters and commas to StringBuilder.
        for (Object i : letters) {
            remainingLetters.append(i).append(",");
        }
        // Remove final unwanted comma from StringBuilder.
        remainingLetters.deleteCharAt(remainingLetters.length() - 1);
        // Convert properly formatted StringBuilder to String to print out.
        String unusedLetters = remainingLetters.toString();
        // Print comma separated string of letters not used.
        System.out.println("Letters not used: " + unusedLetters);
    }
    // Program outputs as requested!
}

