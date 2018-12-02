package WakeUp;


/**
 * Singleton control class for working with Room instances.
 */
public class RoomControl {
    private static RoomControl ourInstance = new RoomControl();
    private static Room selectedRoom;

    public static RoomControl getInstance() {
        return ourInstance;
    }

    private RoomControl() {
    }


    /**
     * A room is used for an activity. This method lists
     * all the available activities.
     *
     * @return String[]         an array of available activities
     */
    public String[] getRoomActivities() {
        String [] activitiesList = {};
        return activitiesList;
    }

    /**
     * This sets the selected room depending on activity.
     */
    public void fetchRoomByActivity(Activity activity) {
    }

    /**
     * This sets the selected room depending on activity.
     */
    public void fetchRoomByRoomID(int roomID) {

    }

    /**
     * This will return the list of all places in a room.
     *
     * @return allPlaces            an array of all places in a room
     */
    public String[] fetchRoomPlaces() {
        String[] tmparr = {};

        return tmparr;
    }


    /**
     *
     * @param userID                an int that is the user ID
     * @param placeID               an int that is the selected place ID
     */
    public void assignUserToRoomPlace(int userID, int placeID) {

    }

}
