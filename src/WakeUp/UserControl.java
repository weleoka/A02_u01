package WakeUp;

import java.util.List;

/**
 * Currently handling details of reading and writing USer to a string for
 * saving in the database. The array is as follows:
 *
 * userArr[0] is the userName
 * userArr[1] is the userID
 * userArr[2] is the status
 *
 * todo: move the user to/from database logic to User class.
 */
public class UserControl {
    private static UserControl ourInstance = new UserControl();

    // Extras
    private static CSVDB userDB;
    private User selectedUser;

    public static UserControl getInstance() {
        return ourInstance;
    }
    private UserControl() {
        this.userDB = new CSVDB("./userDB.csv");
    }

    /**
     * Read from storage and find a user by user name.
     *
     * If found then set selectedUser to new instance with attributes set.
     *
     * @param userName              a String of the name too look for
     */
    public void selectUserByName(String userName) {
        List<String[]> userList = this.userDB.readCSVFull();

        for (String[] userArr : userList) {
            if (userName == userArr[0]) {
                this.selectedUser = new User(userArr);
            }
        }
    }

    /**
     * Read from storage and find a user by user id.
     *
     * If found in then set selectedUser to relevant instance.
     *
     * @param userID                a String of the users id to look for
     */
    public void selectUserByUserID(String userID) {
        List<String[]> userList = this.userDB.readCSVFull();

        for (String[] userArr : userList) {
            if (userID == userArr[1]) {
                this.selectedUser = new User(userArr);
            }
        }
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
     * todo: implement checks to make sure no duplicate users can be created.
     *
     * @param userName              a String of the new user name
     * @param userID                a string of the new user ID
     * @return boolean              true if user was created
     */
    public boolean createUser(String userName, String userID) {
        this.selectedUser = new User(userName, userID);
        this.userDB.writeCSVLine(this.selectedUser.toArray());
        return true;
    }

    /**
     * Remove a user.
     */
    public void removeUser() {
        this.selectedUser.setRemoved();
    }

    /**
     * Checks if selectedUSer is set and returns result
     *
     * @return boolean              true if user is set and thus logged in
     */
    public boolean authenticatedUser () {
        if (this.selectedUser instanceof User) {
            return true;
        }
        return false;
    }
}
