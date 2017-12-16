package edu.chapman.cpsc356.spendingfriend.collections;

import org.joda.time.DateTime;

import java.util.ArrayList;

import edu.chapman.cpsc356.spendingfriend.models.AccountModel;
import edu.chapman.cpsc356.spendingfriend.models.TransactionModel;

/**
 * Created by Nadiya on 12/9/2017.
 */

public class TransactionCollection
{
    //Static methods
    private static TransactionCollection transactionCollection;

    public static TransactionCollection GetInstance()
    {
        if (transactionCollection == null)
        {
            transactionCollection = new TransactionCollection();
        }
        return transactionCollection;
    }

    //Member Variables
    private ArrayList<TransactionModel> transactions;

    //Constructor
    public TransactionCollection()
    {
        this.transactions = new ArrayList<TransactionModel>();
        generateFakeData();
    }

    //Member Methods
    public ArrayList<TransactionModel> getTransactions() {return this.transactions;}

    public TransactionModel getTransaction(String id)
    {
        for (TransactionModel transaction : transactions)
        {
            if (transaction.getId().equals(id))
            {
                return transaction;
            }
        }
        return null;
    }

    private void generateFakeData()
    {
        //Fake Withdrawals
        String[] withdrawalNames = {"New Years Party Favors", "Romantic Dinner", "Green Decorations",
                "Egg Dye", "Mother's Day Gift", "Father's Day Brunch", "American Flag",
                "Barbeque from Home Depot", "School Supplies", "Pumpkin", "Turkey", "Christmas Gift"};
        double[] withdrawalAmounts = {10,20,30,40,50,60,70,80,90,100,110,120};
        String[] withdrawalAccountNames = {"Cash", "BOA Checking", "Key Bank Savings", "Cash",
                "BOA Checking", "Key Bank Savings", "Cash", "BOA Checking", "Key Bank Savings", "Cash",
                "BOA Checking", "Key Bank Savings"};
        DateTime[] withdrawalDates = {
                new DateTime(2017,1,1,0,0),
                new DateTime(2017,2,1,0,0),
                new DateTime(2017,3,1,0,0),
                new DateTime(2017,4,1,0,0),
                new DateTime(2017,5,1,0,0),
                new DateTime(2017,6,1,0,0),
                new DateTime(2017,7,1,0,0),
                new DateTime(2017,8,1,0,0),
                new DateTime(2017,9,1,0,0),
                new DateTime(2017,10,1,0,0),
                new DateTime(2017,11,1,0,0),
                new DateTime(2017,12,1,0,0)};

        //Fake Deposits
        String[] depositNames = {"January Work Payment", "February Work Payment", "March Work Payment",
                "April Work Payment", "May Work Payment", "June Work Payment", "July Work Payment",
                "August Work Payment", "September Work Payment", "October Work Payment", "November Work Payment",
                "December Work Payment"};
        double[] depositAmounts = {100,200,300,400,500,600,700,800,900,1000,1100,1200};
        String[] depositAccountNames = {"Cash", "BOA Checking", "Key Bank Savings", "Cash",
                "BOA Checking", "Key Bank Savings", "Cash", "BOA Checking", "Key Bank Savings", "Cash",
                "BOA Checking", "Key Bank Savings"};
        DateTime[] depositDates = {
                new DateTime(2017,1,15,0,0),
                new DateTime(2017,2,15,0,0),
                new DateTime(2017,3,15,0,0),
                new DateTime(2017,4,15,0,0),
                new DateTime(2017,5,15,0,0),
                new DateTime(2017,6,15,0,0),
                new DateTime(2017,7,15,0,0),
                new DateTime(2017,8,15,0,0),
                new DateTime(2017,9,15,0,0),
                new DateTime(2017,10,15,0,0),
                new DateTime(2017,11,15,0,0),
                new DateTime(2017,12,15,0,0)};


        for (int i = 0; i < withdrawalNames.length; ++i)
        {
            transactions.add(new TransactionModel(withdrawalNames[i], withdrawalAmounts[i], false,
                    AccountCollection.GetInstance().getAccountByName(withdrawalAccountNames[i]),
                    withdrawalDates[i]));
        }

        for (int i =0 ; i < depositNames.length; ++i)
        {
            transactions.add(new TransactionModel(depositNames[i], depositAmounts[i], true,
                    AccountCollection.GetInstance().getAccountByName(depositAccountNames[i]),
                    depositDates[i]));
        }
    }
}
