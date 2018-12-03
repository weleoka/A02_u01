package WakeUp;

/**
 * Class representing a user of the system.
 *
 */
public class User extends Dbitem {
    private static String name;
    private static int id;
    protected static Status status; // enum class Status

    // Constructor for creating a new user.
    User(String userName, int userID) {
        this.name = userName;
        this.id = userID;
    }

    /**
     * Toggle the user status to active.
     */
    public void setActive() {
        this.status = status.ACTIVE;
    }

    /**
     * Toggle the user status to inactive.
     */
    public void setInactive() {
        this.status = status.INACTIVE;
    }

    /**
     * Toggle the user status to removed.
     */
    public void setRemoved() {
        this.status = status.REMOVED;
    }


    /**
     * toString override
     */
    @Override
    public String toString() {
        String s = super.toString();
        return s;
    }


}
