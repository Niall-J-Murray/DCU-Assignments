// Both programs in same package.
package c2a2q3_2022_NiallMurray;

// Class containing methods to record sightings of Bird A and B over 1 season.
public class BirdSightingMachine {
    // Private variables so that testing class cannot access them directly.
    // Ints to track sightings of each bird, set to zero at start of season.
    private int birdASights = 0;
    private int birdBSights = 0;

    // Getter for birdASights so that tester class can access the updated variable.
    public int getBirdA() {
        return birdASights;
    }

    // Setter to update Bird A sightings from test class. Method is called each time bird A is spotted.
    public void setBirdA() {
        this.birdASights++;
    }

    // As above for Bird B.
    public int getBirdB() {
        return birdBSights;
    }

    // As above for Bird B.
    public void setBirdB() {
        this.birdBSights++;
    }

    // Method to print out the results of each season.
    public void displayTotals() {
        System.out.println("Results of season: ");
        System.out.println("Bird A: " + this.getBirdA() + " sightings");
        System.out.println("Bird B: " + this.getBirdB() + " sightings");
        // if...else statements to print winner/draw.
        if (getBirdA() > getBirdB()) {
            System.out.println("Bird A wins!");
        } else if (getBirdA() < getBirdB()) {
            System.out.println("Bird B wins!");
        } else
            System.out.println("It's a draw!");
    }

    // Method to reset counters to zero at the end of the season.
    public void reset() {
        this.birdASights = 0;
        this.birdBSights = 0;
    }

    // Extra method to show totals of all 3 seasons combined and declare overall winner.
    public void displayOverallTotals() {
        // Access static ints from test class and store as local variables.
        int overallA = c2a2q3_2022_NiallMurray.totalCountA;
        int overallB = c2a2q3_2022_NiallMurray.totalCountB;
        // Output overall sightings and declare overall winner.
        System.out.println("Overall total Bird A sightings: " + overallA);
        System.out.println("Overall total Bird B sightings: " + overallB);
        if (overallA > overallB) {
            System.out.println("Bird A wins overall!");
        } else if (overallA < overallB) {
            System.out.println("Bird B wins overall!");
        } else System.out.println("It's a draw!");
    }
}
