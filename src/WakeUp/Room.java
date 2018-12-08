package WakeUp;

import java.util.LinkedList;
import java.util.List;

/**
 * Representation of a room.
 *
 */
public class Room extends CSVDB {
    // Fields declared
    private Activity activity;
    private String id;
    private String[][] roomPlaces;  // A 2D array of places in the room
    private char[] ALPHABET = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l'};
    // Constructor for loading room from DB or creating new room.
    Room(String[] roomArr) {
        this.id = roomArr[0];
        this.setActivity(roomArr[1]);

        try
        {
            this.generatePlaces(
                    Integer.parseInt(roomArr[2]),
                    Integer.parseInt(roomArr[3])
            );
        }

        catch (NumberFormatException e)
        {

            throw e;
        }
    }
    // Constructor for selecting a room by activity
    Room(String activity) {

    }



    /**
     * Helper to make a string into the correct activity enum call.
     *
     * @param act
     */
    private void setActivity(String act)
    {

        switch (act.toLowerCase())
        {
            case "spinning":
                this.activity = activity.SPINNING;

                break;

            case "aerobics":
                this.activity = activity.AEROBICS;

                break;

            case "yoga":
                this.activity = activity.YOGA;

                break;

            case "unassigned":
                this.activity = activity.UNASSIGNED;

                break;
        }
    }

    /**
     * Get the different room activities from the enum class Activity.
     *
     * todo: implement this class.
     *
     * @return activities               a List object of activity types
     */
    public Activity getActivity()
    {

        return this.activity;
    }




    /**
     * Generate 2D array of places in the room.
     *
     * Assumptions are that the room is always square and the
     * rows are always the same length.
     *
     */
    private void generatePlaces(int rows, int columns)
    {
        this.roomPlaces = new String[rows][columns];
    }

    /**
     * Check the room and return a list of all places IDs.
     *
     * @return placesIDs            a LinkedList of all places IDs
     */
    public List<String> getAllPlaces()
    {
        List<String> placesIDs = new LinkedList<String>(); // Linked because inserting at end.

        for (int row = 0; row < this.roomPlaces.length; row++)
        {

            for (int column = 0; column < this.roomPlaces[row].length; column++) {
                String columnChar = String.valueOf(ALPHABET[column]); // cast from char to String
                placesIDs.add(String.format("%s%s", row, columnChar));
            }
        }

        return placesIDs;
    }

    /**
     * Check the array of places to see which ones are booked.
     *
     * @return bookedPlaces         an array of booked places
     */
    public String[] getBookedPlaces()
    {
        String[] tmparr = {};

        return tmparr;
    }




    /**
     * Set a place in the room to booked by
     * recording a user ID to it.
     *
     * The place has to be in array form
     * Where index 0 is castable to int
     * where index 1 is castable to char
     *
     * i.e 2a, or 3d
     *
     *
     * @param placeID               a String[] representing the places ID
     * @param userID                a String of the user ID
     *
     * @return boolean              true if successful
     */
    public boolean setBookedPlace(String[] placeID, String userID)
    {
        int row = Integer.parseInt(placeID[0]);
        char columnChar = placeID[1].charAt(0);
        int column;

        for (int i = 0; i < ALPHABET.length; i++)   // Find row index in 2D array
        {
            System.out.printf("\ncomparing %s to %s\n", columnChar, ALPHABET[i]);
            if (columnChar == ALPHABET[i]) // compare char to char
            {
                column = i;

                if (this.roomPlaces[row][column] != null)
                {

                    return false;
                }

                else
                {
                    this.roomPlaces[row][column] = userID;

                    return true;
                }
            }
        }

        return false;
    }




    /**
     * A string representation of a room and its places.
     *
     * todo: remove the last trailing newline character before returning.
     *
     * @return String               String representation of a room
     */
    @Override
    public String toString()
    {
        String output = String.format("\nRoom ID: %s - Activity: %s\n\n  Places: \n---", this.id, this.activity.toString());

        for (int row = 0; row < this.roomPlaces.length; row++)
        {

            if (row == 0)   // Print column names for first row.
            {

                for (int column = 0; column < this.roomPlaces[row].length; column++)
                {
                    output += String.format("%s-", ALPHABET[column]);
                }
                output += String.format("\n"); // finish with a newline
            }
            output += String.format("%s: ", row); // Print the row number

            for (int column = 0; column < this.roomPlaces[row].length; column++)
            {

                if (this.roomPlaces[row][column] == null)   // Unoccupied places.
                {
                    output += String.format("O ");
                }

                else
                {
                    output += String.format("X ");  // Occupied places.
                }
                //output += String.format("%s ", this.roomPlaces[row][column]); // This prints all NULLS??
            }
            output += String.format("\n");
        }

        return output;
    }

    /**
     * Create an array representation of the object.
     *
     * @return tmpArr               an array of the object attributes
     */
    public String[] toArray()
    {
        String[] tmpArr = {
                this.id,
                this.activity.toString(),
                Integer.toString(this.roomPlaces.length),
                Integer.toString(this.roomPlaces[0].length)
        };

        return tmpArr;
    }
}


