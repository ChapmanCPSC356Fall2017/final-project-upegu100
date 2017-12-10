package edu.chapman.cpsc356.spendingfriend.models;

/**
 * Created by Nadiya on 12/10/2017.
 */

public class BudgetModel
{
    //Static Variables and Methods
    private static BudgetModel budget;

    public BudgetModel GetInstance() {return this.budget;}

    //Member Variables and Methods
    private double savingsGoal;
    private double monthlySpendingCap;
    private double monthlySavingsGoal;
}
