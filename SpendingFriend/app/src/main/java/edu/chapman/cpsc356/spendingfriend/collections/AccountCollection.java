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
    private static AccountModel cashAccount = new AccountModel("Cash",0);

    public static AccountCollection GetInstance()
    {
        if (accountCollection == null)
        {
            accountCollection = new AccountCollection();
        }
        return accountCollection;
    }

    public static AccountModel getCashAccount() { return cashAccount; }

    //Member Variables
    private ArrayList<AccountModel> accounts;

    //Constructors
    public AccountCollection()
    {
        this.accounts = new ArrayList<AccountModel>();
        this.accounts.add(AccountCollection.cashAccount);

        generateFakeData();
    }

    //Member Methods
    public ArrayList<AccountModel> getAccounts(){return this.accounts;}

    public AccountModel getAccount(String id)
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

    private void generateFakeData()
    {
        this.accounts.add(new AccountModel("BOA Checking", 2050));
    }
}
