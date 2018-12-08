package WakeUp;

/**
 * Representation of a room.
 *
 */
public class Room extends CSVDB {
    // Fields declared
    private Activity activity;
    private String id;
    private String[][] roomPlaces;  // A 2D array of places in the room
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
     * Check the room and return a list of all places weather they are
     * booked or not.
     *
     * @return allPlaces            an array of all places
     */
    public String[] getAllPlaces()
    {
        String[] tmparr = {};

        return tmparr;
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
     * @param placeID               an int representing the places ID
     * @param userID                a String of the user ID
     *
     * @return boolean              true if successful
     */
    public boolean setBookedPlace(int placeID, int userID)
    {

        return true;
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
        String output = "";

        for (int row = 0; row < this.roomPlaces.length; row++)
        {
            output += String.format("%s: ", row);

            if (row == 0)   // Print column names for first row.
            {

                for (int column = 0; column < this.roomPlaces[row].length; column++)
                {
                    output += String.format("-%s-", column);
                }
            }

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


