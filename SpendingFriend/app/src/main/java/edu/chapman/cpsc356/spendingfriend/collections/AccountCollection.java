package edu.chapman.cpsc356.spendingfriend.collections;

import java.util.ArrayList;

import edu.chapman.cpsc356.spendingfriend.models.AccountModel;

/**
 * Created by Nadiya on 12/9/2017.
 */

public class AccountCollection
{
    private static AccountCollection accountCollection;

    private static AccountCollection GetInstance()
    {
        if (accountCollection == null)
        {
            accountCollection = new AccountCollection();
        }
        return accountCollection;
    }

    //Member Variables
    private ArrayList<AccountModel> accounts;

    public AccountCollection()
    {
        this.accounts = new ArrayList<AccountModel>();
    }

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
}
