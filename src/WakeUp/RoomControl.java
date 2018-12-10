package WakeUp;

import java.util.Arrays;
import java.util.HashMap;
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
     * todo: implement a check of the enum Activities to find type
     *  return them in a LinkedList.
     *
     * @return String[]         an array of available activities
     */
    public String[] getRoomActivities()
    {
        String[] activitiesList = {"Spinning", "Aerobics", "Yoga"};
        //List<String> activities = new LinkedList<String>();
        //activities = Room.getActivities();
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
     * This will return the list of all places in a room,
     * in a pretty String format for printing.
     *
     * @return allPlaces            an array of all places in a room
     */
    public String fetchRoomPlacesString()
    {
        String allPlaces = this.selectedRoom.toString();

        return allPlaces;
    }

    /**
     * This will return the list of all places in a room.
     *
     * @return allPlaces            an array of all places in a room
     */
    public List<String> fetchRoomPlacesList()
    {
        List<String> allPlaces = this.selectedRoom.getAllPlaces();

        return allPlaces;
    }

    /**
     * This will return the list of all places in a room and
     * the relevant userIDs for places booked. Used for storing
     * bookings in the database.
     *
     * @return allPlaces            a HashMap of placeID -> userID pairs
     */
    public HashMap<String, String> fetchRoomPlacesBookingsList()
    {
        HashMap<String, String> hm = this.selectedRoom.getAllBookingsPlaces();

        return hm;
    }




    /**
     * Set a User ID to a certain place in the room
     *
     * The place Id has to be in the format Letter + Number (Char + Int)
     *
     * todo: get a String[] of all letter-number places pairs and make sure
     *  that user input is one of these to catch faulty input.
     *
     * @param placeID               a String that is the selected place ID
     * @param userID                a String that is the selected user ID
     */
    public boolean assignUserToRoomPlace(String placeID, String userID)
    {
        String[] parts = placeID.trim().split("(?<=.)"); //"(?<=[a-zA-Z])");
        System.out.println(Arrays.toString(parts));
        //String[] parts = placeID.split("(\\S+)(\\d)");
        //String[] parts = source.split("(?<=\\d)(?=\\D)|(?<=\\D)(?=\\d)");
        if (parts.length == 2)  // only allow two characters
        {

            if (this.selectedRoom.setBookedPlace(parts, userID))
            {

                return true;
            }
        }

        return false;
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
