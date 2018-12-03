package WakeUp;

import java.util.Date;

/**
 * Class representing a subscription for a user of WakeUp Gym.
 */
public class Subscription {
    private static Date sDate;
    private static Date eDate;
    private static int userID; // Development int. later String.
    private static Status status; // enum class Status.








    /**
     * Set the starting date.
     *
     * @param sDate             a timestamp for start
     */
    public void setSDate(Date sDate) {
        this.sDate = sDate;
    }


    /**
     *  Set the ending date.
     *
     * @param eDate             a timestamp for end
     */
    public void setEDate(Date eDate) {
        this.eDate = eDate;
    }

    /**
     * Toggle to active.
     */
    public void setActive() {
        this.status = status.ACTIVE;
    }

    /**
     * Toggle to active.
     */
    public void setInactive() {
        this.status = status.INACTIVE;
    }

    /**
     * Toogle to removed.
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
