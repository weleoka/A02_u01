package WakeUp;


/**
 * Representation of a room.
 *
 */
public class Room extends Dbitem {
    private static Activity type;
    private static int id;

    // Constructor
    Room() {
        String[] roomPlaces = this.generatePlaces();
    }


    private String[] generatePlaces() {
        String[] tmparr = {};

        return tmparr;
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
}
