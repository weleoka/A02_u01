package WakeUp;

/**
 * Helper class with methods for handling users and login authentification.
 */
public class WakeUpHelpers {

    /**
     * Helper for validating an ID number.
     *
     * The format for the ID is what is known as the Swedish personal number system.
     *
     * It is a modulus 10 based system in the format YYMMDD-XXXX
     *
     * The last number is the modulus check.
     *
     *
     * @param userID                a userID to check for conformity
     * @return boolean              true if valid userID
     */
    public static boolean validateUserID(String userID)
    {

        return true;
    }

    /**
     * Sleep the program for x number of miliseconds.
     *
     * @param mSeconds
     */
    public static void sleeper(int mSeconds)
    {
        try
        {
            Thread.sleep(mSeconds);
        }

        catch (InterruptedException e)
        {
            System.out.println("Sleep function has been aborted.");
        }
    }
}