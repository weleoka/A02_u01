package WakeUp;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Date;

/**
 * Class representing a subscription for a user of WakeUp Gym.
 *
 * Serialised it looks like the following:
 *
 *                 this.sDate.toString(),
 *                 this.eDate.toString(),
 *                 this.userID,
 *                 this.status.toString()
 */
public class Subscription {
    private LocalDate sDate;
    private LocalDate eDate;
    private String userID;
    private boolean status = true; // By default subscrtiptions are active.
    // Constructor for creating new subscription
    Subscription(String userID, int months)
    {
        this.sDate = LocalDate.now();
        this.eDate = sDate.plusMonths(months);
    }

    // Constructor for creating new subscription
    Subscription(LocalDate sDate, LocalDate eDate, String userID)
    {
        this.sDate = sDate;
        this.eDate = eDate;
        this.userID = userID;
    }

    // Constructor for loading subscription from DB.
    Subscription(String[] subscriptionArr) {
        LocalDate sDate = LocalDate.parse(subscriptionArr[0]);
        LocalDate eDate = LocalDate.parse(subscriptionArr[1]);
        this.setStatus(Boolean.valueOf(subscriptionArr[2]));
        this.userID = subscriptionArr[3];
    }




    // Getters and setters

    /**
     * Get the number of months duration of the subscription.
     *
     * @return months               an int with the number of months of the subscription
     */
    public int getMonths()
    {
        int months;
        long numberOfDays = Duration.between(this.eDate, this.sDate).toDays();
        months = Math.toIntExact(numberOfDays / 30);

        return months;
    }


    /**
     * Get the starting date.
     *
     * @return sDate             a timestamp for start time
     */
    public LocalDate getSDate()
    {

        return this.sDate;
    }

    /**
     * Set the starting date.
     *
     * @param sDate             a timestamp for start
     */
    public void setSDate(LocalDate sDate)
    {
        this.sDate = sDate;
    }


    /**
     * Get the ending date.
     *
     * @return eDate             a timestamp for end time
     */
    public LocalDate getEDate()
    {

        return this.eDate;
    }

    /**
     *  Set the ending date.
     *
     * @param eDate             a timestamp for end
     */
    public void setEDate(LocalDate eDate)
    {
        this.eDate = eDate;
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
     * @param status             a boolean of the status to set
     */
    private void setStatus(boolean status)
    {
        this.status = status;
    }




    // Other methods

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
                this.sDate.toString(),
                this.eDate.toString(),
                this.userID,
                String.valueOf(this.status)
        };

        return tmpArr;
    }
}
