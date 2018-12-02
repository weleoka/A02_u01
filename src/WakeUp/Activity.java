package WakeUp;

/**
 * Different available activities.
 */
public enum Activity {
    SPINNING("Spinning"),
    AEROBICS("Aerobics"),
    YOGA("Yoga");

    private final String name;

    Activity(String name) {
        this.name = name;
    }

    //Override för att skriva ut enum med små bokstäver.
    @Override
    public String toString() {
        return this.name;
    }
}
