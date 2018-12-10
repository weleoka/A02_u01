package WakeUp;

/**
 * Helper class with methods for handling users and login authentication.
 */
public class WakeUpHelpers {


    /**
     * Helper for validating an ID number.
     *
     * The format for the ID is what is known as the Swedish personal number system.
     * It is a modulus 10 based system in the format YYMMDD[-/+]XXXX
     * The last number is the modulus check.
     *
     * This method works with an integer array and makes an external call to a method that
     * converts the String userID to int[10] userID.
     *
     * todo: implement the check for the + and - signs if the person is more than 100 years old.
     * todo: refactor to not make external method call from this method.
     *
     *
     * @param userID                a String of the userID to check for conformity
     * @return boolean              true if valid userID conforms
     */
    public static boolean validateUserID(String userID)
    {
        int[] uid; // YYMMDDXXXX
        int sum = 0;

        try
        {
            uid = getIDAsIntArr(userID);
        }

        catch (NumberFormatException e)
        {

            return false;
        }

        for (int i = 0; i < 10; i++)
        {

            if (i % 2 == 0) // If i is evenly dividable by 2. Mode of multiplying every other digit.
            {
                int tmp = uid[i] * 2;

                if (tmp < 10)
                {
                    sum += uid[i] * 2;
                }

                else // 2 digit result, ie greater than 10. (Can be up to 9 x 9 = 18).
                {
                    sum += 1; // Handle numbers 10 to 18 by only counting the 1 towards the sum total and:
                    sum += tmp % 10; // count the second digit towards the total.
                }
            }

            else
            {
                sum += uid[i];
            }
        }
        //return true;
        return (sum % 10 == 0);
    }


    /**
     * Get the users ID returned as an array of single digit integers.
     * The string should have the format YYMMDD[-/+]XXXX
     *
     * @param userID                    a String of the users ID
     * @return userIDIntArr             an int[] of length 10
     * @throws NumberFormatException
     */
    public static int[] getIDAsIntArr(String userID) throws NumberFormatException {
        String number;
        int j = 0;
        String[] userIDStringArr = userID.split("(?<=.)");
        int[] userIDIntArr = new int[10]; // YYMMDDXXXX

        for (int i = 0; i < userIDStringArr.length; i++)
        {
            number = userIDStringArr[i];

            if (number.equals("-") || number.equals("+"))
            {

                continue;
            }
            userIDIntArr[j] = Integer.parseInt(userIDStringArr[i]);
            j++;
        }

        return userIDIntArr;
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