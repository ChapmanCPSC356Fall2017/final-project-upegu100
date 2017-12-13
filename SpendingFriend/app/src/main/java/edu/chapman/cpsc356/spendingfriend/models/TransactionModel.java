package edu.chapman.cpsc356.spendingfriend.models;

import org.joda.time.DateTime;

import java.util.UUID;

import edu.chapman.cpsc356.spendingfriend.R;
import edu.chapman.cpsc356.spendingfriend.collections.AccountCollection;

/**
 * Created by Nadiya on 12/3/2017.
 */

public class TransactionModel
{
    //Member Variables
    private double amount;
    private AccountModel account;
    private String id;
    private boolean isDeposit;
    private String name;
    private DateTime date;

    //Constructors
    public TransactionModel()
    {
        this.id = UUID.randomUUID().toString();
        this.amount = 0;
        this.account = AccountCollection.GetCashAccount();
        this.isDeposit = true;
        this.name = "New Transaction";
        this.date = DateTime.now();
    }

    public TransactionModel(String name, double amount, boolean isDeposit)
    {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.amount = amount;
        this.isDeposit = isDeposit;
        this.account = AccountCollection.GetCashAccount();
        this.date = DateTime.now();
    }

    public TransactionModel(String name, double amount, boolean isDeposit, AccountModel account)
    {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.amount = amount;
        this.isDeposit = isDeposit;
        this.account = account;
        this.date = DateTime.now();
    }

    //Getters
    public double getAmount() {
        return amount;
    }
    public AccountModel getAccount() {
        return account;
    }
    public String getId() { return id; }
    public boolean isDeposit() { return this.isDeposit; }
    public boolean isWithdrawal() {return !this.isDeposit;}
    public String getName() { return this.name; }
    public DateTime getDate() { return this.date; }

    //Setters
    public void setAmount(double amount) {this.amount = amount;}
    public void setAccount(AccountModel account) {
        this.account = account;
    }
    public void setId(String id) {this.id = id;}
    public void setDeposit(boolean isDeposit) {this.isDeposit = isDeposit;}
    public void setWithdrawal(boolean isWithdrawal) {this.isDeposit = !isWithdrawal;}
    public void setName(String name) {this.name = name;}
    public void setDate(DateTime date) {this.date = date;}

}
