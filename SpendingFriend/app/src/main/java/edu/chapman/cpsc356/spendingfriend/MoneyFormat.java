package edu.chapman.cpsc356.spendingfriend;

import java.text.DecimalFormat;

/**
 * Created by Nadiya on 12/11/2017.
 */

public class MoneyFormat
{
    private static DecimalFormat MONEY_FORMAT = new DecimalFormat("0.00");
    private static String FORMATTED_VALUE = "0.00";
    private static String s;

    public static String format(String s)
    {
        return MONEY_FORMAT.format(s);
    }

    public static String moveDecimalLeft(String decimalNumber)
    {
        if(decimalNumber.contains("."))
        {
            int position = decimalNumber.indexOf(".");

            if (decimalNumber.startsWith("."))
            {
                return decimalNumber.replace(".","");
            }
            else if (decimalNumber.endsWith("."))
            {

                String lastNumber = decimalNumber.substring(position-1,position);
                String firstPart = decimalNumber.substring(0,position-1);
                return firstPart + "." + lastNumber;

            }
            else
            {
                String firstHalf = decimalNumber.substring(0, position - 1);
                String middleNumber = decimalNumber.substring(position-1, position);
                String secondHalf = decimalNumber.substring(position + 1);
                return firstHalf + "." + middleNumber + secondHalf;
            }
        }

        return decimalNumber;
    }

    public static String moveDecimalRight(String decimalNumber)
    {
        if(decimalNumber.contains("."))
        {
            int position = decimalNumber.indexOf(".");

            if (decimalNumber.startsWith("."))
            {
                String firstNumber = decimalNumber.substring(1,2);
                String lastPart = decimalNumber.substring(2);
                return firstNumber + "." + lastPart;
            }
            else if (decimalNumber.endsWith("."))
            {
                return decimalNumber.replace(".", "0.");
            }
            else
            {
                String firstHalf = decimalNumber.substring(0, position);
                String middleNumber = decimalNumber.substring(position+1, position+2);
                String secondHalf = decimalNumber.substring(position + 2);
                return firstHalf + middleNumber + "." + secondHalf;
            }
        }

        return decimalNumber;
    }
    //TODO: Delete this method
    public static String test(String s)
    {
        MoneyFormat.s = s;
        return s.substring(0,2);
    }
}
