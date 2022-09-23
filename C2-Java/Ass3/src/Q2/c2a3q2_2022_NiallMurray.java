/*
Question 2 								         (20 marks)
Implement a class called House which has a house type, number of bedrooms, and a price.
In a sample program, create an ArrayList of Houses and populate it with at least 5 Houses with different values for house types, number of bedrooms, and prices.
Display the unsorted list. Sort the list by house type and display the sorted list. Then sort the list by number of bedrooms and display the sorted list.
Then sort the list by price and display the sorted list.

Hint: Use the ‘Comparable’ interface. Add a static class variable to configure the sort type (by house type, or by number of bedrooms or by price).
 */

// Imported utilities.
import java.util.ArrayList;
import java.util.Collections;
// Class containing main method to create ArrayList and print sorted ArrayLists.
public class c2a3q2_2022_NiallMurray {

    public static void main(String[] args) {
        // Declare ArrayList of House objects named houseList.
        ArrayList<House> houseList = new ArrayList<>();
        // Use houseList.add() to add House objects with a selection of different parameters.
        // House() constructor is called to create new House objects.
        // Add them in a relatively random order to demonstrate sorting better later on.
        // Also, try not to have numBedrooms and price as the exact same order to show sorting is working properly.
        houseList.add(new House("Detached", 6, 750000));
        houseList.add(new House("Cottage", 1, 250000));
        houseList.add(new House("Mansion", 9, 3500000));
        houseList.add(new House("Bungalow", 2, 450000));
        houseList.add(new House("Terrace", 4, 350000));
        // Output the final ArrayList unsorted first.
        System.out.println("Unsorted ArrayList of houses: ");
        // Enhanced for loop to iterate through and print each House object in list.
        // Note toString method is overridden in the House class to print the objects as needed.
        // Otherwise, it would print out the objects hashcode.
        for (House house:houseList) {
            System.out.println(house);
        }
        // Dividing line for formatting output.
        System.out.println("------------------------------------------------------------");

        // Call setSortBy(0) to update static class variable sortBy to the first sort type.
        // If sortBy is 0, sort by house type (alphabetically).
        House.setSortBy(0);
        // Use Collections.sort to sort houseList by house type, as defined in compareTo method in House Class.
        Collections.sort(houseList);
        // As above integrate through and print out newly sorted list with enhanced for loop.
        System.out.println("ArrayList sorted alphabetically by house type: ");
        for (House house:houseList) {
            System.out.println(house);
        }
        // Dividing line for formatting output.
        System.out.println("------------------------------------------------------------");

        // Update sortBy variable to 1 to change to next sort type.
        House.setSortBy(1);
        // .sort will now sort by comparing number of bedrooms.
        Collections.sort(houseList);
        // Print list with new sorting.
        System.out.println("ArrayList sorted by number of bedrooms ascending: ");
        for (House house:houseList) {
            System.out.println(house);
        }
        // Dividing line for formatting output.
        System.out.println("------------------------------------------------------------");

        // Finally, as above, update sortBy to price ascending.
        House.setSortBy(2);
        Collections.sort(houseList);
        System.out.println("ArrayList sorted by price ascending: ");
        for (House house:houseList) {
            System.out.println(house);
        }

        System.out.println("------------------------------------------------------------");

        // End of main method, lists have printed in 4 different orders as required.
    }
    // End of main class.
}



