package edu.chapman.cpsc356.spendingfriend.models;

/**
 * Created by Nadiya on 12/3/2017.
 */

public class AccountModel
{
    //Static Variables
    public static int CHECKING = 0;
    public static int SAVINGS = 1;
    public static int CASH = 2;

    //Member Variables
    private String name;
    private int number;
    private int type;
    private double balance;

    //Constructors
    public AccountModel(){}

    public AccountModel(String name, double balance)
    {
        this.name = name;
        this.balance = balance;
    }

    //Getters
    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public int getType() {
        return type;
    }

    public double getBalance() {
        return balance;
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

    public void setAmount(double balance) {
        this.balance = balance;
    }
}
