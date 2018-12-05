package WakeUp;


/**
 * Enum holding the different statuses of users, and also their subscriptions.
 *
 * Currently the following statuses exist:
 * ACTIVE: A user that has a valid membership, or a Subscription that has been "paid".
 * INACTIVE: A user that has not yet OK:ed their membership fees, or a subscription that is not paid.
 * REMOVED: A user that has ended their membership, or a subscription that has been removed.
 *
 */
public enum Status {
    ACTIVE      ("Aktiv"),
    INACTIVE    ("Inaktiv"),
    REMOVED     ("Borttagen");

    private final String name;

    // Constructor
    Status(String name) {
        this.name = name;
    }

    // Override to print name.
    @Override
    public String toString(){
        final String name = this.name;
        return name;
    }
}
