package edu.chapman.cpsc356.spendingfriend.collections;

import java.util.ArrayList;

import edu.chapman.cpsc356.spendingfriend.models.AccountModel;
import edu.chapman.cpsc356.spendingfriend.models.TransactionModel;

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


    public double getTotalMonthSpent(int month)
    {
        double totalMonthSpent = 0;
        for (TransactionModel transaction : TransactionCollection.GetInstance().getTransactions())
        {
            if (transaction.isWithdrawal()&& transaction.getDate().getMonthOfYear() == month)
            {
                totalMonthSpent += transaction.getAmount();
            }
        }
        return totalMonthSpent;
    }

    public double getTotalSpent()
    {
        double totalSpent = 0;
        for(TransactionModel transaction : TransactionCollection.GetInstance().getTransactions())
        {
            if (transaction.isWithdrawal())
            {
                totalSpent += transaction.getAmount();
            }
        }
        return totalSpent;
    }

    public double getTotalMonthSpendingCap()
    {
        double totalSpendingCap = 0;
        for(AccountModel account : AccountCollection.GetInstance().getAccounts())
        {
            totalSpendingCap += account.getMonthlySpendingCap();
        }
        return totalSpendingCap;
    }

    public double getTotalMonthSpentDiff(int month)
    {
        return getTotalMonthSpent(month) - getTotalMonthSpendingCap();
    }

    public double getTotalMonthEarnedDiff(int month)
    {
        return getTotalMonthIncomeGoal() - getTotalMonthEarned(month);
    }

    public double getTotalMonthIncomeGoal()
    {
        double totalIncomeGoal = 0;
        for (AccountModel account : AccountCollection.GetInstance().getAccounts())
        {
            totalIncomeGoal += account.getMonthlyIncomeGoal();
        }
        return totalIncomeGoal;
    }

    public double getTotalMonthEarned(int month)
    {
        double totalEarned = 0;
        for(TransactionModel transaction : TransactionCollection.GetInstance().getTransactions())
        {
            if (transaction.isDeposit() && transaction.getDate().getMonthOfYear() == month)
            {
                totalEarned += transaction.getAmount();
            }
        }
        return totalEarned;
    }

    public double getTotalEarned()
    {
        double totalEarned = 0;
        for(TransactionModel transaction : TransactionCollection.GetInstance().getTransactions())
        {
            if (transaction.isDeposit())
            {
                totalEarned += transaction.getAmount();
            }
        }
        return totalEarned;
    }

    public double getCurrentTotalBalance()
    {
        double totalBalance = 0;
        for (AccountModel account : accounts)
        {
            totalBalance += account.getCurrentBalance();
        }

        return totalBalance;
    }

    public double getTotalSavingsGoal()
    {
        double totalSavingsGoal = 0;
        for (AccountModel account : accounts)
        {
            totalSavingsGoal += account.getTotalSavingsGoal();
        }
        return totalSavingsGoal;
    }

    public double getTotalSavingsDiff()
    {
        return getCurrentTotalBalance() - getTotalSavingsGoal();
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
        addAccount(new AccountModel("BOA Checking", 1000,
                20879789, AccountModel.CHECKING, 100, 500,
                2500));
        addAccount(new AccountModel("Key Bank Savings", 5000,
                5738593, AccountModel.SAVINGS, 50, 400,
                8000));
    }
}
