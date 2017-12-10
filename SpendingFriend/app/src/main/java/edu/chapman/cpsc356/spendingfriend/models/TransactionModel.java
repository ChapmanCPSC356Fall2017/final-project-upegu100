package edu.chapman.cpsc356.spendingfriend.models;

/**
 * Created by Nadiya on 12/3/2017.
 */

public class TransactionModel
{
    private double amount;
    private AccountModel account;
    private double id;

    public double getAmount() {
        return amount;
    }

    public AccountModel getAccount() {
        return account;
    }

    public double getId()
    {
        return id;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setAccount(AccountModel account) {
        this.account = account;
    }

    public void setId(double id) {
        this.id = id;
    }




}
