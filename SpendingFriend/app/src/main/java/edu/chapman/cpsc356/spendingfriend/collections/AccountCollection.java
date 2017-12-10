package edu.chapman.cpsc356.spendingfriend.collections;

import java.util.ArrayList;

import edu.chapman.cpsc356.spendingfriend.models.AccountModel;

/**
 * Created by Nadiya on 12/9/2017.
 */

public class AccountCollection
{
    //Static Variables and Methods
    private static AccountCollection accountCollection;

    public static AccountCollection GetInstance()
    {
        if (accountCollection == null)
        {
            accountCollection = new AccountCollection();
        }
        return accountCollection;
    }

    //Member Variables
    private ArrayList<AccountModel> accounts;

    //Constructors
    public AccountCollection()
    {
        this.accounts = new ArrayList<AccountModel>();
        generateFakeData();
    }

    //Member Methods
    public ArrayList<AccountModel> getAccounts(){return this.accounts;}

    public AccountModel getAccount(int number)
    {
        for (AccountModel account : accounts)
        {
            if (account.getNumber() == number)
            {
                return account;
            }
        }

        return null;
    }

    private void generateFakeData()
    {
        this.accounts.add(new AccountModel("Cash", 1000));
        this.accounts.add(new AccountModel("BOA Checking", 2050));
    }
}
