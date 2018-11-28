import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

/**
 *  Kontrollklass för exekvering.
 *
  * @author  Kai Weeks
 *  För D0019N - Assignment 2 - Gym WakeUp
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
public class Main {
    private static Scanner input = new Scanner(in);  // Programmet behöver indata


    /**
     * main-metoden för klassen Main.
     */
    public static void main(String args[]) throws IOException {
        BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
        int Number[][] = new int[3][3];
        //String[][] platser = new String[3][3];
        String [][] platser = {{"a", "b", "c"}, {"a", "b", "c"}, {"a", "b", "c"}};
        int i, j;
        String m;
        System.out.println("Enter Elements for Matrix 3x3 :");
        for (i = 0; i <= 2; i++) {
            for (j = 0; j <= 2; j++) {
                m = BR.readLine();
                Number[i][j] = Integer.parseInt(m);
            }
        }
        System.out.println("Elements in Matrix are : ");
        System.out.println("");
        for (i = 0; i <= 2; i++) {
            for (j = 0; j <= 2; j++) {
                System.out.print(Number[i][j] + "\t");
            }
            System.out.println();
        }
    }

}
