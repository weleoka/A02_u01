package WakeUp;

import java.util.List;

/**
 * Singleton control class for working with Room instances.
 */
public class RoomControl
{
    // Fields declared
    private CSVDB roomDB;
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
     *
     * @param activity              a String of the activity to look for
     */
    public boolean selectRoomByActivity(String activity)
    {
        List<String[]> roomList = this.roomDB.readCSVFull();

        for (String[] roomArr : roomList)
        {

            if (activity.equalsIgnoreCase(roomArr[1]))
            {
                this.selectedRoom = new Room(roomArr);

                return true;
            }
        }

        return false;
    }

    /**
     * This sets the selected room depending on room ID..
     *
     * @param roomID                a String of the roomID to look for
     */
    public boolean selectRoomByRoomID(String roomID)
    {
        List<String[]> roomList = this.roomDB.readCSVFull();

        for (String[] roomArr : roomList)
        {

            if (roomID.equalsIgnoreCase(roomArr[1]))
            {
                this.selectedRoom = new Room(roomArr);

                return true;
            }
        }

        return false;
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
     * Create a new room from parameters
     *
     * todo: write the room to database directly without going toArray method etc.
     *
     * @param array     a string[] of the the following and in this order:
     *      id               a String of the room's identifier
     *      activity         a String representing the activity to set for the room
     *      rows             a String of the number of rows in the room
     *      columns          a String of the number of columns in the room
     *
     * @return boolean      it is true if the room was created successfully
     */
    public boolean createRoom(String[] array)
    {
        this.selectedRoom = new Room(array);
        this.roomDB.writeCSVLine(this.selectedRoom.toArray());

        return true;
    }
}
