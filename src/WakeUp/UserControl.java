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
     * Read from storage and find a user by user name.
     *
     * If found then set selectedUSer to relevant instance.
     *
     * @param userName              a String of the name too look for
     */
    public void selectUserByName(String userName) {

    }

    /**
     * Read from storage and find a user by user id.
     *
     * If found in then set selectedUser to relevant instance.
     *
     * @param userID                a String of the users id to look for
     */
    public void selectUserByUserID(int userID) {

    }

    /**
     *
     */
    private void loginSelectedUser() {

    }

    /**
     *
     */
    public void logoutSelectedUser() {

    }

    /**
     * Create a new user.
     *
     * @param userName              a String of the new user name
     * @param userID                a string of the new user ID
     */
    public void createUser(String userName, int userID) {
        User tmpUser = new User(userName, userID);
    }

    /**
     * Remove a user.
     */
    public void removeUser() {
        this.selectedUser.setRemoved();
    }

}
