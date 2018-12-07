package WakeUp;


import java.util.List;

/**
 * Singleton control class for working with Room instances.
 */
public class RoomControl
{
    // Fields declared
    private static CSVDB roomDB;
    private Room selectedRoom;
    // Singleton
    private static RoomControl ourInstance = new RoomControl();
    public static RoomControl getInstance()
    {

        return ourInstance;
    }
    // Constructor
    private RoomControl()
    {

        this.roomDB = new CSVDB("./roomDB.csv");
    }




    /**
     * A room is used for an activity. This method lists
     * all the available activities.
     *
     * todo: implement a check of the enum Activities to find types.
     *
     * @return String[]         an array of available activities
     */
    public String[] getRoomActivities()
    {
        String [] activitiesList = {"Spinning", "Aerobics", "Yoga"};
        //List<String> activities = Room.getActivities();
        return activitiesList;
    }

    /**
     * This sets the selected room depending on activity.
     */
    public void selectRoomByActivity(String activity)
    {
        this.selectedRoom = new Room(activity);
    }

    /**
     * This sets the selected room depending on activity.
     */
    public void selectRoomByRoomID(int roomID)
    {

    }




    /**
     * This will return the list of all places in a room.
     *
     * @return allPlaces            an array of all places in a room
     */
    public String[] fetchRoomPlaces()
    {
        String[] tmparr = {};

        return tmparr;
    }

    /**
     *
     * @param userID                an int that is the user ID
     * @param placeID               an int that is the selected place ID
     */
    public void assignUserToRoomPlace(int userID, int placeID)
    {

    }

    /**
     * Temporary method to generate rooms.
     */
    public static void generateDefaultRooms()
    {

        Room room1 = new Room();
    }
}
