package WakeUp;
import java.io.IOError;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;   // Take user input from the console.
import static java.lang.System.*; // input and output to the console.

/**
 *  Execution controller class for WakeUp Gym UI.
 *
  * @author  Kai Weeks
 *  För D0019N - Assignment 2 - WakeUp Gym
 *
 *  @version na
 *  @since   2018-12-10
 *
 *  todo: divide and conquer the authenticated and non-authenticated options into different classes.
 *
 */
public class WakeUp {
    private static Scanner userInput = new Scanner(in);  // User input
    private static UserControl USERCONTROL = UserControl.getInstance();
    private static RoomControl ROOMCONTROL = RoomControl.getInstance();
    private static SubscriptionControl SUBSCRCONTROL = SubscriptionControl.getInstance();

    /**
     * Program entry point.
     *
     * @param args              none required
     */
    public static void main(String args[])
    {
        mainMenu();
    }




    /**
     * Menu default to all users.
     *
     * Items:
     * 1) Login User
     * 2) Create User
     * 9) Quit Application
     *
     * todo: test the inputLoop breaking and what happens to following switch cases.
     */
    private static void mainMenu()
    {
        int selection = 0;

        inputLoop: while (true)
        {
            out.println(UI_strings.mainMenu);

            if (userInput.hasNextInt()) {
                selection = userInput.nextInt();

                switch (selection) {

                    case 1:
                        if (loginUser())
                        {
                            out.println(UI_strings.successfullLogin);
                            loggedInMenu();
                            break inputLoop;
                        }

                        else
                        {
                            out.println(UI_strings.unsuccessfullLogin);
                            continue;
                        }

                    case 2:
                        createUser();
                        break inputLoop;

                    case 3: // Secret case for making default rooms.
                        generateDefaultRooms();
                        break inputLoop;

                    case 4: // Secret case for booking an activity.
                        bookActivity();

                    case 9:
                        quit();
                        break inputLoop;
                }
                userInput.next(); // flush the in buffer

            }

            else
            {
                out.println(UI_strings.menuSelectionFailed);
            }
        }
    }

    /**
     * Menu displaid to a user when it is authenticated.
     *
     * Items:
     * 1. Book Activity
     * (2. Change Subscription)
     * 9. Return to Main Menu
     *
     */
    private static void loggedInMenu()
    {
        int selection;

        if (!USERCONTROL.isAuthenticatedUser()) {
            out.println(UI_strings.userNotAuthenticated);
            mainMenu();
        }

        inputLoop: while (true)
        {
            out.println(UI_strings.loggedInMenu);

            if (userInput.hasNextInt()) {
                selection = userInput.nextInt();

                switch (selection)
                {

                    case 1:
                        bookActivity();
                        break inputLoop;

                    case 9:
                        logoutUser();
                        break inputLoop;
                }
            }

            else
            {
                System.out.println(UI_strings.menuSelectionFailed);
            }
            userInput.next(); // flush the in buffer
        }
    }

    /**
     * Simple name and password prompt
     *
     * @returns tmpArr             an array of name and password pair
     */
    private static String[] credentialsPrompt()
    {
        userInput.nextLine(); // flush the input buffer
        out.println(UI_strings.promptUserName);
        String userName = userInput.nextLine(); // To accept whitespace.
        out.println(UI_strings.promptUserID);
        String userID = userInput.nextLine();
        String[] tmpArr = {userName, userID};

        return tmpArr;
    }

