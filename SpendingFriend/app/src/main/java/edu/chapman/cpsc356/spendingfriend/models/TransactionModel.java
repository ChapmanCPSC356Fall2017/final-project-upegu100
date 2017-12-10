package edu.chapman.cpsc356.spendingfriend.models;

import java.util.UUID;

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

    //Constructors
    public TransactionModel()
    {
        this.id = UUID.randomUUID().toString();
    }

    public TransactionModel(AccountModel account, double amount, boolean isDeposit)
    {
        this.id = UUID.randomUUID().toString();
        this.account = account;
        this.amount = amount;
        this.isDeposit = isDeposit;
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
    public boolean isWithdrawl() {return !this.isDeposit;}

    //Setters
    public void setAmount(double amount) {
        this.amount = amount;
    }
    public void setAccount(AccountModel account) {
        this.account = account;
    }
    public void setId(String id) {this.id = id;}
    public void setDeposit(boolean isDeposit) {this.isDeposit = isDeposit;}
    public void setWithdrawl(boolean isWithdrawl) {this.isDeposit = !isWithdrawl;}

}
