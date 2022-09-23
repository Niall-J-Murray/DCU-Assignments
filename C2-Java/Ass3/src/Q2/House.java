// House class implements Comparable interface to define sorting.
public class House implements Comparable<House> {
    // Private class variables for house objects.
    private String houseType;
    private int numBedrooms;
    private int price;
    // Private static class variable to change sort type as needed.
    private static int sortBy;

    // House constructor to create House objects in main class.
    public House(String houseType, int numBedrooms, int price) {
        // this keyword to specify class variables.
        this.houseType = houseType;
        this.numBedrooms = numBedrooms;
        this.price = price;
    }
    // sortBy setter to access private static variable from main class.
    public static void setSortBy(int sortBy) {
        House.sortBy = sortBy;
    }

    // Override toString() to print objects with user readable information.
    @Override
    public String toString() {
        // .format and '|' used to make output neater. Include commas for prices.
        return String.format("House Type= %8s | Bedrooms= %d | Price= €%,d ", houseType,numBedrooms,price);
    }
    // Overridden compareTo() from Comparable interface.
    @Override
    public int compareTo(House o) {
        // First check static sortBy variable to see which sorting method is requested.
        if (sortBy == 0) {
            // Use CharSequence.compare to compare and sort alphabetically by house type.
            // Returns -1, 0 or 1 for Collections.sort to sort ArrayList.
            return CharSequence.compare(this.houseType, o.houseType);
            // If sortBy is 1, then compare by number of bedrooms in ascending order.
        } else if (sortBy == 1) {
            // Similar to above, returns -1, 0 or 1 but based on integer numOfBedrooms.
            return Integer.compare(this.numBedrooms, o.numBedrooms);
        }
        // If sortBy is 2, sort by integer number of house price ascending.
        else if (sortBy == 2) {
            return Integer.compare(this.price, o.price);
        }
        return sortBy;
    }
// End of House class.
}

