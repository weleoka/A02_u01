package WakeUp;

/**
 * Class representing a user of the system.
 *
 * The status of the user signifies if they have a membership.
 *
 */
public class User {
    private String id;
    private String name;
    private boolean status = false; // By default users are inactive
    // Default empty constructor.
    User() {}
    // Constructor for creating a new user.
    User(String userName, String userID) {
        this.name = userName;
        this.id = userID;
        this.status = false;
    }
    // Constructor for loading user from DB.
    User(String[] userArr) {
        this.name = userArr[0];
        this.id = userArr[1];
        this.setStatus(Boolean.valueOf(userArr[2]));
    }

    /**
     *
     * @return
     */
    public String getID()
    {

        return this.id;
    }




    /**
     *
     * @return name             a String return type
     */
    public String getName()
    {

        return this.name;
    }

    /**
     *
     * @return status           a boolean true if active else false
     */
    public boolean getStatus()
    {

        return this.status;
    }

    /**
     * Helper to make a string into the correct status enum call.
     *
     * @param status               a boolean of the status to set
     */
    public void setStatus(boolean status)
    {
        this.status = status;
    }




    /**
     * toString override
     */
    @Override
    public String toString()
    {
        String s = super.toString();

        return s;
    }

    /**
     * Create an array representation of the object.
     *
     * @return tmpArr               an array of the object attributes
     */
    public String[] toArray()
    {
        String[] tmpArr = {
                this.name,
                this.id,
                String.valueOf(this.status)
        };

        return tmpArr;
    }
}
