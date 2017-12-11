package edu.chapman.cpsc356.spendingfriend.models;

import java.util.Random;
import java.util.UUID;

import edu.chapman.cpsc356.spendingfriend.R;

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
    private String id;
    private String name;
    private int number;
    private int type;
    private double startingBalance;
    private double currentBalance;


    //Constructors
    public AccountModel()
    {
        this.id = UUID.randomUUID().toString();
        this.name = "New Account";
        this.number = 0;
        this.type = AccountModel.CHECKING;
        this.startingBalance = 0;
        this.currentBalance = 0;
    }

    public AccountModel(String name, double startingBalance)
    {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.number = 0;
        this.type = AccountModel.CHECKING;
        this.startingBalance = startingBalance;
        this.currentBalance = startingBalance;
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
    public double getCurrentBalance() {
        return this.currentBalance;
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
    public void setAmount(double currentBalance) {
        this.currentBalance = currentBalance;
    }
}
