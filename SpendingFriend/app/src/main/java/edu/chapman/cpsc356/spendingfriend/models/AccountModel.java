package edu.chapman.cpsc356.spendingfriend.models;

import java.util.UUID;

import edu.chapman.cpsc356.spendingfriend.collections.TransactionCollection;

/**
 * Created by Nadiya on 12/3/2017.
 */

public class AccountModel
{
    //Static Variables
    public static int CHECKING = 0;
    public static int SAVINGS = 1;

    //Member Variables
    private String id;
    private String name;
    private int number;
    private int type;
    private double startingBalance;
    private double currentBalance;
    private double monthlySpendingCap;
    private double monthlyIncomeGoal;
    private double totalSavingsGoal;

    //Constructors
    public AccountModel()
    {
        this.id = UUID.randomUUID().toString();
        this.name = "New Account";
        this.number = 0;
        this.type = AccountModel.CHECKING;
        this.startingBalance = 0;
        this.currentBalance = 0;
        this.monthlySpendingCap = 0;
        this.monthlyIncomeGoal = 0;
        this.totalSavingsGoal = 0;
    }

    public AccountModel(String name, double startingBalance)
    {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.number = 0;
        this.type = AccountModel.CHECKING;
        this.startingBalance = startingBalance;
        this.currentBalance = startingBalance;
        this.monthlySpendingCap = 0;
        this.monthlyIncomeGoal = 0;
        this.totalSavingsGoal = 0;
    }

    //Getters
    public String getId() { return this.id; }
    public String getName() {
        return this.name;
    }
    public int getNumber() {
        return this.number;
    }
    public int getType() { return this.type; }
    public double getStartingBalance() {return this.startingBalance;}
    public double getCurrentBalance()
    {
        updateCurrentBalance();
        return this.currentBalance;
    }
    //public int getNumTransactions() { return this.numTransactions; }
    public double getMonthlySpendingCap() {
        return monthlySpendingCap;
    }
    public double getMonthlyIncomeGoal() {
        return monthlyIncomeGoal;
    }
    public double getTotalSavingsGoal() {
        return totalSavingsGoal;
    }

    //Setters
    public void setName(String name) {
        this.name = name;
    }
    public void setNumber(int number) {
        this.number = number;
    }
    public void setType(int type) {
        this.type = type;
    }
    public void setStartingBalance(double startingBalance){this.startingBalance = startingBalance;}
    public void setAmount(double currentBalance) {this.currentBalance = currentBalance;}
    public void setMonthlySpendingCap(double monthlySpendingCap) {this.monthlySpendingCap = monthlySpendingCap;}
    public void setMonthlyIncomeGoal(double monthlyIncomeGoal) {this.monthlyIncomeGoal = monthlyIncomeGoal;}

    public void setTotalSavingsGoal(double totalSavingsGoal) {
        this.totalSavingsGoal = totalSavingsGoal;
    }

    public void updateCurrentBalance()
    {
        this.currentBalance = this.startingBalance;
        for (TransactionModel transaction : TransactionCollection.GetInstance().getTransactions())
        {
            if (transaction.getAccount().equals(this))
            {
                if (transaction.isDeposit())
                {
                    this.currentBalance += transaction.getAmount();
                }
                else
                {
                    this.currentBalance -= transaction.getAmount();
                }
            }
        }
    }

    public boolean equals(AccountModel account)
    {
        if (this.id == account.id)
        {
            return true;
        }
        return false;
    }

    public boolean hasTransaction()
    {
        for (TransactionModel transaction : TransactionCollection.GetInstance().getTransactions())
        {
            if (transaction.getAccount().getId().equals(this.id))
            {
                return true;
            }
        }
        return false;
    }

    public double calcEarned()
    {
        double earned = 0;
        for (TransactionModel transaction : TransactionCollection.GetInstance().getTransactions())
        {
            if (transaction.getAccount().equals(this) & transaction.isDeposit())
            {
                earned += transaction.getAmount();
            }
        }
        return earned;
    }

    public double calcSpent()
    {
        double spent = 0;
        for (TransactionModel transaction : TransactionCollection.GetInstance().getTransactions())
        {
            if (transaction.getAccount().equals(this) & transaction.isWithdrawal())
            {
                spent -= transaction.getAmount();
            }
        }
        return spent;
    }

    public double calcBudgetDiffSpent()
    {
        return (this.calcSpent() - this.monthlySpendingCap);
    }

    public double callBudgetDiffEarned()
    {
        return (this.calcEarned() - this.getMonthlyIncomeGoal());
    }

    public double callBudgetDiffSavings()
    {
        return (this.getCurrentBalance() - this.totalSavingsGoal);
    }


}
