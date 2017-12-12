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
    private static AccountModel CASH_ACCOUNT = new AccountModel("Cash",0);

    public static AccountCollection GetInstance()
    {
        if (accountCollection == null)
        {
            accountCollection = new AccountCollection();
        }
        return accountCollection;
    }

    public static AccountModel GetCashAccount() { return CASH_ACCOUNT; }

    //Member Variables
    private ArrayList<AccountModel> accounts;

    //Constructors
    public AccountCollection()
    {
        this.accounts = new ArrayList<AccountModel>();
        this.accounts.add(AccountCollection.CASH_ACCOUNT);

        generateFakeData();
    }

    public static boolean isUniqueAccountName(String name)
    {
        for (AccountModel account : accountCollection.getAccounts())
        {
            if (account.getName().equals(name))
            {
                return false;
            }
        }

        return true;
    }

    //Member Methods
    public ArrayList<AccountModel> getAccounts(){return this.accounts;}

    public AccountModel getAccountById(String id)
    {
        for (AccountModel account : accounts)
        {
            if (account.getId().equals(id))
            {
                return account;
            }
        }

        return null;
    }

    public AccountModel getAccountByName(String name)
    {
        for(AccountModel account : accounts)
        {
            if (account.getName().equals(name))
            {
                return account;
            }
        }

        return null;
    }

    private void generateFakeData()
    {
        this.accounts.add(new AccountModel("BOA Checking", 2050));
    }
}
