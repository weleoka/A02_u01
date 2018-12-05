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
    // Singleton
    private static UserControl ourInstance = new UserControl();
    public static UserControl getInstance() {
        return ourInstance;
    }
    // Constructor
    private UserControl() {
        this.userDB = new CSVDB("./userDB.csv");
    }
    // Fields declared
    private static CSVDB userDB;
    private User selectedUser;  // holds the user object that is subject to operations.
    private User authenticatedUser; // holds a reference to the user object if isAuthenticated.




    /**
     * Read from storage and find a user by user name.
     *
     * If found then set selectedUser to new instance with attributes set.
     *
     * @param userName              a String of the name too look for
     */
    public boolean selectUserByName(String userName) {
        List<String[]> userList = this.userDB.readCSVFull();

        for (String[] userArr : userList) {

            if (userName == userArr[0]) {
                this.selectedUser = new User(userArr);

                return true;
            }
        }

        return false;
    }

    /**
     * Read from storage and find a user by user id.
     *
     * If found in DB then set selectedUser to relevant instance.
     *
     * @param userID                a String of the users id to look for
     */
    public boolean selectUserByUserID(String userID) {
        List<String[]> userList = this.userDB.readCSVFull();

        for (String[] userArr : userList) {

            if (userID == userArr[1]) {
                this.selectedUser = new User(userArr);

                return true;
            }
        }

        return false;
    }




    /**
     * Checks if authenticatedUser is set and returns result
     *
     * @return boolean              true if user is set and thus logged in
     */
    public boolean isAuthenticatedUser () {

        if (this.authenticatedUser instanceof User) {

            return true;
        }

        return false;
    }

    /**
     * setAuthenticated
     *
     * The selectedUser variable should already be set before this method is called.
     * This method implements a check that the supplied UserID matches the stored selectedUser.id.
     */
    public void loginSelectedUser(String userID) {
        if (userID == this.selectedUser.getSelectedUserID()) {
            this.authenticatedUser = this.selectedUser;
        }
    }

    /**
     * set authenticatedUser to null.
     */
    public void logoutSelectedUser() {
        this.authenticatedUser = null;
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
    public boolean removeSelectedUser() {
        this.selectedUser.setRemoved();
        return true;
    }
}
