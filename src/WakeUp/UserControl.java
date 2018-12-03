package WakeUp;

public class UserControl {
    private static UserControl ourInstance = new UserControl();
    private User selectedUser;

    public static UserControl getInstance() {
        return ourInstance;
    }

    private UserControl() {
    }

    /**
     * Add a new user
     *
     */
    public void addUser() {
        User tmpUser = new User();
    }

    /**
     *
     *
     */
    public void removeUser() {
        this.selectedUser.status = this.selectedUser.status.REMOVED;
    }

    /**
     *
     *
     */
    public void selectUserByName(String name) {


    }

    /**
     *
     *
     */
    public void selectUserByUserID(int userID) {

    }

    /**
     *
     *
     */
    private void loginUser() {

    }

    /**
     *
     *
     */
    public void logoutUser() {

    }
}
