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
 * todo: move the to/from database logic to out into User class.
 * todo: pass the User instance to callers?
 */
public class UserControl {
    // Fields declared
    private CSVDB userDB;    // the database connection interface.
    private User selectedUser;  // user object that is subject to operations.
    private User authenticatedUser; // holds a reference to the user object if isAuthenticated.
    // Singleton
    private static UserControl ourInstance = new UserControl();
    public static UserControl getInstance()
    {
        return ourInstance;
    }
    // Constructor
    private UserControl()
    {
        this.userDB = new CSVDB("./userDB.csv");
    }




    /**
     * Read from storage and find a user by user name.
     *
     * If found then set selectedUser to new instance with attributes set.
     *
     * @param userName              a String of the name too look for
     */
    public boolean selectUserByName(String userName)
    {
        List<String[]> userList = this.userDB.readCSVFull();

        for (String[] userArr : userList) {

            if (userName.equalsIgnoreCase(userArr[0])) {
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
    public boolean selectUserByUserID(String userID)
    {
        List<String[]> userList = this.userDB.readCSVFull();

        for (String[] userArr : userList) {

            if (userID.equalsIgnoreCase(userArr[1])) {
                this.selectedUser = new User(userArr);

                return true;
            }
        }

        return false;
    }

    /**
     * Update the user in DB
     */
    public void updateUser()
    {
        boolean userFound = false;
        this.userDB.readCSVFull();
        String tmpName = this.selectedUser.getName();
        List<String[]> userList = this.userDB.readCSVFull();

        for (int i = 0; i < userList.size(); i++)
        {
            String[] userArr = userList.get(i);

            if (tmpName.equalsIgnoreCase(userArr[0]))
            {
                    userArr = this.selectedUser.toArray();
                    userList.set(i, userArr);
                    userFound = true;
                    break;
            }
        }

        if (userFound)
        {
            System.out.println("DEBUG: User found and updated.");
            this.userDB.writeCSVMultiLine(userList);
        }
    }

    /**
     * Print the entire user database to stdout.
     */
    public void printUserList()
    {
        List<String[]> userList = this.userDB.readCSVFull();

        for ( String[] user : userList)
        {

            for (String item : user)
            {
                System.out.println(item);
            }
        }
        System.out.println("==========================");
    }




    /**
     * Checks if authenticatedUser is set and returns result
     *
     * @return boolean              true if user is set and thus logged in
     */
    public boolean isAuthenticatedUser ()
    {

        if (this.authenticatedUser == null)
        {

            return false;
        }

        return true;
    }

    /**
     * return the ID of the selected user
     *
     * @return userID           true if user is set and thus logged in
     */
    public String getSelectedUserID ()
    {
        return this.selectedUser.getID();
    }


    /**
     * return the status of the selected user
     *
     * @return status           true if user is active else false
     */
    public boolean getSelectedUserStatus ()
    {
        return this.selectedUser.getStatus();
    }

    /**
     * return the status of the selected user
     *
     * @param status                boolean true if active
     */
    public void setSelectedUserStatus (boolean status)
    {
        this.selectedUser.setStatus(status);
        this.updateUser();
    }




    /**
     * setAuthenticated
     *
     * The selectedUser variable should already be set before this method is called.
     * This method implements a check that the supplied UserID matches the stored selectedUser.id.
     */
    public boolean loginSelectedUser(String userID)
    {
        //System.out.printf("'%s' VS '%s'", userID, this.selectedUser.getSelectedUserID()); //debug line.
        if (userID.equalsIgnoreCase(this.selectedUser.getID()))
        {
            this.authenticatedUser = this.selectedUser;

            return true;
        }

        return false;
    }

    /**
     * set authenticatedUser to null.
     */
    public void logoutSelectedUser()
    {
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
    public boolean createUser(String userName, String userID)
    {
        this.selectedUser = new User(userName, userID);
        this.userDB.writeCSVLine(this.selectedUser.toArray());

        return true;
    }
}
