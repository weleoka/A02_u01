package WakeUp;

/**
 * Class representing a user of the system.
 *
 */
public class User extends CSVDB {
    private static String name;
    private static String id;
    private static Status status; // enum class Status
    // Default empty constructor.
    User() {}
    // Constructor for creating a new user.
    User(String userName, String userID) {
        this.name = userName;
        this.id = userID;
        this.status = status.INACTIVE;
    }
    // Constructor for loading user from DB.
    User(String[] userArr) {
        this.name = userArr[0];
        this.id = userArr[1];
        this.setStatus(userArr[2]);
    }




    /**
     * Toggle the user status to active.
     */
    public void setActive()
    {
        this.status = status.ACTIVE;
    }

    /**
     * Toggle the user status to inactive.
     */
    public void setInactive()
    {
        this.status = status.INACTIVE;
    }

    /**
     * Toggle the user status to removed.
     */
    public void setRemoved()
    {
        this.status = status.REMOVED;
    }




    public String getID()
    {

        return this.id;
    }

    public String getName()
    {

        return this.name;
    }

    public String getStatus()
    {

        return this.status.toString();
    }




    /**
     * Helper to make a string into the correct status enum call.
     *
     * @param sta               a String of the status to set
     */
    private void setStatus(String sta)
    {

        switch (sta.toLowerCase())
        {
            case "active":
                this.status = status.ACTIVE;
                break;

            case "inactive":
                this.status = status.INACTIVE;
                break;

            case "removed":
                this.status = status.REMOVED;
                break;
        }
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
                this.status.toString()
        };

        return tmpArr;
    }
}
