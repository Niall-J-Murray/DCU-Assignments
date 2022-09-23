/*
Question 2								         (30 Marks)
Write a program that generates 16 random lowercase letters of the alphabet (range a–z inclusive) and then writes the letters to a file.
Each letter in the file should be separated by a | symbol with four letters per line.
No line should begin or end with a | symbol.
The program should also write control totals on the last 2 lines of the file as follows:

The second last line should show the letter(s) that was/were generated the most number of times.
Include the number of times generated as per sample file output.
The last line should show the letter(s) that was/were generated the least number of times.
Include the number of times generated as per sample file output.

Example file contents:
f|j|r|h
u|g|b|f
u|z|o|h
y|w|m|p
Generated the most number of times (2 times): f h u
Generated the least number of times (0 times): a c d e i k l n q s t v x
*/
// Imported classes

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;

public class c2a2q2_2022_NiallMurray {
    // Default main method used.
    // @param args - Startup arguments.
    // FileNotFoundException added to main method signature since using PrintWriter.
    public static void main(String[] args) throws FileNotFoundException {
        // Initialise new PrintWriter to output to separate file called "c2a2q2output.txt".
        PrintWriter out = new PrintWriter("c2a2q2output.txt");
        // Call Random class and initialise new random variable.
        Random random = new Random();
        // Create empty int array with 26 positions, to represent the lowercase alphabet, to count the occurrence of each letter.
        int[] count = new int[26];
        // Create Stringbuilder to gather generated letters and format the output as requested.
        StringBuilder letterString = new StringBuilder();
        // Nested for loops to create 4x4 grid of 16 random letters.
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                // Generate random integer from 0-25 to choose letter based on alphabetical order.i.e. a=0, b=1,...z=25.
                // Use (random number + 'a') to get ASCII value of lowercase alphabet, and assign to new char variable.
                char randomLetter = (char) (random.nextInt(26) + 'a');
                // Add randomly generated chars to StringBuilder.
                // After every 4th letter, start new line.
                if (j == 3) {
                    letterString.append(randomLetter).append("\n");
                    // Add '|' after every other letter.
                } else {
                    letterString.append(randomLetter).append("|");
                }
                // (randomLetter - 'a') is in the range 0-25.
                // The corresponding position in our empty count array is increased by 1 each time a letter is generated.
                // e.g. If (randomLetter - 'a') = 14, the 14th position is increased by 1.
                // The 14th position is the 15th letter of the alphabet, 'o'.
                count[randomLetter - 'a']++;
            }
        }
        // Store formatted StringBuilder as string.
        String letterGrid = letterString.toString();
        // Print to file using PrintWriter.
        out.print(letterGrid);

        // Initialise int variables track most and least number of times a letter was generated, starting at position 0, (0 = 'a').
        int most = count[0];
        int least = count[0];
        // Loop through count array to find and record the highest and lowest numbers.
        for (int i : count) {
            if (i > most) {
                most = i;
            }
            if (i < least) {
                least = i;
            }
        }

        // Create two new StringBuilders, to find and add the most and least generated to respective Strings.
        StringBuilder mostFrequent = new StringBuilder();
        StringBuilder leastFrequent = new StringBuilder();
        // Use for loop to check if the value at each position in count array is equal to the most, or least ,generated letters.
        for (int i = 0; i < count.length; i++) {
            // If position i equals the most that any letter was generated, convert position i (0-25) to char between a-z, and add to StringBuilder.
            if (count[i] == most) {
                // Most generated letters are added to one string, along with a space for formatting.
                // (i + 97) used to avoid potential confusion of (i +'a').
                mostFrequent.append((char) (i + 97)).append(" ");
            }
            // Do the same for least generated letters.
            if (count[i] == least) {
                leastFrequent.append((char) (i + 97)).append(" ");
            }
        }
        // Print results to file as requested, with proper formatting as in example answer.
        out.println("Generated the most number of times (" + most + " times): " + mostFrequent);
        out.println("Generated the least number of times (" + least + " times): " + leastFrequent);
        // Close PrintWriter out
        out.close();
        // Program runs as expected!


        // Below is the same results printed to console to check output more quickly.
        // Commented out as it's not requested in the question.
        /*
        System.out.print(letterGrid);
        System.out.println();

        System.out.println("Generated the most number of times (" + most + " times): " + mostFrequent);
        System.out.println("Generated the least number of times (" + least + " times): " + leastFrequent);
        System.out.println();
        System.out.println("---------------Compare output below to confirm results---------------");

        System.out.println(Arrays.toString(count));
        // Just to compare to alphabet.
        char c;
        for (c = 'a'; c <= 'z'; c++)
            if (c == 'a'){
                System.out.print("[" + c + ", ");
            }
        else if (c == 'z') {
                System.out.print(c + "]");
            }
        else
            System.out.print(c + ", ");

         */
    }
}