    /**
     * Select activity prompt
     *     * todo: catch error if instantiating non-valid activity ENUM.
     *      *  - Seems to require an explicit throwing of an exception.
     *      * try {
     *      *     this.url = new URL(url);
     *      * }
     *      * catch(MalformedURLException e) {
     *      *     throw new AssertionError(e);
     *      * }
     * @return boolean          true if the room and activity have been set
     */
    private static boolean selectActivityPrompt()
    {
        int i;
        int selection;
        String output = "";
        String [] activities = ROOMCONTROL.getRoomActivities();
        // Render the menu selections outside of the input loop.
        for (i = 0; i <= activities.length - 1; i++)
        {
            output += String.format("\n%s: %s", (i + 1), activities[i]);
        }

        inputLoop: while (true)
        {
            out.println(output);    // Print the possible options.
            out.println(UI_strings.selectActivityPrompt);

            if (userInput.hasNextInt())
            {
                selection = userInput.nextInt();

                try
                {

                    if (ROOMCONTROL.selectRoomByActivity(activities[selection - 1]))
                    {

                        break inputLoop;
                    }
                }

                catch (IOError e) // big fat enum error and others here:
                {
                    out.println(UI_strings.noSuchActivity);
                }

            }

            else
            {
                System.out.println(UI_strings.menuSelectionFailed);
                userInput.next(); // flush the in buffer.
            }
        }

        return true;
    }

    /**
     * Select room place prompt
     *
     * todo: DRY the two else clauses.
     * todo: Bug: when selecting the same place again as was chosen before and the
     *  user was assigned to it then the input is not parsed. Also does it if entering
     *  incorrect room ID and then a correct one. Something to do with Scanner.
     *
     * @return selection             a String of the selected place (2a, or 2c, etc.)
     */
    private static String selectRoomPlacePrompt()
    {
        int i;
        String selection;
        String output = ROOMCONTROL.fetchRoomPlacesString();
        List<String> placesIDs = ROOMCONTROL.fetchRoomPlacesList();

        inputLoop: while (true)
        {
            out.println(output);
            out.println(UI_strings.selectRoomPlacePrompt);
            out.println(placesIDs.toString());

            if (userInput.hasNext())
            {
                selection = userInput.next().toLowerCase();

                if (placesIDs.indexOf(selection) >= 0)  // Its a valid room ID.
                {

                    break;
                }
                else
                {
                    System.out.println(UI_strings.menuSelectionFailed);
                }
            }

            else
            {
                System.out.println(UI_strings.menuSelectionFailed);
            }
            userInput.next(); // flush the input buffer.
        }

        return selection;
    }




    /**
     * Steps for logging user in.
     *
     * @return boolean
     */
    private static boolean loginUser()
    {
        String[] creds = credentialsPrompt();

        if (USERCONTROL.selectUserByName(creds[0])) // Find user in the db.
        {
            out.println(UI_strings.userNameFound);

            if (WakeUpHelpers.validateUserID(creds[1])) // Test validity of supplied ID.
            {
                out.println(UI_strings.userIDValid);

                if (USERCONTROL.loginSelectedUser(creds[1]))
                {    // Test ID and name pair for match in db.

                    return true;

                }

                else
                {
                    out.println(UI_strings.userNameToIDMissmatch);

                    return false;
                }

            }

            else
            {
                out.println(UI_strings.userIDInvalid);

                return false;
            }

        }

        else
        {
            out.println(UI_strings.userNameNotFound);

            return false;
        }

    }

    /**
     * Steps for logging user out.
     */
    private static void logoutUser()
    {
        USERCONTROL.logoutSelectedUser();
        out.println(UI_strings.logoutSuccessfull);
        mainMenu();
    }




    /**
     * Handles booking an activity.
     * Requires a logged in user.
     *
     */
    private static void bookActivity()
    {
        if (selectActivityPrompt())
        {
            inputLoop: while (true)
            {
                String placeID = selectRoomPlacePrompt();

                if (ROOMCONTROL.assignUserToRoomPlace(placeID, USERCONTROL.getSelectedUserID()))
                {
                    out.println(UI_strings.assignedUserToPlace);

                    selectRoomPlacePrompt();
                }

                else
                {
                    out.println(UI_strings.assignedUserToPlaceFail);
                }
            }
        }
        out.println(UI_strings.bookingActivitySuccess);

    }




