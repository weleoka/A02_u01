package WakeUp;

public class RoomControl {
    private static RoomControl ourInstance = new RoomControl();

    public static RoomControl getInstance() {
        return ourInstance;
    }

    private RoomControl() {
    }
}
