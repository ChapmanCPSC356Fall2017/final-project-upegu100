package edu.chapman.cpsc356.spendingfriend.models;

import java.time.chrono.ThaiBuddhistEra;

/**
 * Created by Nadiya on 12/10/2017.
 */

public class BudgetModel
{
    //Static Variables and Methods
    private static BudgetModel TOTAL_BUDGET;

    //Member Variables and Methods
    private AccountModel account;


    public BudgetModel()
    {
        this.account = null;
    }

    //Getters
    public AccountModel getAccount()
    {
        return account;
    }

    //Setters
    public void setAccount(AccountModel accout)
    {
        this.account = account;
    }
}
