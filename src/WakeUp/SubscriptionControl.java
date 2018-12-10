package WakeUp;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;


/**
 * Singleton class handling subscriptions.
 *
 * Methods work mostly on a single selected instance of a Subscription
 * which is fetched from storage by argument to method call.
 */
public class SubscriptionControl
{
    // Fields declared
    private Subscription selectedSubscription;   // Populated with valid subscription.
    private CSVDB subscriptionDB;
    // Singleton
    private static SubscriptionControl ourInstance = new SubscriptionControl();
    public static SubscriptionControl getInstance()
    {

        return ourInstance;
    }
    // Constructor
    private SubscriptionControl()
    {
        this.subscriptionDB = new CSVDB("./subscriptionDB.csv");
    }


    /**
     * Calculates the cost of a subscription.
     *
     * The subscription price depends on the time period.
     *
     * todo: bring the pricelist in from an external source.
     * todo: calculate cost from selectedSubscription
     *
     * @return double           the sum of the subscription cost
     */
    public double calculateCost(int months)
    {
        double netPrice;
        final int basePrice = 250;
        double extra = 50;

        //if (!months) { m = this.selectedSubscription.getMonths();
        int m = months;

        if (m > 12) {
            netPrice = m * 250;
        }
        else if (m > 6) {
            netPrice = (m * 300);
        }
        else if (m > 2) {
            netPrice = (m * 350);
        }
        else {
            netPrice = (m * 400);
        }

        return netPrice;
    }


    /**
     * Checks that the subscription is valid.
     *
     * The time now() has to be within the attributes of sDate and eDate of the subscription instance.
     *
     * The status of the subscription also has to be active!
     *
     * @return boolean              true if the subscription is valid
     */
    public boolean checkSubscriptionValidNow()
    {
        LocalDate today = LocalDate.now();

        if (today.isAfter(this.selectedSubscription.getSDate()))
        {

            return (today.isBefore(this.selectedSubscription.getEDate()));
        }

        return false;
    }

    /**
     * Check the status of the subscription
     *
     * @return boolean              true if the subscription is active and in a valid timeframe.
     */
    public boolean getSubscriptionStatus()
    {

        return this.selectedSubscription.getStatus();
    }




    /**
     * A subscription needs a start timestamp and an end timestamp.
     * Also a user ID has to be attached to it.
     *
     * todo: implement validity checks of argument data.
     *
     * @param sDate             a LocalDate object for the start time
     * @param eDate             a LocalDate object for the end time
     * @param userID            a String which is the userID to attach to the subscription
     */
    public boolean createSubscription(LocalDate sDate, LocalDate eDate, String userID)
    {
        this.selectedSubscription = new Subscription(sDate, eDate, userID);
        this.subscriptionDB.writeCSVLine(this.selectedSubscription.toArray());

        return true;
    }

    /**
     * A subscription can be changed by setting a different
     * start and end timestamp. The user ID is always the same.
     *
     * If only one of the method parameters has a supplied argument the
     * existing value for the other attribute will be used.
     *
     * @param sDate             a timestamp for the new start
     * @param eDate             a timestamp for the new end
     */
    public void changeSelectedSubscription(Date sDate, Date eDate, int userID)
    {

    }

    /**
     * Remove subscription
     * Sets the status to removed.
     */
    public void removeSelectedSubscription()
    {

    }




    /**
     * Fetch a Subscription from storage by userID
     *
     * @param userID            a String to query storage items for
     * @return boolean          true if the Subscription was found
     */
    public boolean selectSubscriptionByUserId(String userID) throws ArrayIndexOutOfBoundsException
    {
            List<String[]> userList = this.subscriptionDB.readCSVFull();

            for (String[] subscriptionArr : userList)
            {

                if (userID.equalsIgnoreCase(subscriptionArr[2]))
                {
                    this.selectedSubscription = new Subscription(subscriptionArr);

                    return true;
                }
            }

            return false;
    }
}
