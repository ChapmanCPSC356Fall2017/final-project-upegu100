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
    private static AccountModel TOTAL_ACCOUNT = new AccountModel("Total", 0);

    public static AccountCollection GetInstance()
    {
        if (accountCollection == null)
        {
            accountCollection = new AccountCollection();
        }
        return accountCollection;
    }

    public static AccountModel GetTotalAccount() {return TOTAL_ACCOUNT;}
    public static AccountModel GetCashAccount() { return CASH_ACCOUNT; }

    //Member Variables
    private ArrayList<AccountModel> accounts;
    private ArrayList<AccountModel> extendedAccounts;

    //Constructors
    public AccountCollection()
    {
        this.accounts = new ArrayList<AccountModel>();
        this.extendedAccounts = new ArrayList<AccountModel>();

        addAccount(AccountCollection.CASH_ACCOUNT);
        this.extendedAccounts.add(AccountCollection.TOTAL_ACCOUNT);

        generateFakeData();
    }

    public static boolean isUniqueAccountName(String name, String id)
    {
        for (AccountModel account : accountCollection.getExtendedAccounts())
        {
            if (account.getName().equals(name) && !account.getId().equals(id))
            {
                return false;
            }
        }

        return true;
    }

    //Member Methods
    public ArrayList<AccountModel> getAccounts(){return this.accounts;}
    public ArrayList<AccountModel> getExtendedAccounts(){return this.extendedAccounts;}

    public AccountModel getAccountById(String id)
    {
        for (AccountModel account : extendedAccounts)
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
        for(AccountModel account : extendedAccounts)
        {
            if (account.getName().equals(name))
            {
                return account;
            }
        }

        return null;
    }

    public void addAccount(AccountModel account)
    {
        accounts.add(0, account);
        extendedAccounts.add(0, account);
    }

    public void removeAccount(AccountModel account)
    {
        accounts.remove(account);
        extendedAccounts.remove(account);
    }

    private void generateFakeData()
    {
       // addAccount(new AccountModel("BOA Checking", 2050));
    }
}
