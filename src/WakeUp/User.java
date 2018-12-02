package WakeUp;

/**
 * Class representing a user of the system.
 */
public class User {
    private static String name;
    private static String id;
    protected static Status status; // enum class Status

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
        return super.toString();
    }


}
