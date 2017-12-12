package edu.chapman.cpsc356.spendingfriend;

/**
 * Created by Nadiya on 12/11/2017.
 */

public class ParseHelper
{
    public static boolean tryParseInt(String s)
    {
        try
        {
            Integer.parseInt(s);
            return true;
        }
        catch (NumberFormatException e)
        {
            return false;
        }
    }

    public static boolean tryParseDouble(String s)
    {
        try
        {
            Double.parseDouble(s);
            return true;
        }
        catch(NumberFormatException e)
        {
            return false;
        }
    }
}
