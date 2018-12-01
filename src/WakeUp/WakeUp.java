package WakeUp;

/**
 *  Kontrollklass för exekvering.
 *
  * @author  Kai Weeks
 *  För D0019N - Assignment 2 - Gym WakeUp.WakeUp
 *
 *  @version na
 *  @since   2018-11-xx
 *
 *
 * Följande uppgift skall utföras som gruppuppgift med max 2 studenter per grupp.
 *
 * Programmet består av 4 delar, Meny, Autentisering, Kostnadsberäkning, och Aktivitetsbokning.
 *
 * Sedan så finns ju en extärn del; Användare (User) som även den kanske ska representeras med en klass i systemet.
 * I denna uppgift är det lämpligt att använda någon form av datastruktur för användaren. CSV, JSON på rader?
 *
 * Huvudmeny:
 * 1. Bli medlem
 * 2. Logga in
 * 3. Boka plats på aktivitet
 * 4. Avsluta
 *
 * Autentisering:
 * När man försöker bli medlem eller när man vill logga in, eller boka plats så skriver man in sitt personnummer för
 * autentisering. Ni behöver beräkna att personnumret som användaren använder är korrekt.
 *
 * Aktivitetsbokning:
 * Endast en användare som är inloggad och som är medlem får boka in sig på aktiviteter. Det finns 3
 * olika typer av aktiviteter (Spinning, Aerobics, och Yoga) och varje aktivitet har totalt 9 platser fördelat
 * på 3 rader i salen (rad 1-3, plats a, b, c).
 *
 * Medlemsskapsalternativ:
 * När man väljer att bli medlem så behöver man, förutom att autentisera sig med personnummer,
 * även välja ett medlemsskapsalternativ.
 *
 */

import java.util.Scanner;   // Take user input from the console.
import static java.lang.System.*; // input and output to the console.

class UI_strings {
   public static String menuSelectionFailed = "Ogiltigt alternativ";
   public static String menuHeader = "\n - WakeUP Gym - ";
   public static String mainMenuAlternatives = "\nVälkommen!\n1.Logga in\n2.Registrera Användare\n9.Avsluta";
   public static String loggedInMenuAlternatives = "\nVälkommen!\n1.Boka plats på aktivitet\n9.Logga ut";
   public static String makeSelectionPrompt = "\n\nVar god välj ett alternativ:";
   public static String mainMenu = menuHeader + mainMenuAlternatives + makeSelectionPrompt;
   public static String loggedInMenu = menuHeader + loggedInMenuAlternatives + makeSelectionPrompt;

}

public class WakeUp {
    private static Scanner userInput = new Scanner(in);  // User input

    public static void main(String args[]) {
        mainMenu();
    }

    private static void mainMenu() {
        int selection = 0;

        while (true) {
            out.println(UI_strings.mainMenu);

            if (userInput.hasNextInt()) {
                selection = userInput.nextInt();

                switch (selection) {

                    case 1:
                        loginUser();

                    case 2:
                        registerUser();

                    case 9:
                        quit();
                }

            } else {
                out.println(UI_strings.menuSelectionFailed);
                userInput.next(); // flush the in buffer
            }
        }
    }

    private static void loggedInMenu() {
        int selection = 0;

        while (true) {
            out.println(UI_strings.loggedInMenu);

            if (userInput.hasNextInt()) {
                selection = userInput.nextInt();

                switch (selection) {

                    case 1:
                        bookActivity();

                    case 9:
                        mainMenu();
                }

            } else {
                System.out.println(UI_strings.menuSelectionFailed);
                userInput.next(); // flush the in buffer
            }
        }
    }


    private static void loginUser() {
        loggedInMenu();
    }



    private static void bookActivity() {

    }

    private static void registerUser() {

    }


    private static void quit() {

    }
}
