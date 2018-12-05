package WakeUp;

/**
 * Representation of a room.
 *
 */
public class Room extends CSVDB {
    private static Activity activity;
    private static String id;
    private String[] roomPlaces;
    // Default empty constructor.
    Room() {}
    // Constructor for creating a new Room.
    Room(String activity) {
        setActivity(activity);
    }
    Room(String roomID, String activity) {
        this.id = roomID;
        this.setActivity(activity);
    }
    // Constructor for loading room from DB or creating new room.
    Room(String[] roomArr) {
        this.id = roomArr[0];
        this.setActivity(roomArr[1]);
        String[] roomPlaces = this.generatePlaces();
    }




    /**
     * Helper to make a string into the correct activity enum call.
     *
     * @param act
     */
    private void setActivity(String act) {

        switch (act.toLowerCase()) {
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
    public static void getActivities() {

    }




    /**
     * Generate 2D array of places in the room.
     *
     * Assumptions are that the room is always square and the
     * rows are always the same length.
     *
     * @return roomPlaces               an Array of all the places in a room
     */
    public static String[] generatePlaces() {
        String[] tmpArr = {};
        return tmpArr;
    }
    /**
     * Check the room and return a list of all places weather they are
     * booked or not.
     *
     * @return allPlaces            an array of all places
     */
    public String[] getAllPlaces() {
        String[] tmparr = {};

        return tmparr;
    }

    /**
     * Check the array of places to see which ones are booked.
     *
     * @return bookedPlaces         an array of booked places
     */
    public String[] getBookedPlaces() {
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
    public boolean setBookedPlace(int placeID, int userID) {
        return true;
    }




    /**
     * A string representation of a room and its places.
     *
     * @return String               String representation of a room
     */
    @Override
    public String toString() {
        String s = super.toString();
        return s;
    }

    /**
     * Create an array representation of the object.
     *
     * @return tmpArr               an array of the object attributes
     */
    public String[] toArray() {
        String[] tmpArr = {
                this.activity.toString(),
                this.id
        };

        return tmpArr;
    }
}
