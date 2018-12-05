package WakeUp;

import java.util.Date;


/**
 * Singleton class handling subscriptions.
 *
 * Methods work mostly on a single selected instance of a Subscription
 * which is fetched from storage by argument to method call.
 */
public class SubscriptionControl {
    // Singleton
    private static SubscriptionControl ourInstance = new SubscriptionControl();
    public static SubscriptionControl getInstance() {
        return ourInstance;
    }
    // Constructor
    private SubscriptionControl() {
    }
    // Fields declared
    private static Subscription selectedSubscription;   // Populated with valid subscription.

    /**
     * Calculates the cost of a subscription.
     *
     * The subscription price depends on the time period.
     *
     * @return double           the sum of the subscription cost
     */
    public double calculateCost() {
        double priceTotal = 100.99;

        return priceTotal;
    }

    /**
     * A subscription needs a start timestamp and an end timestamp.
     * Also a user ID has to be attached to it.
     *
     * @param sDate             a timestamp for the start
     * @param eDate             a timestamp for the end
     * @param userID            a String which is the userID to attach
     */
    public void createSubscription(Date sDate, Date eDate, int userID) {

    }

    /**
     * Remove subscription
     * Sets the status to removed.
     */
    public void removeSelectedSubscription() {

    }

    /**
     * Fetch a Subscription from storage by userID
     *
     * @param userID            a String to query storage items for
     */
    public Subscription selectSubscriptionByUserId(int userID) {
        return this.selectedSubscription;
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
    public void changeSelectedSubscription(Date sDate, Date eDate, int userID) {

    }
}
