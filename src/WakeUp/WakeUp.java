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
 *  @since   2018-11-x
 *
 */
public class WakeUp {
    private static Scanner userInput = new Scanner(in);  // User input

    public static void main(String args[]) {
        mainMenu();
    }

    /**
     * Menu default to all users.
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
                        registerUser();
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
     */
    private static void loggedInMenu() {
        int selection = 0;

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
    private static void registerUser() {

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
    public static String menuSelectionFailed = "Ogiltigt alternativ";
    public static String menuHeader = "\n - WakeUP Gym - ";
    public static String mainMenuAlternatives = "\nVälkommen!\n1.Logga in\n2.Registrera Användare\n9.Avsluta";
    public static String loggedInMenuAlternatives = "\nVälkommen!\n1.Boka plats på aktivitet\n9.Logga ut";
    public static String makeSelectionPrompt = "\n\nVar god välj ett alternativ:";
    public static String mainMenu = menuHeader + mainMenuAlternatives + makeSelectionPrompt;
    public static String loggedInMenu = menuHeader + loggedInMenuAlternatives + makeSelectionPrompt;
}