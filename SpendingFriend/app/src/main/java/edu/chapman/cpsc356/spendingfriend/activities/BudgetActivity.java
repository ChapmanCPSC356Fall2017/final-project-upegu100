package edu.chapman.cpsc356.spendingfriend.activities;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import edu.chapman.cpsc356.spendingfriend.fragments.BudgetFragment;

public class BudgetActivity extends SingleFragmentActivity
{

    private BudgetFragment budgetFragment;
    @Override
    protected Fragment getFragment()
    {
        this.budgetFragment = new BudgetFragment();
        return this.budgetFragment;
    }
}