    /**
     * Registration process for a new user.
     */
    private static void createUser()
    {
        out.println(UI_strings.createUserHeader);
        String[] creds = credentialsPrompt();

        if (USERCONTROL.createUser(creds[0], creds[1]))
        {
            out.println(UI_strings.createUserSuccess);

        }

        else
        {
            out.println(UI_strings.createUserFail);
        }
        WakeUpHelpers.sleeper(1000);
        //createSubscription();
        loggedInMenu();
    }

    /**
     * Create a new subscription.
     * Requires a logged in user.
     */
    private static void createSubscription()
    {

    }

    /**
     * Create and save to database default rooms.
     */
    private static void generateDefaultRooms()
    {
        String[] room1 = {
                "ID1",
                "yoga",
                "3",
                "3"
        };
        String[] room2 = {
                "ID2",
                "aerobics",
                "4",
                "4"
        };
        String[] room3 = {
                "ID3",
                "spinning",
                "3",
                "3"
        };

        ROOMCONTROL.createRoom(room1);
        ROOMCONTROL.createRoom(room2);
        ROOMCONTROL.createRoom(room3);
        out.println("Rooms generated");
        mainMenu();
    }

    /**
     * End the application.
     */
    private static void quit()
    {
        out.println(UI_strings.goodbyeString);
        System.exit(0);
    }
}




/**
 * Language specific strings for usage in WakeUP Gym UI class
 */
class UI_strings
{
    // Menus and selection
    public static String menuSelectionFailed = "Ogiltigt alternativ";
    public static String menuHeader = "\n - - - WakeUP Gym - - -";
    public static String mainMenuAlternatives = "\n1.Logga in\n2.Registrera Användare\n9.Avsluta";
    public static String loggedInMenuAlternatives = "\n1.Boka plats på aktivitet\n9.Logga ut";
    public static String makeSelectionPrompt = "\n\nVar god välj ett alternativ:";
    public static String mainMenu = menuHeader + mainMenuAlternatives + makeSelectionPrompt;
    public static String loggedInMenu = menuHeader + loggedInMenuAlternatives + makeSelectionPrompt;
    public static String goodbyeString = "\n\nHej då, och tack för besöket.";

    // User creation
    public static String createUserHeader = "--> Skapa Ny Användare";
    public static String promptUserName = "Skriv användarnamn:";
    public static String promptUserID = "Skriv användar id:";
    public static String userNameExists = "Användarnamnet finns redan.";
    public static String userIDExists = "Användarens ID finns redan.";
    public static String createUserSuccess = "Användaren skapades.";
    public static String createUserFail = "Något gick fel. Försök igen.";

    // User authorisation
    public static String userNotAuthenticated = "Ej inloggad.";
    public static String userNameFound = "Användaren hittades i databasen.";
    public static String userNameNotFound = "Användaren hittades inte i databasen.";
    public static String userIDValid = "Användarens ID är giltigt.";
    public static String userIDInvalid = "Användarens ID är ogiltigt.";
    public static String userNameToIDMissmatch = "Användarens Namn och ID är inte ett giltigt par.";
    public static String successfullLogin = "Log-in lyckades. Välkommen.";
    public static String unsuccessfullLogin = "Log-in misslyckades. Försök igen.";
    public static String logoutSuccessfull = "Du är nu utloggad.";

    // Activity booking
    public static String noSuchActivity = "Den aktiviteten finns inte. Försök igen.";
    public static String selectActivityPrompt = "Välj aktivitet:";
    public static String selectRoomPlacePrompt = "Välj plats (ex. 2b eller 1d): ";
    public static String assignedUserToPlace = "Du har registrerats på platsen i rummet.";
    public static String assignedUserToPlaceFail = "Den platsen är redan bokad.";

    public static String bookingActivitySuccess = "Bra! Aktiviteten är bokad!";

}