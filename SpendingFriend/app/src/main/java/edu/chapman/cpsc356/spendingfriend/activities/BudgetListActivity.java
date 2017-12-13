package edu.chapman.cpsc356.spendingfriend.activities;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import edu.chapman.cpsc356.spendingfriend.fragments.BudgetListFragment;

public class BudgetListActivity extends SingleFragmentActivity
{
    private BudgetListFragment budgetListFragment;

    protected Fragment getFragment()
    {
        this.budgetListFragment = new BudgetListFragment();
        return this.budgetListFragment;
    }

}
