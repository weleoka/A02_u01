package WakeUp;

/**
 * Different available activities.
 */
public enum Activity
{
    SPINNING        ("Spinning"),
    AEROBICS        ("Aerobics"),
    YOGA            ("Yoga"),
    UNASSIGNED      ("Unassigned");

    private final String name;

    Activity(String name)
    {
        this.name = name;
    }

    // Override to print pretty name.
    @Override
    public String toString()
    {
        final String name = this.name;
        return name;
    }
}
