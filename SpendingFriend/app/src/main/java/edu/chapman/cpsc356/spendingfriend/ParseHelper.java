package edu.chapman.cpsc356.spendingfriend;

/**
 * Created by Nadiya on 12/11/2017.
 * Helps with parsing Strings from EditText
 */

public class ParseHelper
{
    public static final String EMPTY_STRING = "";
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

    public static boolean tryParseLong(String s)
    {
        try
        {
            Long.parseLong(s);
            return true;
        }
        catch (NumberFormatException e)
        {
            return false;
        }
    }

    public static boolean AllWhiteSpace(String s)
    {
        char[] sCharArray = s.toCharArray();
        for (int i = 0; i < sCharArray.length; i++)
        {
            if (sCharArray[i] != ' ')
            {
                return false;
            }
        }
        return true;
    }
}
