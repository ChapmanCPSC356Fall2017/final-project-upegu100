package edu.chapman.cpsc356.spendingfriend.collections;

import java.util.ArrayList;

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
    }

    //Member Methods
    public ArrayList<TransactionModel> getTransactions() {return this.transactions;}

    public TransactionModel getTransaction(int id)
    {
        for (TransactionModel transaction : transactions)
        {
            if (transaction.getId() == id)
            {
                return transaction;
            }
        }
        return null;
    }


}
