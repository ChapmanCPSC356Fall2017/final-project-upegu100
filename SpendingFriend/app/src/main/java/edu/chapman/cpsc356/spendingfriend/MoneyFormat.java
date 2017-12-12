package edu.chapman.cpsc356.spendingfriend;

import java.text.DecimalFormat;

/**
 * Created by Nadiya on 12/11/2017.
 */

public class MoneyFormat
{
    private static DecimalFormat MONEY_FORMAT = new DecimalFormat("0.00");
    private static String FORMATTED_VALUE = "0.00";

    public static String moveDecimalLeft(String oldString)
    {
        String newString;
        if (oldString.length() > 3)
        {
            oldString.replace(".","");
            newString = oldString.substring(0, oldString.length() - 3) + "." + oldString.substring(oldString.length()-2, oldString.length()-1);
        }
        else
        {
            oldString.replace(".","");
            newString = "0" + oldString.substring(0) + "." + oldString.substring(1,2);
        }
        return newString;
    }
}
