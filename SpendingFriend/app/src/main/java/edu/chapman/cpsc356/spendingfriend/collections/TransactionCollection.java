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

    private static TransactionCollection GetInstance()
    {
        if (transactionCollection == null)
        {
            transactionCollection = new TransactionCollection();
        }
        return transactionCollection;
    }

    //Member Variables

    private ArrayList<TransactionModel> transactionModels;

    public TransactionCollection()
    {
        this.transactionModels = new ArrayList<TransactionModel>();
    }


}
