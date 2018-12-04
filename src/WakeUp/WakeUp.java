package WakeUp;
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
 */
public class WakeUp {
    private static Scanner userInput = new Scanner(in);  // User input
    private static UserControl USERCONTROL = UserControl.getInstance();
    private static RoomControl ROOMCONTROL = RoomControl.getInstance();
    private static SubscriptionControl SUBSCRCONTROL = SubscriptionControl.getInstance();

    /**
     * Program entry point.
     *
     * @param args
     */
    public static void main(String args[]) {
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
    private static void mainMenu() {
        int selection = 0;

        inputLoop: while (true) {
            out.println(UI_strings.mainMenu);

            if (userInput.hasNextInt()) {
                selection = userInput.nextInt();

                switch (selection) {

                    case 1:
                        loginUser();
                        break inputLoop;

                    case 2:
                        createUser();
                        break inputLoop;

                    case 9:
                        quit();
                        break inputLoop;
                }

            } else {
                out.println(UI_strings.menuSelectionFailed);
                userInput.next(); // flush the in buffer
            }
            break;
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
    private static void loggedInMenu() {
        int selection = 0;

        if (!USERCONTROL.authenticatedUser()) {
            out.println(UI_strings.userNotAuthenticated);
            mainMenu();
        }

        inputLoop: while (true) {
            out.println(UI_strings.loggedInMenu);

            if (userInput.hasNextInt()) {
                selection = userInput.nextInt();

                switch (selection) {

                    case 1:
                        bookActivity();
                        break inputLoop;

                    case 9:
                        mainMenu();
                        break inputLoop;
                }

            } else {
                System.out.println(UI_strings.menuSelectionFailed);
                userInput.next(); // flush the in buffer
            }

            break;
        }
    }

    /**
     * Steps for logging user in.
     */
    private static void loginUser() {
        userInput.nextLine(); // flush the input buffer
        loggedInMenu();
    }

    /**
     * Handles booking an activity.
     */
    private static void bookActivity() {

    }

    /**
     * Registration process for a new user.
     */
    private static void createUser() {
        userInput.nextLine(); // flush the input buffer
        out.println(UI_strings.createUserHeader);
        out.println(UI_strings.enterNewUserName);
        String userName = userInput.nextLine(); // To accept whitespace.

        out.println(UI_strings.enterNewUserID);
        String userID = userInput.nextLine();
        //userInput.next(); // flush the in buffer
        // Must not accept blankspace as a scanner.next() divider.

        if (USERCONTROL.createUser(userName, userID)) {
            out.println(UI_strings.createUserSuccess);
        } else {
            out.println(UI_strings.createUserFail);
        }
        WakeUpHelpers.sleeper(1000);
        //createSubscription();
        loggedInMenu();
    }

    private static void createSubscription() {

    }

    /**
     * End the application.
     */
    private static void quit() {
        System.exit(0);
    }
}


/**
 * Language specific strings for usage in WakeUP Gym UI class
 */
class UI_strings {
    
    // Menus and selection
    public static String menuSelectionFailed = "Ogiltigt alternativ";
    public static String menuHeader = "\n - - - WakeUP Gym - - -";
    public static String mainMenuAlternatives = "\nVälkommen!\n1.Logga in\n2.Registrera Användare\n9.Avsluta";
    public static String loggedInMenuAlternatives = "\nVälkommen!\n1.Boka plats på aktivitet\n9.Logga ut";
    public static String makeSelectionPrompt = "\n\nVar god välj ett alternativ:";
    public static String mainMenu = menuHeader + mainMenuAlternatives + makeSelectionPrompt;
    public static String loggedInMenu = menuHeader + loggedInMenuAlternatives + makeSelectionPrompt;
    
    // User creation and authorisation
    public static String createUserHeader = "--> Skapa Ny Användare";
    public static String enterNewUserName = "Skriv ett nytt användarnamn:";
    public static String enterNewUserID = "Skriv in ett nytt användar id:";
    public static String userNameExists = "Användarnamnet finns redan.";
    public static String userIDExists = "Användarens ID finns redan.";
    public static String createUserSuccess = "Användaren skapades.";
    public static String createUserFail = "Något gick fel. Försök igen.";
    public static String userNotAuthenticated = "Ej inloggad.";



    // Activity booking
    

    
}